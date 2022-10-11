package com.cieep.a04_creacindeelementosporcdigo;

import android.content.Intent;
import android.os.Bundle;

import com.cieep.a04_creacindeelementosporcdigo.modelos.Alumno;
import com.google.android.material.snackbar.Snackbar;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.view.LayoutInflater;
import android.view.View;



import com.cieep.a04_creacindeelementosporcdigo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    // 1. Definir la variable del Binding
    private ActivityMainBinding binding;

    private ActivityResultLauncher<Intent> launcherCreateAlumno;

    // Elementos Necesarios para Mostrar Datos en un contenedor
    // Contenedor de los datos (binding.content.contenidoMain)
    // Los datos
    private ArrayList<Alumno> alumnosList;
    // Lógica para montar los elementos en contenedor
    // Una plantilla para mostrar los elementos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 2. Instanciar el Binding al layout
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        // 3. Asignar el Binding como Contenido de la Actividad
        setContentView(binding.getRoot());

        alumnosList = new ArrayList<>();

        inicializaLaunchers();
        pintarElementos();

        setSupportActionBar(binding.toolbar);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launcherCreateAlumno.launch(new Intent(MainActivity.this, AddAlumnoActivity.class));
            }
        });
    }

    private void inicializaLaunchers() {
        launcherCreateAlumno = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                            Alumno alumno = (Alumno) result.getData().getExtras().getSerializable("ALUMNO");
                            alumnosList.add(alumno);
                            pintarElementos();
                        }
                    }
                }
        );
    }

    /**
     * Encargada de recorrer la lista de Alumnos y por cada uno insertarlo en el contenedor
     */
    private void pintarElementos() {
        binding.content.contenerdorMain.removeAllViews();
        for (Alumno alumno : alumnosList) {
            // Construimos un Layout para cada fila de alumnos
            View alumnoView = LayoutInflater.from(MainActivity.this).inflate(R.layout.alumno_model_view, null);
            // Tomo poasesión de los elementos de la Vista de la fila de Alumno
            TextView lblNombre = alumnoView.findViewById(R.id.lblNombreAlumnoModelView);
            TextView lblApellidos = alumnoView.findViewById(R.id.lblApellidosAlumnoModelView);
            TextView lblCiclo = alumnoView.findViewById(R.id.lblCicloAlumnoModelView);
            TextView lblGrupo = alumnoView.findViewById(R.id.lblGrupoAlumnoModelView);
            lblNombre.setText(alumno.getNombre());
            lblApellidos.setText(alumno.getApellidos());
            lblCiclo.setText(alumno.getCiclo());
            lblGrupo.setText(String.valueOf(alumno.getGrupo()));
            binding.content.contenerdorMain.addView(alumnoView);
        }
    }

}