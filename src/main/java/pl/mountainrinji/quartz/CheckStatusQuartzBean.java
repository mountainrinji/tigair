package pl.mountainrinji.quartz;

import javax.mail.MessagingException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import pl.mountainrinji.MailReader;
import pl.mountainrinji.StatusCalculator;
import pl.mountainrinji.spring.ApplicationContextProvider;

public class CheckStatusQuartzBean extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		StatusCalculator bean = ApplicationContextProvider.getApplicationContext().getBean(StatusCalculator.class);
		bean.checkStatusesAndSendEmails();
		
	}

	
}
