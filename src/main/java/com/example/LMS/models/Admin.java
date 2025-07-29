package com.example.LMS.models;


import jakarta.persistence.*;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends User {

    public Admin() {
        super();
    }

    public Admin(String name, String email, String password) {
        super(name, email, password, "ADMIN");
    }

    // You can override methods or add admin-specific methods if required
}
