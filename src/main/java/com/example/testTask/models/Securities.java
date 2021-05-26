package com.example.testTask.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Securities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer data_time;

    private String tool;

    private Integer cost;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getData_time() {
        return data_time;
    }

    public void setData_time(Integer data_time) {
        this.data_time = data_time;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Securities() {
    }

    public Securities(Integer data_time, String tool, Integer cost) {
        this.data_time = data_time;
        this.tool = tool;
        this.cost = cost;
    }
}
