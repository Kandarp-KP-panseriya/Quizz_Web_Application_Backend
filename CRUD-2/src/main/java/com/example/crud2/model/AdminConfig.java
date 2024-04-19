package com.example.crud2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Document(collection = "admin_config")
public class AdminConfig
{
     @Id
     String id;
     List<String> emailsList;
     int maxLogin;
     int maxMinutes;
     int userBlockedTimeInMinutes;
     String  schedulerWorkingTime;

     public AdminConfig()
     {
          this.emailsList = new ArrayList<>(List.of("kpind385@gmail.com"));
          this.maxLogin = 3;
          this.maxMinutes = 1; // Default value for maxMinutes
          this.userBlockedTimeInMinutes = 3;
          this.schedulerWorkingTime = "*/15 * * * * ?";
     }

}
