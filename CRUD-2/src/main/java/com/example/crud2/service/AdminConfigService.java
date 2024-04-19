package com.example.crud2.service;

import com.example.crud2.model.AdminConfig;

import java.util.List;

public interface AdminConfigService
{
    public AdminConfig findAdminsData();
    public void save(AdminConfig adminConfig);

    public List<AdminConfig> findAllAdminData();


}
