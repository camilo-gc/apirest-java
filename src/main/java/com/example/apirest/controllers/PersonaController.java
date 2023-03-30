package com.example.apirest.controllers;

import com.example.apirest.models.Persona;
import com.example.apirest.response.PruebaResponse;
import com.example.apirest.services.interfaces.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/apirest/personas")
public class PersonaController { //endpoints

    @Autowired
    PersonaService personaService;


    @GetMapping(value = "/prueba", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PruebaResponse> prueba(){
        PruebaResponse pruebaResponse = new PruebaResponse("001", "Probando Ando");
        System.err.println(pruebaResponse);
        return new ResponseEntity<>(pruebaResponse, HttpStatus.OK);
    }


    @PostMapping(value = "/registro", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> registrar(@RequestBody Persona persona){
        System.err.println("Registrando... " + persona);
        personaService.registrar(persona);

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Persona>> obtenerPersonas(){
        System.err.println("Obteniendo personas...");
        List<Persona> listPersonas = personaService.obtener();

        return new ResponseEntity<>(listPersonas, HttpStatus.OK);
    }


    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obtenerPorId(@PathVariable("id") Integer id){
        System.err.println("Obteniendo por id... " + id);
        Optional<Persona> persona = personaService.obtenerPorId(id);

        if(persona == null){

            return ResponseEntity.notFound().build();

        }

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


    @GetMapping(value = "/{identificacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> obtenerPorIdentificacion(@PathVariable("identificacion") Integer identificacion){
        System.err.println("Obteniendo por identificacion... " + identificacion);
        Persona persona = personaService.obtenerPorIdentificacion(identificacion);

        if(persona == null){

            return ResponseEntity.notFound().build();

        }

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PutMapping(value = "/actualizar", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persona> actualizar(@RequestBody Persona persona){
        System.err.println("Actualizando... " + persona);
        personaService.actualizarPorId(persona);

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }


    @DeleteMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> eliminar(@PathVariable("id") Integer id){
        System.err.println("Eliminando por id... " + id);
        personaService.eliminar(id);

        return new ResponseEntity<>("Eliminado", HttpStatus.OK);
    }


}
