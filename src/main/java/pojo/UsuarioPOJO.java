/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import pojo.enums.EstadoUsuario;

/**
 *
 * @author dar333n
 */
public class UsuarioPOJO {
    
    private int idUsuario;
    private String username;
    private String contrasena;
    private EstadoUsuario estado;

    public UsuarioPOJO(String username, String contrasena, EstadoUsuario estado) {
        this.username = username;
        this.contrasena = contrasena;
        this.estado = estado;
    }
    
    public UsuarioPOJO(int idUsuario, String username, String contrasena, EstadoUsuario estado) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.contrasena = contrasena;
        this.estado = estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }
    
    
}
