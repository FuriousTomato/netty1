package com.potato.mp.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.potato.mp.entity.po.Employee;
import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper extends BaseMapper<Employee> {
    void updateSalaryByIds(@Param(Constants.WRAPPER) LambdaQueryWrapper queryWrapper, @Param("amount") Double amount);
}
