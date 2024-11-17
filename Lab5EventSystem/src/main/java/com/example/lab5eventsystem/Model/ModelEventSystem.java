package com.example.lab5eventsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ModelEventSystem {

    private String ID , description ;
    private String   capacity;

    private LocalDateTime startDate , endDate;

}
