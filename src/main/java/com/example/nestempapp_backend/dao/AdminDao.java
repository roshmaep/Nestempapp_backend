package com.example.nestempapp_backend.dao;

import com.example.nestempapp_backend.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminDao extends CrudRepository <Admin,Integer> {
}
