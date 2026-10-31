package com.example.escuela.repository;

import com.example.escuela.model.Estudiante;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EstudianteRepository {

    public List<Estudiante> obtenerTodos() {
        return Collections.unmodifiableList(Arrays.asList(
                new Estudiante("Ana López", 9.5),
                new Estudiante("Carlos Pérez", 8.2),
                new Estudiante("María García", 10.0),
                new Estudiante("José Hernández", 7.8),
                new Estudiante("Lucía Martínez", 9.0)
        ));
    }
}
