package com.example.nestempapp_backend.controller;

import com.example.nestempapp_backend.dao.AdminDao;
import com.example.nestempapp_backend.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.naming.ldap.PagedResultsControl;
import java.util.HashMap;
import java.util.List;
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
        status.put("id",String.valueOf(a.getId()));
        status.put("status", "success");
        return status;

    }
    @CrossOrigin(origins = "*")
    @GetMapping(path="/viewallemp")
    public List<Admin> viewEmployee(){
        return(List<Admin>) dao.findAll();
    }
 @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
 public List<Admin> SearchProduct(@RequestBody Admin p)
 {
     return (List<Admin>) dao.SearchProduct(p.getEmpcode());

 }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String, String> delete(@RequestBody Admin p){
        String id=String.valueOf(p.getId());
        System.out.println(id);
        dao.deleteEmp(p.getId());
        HashMap <String,String> map =new HashMap<>();
        map.put("status","success");
        return map;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> UserLogin(@RequestBody Admin u){

        String email=String.valueOf(u.getEmail());
        String password=String.valueOf(u.getPassword());
        List<Admin> result=(List<Admin>) dao.EmpLogin(email,password);
        HashMap<String,String> st=new HashMap<>();
        if (result.size()==0)
        {
            st.put("status","failed");
        }
        else
        {
            int id=result.get(0).getId();
            st.put("userid",String.valueOf(id));
            st.put("status","success");
        }
        return st;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewprofile",consumes = "application/json",produces = "application/json")
    public List<Admin> ViewProfile(@RequestBody Admin v){
        return (List<Admin>) dao.viewProfile(v.getId());
    }



}
