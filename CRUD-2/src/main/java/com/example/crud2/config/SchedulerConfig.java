package com.example.crud2.config;
import com.example.crud2.utils.UnblockUserJob;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.SimpleTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/*@Configuration
public class SchedulerConfig {

    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean()
    {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();
        factoryBean.setJobClass(UnblockUserJob.class);
        factoryBean.setDurability(true);
        return factoryBean;
    }

    @Bean
    public Trigger simpleTrigger(JobDetail jobDetail)
    {
        // Create a simple trigger that repeats every 5 seconds
        SimpleTriggerFactoryBean factoryBean = new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(jobDetail);
        factoryBean.setRepeatInterval(5000); // 5 seconds in milliseconds
        factoryBean.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        factoryBean.setStartDelay(0);
        factoryBean.afterPropertiesSet(); // Ensure the trigger is properly initialized
        return factoryBean.getObject();
    }
}*/
