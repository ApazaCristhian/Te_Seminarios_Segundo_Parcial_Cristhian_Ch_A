
package com.emergentes.dao;

import com.emergentes.modelo.Participantes;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ParticipanteDAOimpl extends ConexionDB implements ParticipanteDAO{

    @Override
    public void insert(Participantes participante) throws Exception {
         try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO participantes (apellidos,nombres,id_seminario,confirmado) values (?,?,?,?)");
            ps.setString(1, participante.getApellidos());
            ps.setString(2, participante.getNombres());
            ps.setInt(3, participante.getId_seminario());
            ps.setString(4,participante.getConfirmado());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    
    }

    @Override
    public void update(Participantes participante) throws Exception {
         try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE participantes SET apellidos=?, nombres=?, id_seminario=?, confirmado=? WHERE id=?");
            ps.setString(1, participante.getApellidos());
            ps.setString(2, participante.getNombres());
            ps.setInt(3, participante.getId_seminario());
            ps.setString(4,participante.getConfirmado());
            ps.setInt(5, participante.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
       try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM participantes WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Participantes> getAll() throws Exception {
        List<Participantes> lista = null;
        try {
            this.conectar();
            String sql = "SELECT p.*,s.titulo FROM participantes p LEFT JOIN seminarios s ON p.id_seminario = s.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            lista = new ArrayList<Participantes>();
            while (rs.next()) {
                Participantes par = new Participantes();

                par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getString("confirmado"));
                par.setTitulo(rs.getString("titulo"));
                lista.add(par);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

    @Override
    public Participantes getById(int id) throws Exception {
        Participantes par = new Participantes();
        try {
            this.conectar();
            String sql ="select * from participantes where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               par.setId(rs.getInt("id"));
                par.setApellidos(rs.getString("apellidos"));
                par.setNombres(rs.getString("nombres"));
                par.setId_seminario(rs.getInt("id_seminario"));
                par.setConfirmado(rs.getString("confirmado"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return par;
    }
    
    
}
