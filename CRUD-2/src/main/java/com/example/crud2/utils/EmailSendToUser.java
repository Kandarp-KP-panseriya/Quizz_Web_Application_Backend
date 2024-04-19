package com.example.crud2.utils;
import com.example.crud2.service.UserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
public class EmailSendToUser extends QuartzJobBean
{
    public final UserService userService;

    public EmailSendToUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        userService.dailyEmailMustach("DailyEmailTemplate.html");
        System.out.println("Email have been Sent Successfully");
    }
}
