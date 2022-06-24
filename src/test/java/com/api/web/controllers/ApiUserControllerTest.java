package com.api.web.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.api.web.dtos.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ApiUserControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
	
	@Test
    public void test_insert_users() throws JsonProcessingException, Exception{
		// given - precondition or setup
		UserRequest user = UserRequest.builder()
				.usr("000001")
    			.ten("Entro")
    			.ent("Tendencia")
    			.tfa(0)
                .scl(0)
                .sse(0)
                .sco("L")
                .nam("Kaylor Navas")
                .pem("kaylor@navas.com")
                .idi("101000000")
                .idt("COL")
                .build();

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        // then - verify the result or output using assert statements
        response.andDo(print())
        		.andExpect(status().isOk())
                .andExpect(jsonPath("$.ten",
                        is(user.getTen())))
                .andExpect(jsonPath("$.nam",
                        is(user.getNam())));
    }
	
	
	@Test
    public void test_insert_users_with_out_ten() throws JsonProcessingException, Exception{
		// given - precondition or setup
		UserRequest user = UserRequest.builder()
				.usr("000001")
				.ten("Entro")
    			.tfa(0)
                .scl(0)
                .sse(0)
                .sco("L")
                .nam("Kaylor Navas")
                .pem("kaylor@navas.com")
                .idi("101000000")
                .idt("COL")
                .build();

        // when - action or behaviour that we are going test
        ResultActions response = mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user)));

        // then - verify the result or output using assert statements
        response.andExpect(status().isUnprocessableEntity())
        .andExpect(result -> assertEquals("El campo 'ent' es Obligatorio", result.getResolvedException().getMessage()))
        .andDo(print());
    }
}