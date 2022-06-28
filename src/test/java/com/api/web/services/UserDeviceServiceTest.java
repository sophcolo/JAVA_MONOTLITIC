package com.api.web.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import com.api.web.dtos.UserDeviceRequest;
import com.api.web.exceptions.ApiNotFound;
import com.api.web.exceptions.ApiUnprocessableEntity;
import com.api.web.model.UserDevice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/text-mysql.sql")
public class UserDeviceServiceTest {
	
	@Autowired
    UserDeviceService userDeviceService;
	
    @Test
    public void all() {
        assertEquals(5, userDeviceService.all().size());
        //assert All
        assertThat(userDeviceService.all()).hasSize(5);
    }

    @Test
    public void getById() throws ApiNotFound {
    	Integer id = 1;
    	UserDevice userDevice = userDeviceService.getById(id);
        assertEquals(id, userDevice.getId());
        assertEquals("KEylorZTE", userDevice.getNombre_dispositivo());
    }

    @Test
    public void save() throws ApiUnprocessableEntity, ApiNotFound, JsonProcessingException {
    	// given - precondition or setup
    	UserDeviceRequest userDeviceReg = UserDeviceRequest.builder()
    			.id(6)
    			.device_id("000001")
    			.usuario_id("100001")
    			.estado_detectid("BUE")
    			.estado_mantenimiento("EXE")
    			.nombre_dispositivo("LINALOP")
    			.id_detectid("700880")
                .build();
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonString = mapper.writeValueAsString(userDeviceReg);
        System.out.println(jsonString);
    	//userDeviceService.save(userDeviceReg);
        //assertThat(userDeviceService.all()).hasSize(6);
    }

    @Test
    public void update_without_exists_entity() throws ApiNotFound, ApiUnprocessableEntity {
    	Integer id = 10;
		// given - precondition or setup
    	UserDeviceRequest deviceCatalogUpdate = UserDeviceRequest.builder()
    			.id(10)
    			.device_id("000001")
    			.usuario_id("100001")
    			.estado_detectid("MAL")
    			.estado_mantenimiento("EXE")
    			.nombre_dispositivo("LINALOP")
    			.id_detectid("700880")
                .build();
    	
    	Throwable thrown = assertThrows(ApiNotFound.class,
	            () ->{
	            		userDeviceService.udpate(id, deviceCatalogUpdate);
	            	 }
    	);

		assertTrue(thrown.getMessage().contains("Not Exists This User Device Register"));
        assertThat(status().isNotFound());
    }
    
    @Test
    public void update_with_invalid_foreing_device_id() throws ApiNotFound, ApiUnprocessableEntity {
    	Integer id = 1;
		// given - precondition or setup
    	UserDeviceRequest deviceCatalogUpdate = UserDeviceRequest.builder()
    			.id(1)
    			.device_id("000011")
    			.usuario_id("100001")
    			.estado_detectid("MAL")
    			.estado_mantenimiento("EXE")
    			.nombre_dispositivo("LINALOP")
    			.id_detectid("700880")
                .build();
    	
    	Throwable thrown = assertThrows(ApiNotFound.class,
	            () ->{
	            		userDeviceService.udpate(id, deviceCatalogUpdate);
	            	 }
    	);

		assertTrue(thrown.getMessage().contains("Not Exists This Device"));
        assertThat(status().isNotFound());
    }
    
    @Test
    public void update_with_invalid_foreing_user_id() throws ApiNotFound, ApiUnprocessableEntity {
    	Integer id = 1;
		// given - precondition or setup
    	UserDeviceRequest deviceCatalogUpdate = UserDeviceRequest.builder()
    			.id(1)
    			.device_id("000001")
    			.usuario_id("111111")
    			.estado_detectid("MAL")
    			.estado_mantenimiento("EXE")
    			.nombre_dispositivo("LINALOP")
    			.id_detectid("700880")
                .build();
    	
    	Throwable thrown = assertThrows(ApiNotFound.class,
	            () ->{
	            		userDeviceService.udpate(id, deviceCatalogUpdate);
	            	 }
    	);

		assertTrue(thrown.getMessage().contains("Not Exists This User"));
        assertThat(status().isNotFound());
    }
    
    @Test
    public void update_without_propierty_required() throws ApiNotFound, ApiUnprocessableEntity {
    	Integer id = 1;
		// given - precondition or setup
    	UserDeviceRequest deviceCatalogUpdate = UserDeviceRequest.builder()
    			.id(1)
    			.device_id("000001")
    			.usuario_id("100001")
    			.estado_detectid("MAL")
    			.estado_mantenimiento("EXE")
    			.id_detectid("700880")
                .build();
    	
    	Throwable thrown = assertThrows(ApiUnprocessableEntity.class,
	            () ->{
	            		userDeviceService.udpate(id, deviceCatalogUpdate);
	            	 }
    	);

		assertTrue(thrown.getMessage().contains("El Nombre del Dispositivo es obligatorio"));
        assertThat(status().isUnprocessableEntity());
    }
    	
    @Test
    public void update() throws ApiNotFound, ApiUnprocessableEntity {
    	Integer id = 1;
		// given - precondition or setup
    	UserDeviceRequest deviceCatalogUpdate = UserDeviceRequest.builder()
    			.id(1)
    			.device_id("000001")
    			.usuario_id("100001")
    			.estado_detectid("MAL")
    			.estado_mantenimiento("EXE")
    			.nombre_dispositivo("LINALOP")
    			.id_detectid("700880")
                .build();
    	
    	userDeviceService.udpate(id, deviceCatalogUpdate);
    	UserDevice userDevice = userDeviceService.getById(id);
 
        assertEquals(deviceCatalogUpdate.getNombre_dispositivo(), userDevice.getNombre_dispositivo());
        assertEquals(deviceCatalogUpdate.getEstado_mantenimiento(), userDevice.getEstado_mantenimiento());
        assertThat(userDeviceService.all()).hasSize(5);
    }
    
    @Test
    public void delete_without_exists_entity() throws ApiNotFound {
    	Integer id = 10;
    	Throwable thrown = assertThrows(ApiNotFound.class,
	            ()->{userDeviceService.delete(id);} );

		assertTrue(thrown.getMessage().contains("Not Exists This User Device Register"));
        assertThat(status().isNotFound());
        assertThat(userDeviceService.all()).hasSize(5);
    }

    @Test
    public void delete() throws ApiNotFound {
    	Integer id = 1;
    	userDeviceService.delete(id);
        assertThat(userDeviceService.all()).hasSize(4);
    }
}