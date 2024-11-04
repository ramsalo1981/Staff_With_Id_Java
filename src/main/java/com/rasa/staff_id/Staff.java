package com.rasa.staff_id;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public class Staff {
    private String id;

    @NotBlank(message = "Name can not be empty")
    private String name;

    @NotBlank(message = "Title can not be empty")
    private String title;

    @NotNull(message = "Salary is required")
    @Positive(message = "Salary must be a positive number")
    private double salary;

    public Staff() {
        this.id = UUID.randomUUID().toString();
    }

    public Staff(String name, String title, double salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.title = title;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
