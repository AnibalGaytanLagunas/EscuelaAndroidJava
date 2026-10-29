package com.example.escuela;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recycler =
                findViewById(R.id.recyclerEstudiantes);

        List<Estudiante> estudiantes = new ArrayList<>();

        estudiantes.add(new Estudiante("Ana López", 9.5));
        estudiantes.add(new Estudiante("Carlos Pérez", 8.2));
        estudiantes.add(new Estudiante("María García", 10.0));
        estudiantes.add(new Estudiante("José Hernández", 7.8));
        estudiantes.add(new Estudiante("Lucía Martínez", 9.0));

        recycler.setLayoutManager(
                new LinearLayoutManager(this)
        );

        EstudianteAdapter adapter =
                new EstudianteAdapter(estudiantes);

        recycler.setAdapter(adapter);

    }
}