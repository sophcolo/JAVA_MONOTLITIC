package com.api.web.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.api.web.dtos.UserRequest;
import com.api.web.exceptions.ApiUnprocessableEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:db-test.properties")
public class UserServiceTest {
	
	@Autowired
    private UserService userService;
		
	/*
	 * Test With Negative Scenary when save USer
	*/
	@Test
    public void saveUserWithOutFieldEnt() throws ApiUnprocessableEntity {
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
		
		Throwable thrown = assertThrows(ApiUnprocessableEntity.class,
	            ()->{userService.save(user);} );

		assertTrue(thrown.getMessage().contains("El campo 'ent' es Obligatorio"));
		assertEquals("El campo 'ent' es Obligatorio", thrown.getMessage());
    }
	
	/*
	 * Test With Positive Scenary when save USer
	 */
	@Test
    public void saveUser() throws ApiUnprocessableEntity {
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
    	
    	userService.save(user);
        assertThat(userService.all()).hasSize(1);
    }
}