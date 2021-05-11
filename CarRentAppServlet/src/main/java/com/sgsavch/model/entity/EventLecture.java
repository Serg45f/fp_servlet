package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Theme;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "event_lecture")
public class EventLecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "order_number")
    private Integer orderNumber;
    @Enumerated
    @Column (name = "theme")
    private Theme theme;
    @OneToOne
    @JoinColumn(name = "lecture_id")
    private com.sgsavch.model.entity.Lecture lecture;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=false)
    private Event event;
}
