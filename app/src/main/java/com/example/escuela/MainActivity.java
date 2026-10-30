package com.example.escuela;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        RecyclerView recycler =
                findViewById(R.id.recyclerEstudiantes);

        EstudianteRepository repository =
                new EstudianteRepository();

        List<Estudiante> estudiantes =
                repository.obtenerTodos();

        recycler.setLayoutManager(
                new LinearLayoutManager(this)
        );

        EstudianteAdapter adapter =
                new EstudianteAdapter(estudiantes);

        recycler.setAdapter(adapter);
    }
}
