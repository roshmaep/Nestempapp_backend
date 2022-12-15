package com.example.nestempapp_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emplog")
public class Log {
    @Id
    @GeneratedValue
    private int id;
    private int empId;
    private String date;
    private String enterDateTime;
    private String exitDateTime;

    public Log() {
    }

    public Log(int id, int empId, String date, String enterDateTime, String exitDateTime) {
        this.id = id;
        this.empId = empId;
        this.date = date;
        this.enterDateTime = enterDateTime;
        this.exitDateTime = exitDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEnterDateTime() {
        return enterDateTime;
    }

    public void setEnterDateTime(String enterDateTime) {
        this.enterDateTime = enterDateTime;
    }

    public String getExitDateTime() {
        return exitDateTime;
    }

    public void setExitDateTime(String exitDateTime) {
        this.exitDateTime = exitDateTime;
    }
}
