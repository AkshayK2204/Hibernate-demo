package com.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student{

    @Id
    private int id;

    private String name;

    @Column(name = "rollno")
    private int roll_no;
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getRoll_no() {
        return roll_no;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }

}