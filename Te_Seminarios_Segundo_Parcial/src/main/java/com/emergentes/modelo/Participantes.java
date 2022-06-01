
package com.emergentes.modelo;


public class Participantes {
    private int id;
    private String apellidos;
    private String nombres;
    private int id_seminario;
    private String confirmado;
    private String titulo;

    public Participantes() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getId_seminario() {
        return id_seminario;
    }

    public void setId_seminario(int id_seminario) {
        this.id_seminario = id_seminario;
    }

    public String getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(String confirmado) {
        this.confirmado = confirmado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Participantes{" + "id=" + id + ", apellidos=" + apellidos + ", nombres=" + nombres + ", id_seminario=" + id_seminario + ", confirmado=" + confirmado + ", titulo=" + titulo + '}';
    }

   


    
}
