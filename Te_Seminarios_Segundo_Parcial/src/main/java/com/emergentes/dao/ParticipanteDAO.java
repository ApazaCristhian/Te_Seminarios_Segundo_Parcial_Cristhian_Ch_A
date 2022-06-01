
package com.emergentes.dao;

import com.emergentes.modelo.Participantes;
import java.util.List;


public interface ParticipanteDAO {
        public void insert(Participantes participante) throws Exception;
    public void update(Participantes participante) throws Exception;
    public void delete(int id) throws Exception;
    public List<Participantes> getAll() throws Exception;
    public Participantes getById(int id) throws Exception;
    
}
