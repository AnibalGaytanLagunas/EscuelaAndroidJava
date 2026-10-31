package com.example.escuela.controller;

import com.example.escuela.model.Estudiante;
import com.example.escuela.repository.EstudianteRepository;
import com.example.escuela.view.EstudianteView;

public class EstudianteController {

    private final EstudianteRepository repository;
    private final EstudianteView view;

    public EstudianteController(
            EstudianteRepository repository,
            EstudianteView view) {
        this.repository = repository;
        this.view = view;
    }

    public void cargarEstudiantes() {
        view.mostrarEstudiantes(repository.obtenerTodos());
    }

    public void seleccionarEstudiante(Estudiante estudiante) {
        view.mostrarDetalle(estudiante);
    }
}
