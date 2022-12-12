package com.example.nestempapp_backend.controller;

import com.example.nestempapp_backend.dao.SecurityDao;
import com.example.nestempapp_backend.model.Admin;
import com.example.nestempapp_backend.model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao dao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> SecurityAdd(@RequestBody Security s) {
        dao.save(s);
        HashMap<String, String> status = new HashMap<>();
        status.put("id",String.valueOf(s.getId()));
        status.put("status", "success");
        return status;

    }
    @CrossOrigin(origins = "*")
    @GetMapping(path="/viewallsecurity")
    public List<Security> viewSecurity(){
        return(List<Security>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securitysearch",consumes = "application/json",produces = "application/json")
    public List<Security> SearchSecurity(@RequestBody Security s)
    {
        return (List<Security>) dao.SearchSecurity(s.getScode());

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/deletesecurity",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> delete(@RequestBody Security x){
        String id=String.valueOf(x.getId());
        System.out.println(id);
        dao.deleteSecurity(x.getId());
        HashMap <String,String> map =new HashMap<>();
        map.put("status","success");
        return map;

    }

}
