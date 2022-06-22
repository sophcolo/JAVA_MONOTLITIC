package com.api.web.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void insertDeviceCatalog() throws Exception{

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
        response.andDo(print()).
                andExpect(status().isOk())
                .andExpect(jsonPath("$.numero_telefono",
                        is(devCat.getNumero_telefono())))
                .andExpect(jsonPath("$.operador_telefonico",
                        is(devCat.getOperador_telefonico())));
    }
}