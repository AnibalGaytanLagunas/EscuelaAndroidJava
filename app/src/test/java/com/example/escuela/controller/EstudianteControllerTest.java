package com.example.escuela.controller;

import com.example.escuela.model.Estudiante;
import com.example.escuela.repository.EstudianteRepository;
import com.example.escuela.view.EstudianteView;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class EstudianteControllerTest {

    @Test
    public void cargarEstudiantes_entregaLosCincoEstudiantesALaVista() {
        VistaFalsa vista = new VistaFalsa();
        EstudianteController controller =
                new EstudianteController(new EstudianteRepository(), vista);

        controller.cargarEstudiantes();

        assertEquals(5, vista.estudiantes.size());
        assertEquals("Ana López", vista.estudiantes.get(0).getNombre());
    }

    @Test
    public void seleccionarEstudiante_entregaElEstudianteSeleccionadoALaVista() {
        VistaFalsa vista = new VistaFalsa();
        EstudianteController controller =
                new EstudianteController(new EstudianteRepository(), vista);
        Estudiante seleccionado =
                new Estudiante("Ana López", 9.5);

        controller.seleccionarEstudiante(seleccionado);

        assertSame(seleccionado, vista.detalle);
    }

    private static class VistaFalsa implements EstudianteView {
        private List<Estudiante> estudiantes;
        private Estudiante detalle;

        @Override
        public void mostrarEstudiantes(List<Estudiante> estudiantes) {
            this.estudiantes = estudiantes;
        }

        @Override
        public void mostrarDetalle(Estudiante estudiante) {
            this.detalle = estudiante;
        }
    }
}
