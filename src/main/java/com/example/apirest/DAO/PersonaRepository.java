package com.example.apirest.DAO;


import com.example.apirest.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {


    Persona findByIdentificacion(Integer identificacion);


    @Transactional
    @Modifying
    @Query("update Persona p " +
            "set p.nombres = ?1, p.apellidos = ?2, p.tipoIdentificacion = ?3, p.identificacion = ?4, p.nacimiento = ?5, p.correo = ?6, p.numCelular = ?7 " +
            "where p.id = ?8")
    void updateById(@NonNull String nombres, @NonNull String apellidos, @NonNull String tipoIdentificacion, @NonNull Integer identificacion, @NonNull Date nacimiento, @NonNull String correo, @NonNull String numCelular, Integer id);

}
