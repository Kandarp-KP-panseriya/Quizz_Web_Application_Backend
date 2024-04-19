package com.example.crud2.utils;
import com.example.crud2.enums.UserState;
import com.example.crud2.model.User;
import com.example.crud2.service.SchedulerServiceImp;
import com.example.crud2.service.UserService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.ObjectUtils;


public class UnblockUserJob extends QuartzJobBean {

    private final UserService userService;

    public UnblockUserJob( UserService userService)
    {
        this.userService = userService;
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
            User user = userService.findById(context.getJobDetail().getKey().getName());
            user.setUserState(UserState.DRAFT);
            user.setLoginFailCount(0);
            userService.saveUser(user);
            System.out.println("Unblocking user...");
    }
}