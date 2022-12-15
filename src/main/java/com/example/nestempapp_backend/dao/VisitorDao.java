package com.example.nestempapp_backend.dao;

import com.example.nestempapp_backend.model.Visitor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitorDao extends CrudRepository<Visitor,Integer> {
    @Query(value = "SELECT `id`, `date`, `enter_date_time`, `exit_date_time`, `name`, `purpose`, `whom_to_meet` FROM `visitorlog` WHERE `date`=:date",nativeQuery = true)
    List<Visitor> ViewDailyVisitorLog(@Param("date") String date);
}
