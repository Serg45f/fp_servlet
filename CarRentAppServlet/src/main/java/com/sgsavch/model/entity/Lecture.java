package com.sgsavch.model.entity;
import com.sgsavch.model.entity.enums.Language;
import com.sgsavch.model.entity.enums.StatusLecture;
import com.sgsavch.model.entity.enums.Theme;
import lombok.*;
//import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder


@Entity
@Table(name = "lecture")
public class Lecture{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "name")
    @NonNull
    private String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="eventLecture_id")
    private EventLecture currentEventLecture;

    @Enumerated
    @Column (name = "theme")
    Theme theme;

    @Enumerated
    @Column (name = "language")
    private Language language;

    @Column (name = "file")
    private String lectureFileName;

    @Column (name = "duration")
    private Long duration;

    @Column (name = "description")
    @NonNull
    private String description;

    @Column (name = "short_description")
    @NonNull
    private String shortDescription;

    @Enumerated
    @Column (name = "status_lecture")
    private StatusLecture status;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id", nullable=false)
    private User lector;


}