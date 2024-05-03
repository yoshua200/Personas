package com.mx.Personas.Dominio;


public class Persona {
    private static int contPer=0;
    private int IdPersona;
    private String curp;
    private String nombre;
    private String apellido;
    private int edad;
    private String direccion;
    private String puesto;

    public Persona(){
        this.contPer += 1;
        this.IdPersona = contPer;
    }

    public Persona(String curp, String nombre, String apellido, int edad, String direccion, String puesto) {
        this.contPer +=1;
        this.curp = curp;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "IdPersona" +IdPersona +
                "curp='" + curp + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", direccion='" + direccion + '\'' +
                ", puesto='" + puesto + '\'' +
                '}';
    }

    public int getIdPersona() {
        return IdPersona;
    }

    public void setIdPersona(int idPersona) {
        IdPersona = idPersona;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}

