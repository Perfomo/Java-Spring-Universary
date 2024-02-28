package com.toleyko.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "teachers")
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lesson")
    private String lesson;

    @Column(name = "lessons_amount")
    private Integer lessonsAmount;

    @Column(name = "student_amount")
    private Integer studentAmount;

    @ToString.Exclude
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    private Lessons teacherLesson;
}
