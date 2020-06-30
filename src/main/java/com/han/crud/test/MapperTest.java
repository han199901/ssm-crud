package com.han.crud.test;

import com.han.crud.bean.Department;
import com.han.crud.bean.Employee;
import com.han.crud.dao.DepartmentMapper;
import com.han.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import sun.awt.AppContext;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;
    @Test
    public  void  test() {
        /*ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        ioc.getBean(DepartmentMapper.class);*/
        System.out.println(departmentMapper);
        /*departmentMapper.insertSelective(new Department(null,"开发部"));
        departmentMapper.insertSelective(new Department(null,"测试部"));*/
        //employeeMapper.insertSelective(new Employee(null,"Jerry","M","Jerry@han.com",1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for(int i=0; i<1000;i++) {
            String name = UUID.randomUUID().toString().substring(0,5);
            mapper.insertSelective(new Employee(null,name,"M","@han.com",1));
        }
        System.out.println("success");
    }
}
