package com.example.employeesapp.entities;

import javax.persistence.*;

@Entity
public class Department {

    @Id
    private String name;

    @ManyToOne()
    @JoinColumn(name = "parent_id")
    private  Department parent;


    public Department() {
    }

    public Department(String name, Department parent) {
        this.name = name;
        this.parent = parent;
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

}
