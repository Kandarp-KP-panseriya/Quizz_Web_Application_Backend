package com.example.crud2.service;
import com.example.crud2.enums.UserState;
import com.example.crud2.model.User;
import com.example.crud2.repository.UserRepository;
import org.quartz.*;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SchedulerServiceImp implements SchedulerService
{

    private final Scheduler scheduler;
    //private final UserServiceImpl userServiceImpl;

    public SchedulerServiceImp(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override//1-1
    public void scheduleOnDate(Class<? extends QuartzJobBean> job, Date date, String name) throws SchedulerException
    {
        System.out.println("1." + date);
        JobDetail jobDetail = buildJobDetail(job, name);
        Trigger trigger = buildJobTrigger(jobDetail, date);
        if (scheduler.checkExists(jobDetail.getKey()))
        {
            scheduler.deleteJob(jobDetail.getKey());
        }
            scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override//2-1
    public void scheduleCronJob(Class<? extends QuartzJobBean> job, String cronJob,String name) throws SchedulerException
    {
        JobDetail jobDetail = buildJobDetailForEmail(job,name);
        Trigger trigger = buildCronJobTrigger(jobDetail, cronJob);
        if (scheduler.checkExists(jobDetail.getKey()))
        {
            scheduler.deleteJob(jobDetail.getKey());
        }
        scheduler.scheduleJob(jobDetail, trigger);

    }


    //1-2
    private Trigger buildJobTrigger(JobDetail jobDetail, Date startAt) {

        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startAt(startAt)
                .withIdentity(jobDetail.getKey().getName())
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }

    //1-3
    private JobDetail buildJobDetail(Class<? extends QuartzJobBean> job, String groupName) {
        JobDataMap jobDataMap = new JobDataMap();
        return JobBuilder.newJob(job)
                .withIdentity(groupName)
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    //2-2
    private JobDetail buildJobDetailForEmail(Class<? extends QuartzJobBean> job, String name) {
        JobDataMap jobDataMap = new JobDataMap();
        return JobBuilder.newJob(job)
                .withIdentity(name)
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    //2-3
    private Trigger buildCronJobTrigger(JobDetail jobDetail, String cronString) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName())
                .withSchedule(CronScheduleBuilder.cronSchedule(cronString))
                .build();
    }

    @Override
    public void cancelSchedule(String name) throws SchedulerException {
        System.out.println("Schedule is Stop For:"+name);
        //scheduler.pauseJob(new JobKey(name));
        scheduler.deleteJob(new JobKey(name));
    }


}



















 /*public void scheduleCronJob(Class<? extends QuartzJobBean> job,String name, Date date) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job, name);
        Trigger trigger = buildJobTrigger(jobDetail);

        if (scheduler.checkExists(jobDetail.getKey()))
        {
            scheduler.deleteJob(jobDetail.getKey());
        }
        scheduler.scheduleJob(jobDetail, trigger);
    }*/

 /* private Trigger buildJobTrigger(JobDetail jobDetail, String cronString, Date startDate, Date endDate) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startAt(startDate)
                .endAt(endDate)
                .withIdentity(jobDetail.getKey().getName())
                .withSchedule(CronScheduleBuilder.cronSchedule(cronString))
                .build();
    }*/

 /*private Trigger buildJobTrigger(JobDetail jobDetail) {
        System.out.println("Trigger 1:.");
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName())
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(30) // Trigger every 5 seconds
                        .repeatForever())
                .build();

    }*/

/*
//@Scheduled(fixedRate = 2000) // Check every minute
    @Override
    public void checkAndUnblockUsers()
    {
        System.out.println("Schedule Start:-");
        LocalDateTime now = LocalDateTime.now();
        for (Map.Entry<String, LocalDateTime> entry : blockedUsers.entrySet())
        {
            if (now.isAfter(entry.getValue()))
            {
                unblockUser(entry.getKey());
            }
        }
    }
*/
/*public void scheduleCronJob(Class<? extends QuartzJobBean> job, String cron, String name, Date startDate, Date endDate) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job, name);

        if (startDate == null && endDate == null) {
            startDate = new Date();
        }
        if (endDate != null)
        {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            calendar.set(Calendar.MINUTE, -1);
            startDate = calendar.getTime();
        }
        Trigger trigger = buildJobTrigger(jobDetail);

        if (scheduler.checkExists(jobDetail.getKey())) {
            scheduler.deleteJob(jobDetail.getKey());
        }
        scheduler.scheduleJob(jobDetail, trigger);
    }*/

/*

    // Method to unblock a user
    @Override
    public void unblockUser(String userId)
    {
        System.out.println("unblockUser :"+userId);
        User user = findByid(userId);
        user.setUserState(UserState.DRAFT);
        user.setLoginFailCount(0);
        userRepository.save(user);
        blockedUsers.remove(userId);
    }
 */

/*
    // Method to block a user
    @Override
    public void blockUser(String userId)
    {
        System.out.println("blockUser :"+userId);
        blockedUsers.put(userId, LocalDateTime.now().plusMinutes(2)); // Unblock after 10 minutes
    }
*/

/*

    private JobDetail buildJobDetail(Class<? extends QuartzJobBean> job, String groupName, Map<String, String> data) {
        JobDataMap jobDataMap = new JobDataMap(data);
        return JobBuilder.newJob(job)
                .withIdentity(groupName)
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }
 */

  /*@Override
    public void scheduleOnDate(Class<? extends QuartzJobBean> job, Date date, String name, Map<String, String> data) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job, name, data);
        Trigger trigger = buildJobTrigger(jobDetail, date);
        if (scheduler.checkExists(jobDetail.getKey())) {
            scheduler.deleteJob(jobDetail.getKey());
        }
        scheduler.scheduleJob(jobDetail, trigger);

    }*/

 /*public void scheduleCronJob(Class<? extends QuartzJobBean> job,String cronString, Date startDate, Date endDate) throws SchedulerException {
        JobDetail jobDetail = buildJobDetail(job);
        Trigger trigger = buildJobTrigger(jobDetail,cronString,startDate,endDate);

        if (scheduler.checkExists(jobDetail.getKey()))
        {
            scheduler.deleteJob(jobDetail.getKey());
        }
        scheduler.scheduleJob(jobDetail, trigger);
    }

    private Trigger buildJobTrigger(JobDetail jobDetail, String cronString, Date startDate, Date endDate) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startAt(startDate)
                .endAt(endDate)
                .withIdentity(jobDetail.getKey().getName())
                .withSchedule(CronScheduleBuilder.cronSchedule(cronString))
                .build();
    }

    private JobDetail buildJobDetail(Class<? extends QuartzJobBean> job) {
        JobDataMap jobDataMap = new JobDataMap();
        return JobBuilder.newJob(job)
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }*/
