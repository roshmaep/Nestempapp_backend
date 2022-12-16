package com.example.nestempapp_backend.dao;

import com.example.nestempapp_backend.model.Leaves;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<Leaves,Integer> {
    @Modifying
  @Query(value = "UPDATE `leaves` SET `status`=:status WHERE `emp_id`=:emp_id",nativeQuery = true)
   void updateById(@Param("status") Integer status,@Param("emp_id") Integer emp_id);

//    @Query(value = "SELECT  e.`empcode`, e.`name`,l.type,l.apply_date,l.from_date,l.to_date,l.status,l.remarks,l.emp_id FROM `employee` e JOIN leaves l ON e.id=l.emp_id ",nativeQuery = true)
//    List<Map<String,String>> viewAllLeaveBy();

//    @Query(value = "SELECT l.`id`, l.`apply_date`, l.`discrip`, l.`empcode`, l.`leave_date`, l.`status`,e.name,e.designation, `type` FROM `leaves` l JOIN employee e ON l.empcode=e.empcode WHERE l.empcode=:empcode",nativeQuery = true)
//    List<Map<String,String>>viewLeaveById(@Param("empcode") Integer empcode);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `leaves` SET `status`= 1 WHERE `emp_id`= :emp_id",nativeQuery = true)
    void AcceptLeave(@Param("emp_id") Integer emp_id);

    @Query(value = "SELECT `id`, `apply_date`, `emp_id`, `from_date`, `remarks`, `status`, `to_date`, `type` FROM `leaves` WHERE `emp_id`=:emp_id",nativeQuery = true)
    List<Leaves> SearchStatus(@Param("emp_id") Integer emp_id);
}
