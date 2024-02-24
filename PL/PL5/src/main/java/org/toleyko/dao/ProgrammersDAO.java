package org.toleyko.dao;

import org.toleyko.entities.Programmers;
import java.util.List;

public interface ProgrammersDAO {
    public List<Programmers> getAllProgrammers();

    public void saveProgrammer(Programmers programmer);

    public void deleteProgrammer(Integer id);
}
