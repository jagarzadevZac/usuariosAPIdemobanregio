package com.UserManagement.UserManagement.dto;


import org.springframework.lang.NonNull;


public class UserDto {

    @NonNull
    private String brm;

    @NonNull
    private String puesto;

    @NonNull
    private String nombre;

    @NonNull
    private String foto;

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

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    
}
