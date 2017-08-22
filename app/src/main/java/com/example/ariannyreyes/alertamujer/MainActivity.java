package com.example.ariannyreyes.alertamujer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.greendao.query.QueryBuilder;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnEntrar;
    private TextView txtCedula;
    private TextView txtPassword;
    private ImageView imageView;

    AlertDialog.Builder builder;


    private MujerDao mujerDao;

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
                if(!txtCedula.getText().toString().equals("") && !txtPassword.getText().toString().equals("")){
                    MyApp myApp = (MyApp) getApplication();

                    mujerDao = myApp.getDaoSession().getMujerDao();

                    QueryBuilder queryBuilder = mujerDao.queryBuilder().where(MujerDao.Properties.NoCedula.eq(txtCedula.getText().toString()));
                    List<Mujer> mujeres = queryBuilder.list();
                    Mujer m = new Mujer();
                    m.setId(0);
                    if(mujeres.size() > 0){
                        m = mujeres.get(0);
                    }


                    if(m.getId() > 0){
                        Intent i = new Intent(MainActivity.this, PerfilActivity.class);
                        i.putExtra("id", Long.parseLong(m.getId().toString()));
                        startActivity(i);
                    }else{
                        mostrarDialogo("Error de autenticación", "Cédula o contraseña invalida!");
                    }
                }
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

    public void mostrarDialogo(String title, String message) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }).show();
    }
}

