package com.mx.Personas.service.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.Personas.Dominio.Persona;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
public class PersonaControllerTest {
    
    MockMvc mockMvc;
    
    //contexto de aplicacion web para la configuracion del mockmvc 
    
    @Autowired
    WebApplicationContext webApplicationContext;
    
    //configuracion antes de cada prueba 
    @BeforeEach
    void setUp(){

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    
    @Test
    void listar()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/Persona/listar"))
                .andExpect(status().isOk());
    }

    @Test
    void guardar()throws Exception{
        Persona per = new Persona();
        per.setCurp("LA8963");
        per.setNombre("Paco");
        per.setApellido("Perez");
        per.setEdad(30);
        per.setPuesto("Cargador");
        per.setDireccion("Cuernavaca");

        ObjectMapper mapper = new ObjectMapper();
        String personaJSON = mapper.writeValueAsString(per);
        mockMvc.perform(MockMvcRequestBuilders.post("/Persona/guardar").content(personaJSON)
                        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}
