package org.toleyko.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.toleyko.entities.Programmers;
import java.util.List;

@Repository
public class ProgrammersDAOImpl implements ProgrammersDAO {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Programmers> getAllProgrammers() {
        Session session = sessionFactory.getCurrentSession();
        return session
                .createQuery("from Programmers", Programmers.class)
                .getResultList();
    }

    @Override
    public void saveProgrammer(Programmers programmer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(programmer);
    }

    @Override
    public void deleteProgrammer(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Programmers> query = session.createQuery("delete from Programmers " +
                "where id =: programmerId");
        query.setParameter("programmerId", id);
        query.executeUpdate();
    }
}
