package com.api.web.controllers;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.api.web.dtos.UserRequest;
import com.fasterxml.jackson.databind.ObjectMapper;




@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
@Sql("/text-mysql.sql")
@AutoConfigureMockMvc
public class ApiUserControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ApiUserControllerTest.class);

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

	@Test
    public void test_insert_users() throws Exception{
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

        String response = mockMvc
                .perform(post("/api/users")
                        .content(objectmapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() )
                .andExpect(jsonPath("$.ten",is(user.getTen())))
                .andExpect(jsonPath("$.nam",is(user.getNam())))
                .andReturn()
                .getResponse()
                .getContentAsString();

        logger.info(response);
    }
	
	
	@Test
    public void test_insert_users_with_out_ten() throws Exception{
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

        String response = mockMvc
                .perform(post("/api/users")
                        .content(objectmapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(result -> assertEquals("El campo 'ent' es Obligatorio", result.getResolvedException().getMessage()))
                .andReturn()
                .getResponse()
                .getContentAsString();

        logger.info(response);
    }
	
	
	// JUnit test for Get Users catalog REST API
    @Test
    @Sql("/seeders/www130.sql")
    public void test_get_all_users() throws Exception{
        // when -  action or the behaviour that we are going test
        ResultActions response = mockMvc.perform(get("/api/users"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect( 
                		//(ResultMatcher) jsonPath("$.size()",5)
                		MockMvcResultMatchers.jsonPath("$.size()").value(5)
                		);
    }
    
    
    // JUnit test for Get Users catalog REST API
    @Test
    @Sql("/seeders/www130.sql")
    public void test_get_user_by_id() throws Exception{
        String response = mockMvc.perform(get("/api/users/{id}", "100003") )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nam", is("Bryan Ruiz")))
                .andReturn().getResponse()
                .getContentAsString();

        logger.info("response: " + response);
    }
    
    @Test
    @Sql("/seeders/www130.sql")
    public void test_get_user_by_id_with_not_found_user() throws Exception {
        String response = mockMvc.perform(get("/api/users/{id}", "100006") )
        		.andExpect(status().isNotFound())
                .andReturn().getResponse()
                .getContentAsString();
        logger.info("response: " + response);
    }
    
    
    @Test
    @Sql("/seeders/www130.sql")
    public void test_update_users() throws Exception{
		// given - precondition or setup
		UserRequest user = UserRequest.builder()
				.usr("100001")
    			.ten("Tendencia a Act.")
    			.ent("Entro a Actualizar")
    			.tfa(0)
                .scl(0)
                .sse(0)
                .sco("L")
                .nam("Kaylor Navas")
                .pem("kaylor@navas.com")
                .idi("101000000")
                .idt("COL")
                .build();

        String response = mockMvc
                .perform(put("/api/users/{code}", user.getUsr())
                        .content(objectmapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk() )
                .andExpect(jsonPath("$.ten",is(user.getTen())))
                .andExpect(jsonPath("$.nam",is(user.getNam())))
                .andReturn()
                .getResponse()
                .getContentAsString();

        logger.info(response);
    }
    
    @Test
    public void test_update_users_without_user_exists() throws Exception{
		// given - precondition or setup
		UserRequest user = UserRequest.builder()
				.usr("1000001")
    			.ten("Tendencia a Act.")
    			.ent("Entro a Actualizar")
    			.tfa(0)
                .scl(0)
                .sse(0)
                .sco("L")
                .nam("Kaylor Navas")
                .pem("kaylor@navas.com")
                .idi("101000000")
                .idt("COL")
                .build();

        String response = mockMvc
                .perform(put("/api/users/{code}", user.getUsr())
                        .content(objectmapper.writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        logger.info(response);
    }
    
    
    @Test
    @Sql("/seeders/www130.sql")
    public void test_user_delete() throws Exception{
    	String id = "100001";

        String response = mockMvc
                .perform(delete("/api/users/{code}", id))
                .andExpect(status().isOk() )
                .andReturn()
                .getResponse()
                .getContentAsString();

        logger.info(response);
    }
    
    @Test
    public void test_user_delete_without_user_exists() throws Exception{
    	String id = "1000001";

        String response = mockMvc
                .perform(delete("/api/users/{code}", id))
                .andExpect(status().isNotFound())
                .andReturn()
                .getResponse()
                .getContentAsString();

        logger.info(response);
    }
}