package com.potato.mp.entity.vo;

import lombok.Data;

import java.util.Date;
@Data
public class EmployeeVo {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private Date hireDate;
    private String jobId;
}
