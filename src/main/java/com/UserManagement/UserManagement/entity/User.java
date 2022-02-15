package com.UserManagement.UserManagement.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String brm;
    private String puesto;
    private String nombre;
    private String foto;

    public User(){
        
    }

    
    public User(String brm, String puesto, String nombre, String foto) {
        this.brm = brm;
        this.puesto = puesto;
        this.nombre = nombre;
        this.foto = foto;
    }


    public String getFoto() {
        return foto;
    }


    public void setFoto(String foto) {
        this.foto = foto;
    }



    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getBrm() {
        return brm;
    }


    public void setBrm(String brm) {
        this.brm = brm;
    }


    public String getPuesto() {
        return puesto;
    }


    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    

    
}
