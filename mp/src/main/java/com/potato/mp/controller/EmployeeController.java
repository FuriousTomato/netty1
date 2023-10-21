package com.potato.mp.controller;

import cn.hutool.core.bean.BeanUtil;
import com.potato.mp.entity.po.Employee;
import com.potato.mp.entity.vo.EmployeeVo;
import com.potato.mp.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "员工管理接口")
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation("新增员工接口")
    @PostMapping
    public void saveEmployee(@RequestBody EmployeeVo employeeVo) {
        Employee employee = BeanUtil.copyProperties(employeeVo, Employee.class);
        employeeService.save(employee);
    }

    @ApiOperation("修改员工接口")
    @PutMapping
    public void updateEmployee() {
        System.out.println("aaa");
        System.out.println("bbb");
        System.out.println("ccc");
        System.out.println("push test");
        System.out.println("pull test");
        System.out.println("merge test");
    }
}
