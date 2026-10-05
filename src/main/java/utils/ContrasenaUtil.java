/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 *
 * @author dar333n
 */
public class ContrasenaUtil {
    
    
    /*
    PARA CREAR NUEVOS USUARIOS
    */
    public String codificarContrasena(String contrasenaStr) throws IllegalArgumentException{
        if(contrasenaStr==null || contrasenaStr.isEmpty()){
            throw new IllegalArgumentException("Debe ingresar una constraseña");
        }
        return Base64.getEncoder().encodeToString(contrasenaStr.getBytes(StandardCharsets.UTF_8));
    }
    
    
    /*
    VERIFICACION DE LOGIN
    */
    public boolean verificarContraseña(String contraseñaAct, String ContraseñaIngresada) throws IllegalArgumentException{
        if (ContraseñaIngresada==null || ContraseñaIngresada.trim().isEmpty()) {
            throw new IllegalArgumentException("El usuario o la contraseña son incorrectos");
        }
        
        if(contraseñaAct==null || contraseñaAct.isEmpty()){
            throw new IllegalArgumentException("Debe ingresar una constraseña");
        }
        
        String codificarIngr = codificarContrasena(ContraseñaIngresada);
        return contraseñaAct.equals(codificarIngr);
    };
    
}
