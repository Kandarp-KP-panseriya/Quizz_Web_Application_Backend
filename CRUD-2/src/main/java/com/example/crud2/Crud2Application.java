package com.example.crud2;

import com.example.crud2.model.AdminConfig;
import com.example.crud2.service.AdminConfigService;
import com.example.crud2.service.SchedulerService;
import com.example.crud2.utils.EmailSendToUser;
import com.example.crud2.utils.UnblockUserJob;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.List;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Crud2Application
{

    private final SchedulerService schedulerService;
    private final AdminConfigService adminConfigService;

    public Crud2Application(SchedulerService schedulerService, AdminConfigService adminConfigService) {
        this.schedulerService = schedulerService;
        this.adminConfigService = adminConfigService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Crud2Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        System.out.println("hello world, I have just started up");
        List<AdminConfig> adminConfig = adminConfigService.findAllAdminData();
        AdminConfig adminConfig1 = adminConfigService.findAdminsData();
        try
        {
            schedulerService.scheduleCronJob(EmailSendToUser.class,adminConfig1.getSchedulerWorkingTime(),"EmailSendToUser");
        }
        catch (Exception e)
        {System.out.println(e);}
    }
}
