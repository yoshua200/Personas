package com.mx.Personas.service;

import com.mx.Personas.Dominio.Persona;

import java.util.List;

public interface IPersonaService {
    public void guardar (Persona persona);
    public void editar (Persona persona);
    public void eliminar (Persona persona);
    public Persona buscar(Persona persona);
    public List<Persona> listar ();
}
