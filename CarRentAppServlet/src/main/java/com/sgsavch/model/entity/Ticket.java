package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.StatusTicket;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.File;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@SuperBuilder
//@ToString

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "code")
    private String code;
    @Transient
    Integer quantity;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="event_id", nullable=false)
    private Event event;
    @Column (name = "discount")
    private Integer discount;
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @Enumerated
    @Column (name = "status_ticket")
    private StatusTicket status;
    @Column (name = "qrcode")
    private File qrcode;
    public void setQRCodeAuto(){

    }
//    public void setCode(){
//        StringBuilder codeStr = new StringBuilder();
//        codeStr
//                .append(event.getId())
//                .append(":")
//                .append(event.getDate())
//                .append(":")
//                .append(event.getTime())
//                .append(":")
//                .append(event.getPlace())
//                .append(":")
//                .append(user.getFirstName())
//                .append(":")
//                .append(user.getLastName())
//                .append(":")
//                .append(id);
//        this.code = codeStr.toString();
//    }



}