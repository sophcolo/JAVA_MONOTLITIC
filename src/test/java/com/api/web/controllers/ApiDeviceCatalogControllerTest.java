package com.api.web.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.api.web.model.DeviceCatalog;
import com.api.web.dtos.DeviceCatalogRequest;
import com.api.web.helpers.HelperMapper;
import com.api.web.repositories.DeviceCatalogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ApiDeviceCatalogControllerTest {
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private DeviceCatalogRepository deviceCatalogRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
    	this.deviceCatalogRepository.deleteAll();
    }
    
    @Test
    public void test_insert_device_catalog() throws Exception{

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

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(devCat)));

        // then - verify the result or output using assert statements
        response.andDo(print())
        		.andExpect(status().isOk())
                .andExpect(jsonPath("$.numero_telefono",
                        is(devCat.getNumero_telefono())))
                .andExpect(jsonPath("$.operador_telefonico",
                        is(devCat.getOperador_telefonico())));
    }
    
    // JUnit test for delete employee REST API
    @Test
    public void test_insert_device_catalog_with_out_agente() throws Exception{ 
        // given - precondition or setup
    	DeviceCatalogRequest devCat = DeviceCatalogRequest.builder()
    			.id_dispositivo("0000001")
    			.identificador("0002221")
                .numero_telefono("+579999999991")
                .operador_telefonico("CLARO")
                .sistema_operativo("MAC")
                .version_sistema("088881")
                .modelo_dispositivo("009991")
                .estado_dispositivo("BUE")
                .usuario_ingresa("100001")
                .build();

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/devices")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(devCat)));

        // then - verify the output
        response.andExpect(status().isUnprocessableEntity())
        .andExpect(result -> assertEquals("El Agente es obligatorio", result.getResolvedException().getMessage()))
        .andDo(print());
    }
    
    
    // JUnit test for Get All devices catalog REST API
    @Test
    public void test_get_all_device_catalog() throws Exception{
		List<DeviceCatalog> listdeviceCatalogs = new ArrayList<>();
		DeviceCatalog devicecatalog1 = HelperMapper.modelMapper().map(new DeviceCatalogRequest("00001","0002221","agente","+579999999991","CLARO","MAC","088881","009991","BUE","100001",null,null,null,null,null), DeviceCatalog.class);
		DeviceCatalog devicecatalog2 = HelperMapper.modelMapper().map(new DeviceCatalogRequest("00002","0002222","agente","+579999999992","MOVISTAR","ANDROID","088882","009992","EXE","100002",null,null,null,null,null), DeviceCatalog.class);
		DeviceCatalog devicecatalog3 = HelperMapper.modelMapper().map(new DeviceCatalogRequest("00003","0002223","agente","+579999999993","TIGO","WINDOWS","088883","009993","MAL","100003",null,null,null,null,null), DeviceCatalog.class);
		listdeviceCatalogs.add(devicecatalog1);
		listdeviceCatalogs.add(devicecatalog2);
		listdeviceCatalogs.add(devicecatalog3);
		deviceCatalogRepository.saveAll(listdeviceCatalogs);
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/devices"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listdeviceCatalogs.size())));

    }
    
    
    // positive scenario - get Device Catalog id
    // JUnit test for GET employee by id REST API
    @Test
    public void test_get_device_catalog_by_id() throws Exception{
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
    	
    	DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(devCat, DeviceCatalog.class);
    	this.deviceCatalogRepository.save(devicecatalog);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/devices/{id}", devCat.getId_dispositivo()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.numero_telefono",
                        is(devCat.getNumero_telefono())))
                .andExpect(jsonPath("$.operador_telefonico",
                        is(devCat.getOperador_telefonico())));
    }
    
    
    // negative scenario - valid employee id
    // JUnit test for GET employee by id REST API
    @Test
    public void test_get_by_id_with_not_found_device_catalog() throws Exception{
        // given - precondition or setup
        String deviceCatalogId = "0000002";
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
    	
    	DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(devCat, DeviceCatalog.class);
    	this.deviceCatalogRepository.save(devicecatalog);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/devices/{id}", deviceCatalogId));
        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());

    }
    
    // JUnit test for update employee REST API - positive scenario
    @Test
    public void test_update_device_catalog() throws Exception{
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
    	
    	DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(devCat, DeviceCatalog.class);
    	this.deviceCatalogRepository.save(devicecatalog);

    	DeviceCatalogRequest deviceCatalogUpdate =  DeviceCatalogRequest.builder()
    			.id_dispositivo("0000001")
    			.identificador("0002221")
    			.agente("agente 2")
                .numero_telefono("+579999999991")
                .operador_telefonico("MOVISTAR")
                .sistema_operativo("Windows Phone")
                .version_sistema("088881")
                .modelo_dispositivo("009991")
                .estado_dispositivo("EXE")
                .usuario_ingresa("100001")
                .build();

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/devices/{id}", devCat.getId_dispositivo())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(deviceCatalogUpdate)));


        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.agente", is(deviceCatalogUpdate.getAgente())))
                .andExpect(jsonPath("$.operador_telefonico", is(deviceCatalogUpdate.getOperador_telefonico())))
                .andExpect(jsonPath("$.sistema_operativo", is(deviceCatalogUpdate.getSistema_operativo())))
                .andExpect(jsonPath("$.estado_dispositivo", is(deviceCatalogUpdate.getEstado_dispositivo())));
    }
    
    // JUnit test for update employee REST API - negative scenario
    @Test
    public void test_update_device_catalog_not_found() throws Exception{
    	// given - precondition or setup
        String deviceCatalogId = "0000002";
        
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
    	
    	DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(devCat, DeviceCatalog.class);
    	this.deviceCatalogRepository.save(devicecatalog);

    	DeviceCatalogRequest deviceCatalogUpdate =  DeviceCatalogRequest.builder()
    			.id_dispositivo("0000001")
    			.identificador("0002221")
    			.agente("agente 2")
                .numero_telefono("+579999999991")
                .operador_telefonico("MOVISTAR")
                .sistema_operativo("Windows Phone")
                .version_sistema("088881")
                .modelo_dispositivo("009991")
                .estado_dispositivo("EXE")
                .usuario_ingresa("100001")
                .build();

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(put("/api/devices/{id}", deviceCatalogId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(deviceCatalogUpdate)));

        // then - verify the output
        response.andExpect(status().isNotFound())
                .andDo(print());
    }
    
    
    // JUnit test for delete employee REST API
    @Test
    public void test_delete_device_catalog() throws Exception{
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
    	
    	DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(devCat, DeviceCatalog.class);
    	this.deviceCatalogRepository.save(devicecatalog);

        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(delete("/api/devices/{id}", devCat.getId_dispositivo()));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print());
    }
       
    @Test
    public void test_delete_device_catalog_not_found() throws Exception {
    	// given - precondition or setup
        String deviceCatalogId = "0000002";
        
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
    	
    	DeviceCatalog devicecatalog = HelperMapper.modelMapper().map(devCat, DeviceCatalog.class);
    	this.deviceCatalogRepository.save(devicecatalog);

        mockMvc.perform(get("/api/devices/{id}", deviceCatalogId)
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isNotFound())
          .andExpect(result -> assertEquals("Not Exists This Device", result.getResolvedException().getMessage()));
    }
}