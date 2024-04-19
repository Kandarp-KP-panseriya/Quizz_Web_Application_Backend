package com.example.crud2.service;

import org.quartz.SchedulerException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.Map;

public interface SchedulerService
{
    public void scheduleOnDate(Class<? extends QuartzJobBean> job, Date date, String name) throws SchedulerException;
    public void scheduleCronJob(Class<? extends QuartzJobBean> job,String cronJob,String name) throws SchedulerException;
    public void cancelSchedule(String name) throws SchedulerException;
}









//public void cancelSchedule(String name) throws SchedulerException;

/*
    public void checkAndUnblockUsers();
    public void unblockUser(String userId);
    public void blockUser(String userId);
*/
/*void scheduleOnDate(Class<? extends QuartzJobBean> job, Date date, String name, Map<String,String> data) throws SchedulerException;
void scheduleOnDate(Class<? extends QuartzJobBean> job, Date date, String name) throws SchedulerException;
void cancelSchedule(String name) throws SchedulerException;
void scheduleCronJob(Class<? extends QuartzJobBean> job, String cron, String name,Date startDate, Date endDate) throws SchedulerException;
 */