package com.example.crud2.service;

import com.example.crud2.model.AdminConfig;
import com.example.crud2.repository.AdminConfigRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AdminConfigServiceImpl implements AdminConfigService {
    private final AdminConfigRepository adminConfigRepository;

    public AdminConfigServiceImpl(AdminConfigRepository adminConfigRepository) {
        this.adminConfigRepository = adminConfigRepository;
    }

    @Override
    public AdminConfig findAdminsData() {
        List<AdminConfig> adminConfigList = adminConfigRepository.findAll();
        if (CollectionUtils.isEmpty(adminConfigList)) {
            AdminConfig adminConfig1 = new AdminConfig();
            adminConfigRepository.save(adminConfig1);
            return adminConfig1;
        }
        return adminConfigList.get(0);
    }

    @Override
    public void save(AdminConfig adminConfig) {
        adminConfigRepository.save(adminConfig);
    }

    @Override
    public List<AdminConfig> findAllAdminData() {
        return adminConfigRepository.findAll();
    }
}
