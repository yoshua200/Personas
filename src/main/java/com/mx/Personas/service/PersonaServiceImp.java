package com.mx.Personas.service;

import com.mx.Personas.Dominio.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class PersonaServiceImp  implements IPersonaService{

   private List<Persona> list = new ArrayList<Persona>();
    @Override
    public void guardar(Persona persona) {
        list.add(persona);
    }

    @Override
    public void editar(Persona persona) {
            //buscar(persona);
    Persona aux = buscar(persona);
            if(persona != null){
                aux.setCurp(persona.getCurp());
                aux.setNombre(persona.getNombre());
                aux.setApellido(persona.getApellido());
                aux.setEdad(persona.getEdad());
                aux.setDireccion(persona.getDireccion());
                aux.setPuesto(persona.getPuesto());
                                }

       /* if(indice >=0 && indice <list.size()) {
            Persona aux = list.get(indice);


            aux.setCurp(persona.getCurp());
            aux.setNombre(persona.getNombre());
            aux.setApellido(persona.getApellido());
            aux.setEdad(persona.getEdad());
            aux.setDireccion(persona.getDireccion());
            aux.setPuesto(persona.getPuesto());
            return aux;
        }
        return null;*/
    }

    @Override
    public void eliminar(Persona persona) {
        Iterator<Persona> iterator = list.iterator();
        while(iterator.hasNext()){
            Persona p = iterator.next();
            if(p.getCurp().equals(persona.getCurp())){
                iterator.remove();
            }
        }
    }

    @Override
    public Persona buscar(Persona persona) {
        for (Persona p : list){
            if(p.getCurp().equals(persona.getCurp())) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Persona> listar() {
        return this.list;
    }

    public Persona buscarCurp(String curp) {
        for (Persona p : list){
            if(p.getCurp().equals(curp)) {
                return p;
            }
        }
        return null;
    }
}
