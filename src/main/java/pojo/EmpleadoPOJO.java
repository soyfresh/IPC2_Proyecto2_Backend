/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.time.LocalDate;
import pojo.enums.RolEmpleado;

/**
 *
 * @author dar333n
 */
public class EmpleadoPOJO {
    
    private String dpi;
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String telefono;
    private String correo;
    private String direccion;
    private LocalDate fechaContratacion;
    private double salario;
    private RolEmpleado rol;
    private UsuarioPOJO usuario;

    public EmpleadoPOJO(String dpi, int idUsuario, String nombres, String apellidos, String telefono, String correo, String direccion, LocalDate fechaContratacion, double salario, RolEmpleado rol) {
        this.dpi = dpi;
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.rol = rol;
    }

    public EmpleadoPOJO(String dpi, int idUsuario, String nombres, String apellidos, String telefono, String correo, String direccion, LocalDate fechaContratacion, double salario, RolEmpleado rol, UsuarioPOJO usuario) {
        this.dpi = dpi;
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.fechaContratacion = fechaContratacion;
        this.salario = salario;
        this.rol = rol;
        this.usuario = usuario;
        if (usuario != null) {
            this.idUsuario = usuario.getIdUsuario();
        }
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(LocalDate fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public RolEmpleado getRol() {
        return rol;
    }

    public void setRol(RolEmpleado rol) {
        this.rol = rol;
    }

    public UsuarioPOJO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPOJO usuario) {
        this.usuario = usuario;
    }
    
    
    
}
