/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import config.ConexionDB;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author oriana
 */
public final class ActualizadorBD {
     private ActualizadorBD() { }

    /** Devuelve true si la base queda lista (ya estaba actualizada o se actualizó ahora). */
    public static boolean actualizar() {
        Connection con = ConexionDB.getInstance().getConnection();
        if (con == null) {
            return false;
        }
        try {
            if (existeColumna(con, "familiares", "familiar_usuario_id")) {
                return true; // Ya está actualizada, no hay nada que hacer
            }
            // Mismo cambio que sql/equipo1_red_familiar.sql
            String sql = "ALTER TABLE familiares "
                    + "ADD COLUMN familiar_usuario_id INT(11) NULL AFTER usuario_id, "
                    + "ADD UNIQUE KEY uk_vinculo_familiar (usuario_id, familiar_usuario_id), "
                    + "ADD CONSTRAINT fk_familiar_usuario "
                    + "FOREIGN KEY (familiar_usuario_id) REFERENCES usuarios (id) ON DELETE CASCADE";
            try (Statement st = con.createStatement()) {
                st.executeUpdate(sql);
            }
            System.out.println("Base de datos actualizada: se agregó familiares.familiar_usuario_id");
            return true;
        } catch (SQLException e) {
            System.err.println("No se pudo actualizar la base de datos: " + e.getMessage());
            return false;
        }
    }

    // Pregunta a MySQL si la tabla tiene esa columna
    private static boolean existeColumna(Connection con, String tabla, String columna) throws SQLException {
        DatabaseMetaData info = con.getMetaData();
        try (ResultSet rs = info.getColumns(con.getCatalog(), null, tabla, columna)) {
            return rs.next(); // true si encontró la columna
        }
    }
    
}
