package com.api.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.web.model.DeviceCatalog;

@Repository
public interface DeviceCatalogRepository extends JpaRepository<DeviceCatalog, String> {

}