package com.example.nestempapp_backend.dao;

import com.example.nestempapp_backend.model.Admin;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminDao extends CrudRepository <Admin,Integer> {
@Query(value = "SELECT `id`, `address`, `cpassword`, `designation`, `email`, `empcode`, `name`, `password`, `phone`, `username` FROM `employee` WHERE `empcode`=:empcode",nativeQuery = true)
List<Admin>SearchProduct(@Param("empcode") Integer empcode);
@Modifying
@Transactional
@Query(value = "DELETE FROM `employee` WHERE `id`=:id",nativeQuery = true)
void deleteEmp(@Param("id")Integer id);
@Query(value = "SELECT `id`, `address`, `cpassword`, `designation`, `email`, `empcode`, `name`, `password`, `phone`, `username` FROM `employee` WHERE `email`:=email AND `password`=:password",nativeQuery = true)
List<Admin> EmpLogin(@Param("email") String email, @Param("password") String password);
}

