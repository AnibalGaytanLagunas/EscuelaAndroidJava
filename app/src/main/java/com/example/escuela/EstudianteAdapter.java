package com.example.escuela;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class EstudianteAdapter
        extends RecyclerView.Adapter<EstudianteAdapter.ViewHolder> {

    private final List<Estudiante> estudiantes;

    public EstudianteAdapter(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_estudiante, parent, false);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder, int position) {

        Estudiante estudiante = estudiantes.get(position);

        holder.txtNombre.setText(estudiante.getNombre());

        holder.txtCalificacion.setText(
                String.format(
                        Locale.getDefault(),
                        "%.1f",
                        estudiante.getCalificacion()
                )
        );
    }

    @Override
    public int getItemCount() {
        return estudiantes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtCalificacion;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtCalificacion =
                    itemView.findViewById(R.id.txtCalificacion);
        }
    }
}
