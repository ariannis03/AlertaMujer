package com.example.ariannyreyes.alertamujer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    private MujerDao mujerDao;
    private DenunciaDao denunciaDao;

    private Long id;
    private Button btnAgregarDenuncia;
    private int total;
    private Mujer m = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        MyApp myApp = (MyApp) getApplication();

        mujerDao = myApp.getDaoSession().getMujerDao();

        denunciaDao = myApp.getDaoSession().getDenunciaDao();

        id = getIntent().getLongExtra("id", 0);

        if(id > 0){
            QueryBuilder queryBuilder = mujerDao.queryBuilder().where(MujerDao.Properties.Id.eq(id));

            m = ((List<Mujer>)queryBuilder.list()).get(0);
        }else{

        }

        if(m != null){

            ((TextView)(findViewById(R.id.txt_nombre))).setText(m.getNombres());
            ((TextView)(findViewById(R.id.txt_apellidos))).setText(m.getApellidos());
            ((TextView)(findViewById(R.id.txt_cedula))).setText(m.getNoCedula());
            ((TextView)(findViewById(R.id.txt_total_hios))).setText(String.valueOf(m.getTotalHijos()));
            ((TextView)(findViewById(R.id.txt_edad))).setText(String.valueOf(m.getEdad()));
            ((TextView)(findViewById(R.id.txt_estado_civil))).setText(m.getEstadoCivil());
        }

        cargarDenuncias();


        btnAgregarDenuncia = (Button)findViewById(R.id.btn_agregar_denuncia);
        btnAgregarDenuncia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = m.getId()+"-DEN-"+total;
                Denuncia d = new Denuncia();

                d.setMujerId(m.getId());
                d.setNombre(nombre);

                denunciaDao.insert(d);
                Toast.makeText(PerfilActivity.this, "Denuncia "+nombre+" creada!", Toast.LENGTH_LONG).show();
                cargarDenuncias();
            }
        });

    }

    public void cargarDenuncias(){
        // Denuncias

        QueryBuilder queryBuilder = denunciaDao.queryBuilder().where(DenunciaDao.Properties.MujerId.eq(m.getId()));
        final List<Denuncia> items = queryBuilder.list();
        total = items.size();

        final DenunciasAdapter adapter = new DenunciasAdapter(getApplicationContext(), (ArrayList<Denuncia>) items);
        ((ListView) findViewById(R.id.listado_denuncias)).setAdapter(adapter);
    }
}
