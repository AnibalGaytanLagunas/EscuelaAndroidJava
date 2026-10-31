package com.example.escuela.repository;

import com.example.escuela.model.Estudiante;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class EstudianteRepositoryTest {

    @Test
    public void obtenerTodos_devuelveLosCincoEstudiantesEnOrden() {
        EstudianteRepository repository = new EstudianteRepository();

        List<Estudiante> estudiantes = repository.obtenerTodos();

        assertEquals(5, estudiantes.size());

        assertEquals("Ana López", estudiantes.get(0).getNombre());
        assertEquals(9.5, estudiantes.get(0).getCalificacion(), 0.001);

        assertEquals("Carlos Pérez", estudiantes.get(1).getNombre());
        assertEquals(8.2, estudiantes.get(1).getCalificacion(), 0.001);

        assertEquals("María García", estudiantes.get(2).getNombre());
        assertEquals(10.0, estudiantes.get(2).getCalificacion(), 0.001);

        assertEquals("José Hernández", estudiantes.get(3).getNombre());
        assertEquals(7.8, estudiantes.get(3).getCalificacion(), 0.001);

        assertEquals("Lucía Martínez", estudiantes.get(4).getNombre());
        assertEquals(9.0, estudiantes.get(4).getCalificacion(), 0.001);
    }

    @Test
    public void obtenerTodos_devuelveUnaListaDeSoloLectura() {
        EstudianteRepository repository = new EstudianteRepository();

        List<Estudiante> estudiantes = repository.obtenerTodos();

        assertThrows(
                UnsupportedOperationException.class,
                () -> estudiantes.add(new Estudiante("Estudiante adicional", 8.0))
        );
    }
}
