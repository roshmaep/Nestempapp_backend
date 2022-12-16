package com.example.nestempapp_backend.controller;

import com.example.nestempapp_backend.dao.LeaveDao;
import com.example.nestempapp_backend.model.Leaves;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeaveController {
@Autowired
private LeaveDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addleaves",consumes = "application/json",produces = "application/json")
    public  Map<String,String> addLeave(@RequestBody Leaves lm){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        String currentdate=String.valueOf((dt.format(now)));
        lm.setApplyDate(currentdate);
        dao.save(lm);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @Transactional
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/updatestatus",consumes = "application/json",produces = "application/json")
    public Map<String,String> updateStatus(@RequestBody Leaves lm){
        dao.updateById(lm.getStatus(),lm.getEmpId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;

    }
//    @CrossOrigin(origins = "*")
//    @GetMapping("/viewallleaves")
//    public List<Map<String,String>> viewallleaves(){
//        return (List<Map<String, String>>) dao.viewAllLeaveBy();
//
//    }
//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/viewleavesbyempid",consumes = "application/json",produces = "application/json")
//    public  List<Map<String,String>> viewLeavesById(@RequestBody Leaves lm){
//        return (List<Map<String, String>>) dao.viewLeaveById(lm.getEmpcode());
//    }
@CrossOrigin(origins = "*")
@GetMapping(path = "/viewAllLeaves")
public List<Leaves> viewAllLeave()
{
    return (List<Leaves>) dao.findAll();
}
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/accept",consumes = "application/json",produces = "application/json")
    public Map<String,String> AcceptLeave(@RequestBody Leaves l)
    {
        dao.AcceptLeave(l.getEmpId());
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");

        return map;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchstatus",consumes = "application/json",produces = "application/json")
    public List<Leaves> SearchStatus(@RequestBody Leaves l)
    {
        String empid=String.valueOf(l.getEmpId());
        System.out.println(empid);
        return (List<Leaves>) dao.SearchStatus(l.getEmpId());
    }

}
