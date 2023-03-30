package com.example.apirest.services;

import com.example.apirest.DAO.PersonaRepository;
import com.example.apirest.models.Persona;
import com.example.apirest.services.interfaces.PersonaService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;


    public Persona registrar(Persona persona){
        return personaRepository.save(persona);
    }


    public List<Persona> obtener(){
        return personaRepository.findAll();
    }


    public Optional<Persona> obtenerPorId(Integer id) {
        return personaRepository.findById(id);
    }


    public Persona obtenerPorIdentificacion(Integer identificacion) {
        return personaRepository.findByIdentificacion(identificacion);
    }


    public void actualizarPorId(@NotNull Persona persona){

        personaRepository.updateById(
                persona.getNombres(),
                persona.getApellidos(),
                persona.getTipoIdentificacion(),
                persona.getIdentificacion(),
                persona.getNacimiento(),
                persona.getCorreo(),
                persona.getNumCelular(),
                persona.getId());
    }


    public void eliminar(Integer id) {
        personaRepository.deleteById(id);
    }

}
