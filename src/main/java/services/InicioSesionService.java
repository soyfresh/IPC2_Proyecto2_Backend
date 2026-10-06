/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import config.DBConfig;
import dao.UsuarioDAO;
import dto.Login.DetalleUsuarioDTO;
import exception.DatoInvalidoException;
import exception.ValorVacioException;
import java.sql.Connection;
import java.sql.SQLException;
import pojo.UsuarioPOJO;
import pojo.enums.EstadoUsuario;
import utils.ContrasenaUtil;

/**
 *
 * @author dar333n
 */
public class InicioSesionService {
    
    private DBConfig dbConfig;

    public InicioSesionService(DBConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
    
    public DetalleUsuarioDTO login(String username, String contrasenaPru) throws SQLException, ValorVacioException, DatoInvalidoException{
        try(Connection cone = dbConfig.getConnection()){
            if(username==null || username.trim().isEmpty()){
                throw new ValorVacioException("Debe llenar todos los campos del formulario.");
            }
            
            if(contrasenaPru==null || contrasenaPru.trim().isEmpty()){
                throw new ValorVacioException("Debe llenar todos los campos del formulario.");
            }
            
            UsuarioDAO usuarioDao = new UsuarioDAO(cone);
            UsuarioPOJO usuarioPojo = usuarioDao.buscarPorUsuario(username);
            
            if(usuarioPojo==null){
                throw new SQLException("El usuario o la contraseña son incorrectos.");
            }
            
            if(usuarioPojo.getEstado()==EstadoUsuario.GRADUADO || usuarioPojo.getEstado()==EstadoUsuario.INACTIVO){
                throw new DatoInvalidoException("Este usuario ya no existe.");
            }
            
            ContrasenaUtil verificacion = new ContrasenaUtil();
            if(!verificacion.verificarContraseña(usuarioPojo.getContrasena(), contrasenaPru)){
                throw new SQLException("El usuario o la contraseña son incorrectos.");
            }
            
            DetalleUsuarioDTO detallUs = usuarioDao.obtenerDetallePorID(usuarioPojo.getIdUsuario());
            if(detallUs==null){
                throw new SQLException("El usuario no se encontró.");
            }
            
            detallUs.setDpi_cui(usuarioPojo.getUsername());
            
            return detallUs;
        }
    }
    
    /*
    CAMBIO DE CONTRASEÑA
    */
    
    public int verificarExistencia(String username) throws ValorVacioException, SQLException{
        try(Connection cone = dbConfig.getConnection()){
            if(username==null || username.trim().isEmpty()){
                throw new ValorVacioException("Debe llenar todos los campos del formulario.");
            } 
            
            UsuarioDAO usuarioDao = new UsuarioDAO(cone);
            UsuarioPOJO usuarioPojo = usuarioDao.buscarPorUsuario(username);
            
            if(usuarioPojo==null){
                throw new SQLException("El usuario o la contraseña son incorrectos.");
            }
            
            return usuarioPojo.getIdUsuario();
        }
    }
    
    public boolean cambiarContraseña(int idUsuario, String nuevaContrasena) throws SQLException, ValorVacioException, DatoInvalidoException{
        try(Connection cone = dbConfig.getConnection()){
            if (nuevaContrasena == null || nuevaContrasena.trim().isEmpty()) {
                throw new ValorVacioException("Debe ingresar la nueva contraseña.");
            }
            
            UsuarioDAO usuarioDao = new UsuarioDAO(cone);
            ContrasenaUtil utilContr = new ContrasenaUtil();
            String NuevaContr = utilContr.codificarContrasena(nuevaContrasena.trim());
            
            if(!usuarioDao.actualizarContrasena(idUsuario, NuevaContr)){
                throw new DatoInvalidoException("No se pudo restablecer, intente de nuevo.");
            }
            
            return true;
        }
    }
    
    /*
    CAMBIAR ESTADO DE USUARIOS-ADMIN Y SUPERADMIN
    */
    
    public boolean cambiarEstado(int idUsuario, EstadoUsuario nuevoEst) throws DatoInvalidoException, SQLException{
        try(Connection cone = dbConfig.getConnection()){
            if (nuevoEst == null) {
                throw new DatoInvalidoException("No se pudo realizar el cambio, intente de nuevo.");
            }
            
            UsuarioDAO usuarioDAO = new UsuarioDAO(cone);
            
            return usuarioDAO.cambiarEstado(idUsuario, nuevoEst);
        }
    }
}
