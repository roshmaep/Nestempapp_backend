package com.example.nestempapp_backend.dao;

import com.example.nestempapp_backend.model.Admin;
import com.example.nestempapp_backend.model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository <Security,Integer> {
  @Query(value = "SELECT `id`, `address`, `cpassword`, `email`, `name`, `password`, `phone`, `scode`, `username` FROM `security` WHERE `scode`=:scode",nativeQuery = true)
  List<Security> SearchSecurity(@Param("scode") Integer scode);

}
