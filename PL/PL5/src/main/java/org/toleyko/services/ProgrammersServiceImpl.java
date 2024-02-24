package org.toleyko.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.toleyko.dao.ProgrammersDAO;
import org.toleyko.entities.Programmers;
import java.util.List;


@Service
public class ProgrammersServiceImpl implements ProgrammersService {

    @Autowired
    private ProgrammersDAO programmersDAOImpl;
    @Override
    @Transactional
    public List<Programmers> getAllProgrammers() {
        return programmersDAOImpl.getAllProgrammers();
    }

    @Override
    @Transactional
    public void saveProgrammer(Programmers programmer) {
        programmersDAOImpl.saveProgrammer(programmer);
    }

    @Override
    @Transactional
    public void deleteProgrammer(Integer id) {
        programmersDAOImpl.deleteProgrammer(id);
    }
}
