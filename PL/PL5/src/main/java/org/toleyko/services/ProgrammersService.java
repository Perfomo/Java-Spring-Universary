package org.toleyko.services;

import org.toleyko.entities.Programmers;
import java.util.List;

public interface ProgrammersService {
    public List<Programmers> getAllProgrammers();

    public void saveProgrammer(Programmers programmer);

    public void deleteProgrammer(Integer id);
}
