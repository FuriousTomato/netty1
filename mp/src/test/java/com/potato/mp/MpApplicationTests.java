package com.potato.mp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.potato.mp.dao.EmployeeMapper;
import com.potato.mp.entity.po.Employee;
import com.potato.mp.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeService employeeService;

    @Test
    void contextLoads() {
        LambdaQueryWrapper<Employee> lambdaQueryWrapper = new LambdaQueryWrapper<Employee>().select(Employee::getEmployeeId, Employee::getFirstName)
                .eq(Employee::getEmployeeId, 100L);
        List<Employee> employees = employeeMapper.selectList(lambdaQueryWrapper);
        System.out.println(employees);
    }

    @Test
    void testQueryWrapper() {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>()
                .select("employee_id", "first_name", "salary")
                .likeLeft("first_name", "A")
                .gt("salary", 5000);
        System.out.println(employeeMapper.selectList(queryWrapper));
    }

    @Test
    void testUpdateWrapper() {
        UpdateWrapper<Employee> wrapper = new UpdateWrapper<Employee>()
                .eq("employee_id", 104);
        Employee employee = new Employee();
        employee.setSalary(6400.00);
        System.out.println(employeeMapper.update(employee, wrapper));
    }

    @Test
    void testLambdaQuery() {
        LambdaQueryWrapper<Employee> wrapper = new LambdaQueryWrapper<Employee>()
                .select(Employee::getEmployeeId, Employee::getHireDate)
                .ge(Employee::getHireDate, LocalDate.of(2000,1,1));
        System.out.println(employeeMapper.selectList(wrapper));
    }

    @Test
    void testCustomSql() {
        List<Integer> integers = Arrays.asList(105, 106, 107);
        LambdaQueryWrapper<Employee> in = new LambdaQueryWrapper<Employee>().in(Employee::getEmployeeId, integers);
        employeeMapper.updateSalaryByIds(in, 200.00);
    }

    @Test
    void testService() {
        List<Employee> employees = employeeService.listByIds(Arrays.asList(100L, 200L));
        employees.forEach(System.out::println);
    }
}
