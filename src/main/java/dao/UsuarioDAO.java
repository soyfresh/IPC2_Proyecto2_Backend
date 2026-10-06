/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Login.DetalleUsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.UsuarioPOJO;
import pojo.enums.EstadoUsuario;

/**
 *
 * @author dar333n
 */
public class UsuarioDAO {
    
    
    Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public static final String BUSCAR_POR_USUARIO="SELECT * FROM usuario WHERE username=? ? AND estado='ACTIVO";
    
    
    public static final String OBTENER_DETALLE_POR_ID="""
                                                      SELECT 
                                                      empleado.nombres AS emp_nombres,
                                                      empleado.apellidos AS emp_apellidos,
                                                      empleado.rol,
                                                      estudiante.nombres AS est_nombres,
                                                      estudiantes.apellidos AS est_apellidos,
                                                      FROM usuario
                                                      LEFT JOIN empleado ON usuario.id_usuario=empleado.id_usuario
                                                      LEFT JOIN estudiante ON usuario.id_usuario=estudiante.id_usuario
                                                      WHERE id_usuario=?;
                                                      """;
    
    
    public static final String ACTUALIZAR_CONSTRASENA="UPDATE usuario SET contrasena=? WHERE id_usuario=?";
    
    
    public static final String CAMBIAR_ESTADO="UPDATE usuario SET estado=? WHERE id_usuario=?";
    
    
   
    
    public UsuarioPOJO buscarPorUsuario(String usuarioIng) throws SQLException{
        try(PreparedStatement ps = connection.prepareStatement(BUSCAR_POR_USUARIO)){
            ps.setString(1, usuarioIng);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    return new UsuarioPOJO(
                    rs.getInt("id_usuario"),
                    rs.getString("username"),
                    rs.getString("contrasena"),
                    EstadoUsuario.valueOf(rs.getString("estado")));
                }
            }
        }
        return null;
    }
    
    public DetalleUsuarioDTO obtenerDetallePorID(int idUsuario) throws SQLException{
        try(PreparedStatement ps = connection.prepareStatement(OBTENER_DETALLE_POR_ID)){
            ps.setInt(1, idUsuario);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()){
                    
                    String nombreEmpleado = rs.getString("emp_nombres");
                    if(nombreEmpleado != null){
                        
                        String nombreCompleto = nombreEmpleado+" "+rs.getString("emp_apellidos");
                        String rol = rs.getString("rol");
                        return new DetalleUsuarioDTO(nombreCompleto, rol);
                    }
                  
                    String estNombres = rs.getString("est_nombres");
                    if (estNombres != null) {
                        
                        String nombreCompleto = estNombres + " " + rs.getString("est_apellidos");
                        return new DetalleUsuarioDTO(nombreCompleto, "ESTUDIANTE");
                    }
                }
            }
            
        }
        return null;
    }
    
    public boolean actualizarContrasena(int idUsuario, String nuevaConstraseña) throws SQLException{
        try(PreparedStatement ps = connection.prepareStatement(ACTUALIZAR_CONSTRASENA)){
            ps.setString(1, nuevaConstraseña);
            ps.setInt(2, idUsuario);
            
            return ps.executeUpdate()>0;
        }
    }
    
    public boolean cambiarEstado(int idUsuario, EstadoUsuario nuevoEstado) throws SQLException{
        try(PreparedStatement ps = connection.prepareStatement(CAMBIAR_ESTADO)){
            ps.setString(1, nuevoEstado.toString());
            ps.setInt(2, idUsuario);
            
            return ps.executeUpdate()>0;
        }
    }
}
