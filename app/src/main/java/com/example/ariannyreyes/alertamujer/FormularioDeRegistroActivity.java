package com.example.ariannyreyes.alertamujer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class FormularioDeRegistroActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText cedula;
    private EditText telefono;
    private EditText edad;
    private EditText cantidaDeHijos;
    private Spinner estadoCivil;
    private Button btnRegistrar;

    AlertDialog.Builder builder;

    private MujerDao mujerDao;

    private Long newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_de_registro);

        nombre          = (EditText) findViewById(R.id.txtNombre);
        apellido        = (EditText) findViewById(R.id.txtApellidos);
        cedula          = (EditText) findViewById(R.id.txtCedula);
        telefono        = (EditText) findViewById(R.id.txtTelefono);
        edad            = (EditText) findViewById(R.id.txtEdad);
        cantidaDeHijos  = (EditText) findViewById(R.id.txtCantidadDeHijos);
        estadoCivil     = (Spinner) findViewById(R.id.estadoCivil);
        btnRegistrar    = (Button) findViewById(R.id.btnRegistrar);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.estado_civil));
        estadoCivil.setAdapter(adapter);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nombre.getText().toString().equals("")
                        || apellido.getText().toString().equals("")
                        || cedula.getText().toString().equals("")
                        || telefono.getText().toString().equals("")
                        || edad.getText().toString().equals("")
                        || cantidaDeHijos.getText().toString().equals("")
                        || estadoCivil.getSelectedItem().toString().equals("Seleccione")) {
                    FormularioDeRegistroActivity.this.mostrarDialogo("Información", "Complete el formulario", 0);
                }else{
                    MyApp myApp = (MyApp) getApplication();

                    mujerDao = myApp.getDaoSession().getMujerDao();

                    Mujer mujer = new Mujer();

                    mujer.setNombres(nombre.getText().toString());
                    mujer.setApellidos(apellido.getText().toString());
                    mujer.setNoCedula(cedula.getText().toString());
                    mujer.setNoTelefono(telefono.getText().toString());
                    mujer.setEdad(Integer.parseInt(edad.getText().toString()));
                    mujer.setTotalHijos(Integer.parseInt(cantidaDeHijos.getText().toString()));
                    mujer.setEstadoCivil(estadoCivil.getSelectedItem().toString());

                    newId = mujerDao.insert(mujer);

                    if(newId > 0){
                        FormularioDeRegistroActivity.this.mostrarDialogo("Información", "Datos guardados", 1);
                    }else{
                        FormularioDeRegistroActivity.this.mostrarDialogo("Error", "No se guardaron los datos", 0);
                    }
                }
            }
        });
    }

    public void mostrarDialogo(String title, String message, final int type) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if(type == 0){
                            dialog.cancel();
                        }else{
                            Intent i = new Intent(FormularioDeRegistroActivity.this, PerfilActivity.class);
                            i.putExtra("id", newId);
                            startActivity(i);
                        }
                    }
                }).show();
    }
}



