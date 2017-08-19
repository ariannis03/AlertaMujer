package com.example.ariannyreyes.alertamujer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FormularioDeRegistroActivity extends AppCompatActivity {

    private Spinner estadoCivil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_de_registro);

        estadoCivil = (Spinner) findViewById(R.id.estadoCivil);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                        getResources().getStringArray(R.array.estado_civil));
        estadoCivil.setAdapter(adapter);
    }
}
