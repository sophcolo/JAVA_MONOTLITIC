package com.api.web.services;

import static org.junit.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/text-mysql.sql")
public class DeviceCatalogServiceTest {
	@Autowired
    DeviceCatalogService deviceCatalogService;
	
	@Test
    public void all() {
        assertEquals(5, deviceCatalogService.all().size());
        //assertj
        assertThat(deviceCatalogService.all()).hasSize(5);
    }
	
	
	/*@Test
    public void getByID() {
        assertEquals(1, deviceCatalogService.getById("000003"));
    }*/
	
}