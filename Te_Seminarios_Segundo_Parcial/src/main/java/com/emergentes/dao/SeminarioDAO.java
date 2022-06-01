
package com.emergentes.dao;

import com.emergentes.modelo.Seminarios;
import java.util.List;


public interface SeminarioDAO {
            public void insert(Seminarios seminario) throws Exception;
    public void update(Seminarios seminario) throws Exception;
    public void delete(int id) throws Exception;
    public List<Seminarios> getAll() throws Exception;
    public Seminarios getById(int id) throws Exception;
    
}
