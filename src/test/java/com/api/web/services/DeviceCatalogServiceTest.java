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

import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.model.DeviceCatalog;

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
        //assert All
        assertThat(deviceCatalogService.all()).hasSize(5);
    }
	
	
	@Test
    public void getByID() {
		String id = "000001";
    	DeviceCatalog deviceCatalog = deviceCatalogService.getById(id).get();
        assertEquals(id, deviceCatalog.getId_dispositivo());
        assertEquals("Agente", deviceCatalog.getAgente());
    }
	
	@Test
    public void saveDeviceCatalog() {
		// given - precondition or setup
    	DeviceCatalogRequest devCat = DeviceCatalogRequest.builder()
    			.id_dispositivo("0000001")
    			.identificador("0002221")
    			.agente("agente")
                .numero_telefono("+579999999991")
                .operador_telefonico("CLARO")
                .sistema_operativo("MAC")
                .version_sistema("088881")
                .modelo_dispositivo("009991")
                .estado_dispositivo("BUE")
                .usuario_ingresa("100001")
                .build();
    	
    	deviceCatalogService.insert(devCat);
        assertEquals(devCat.getId_dispositivo(), devCat.getId_dispositivo());
        assertEquals(devCat.getAgente(),devCat.getAgente());
        assertThat(deviceCatalogService.all()).hasSize(6);
    }
	
	
	@Test
    public void updateDeviceCatalog() {
		String id = "000001";
		// given - precondition or setup
    	DeviceCatalogRequest deviceCatalogUpdate =  DeviceCatalogRequest.builder()
    			.id_dispositivo("000001")
    			.identificador("0002221")
    			.agente("Agente 2")
                .numero_telefono("+589999999991")
                .operador_telefonico("ETB")
                .sistema_operativo("WINDOWS")
                .version_sistema("088881")
                .modelo_dispositivo("ZTE Blade L1")
                .estado_dispositivo("EXE")
                .usuario_ingresa("100001")
                .build();
    	
    	deviceCatalogService.udpate(id, deviceCatalogUpdate);
    	
    	DeviceCatalog deviceCatalog = deviceCatalogService.getById(id).get();
 
        assertEquals(deviceCatalogUpdate.getAgente(), deviceCatalog.getAgente());
        assertEquals(deviceCatalogUpdate.getSistema_operativo(), deviceCatalog.getSistema_operativo());
        assertEquals(deviceCatalogUpdate.getOperador_telefonico(), deviceCatalog.getOperador_telefonico());
        assertThat(deviceCatalogService.all()).hasSize(5);
    }
	
	@Test
    public void deleteDeviceCatalog() {
		String id = "000001";
    	deviceCatalogService.delete(id);
        assertThat(deviceCatalogService.all()).hasSize(4);
    }
}