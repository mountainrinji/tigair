package pl.mountainrinji;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.FlagTerm;

import org.hibernate.validator.engine.MessageAndPath;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import pl.mountainrinji.db.dao.AircraftDAO;
import pl.mountainrinji.db.dao.FlightHistoryDAO;
import pl.mountainrinji.db.entities.FlightHistory;
import pl.mountainrinji.spring.ApplicationContextProvider;

public class MailReader {

    static Folder inbox;
    static Store store;

    // Constructor of the calss.

    private static void init() {
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        Properties props = System.getProperties();
        // Set manual Properties
        props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        props.put("mail.pop3.host", "pop.gmail.com");

        try{

            /* Create the session and get the store for read the mail. */

            Session session = Session.getDefaultInstance(
                    System.getProperties(), null);

            store = session.getStore("pop3");

            store.connect("pop.gmail.com", 995, "tigair.tt@gmail.com",
                    "1qa2ws#ED");
            // inbox = store.getDefaultFolder();
            inbox = store.getFolder("INBOX");
        	inbox.open(Folder.READ_ONLY);
        } catch (MessagingException e){
            System.out.println("Exception while connecting to server: "
                    + e.getLocalizedMessage());
            e.printStackTrace();
        }

    }
    
    public static synchronized void getMails() throws MessagingException {
    	init();
        Message messages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        System.out.println("No. of Unread Messages : " + messages.length);

        /* Use a suitable FetchProfile */
        FetchProfile fp = new FetchProfile();
        fp.add(FetchProfile.Item.ENVELOPE);
        fp.add(FetchProfile.Item.CONTENT_INFO);

        inbox.fetch(messages, fp);

        try{
            processMessages(messages);
            terminate();
        } catch (Exception ex) {
            System.out.println("Exception arise at the time of read mail");
            ex.printStackTrace();
        }

    }

    
    private static void terminate() throws MessagingException {
    	inbox.close(true);
        store.close();
    }
    
    private static void processMessages(Message[] msgs) throws Exception {
        for (int i = 0; i < msgs.length; i++) {
        	processMessage(msgs[i]);
        }

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private static void processMessage(Message message) throws Exception {
        String subject = message.getSubject();
        System.out.println("Subject: " + subject);
        subject = subject.trim();
        String [] info = subject.split(" ");
        if (info.length < 2) {
        	return;
        }
        
        if (!info[0].contains("-TT")) {
        	return;
        }
        
        String [] regmark = info[0].split("-TT");
        if (regmark.length != 1 || regmark[0].contains("-TT")) {
        	return;
        }
        
        String registration = regmark [0];
        String flightTime = info[info.length - 1];
        
        FlightHistoryDAO dao = ApplicationContextProvider.getApplicationContext().getBean(FlightHistoryDAO.class);
        dao.addFlightTime(Aircraft.getDbIdForRegistration(registration), flightTime, getFlightDate(message));
        
        AircraftDAO afDao = ApplicationContextProvider.getApplicationContext().getBean(AircraftDAO.class);
        pl.mountainrinji.db.entities.Aircraft af = afDao.getAircraft(registration);
        af.setTotalTime(Utils.addTimes(af.getTotalTime(), flightTime));
        af.setEngineTotalTime(Utils.addTimes(af.getEngineTotalTime(), flightTime));
        af.setEngineTimeSinceOverhaul(Utils.addTimes(af.getEngineTimeSinceOverhaul(), flightTime));
        af.setPropellerTotalTime(Utils.addTimes(af.getPropellerTotalTime(), flightTime));
        af.setPropellerTimeSinceOverhaul(Utils.addTimes(af.getPropellerTimeSinceOverhaul(), flightTime));
        afDao.updateAircraft(af);
    }

    
    private static String getFlightDate(Message msg)

    {
        try {
            String contentType = msg.getContentType();
            Multipart mp = (Multipart) msg.getContent();
            int count = mp.getCount();
            String line = null;
            for (int i = 0; i < count; i++) {
                line = dumpPart(mp.getBodyPart(i));
                if (!StringUtils.isEmpty(line)) {
                	return line;
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception arise at get Content");
            ex.printStackTrace();
        }
        
        return null;
    }

    private static String dumpPart(Part p) throws Exception {
        
        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = null;

        while((line = br.readLine()) != null) {
            if (line.contains("Data")) {
            	is.close();
            	br.close();
            	return line;
            }
        }
        br.close();
        is.close();
        return null;
    }

    
    public static void main(String args[]) {
        new MailReader();
    }
}
