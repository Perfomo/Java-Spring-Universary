package org.toleyko.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;


@Entity
@Data
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Table(name = "programmers")
public class Programmers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "pr_lang")
    private String progLang;

    @Column(name = "exp")
    private Integer exp;

}
