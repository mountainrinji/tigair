package pl.mountainrinji.quartz;

import javax.mail.MessagingException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import pl.mountainrinji.MailReader;
import pl.mountainrinji.StatusCalculator;
import pl.mountainrinji.spring.ApplicationContextProvider;

public class UpdateFlightsQuartzBean extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		try {	
			MailReader.getMails();
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
	}

	
}
