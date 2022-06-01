
package com.emergentes.dao;

import com.emergentes.modelo.Seminarios;
import com.emergentes.utiles.ConexionDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SeminarioDAOimpl extends ConexionDB implements SeminarioDAO{

    @Override
    public void insert(Seminarios seminario) throws Exception {
         try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO seminarios (titulo,fecha,cupo) values (?,?,?)");
            ps.setString(1, seminario.getTitulo());
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupo());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Seminarios seminario) throws Exception {
       try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE seminarios SET titulo=?, fecha=?, cupo=? WHERE id=?");
            ps.setString(1, seminario.getTitulo());
            ps.setDate(2, seminario.getFecha());
            ps.setInt(3, seminario.getCupo());
            ps.setInt(4, seminario.getId());
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
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM seminarios WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Seminarios> getAll() throws Exception {
         List<Seminarios> lista = null;
        try {
            this.conectar();
            String sql="SELECT * FROM seminarios ";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Seminarios>();
            while (rs.next()) {
                Seminarios s = new Seminarios();

                 s.setId(rs.getInt("id"));
                s.setTitulo(rs.getString("titulo"));
                s.setFecha(rs.getDate("fecha"));
                s.setCupo(rs.getInt("cupo"));
                lista.add(s);
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
    public Seminarios getById(int id) throws Exception {
        Seminarios s = new Seminarios();
        try {
            this.conectar();
            String sql = "select * from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setTitulo(rs.getString("titulo"));
                s.setFecha(rs.getDate("fecha"));
                s.setCupo(rs.getInt("cupo"));
            }
        } catch (SQLException e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return s;
    }
    
}
