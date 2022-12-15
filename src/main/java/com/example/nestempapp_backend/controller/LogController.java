package com.example.nestempapp_backend.controller;

import com.example.nestempapp_backend.dao.LogDao;
import com.example.nestempapp_backend.dao.VisitorDao;
import com.example.nestempapp_backend.model.Log;
import com.example.nestempapp_backend.model.Visitor;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogController {
    @Autowired
    private LogDao edao;

    @Autowired
    private VisitorDao vdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logEmployee",consumes = "application/json",produces = "application/json")
    public Map<String,String> EmployLog(@RequestBody Log emp)
    {

        edao.save(emp);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllEmployeeLog")
    public List<Log> ViewAllEmployeeLog()
    {
        return (List<Log>) edao.findAll();
    }
//
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewDailyEmployeeLog",consumes = "application/json",produces = "application/json")
    public List<Log> viewDailyEmployeeLog(@RequestBody Log emp)
    {
        return (List<Log>) edao.viewDailyEmployeeLog(emp.getDate());
    }
//
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/logVisitor",consumes = "application/json",produces = "application/json")
    public Map<String,String> VisitorLog(@RequestBody Visitor v)
    {

        vdao.save(v);
        HashMap<String,String> map =new HashMap<>();
        map.put("status","success");
        return map;
    }
//
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/viewAllVisitorLog")
    public List<Visitor> ViewAllVisitorLog()
    {
        return (List<Visitor>) vdao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewDailyVisitorLog",consumes = "application/json",produces = "application/json")
    public List<Visitor> ViewDailyVisitorLog(@RequestBody Visitor v)
    {
        return (List<Visitor>) vdao.ViewDailyVisitorLog(v.getDate());
    }






}


