package com.example.ariannyreyes.alertamujer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity {

    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        btnRegistro = (Button) findViewById(R.id.btnResgistrate);

        btnRegistro.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent i = new Intent(RegistroActivity.this, FormularioDeRegistroActivity.class);
                startActivity(i);
            }
        });

    }
}
