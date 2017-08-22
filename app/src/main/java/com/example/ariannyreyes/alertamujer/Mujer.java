package com.example.ariannyreyes.alertamujer;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Mujer {
    @Id
    private Integer id;

    private String nombres;
    private String apellidos;
    private String noCedula;
    private String noTelefono;
    private int edad;
    private int totalHijos;
    private String estadoCivil;
    @Generated(hash = 717651437)
    public Mujer(Integer id, String nombres, String apellidos, String noCedula,
            String noTelefono, int edad, int totalHijos, String estadoCivil) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.noCedula = noCedula;
        this.noTelefono = noTelefono;
        this.edad = edad;
        this.totalHijos = totalHijos;
        this.estadoCivil = estadoCivil;
    }
    @Generated(hash = 2007431504)
    public Mujer() {
    }
    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombres() {
        return this.nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNoCedula() {
        return this.noCedula;
    }
    public void setNoCedula(String noCedula) {
        this.noCedula = noCedula;
    }
    public String getNoTelefono() {
        return this.noTelefono;
    }
    public void setNoTelefono(String noTelefono) {
        this.noTelefono = noTelefono;
    }
    public int getEdad() {
        return this.edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public int getTotalHijos() {
        return this.totalHijos;
    }
    public void setTotalHijos(int totalHijos) {
        this.totalHijos = totalHijos;
    }
    public String getEstadoCivil() {
        return this.estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

}