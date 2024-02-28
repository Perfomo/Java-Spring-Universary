package com.toleyko.controller;

import com.toleyko.dao.ShowInfoDao;
import com.toleyko.entity.Lessons;
import com.toleyko.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private ShowInfoDao showInfoDaoImpl;

    //Main page

    @RequestMapping("/")
    public String showIndex() {
        System.out.println("inter");
        return "index";
    }

    //Task1

    @GetMapping("/teacherDayClassroom")
    public String inputTeacherDayClassroom() {
        return "inputTeacherDayClassroom";
    }

    @PostMapping("/teacherDayClassroom")
    public String showTeacherDayClassroom(@RequestParam("dayOfWeek") String dayOfWeek,
                                          @RequestParam("classroomNum") Integer classroomNum,
                                          Model model) {
        List<Lessons> lessons = showInfoDaoImpl.getTeacherDayClassroom(dayOfWeek, classroomNum);
        model.addAttribute("info", lessons);
        return "showTeacherDayClassroom";
    }

    //Task2

    @GetMapping("/teacherNotInThisDay")
    public String inputTeacherNotInThisDay() {
        return "inputTeacherNotInThisDay";
    }

    @PostMapping("/teacherNotInThisDay")
    public String showTeacherNotInThisDay(@RequestParam("dayOfWeek") String dayOfWeek,
                                          Model model) {
        List<Teachers> teachers = showInfoDaoImpl.getTeacherNotInThisDay(dayOfWeek);
        model.addAttribute("info", teachers);
        return "showTeacherNotInThisDay";
    }

    //Task3

    @GetMapping("/dayOfWeekInDayClassesAmount")
    public String inputDayOfWeekInDayClassesAmount() {
        return "inputDayOfWeekInDayClassAmount";
    }

    @PostMapping("/dayOfWeekInDayClassesAmount")
    public String showDayOfWeekInDayClassesAmount(@RequestParam("classesAmount") Integer classesAmount,
                                                  Model model) {
        List<Lessons> lessons = showInfoDaoImpl.getDayOfWeekInDayClassesAmount(classesAmount);
        model.addAttribute("info", lessons);
        return "showDayOfWeekInDayClassesAmount";
    }

    //Task4

    @GetMapping("/dayOfWeekInDayClassroomsAmount")
    public String inputDayOfWeekInDayClassroomsAmount() {
        return "inputDayOfWeekInDayClassroomsAmount";
    }

    @PostMapping("/dayOfWeekInDayClassroomsAmount")
    public String showDayOfWeekInDayClassroomsAmount(@RequestParam("classroomsAmount") Integer classroomsAmount,
                                                     Model model) {
        List<Lessons> lessons = showInfoDaoImpl.getDayOfWeekInDayClassroomsAmount(classroomsAmount);
        System.out.println(lessons);
        model.addAttribute("info", lessons);
        return "showDayOfWeekInDayClassroomsAmount";
    }
}
