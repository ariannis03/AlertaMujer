package com.example.ariannyreyes.alertamujer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private TextView txtCedula;
    private TextView txtPassword;
    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        btnEntrar = (Button)findViewById(R.id.btnEntrar);
        txtCedula = (TextView)findViewById(R.id.txtCedula);
        txtPassword = (TextView)findViewById(R.id.txtPassword);
        imageView = (ImageView)findViewById(R.id.imageView);

        btnEntrar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String cedula = txtCedula.getText().toString();
                String password = txtPassword.getText().toString();

                Usuario usuario = new Usuario();
                usuario.Cedula = usuario.Cedula.toString();
                usuario.Password = usuario.Password.toString();
            }
        });

        findViewById(R.id.lblRegistro).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, FormularioDeRegistroActivity.class);
                startActivity(i);
            }
        });
    }
}

