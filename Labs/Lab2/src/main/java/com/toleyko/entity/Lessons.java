package com.toleyko.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "lessons")
@NoArgsConstructor
@ToString
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "classroom_num")
    private Integer classNum;

    @OneToOne(mappedBy = "teacherLesson", cascade = CascadeType.ALL)
    private Teachers teacher;
}
