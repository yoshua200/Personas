package com.mx.Personas.service.controllers;

import com.mx.Personas.Controladores.PController;
import com.mx.Personas.Dominio.Persona;
import com.mx.Personas.service.PersonaServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonaControllerTest2 {

    @Mock
    private PersonaServiceImp personaServiceImp;

    @InjectMocks
    private PController pController;

    private Persona per;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        per = new Persona();

        per.setCurp("LA8963");
        per.setNombre("Paco");
        per.setApellido("Perez");
        per.setEdad(30);
        per.setPuesto("Cargador");
        per.setDireccion("Cuernavaca");
    }

    @Test
    void listar() {
        when(personaServiceImp.listar()).thenReturn(Arrays.asList(per));
        when(personaServiceImp.listar()).thenReturn(Arrays.asList(
                new Persona("LA8963", "PACO", "PEREZ", 30, "CARGADOR", "CUERNAVACA"),
                new Persona("RE562", "PAULINA", "LECHUGA", 25, "EJECUTIVA", "CDMX")
        ));
        List<Persona> personas = personaServiceImp.listar();
        assertEquals(2, personas.size());
    }

    @Test
    void nuevo() {
        personaServiceImp.guardar(per);
        verify(personaServiceImp).guardar(per);
    }

    @Test
    void eliminar() {
        personaServiceImp.eliminar(per);
        verify(personaServiceImp).eliminar(per);
    }

    @Test
    void editar() {
        Persona persona = new Persona("RE562", "PAULINA", "LECHUGA", 25, "EJECUTIVA", "CDMX");
        // Configuración del comportamiento esperado del servicio
        when(personaServiceImp.buscar(any(Persona.class))).thenReturn(persona);

        // Llamada al método editar() del controlador
        ResponseEntity<?> response = pController.editar(persona);

        // Verificación de que se llama al método editar() del servicio
        Mockito.verify(personaServiceImp).editar(persona);

        // Verificación de la respuesta del controlador
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("{\" MENSAJE\":\"Se edito correctamente la persona: NombreExistente \"}", response.getBody());

    }
}
