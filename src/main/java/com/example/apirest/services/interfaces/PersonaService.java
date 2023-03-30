package com.example.apirest.services.interfaces;

import com.example.apirest.models.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    Persona registrar(Persona persona);

    List<Persona> obtener();

    Optional<Persona> obtenerPorId(Integer id);

    Persona obtenerPorIdentificacion(Integer identificacion);

    void actualizarPorId(Persona persona);


    void eliminar(Integer id);
}
