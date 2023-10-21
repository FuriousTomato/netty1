package com.potato.netty1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private int id;
    private int age;
    private String name;
    private String gender;
    private boolean passExam;
}
