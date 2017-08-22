package com.example.ariannyreyes.alertamujer;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Denuncia {
    @Id
    private Integer id;

    private Integer mujerId;

    private String nombre;

    @Generated(hash = 789902284)
    public Denuncia(Integer id, Integer mujerId, String nombre) {
        this.id = id;
        this.mujerId = mujerId;
        this.nombre = nombre;
    }

    @Generated(hash = 1537487003)
    public Denuncia() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getMujerId() {
        return this.mujerId;
    }

    public void setMujerId(Integer mujerId) {
        this.mujerId = mujerId;
    }
}
