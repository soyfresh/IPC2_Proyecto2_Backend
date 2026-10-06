/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto.Login;

/**
 *
 * @author dar333n
 */
public class DetalleUsuarioDTO {
    
    private String dpi_cui;
    private String nombreCompleto;
    private String rol;

    public DetalleUsuarioDTO(String nombreCompleto, String rol) {
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }

    public String getDpi_cui() {
        return dpi_cui;
    }

    public void setDpi_cui(String dpi_cui) {
        this.dpi_cui = dpi_cui;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
    
    
}
