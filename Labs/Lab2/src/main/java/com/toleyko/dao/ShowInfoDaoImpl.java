package com.toleyko.dao;

import com.toleyko.entity.Lessons;
import com.toleyko.entity.Teachers;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class ShowInfoDaoImpl implements ShowInfoDao {

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Lessons> getTeacherDayClassroom(String dayOfWeek, Integer classroomNum) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lessons where" +
                        " dayOfWeek =: dayOfWeek and classNum =: classroomNum", Lessons.class)
                        .setParameter("dayOfWeek", dayOfWeek)
                        .setParameter("classroomNum", classroomNum)
                        .getResultList();
    }

    @Override
    @Transactional
    public List<Teachers> getTeacherNotInThisDay(String dayOfWeek) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teachers t where t.id not in " +
                "(select l.teacher.id from Lessons l where l.dayOfWeek =: dayOfWeek)")
                .setParameter("dayOfWeek", dayOfWeek)
                .getResultList();
    }

    @Override
    @Transactional
    public List<Lessons> getDayOfWeekInDayClassesAmount(Integer classesAmount) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lessons group by dayOfWeek having count(*) =: classesAmount")
                .setParameter("classesAmount", classesAmount).getResultList();
    }

    @Override
    @Transactional
    public List<Lessons> getDayOfWeekInDayClassroomsAmount(Integer classroomsAmount) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lessons group by dayOfWeek having count(distinct classNum) =: classroomsAmount")
                .setParameter("classroomsAmount", classroomsAmount).getResultList();
    }
}
