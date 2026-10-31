package com.example.escuela.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.escuela.R;
import com.example.escuela.controller.EstudianteController;
import com.example.escuela.model.Estudiante;
import com.example.escuela.repository.EstudianteRepository;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements EstudianteView {

    private EstudianteController controller;
    private EstudianteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recycler = findViewById(R.id.recyclerEstudiantes);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        controller = new EstudianteController(
                new EstudianteRepository(),
                this
        );

        controller.cargarEstudiantes();
        recycler.setAdapter(adapter);
    }

    @Override
    public void mostrarEstudiantes(List<Estudiante> estudiantes) {
        adapter = new EstudianteAdapter(
                estudiantes,
                estudiante -> controller.seleccionarEstudiante(estudiante)
        );
    }

    @Override
    public void mostrarDetalle(Estudiante estudiante) {
        String calificacion = String.format(
                Locale.getDefault(),
                "%.1f",
                estudiante.getCalificacion()
        );

        new AlertDialog.Builder(this)
                .setTitle(estudiante.getNombre())
                .setMessage("Calificación: " + calificacion)
                .setPositiveButton("Cerrar", null)
                .show();
    }
}
