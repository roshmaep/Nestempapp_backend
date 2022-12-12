package com.example.nestempapp_backend.controller;

import com.example.nestempapp_backend.dao.AdminDao;
import com.example.nestempapp_backend.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ldap.PagedResultsControl;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemployee",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> EmployeeAdd(@RequestBody Admin a) {
        dao.save(a);
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "success");
        return status;

    }
}
