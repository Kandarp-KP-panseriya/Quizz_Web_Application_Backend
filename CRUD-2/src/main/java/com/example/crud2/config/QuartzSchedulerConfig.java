/*package com.example.crud2.config;

import com.example.crud2.utils.UnblockUserJob;
import org.quartz.*;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class QuartzSchedulerConfig
{
    private final Scheduler scheduler;

    public QuartzSchedulerConfig(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @PostConstruct
    public void init() throws SchedulerException {
        scheduler.start();
    }

    // Method to schedule the job
    public void scheduleUnblockUsersJob() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(UnblockUserJob.class)
                .withIdentity("unblockUsersJob")
                .storeDurably()
                .build();

        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("unblockUsersTrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(60)) // Check every minute
                .build();

        scheduler.scheduleJob(job, trigger);
    }
    /*@Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(MyQuartzJob.class)
                .withIdentity("MyQuartzJob")
                .storeDurably()
                .build();
    }


    @Bean
    public SimpleTrigger unblockUserTrigger() {
        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(myJobDetail());
        trigger.setRepeatInterval(2000); // 3 minutes in milliseconds
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        trigger.setStartDelay(0);
        return trigger.getObject();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
        scheduler.setTriggers(unblockUserTrigger());
        return scheduler;
    }*/

   /*public final AdminConfigService adminConfigService;

    public QuartzSchedulerConfig(AdminConfigService adminConfigService) {
        this.adminConfigService = adminConfigService;
    }


    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(MyQuartzJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetail jobDetail)
    {
        AdminConfig adminConfig = adminConfigService.findAdminsData();
        CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setCronExpression(adminConfig.getSchedulerWorkingTime()); // Execute every 5 sec
        //factoryBean.setCronExpression("0 47 16 1/1 * ?"); // Execute every 5 sec
        return factoryBean;
    }

    /*private final ConcurrentHashMap<String, LocalDateTime> blockedUsers = new ConcurrentHashMap<>();

    // Method to block a user
    public void blockUser(String userId)
    {
        System.out.println("blockUser :"+userId);
        blockedUsers.put(userId, LocalDateTime.now().plusMinutes(2)); // Unblock after 10 minutes
    }

    // Method to unblock a user
    public void unblockUser(String userId) {
        // Implement logic to unblock the user
        // For example, remove the block flag from the user's profile or database record
        System.out.println("unblockUser :"+userId);
        User user = userRepository.findByIdAndSoftDeleteIsFalse(userId).orElse(null);
        user.setUserState(UserState.DRAFT);
        user.setLoginFailCount(0);
        userRepository.save(user);
        blockedUsers.remove(userId);
    }

    // Scheduled task to check and unblock users
    @Scheduled(fixedRate = 2000) // Check every minute
    public void checkAndUnblockUsers()
    {
        System.out.println("Schedule Start:-");
        LocalDateTime now = LocalDateTime.now();
        ConcurrentHashMap<String, LocalDateTime> temp = blockedUsers;
        blockedUsers.forEach((userId, unblockTime) -> {
            if (now.isAfter(unblockTime)) {
                unblockUser(userId);
            }
        });
    }*/
//}