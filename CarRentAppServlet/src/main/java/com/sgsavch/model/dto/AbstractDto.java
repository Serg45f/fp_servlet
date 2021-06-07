package com.sgsavch.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;


public abstract class AbstractDto implements Serializable {
    private Long id;
    LocalDateTime created;
    LocalDateTime updated;
}
