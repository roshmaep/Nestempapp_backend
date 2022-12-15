package com.example.nestempapp_backend.dao;

import com.example.nestempapp_backend.model.Log;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository <Log,Integer> {
    @Query(value = "SELECT `id`, `date`, `emp_id`, `enter_date_time`, `exit_date_time` FROM `emplog` WHERE `date` =:date",nativeQuery = true)
    List<Log> viewDailyEmployeeLog(@Param("date") String date);

//    @Modifying
//
//    @Query(value="UPDATE `logs` SET `check_out`=:check_out ,`out_date`=:out_date  WHERE `empcode`=:empcode",nativeQuery = true)
//    void logOutStatus(String check_out, String out_date, Integer empcode);
//    @Query(value = "SELECT l.`id`, l.`check_in`, l.`check_out`, l.`empcode`, l.`in_date`, l.`out_date`,e.name,e.designation FROM `log` l JOIN employee e ON l.empcode=e.empcode",nativeQuery = true)
//    List<Map<String,String>> viewAllLogBy();
//    @Query(value = "SELECT l.`id`, l.`check_in`, l.`check_out`, l.`empcode`, l.`in_date`, l.`out_date`,e.empname FROM `log` l JOIN employee e ON l.empcode=e.empcode WHERE l.empcode=:e.empcode",nativeQuery = true)
//    List<Map<String,String>> viewlogByEmpid(Integer empcode);
}
