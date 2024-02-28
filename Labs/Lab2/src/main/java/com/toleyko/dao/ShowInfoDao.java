package com.toleyko.dao;

import com.toleyko.entity.Lessons;
import com.toleyko.entity.Teachers;
import java.util.List;

public interface ShowInfoDao {
    public List<Lessons> getTeacherDayClassroom(String dayOfWeek, Integer classroomNum);

    public List<Teachers> getTeacherNotInThisDay(String dayOfWeek);

    public List<Lessons> getDayOfWeekInDayClassesAmount(Integer classesAmount);

    public List<Lessons> getDayOfWeekInDayClassroomsAmount(Integer classroomsAmount);
}
