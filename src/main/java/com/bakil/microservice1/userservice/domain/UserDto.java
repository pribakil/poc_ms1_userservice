package com.bakil.microservice1.userservice.domain;

public class UserDto {
    User user;
    Department department;

    public UserDto() {
    }

    public UserDto(User user, Department department) {
        this.user = user;
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
