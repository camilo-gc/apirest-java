package com.example.apirest;

import com.example.apirest.models.Persona;
import com.example.apirest.services.interfaces.PersonaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PersonaTest {

    @Autowired(required = true)
    private PersonaService personaService;

    @Test
    public void testGuardarPersona() throws ParseException {
        Persona persona = new Persona(
                4,
                "Probando44",
                "ando4",
                "CE",
                444444,
                new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1995"),
                "probando4.ando4@gmail.com",
                "4444444444");

        Persona personaGuardada = personaService.registrar(persona);

        assertNotNull(personaGuardada);

    }

}
