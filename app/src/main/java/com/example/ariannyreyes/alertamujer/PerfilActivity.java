package com.example.ariannyreyes.alertamujer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class PerfilActivity extends AppCompatActivity {

    private MujerDao mujerDao;
    private Long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        MyApp myApp = (MyApp) getApplication();

        mujerDao = myApp.getDaoSession().getMujerDao();

        id = getIntent().getLongExtra("id", 0);
        Mujer m = null;

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

    }
}
