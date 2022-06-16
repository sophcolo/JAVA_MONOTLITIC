package com.api.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.web.model.UserDevice;

@Repository
public interface UserDeviceRepository extends JpaRepository<UserDevice, String> {

}

