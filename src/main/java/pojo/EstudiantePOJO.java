/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.time.LocalDate;

/**
 *
 * @author dar333n
 */
public class EstudiantePOJO {
    private String cui;
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private String direccion;
    private String nombreEncargado;
    private String nombreEncargado2;
    private String telefonoEncargado;
    private String telefonoEncargado2;
    private String informacionMedica;
    private UsuarioPOJO usuario;

    public EstudiantePOJO(String cui, int idUsuario, String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String nombreEncargado, String nombreEncargado2, String telefonoEncargado, String telefonoEncargado2, String informacionMedica) {
        this.cui = cui;
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.nombreEncargado = nombreEncargado;
        this.nombreEncargado2 = nombreEncargado2;
        this.telefonoEncargado = telefonoEncargado;
        this.telefonoEncargado2 = telefonoEncargado2;
        this.informacionMedica = informacionMedica;
    }

    public EstudiantePOJO(String cui, int idUsuario, String nombres, String apellidos, LocalDate fechaNacimiento, String direccion, String nombreEncargado, String nombreEncargado2, String telefonoEncargado, String telefonoEncargado2, String informacionMedica, UsuarioPOJO usuario) {
        this.cui = cui;
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.nombreEncargado = nombreEncargado;
        this.nombreEncargado2 = nombreEncargado2;
        this.telefonoEncargado = telefonoEncargado;
        this.telefonoEncargado2 = telefonoEncargado2;
        this.informacionMedica = informacionMedica;
        this.usuario = usuario;
    }

    public String getCui() {
        return cui;
    }

    public void setCui(String cui) {
        this.cui = cui;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreEncargado() {
        return nombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        this.nombreEncargado = nombreEncargado;
    }

    public String getNombreEncargado2() {
        return nombreEncargado2;
    }

    public void setNombreEncargado2(String nombreEncargado2) {
        this.nombreEncargado2 = nombreEncargado2;
    }

    public String getTelefonoEncargado() {
        return telefonoEncargado;
    }

    public void setTelefonoEncargado(String telefonoEncargado) {
        this.telefonoEncargado = telefonoEncargado;
    }

    public String getTelefonoEncargado2() {
        return telefonoEncargado2;
    }

    public void setTelefonoEncargado2(String telefonoEncargado2) {
        this.telefonoEncargado2 = telefonoEncargado2;
    }

    public String getInformacionMedica() {
        return informacionMedica;
    }

    public void setInformacionMedica(String informacionMedica) {
        this.informacionMedica = informacionMedica;
    }

    public UsuarioPOJO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPOJO usuario) {
        this.usuario = usuario;
    }
    
    
}
