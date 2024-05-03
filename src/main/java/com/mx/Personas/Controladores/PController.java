package com.mx.Personas.Controladores;

import com.mx.Personas.Dominio.Persona;
import com.mx.Personas.service.PersonaServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Controller
@RestController
@RequestMapping (path="/Persona")
@CrossOrigin

public class PController {

    @Autowired
    PersonaServiceImp serv;


    @GetMapping(path = "/listar") //  http://localhost:8080/Persona/listar
    public List<Persona> listar() {
        return serv.listar();
    }

    @PostMapping(path = "/nuevo") // http://localhost:8080/Persona/nuevo
    public ResponseEntity<?> guardar(@RequestBody Persona persona) {
        Persona perAux = serv.buscar(persona);
        if (perAux == null) {
            serv.guardar(persona);
            return ResponseEntity.status(HttpStatus.OK).body("{\" MENSAJE\":\"Se guardo la persona: " + persona.getNombre() + " exitosamente.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\" MENSAJE\":\"Ya existe una persona con este CRUP, intente con otro\"}");
        }

    }//fin del metodo guardar

    @PostMapping(path = "/eliminar") // http://localhost:8080/Persona/eliminar
    public ResponseEntity<?> eliminar(@RequestBody Persona persona) {
        if (serv.buscar(persona) != null) {
            serv.eliminar(persona);
            return ResponseEntity.status(HttpStatus.OK).body("{\" MENSAJE\":\"Se elimino la persona:   exitosamente.\"}");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\" MENSAJE\":\"Este curp, no existe \"}");
        }
    }//fin del metodo eliminar

    @PostMapping(path = "/editar") //http://localhost:8080/Persona/editar
    public ResponseEntity<?> editar( @RequestBody Persona persona) {
            if(serv.buscar(persona)!= null){
         serv.editar(persona);
            return ResponseEntity.status(HttpStatus.OK).body("{\" MENSAJE\":\"Se edito correctamente la persona: " + persona.getNombre() + " \"}");
        } else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\" MENSAJE\":\"Este curp, no existe para editar \"}");
         }
       }



   @PostMapping(path="/buscarCurp")
    public ResponseEntity<?> buscarCurp(@RequestParam("curp")String curp){
        Persona p = serv.buscarCurp(curp);

        if(p != null){
            return ResponseEntity.status(HttpStatus.OK).body(p);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }


}
