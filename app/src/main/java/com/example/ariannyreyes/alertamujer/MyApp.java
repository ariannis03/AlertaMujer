package com.example.ariannyreyes.alertamujer;

import android.app.Application;

import org.greenrobot.greendao.database.Database;


public class MyApp extends Application {

    private DaoSession daoSession;
    @Override
    public void onCreate() {
        super.onCreate();
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "alertamujer-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
