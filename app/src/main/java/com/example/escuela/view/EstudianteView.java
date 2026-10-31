package com.example.escuela.view;

import com.example.escuela.model.Estudiante;

import java.util.List;

public interface EstudianteView {

    void mostrarEstudiantes(List<Estudiante> estudiantes);

    void mostrarDetalle(Estudiante estudiante);
}
