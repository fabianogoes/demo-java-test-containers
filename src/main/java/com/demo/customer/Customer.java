package com.demo.customer;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class Customer {

    @Id
    public String id;

    public String name;
    public String document;

    public Customer(String id, String name, String document) {
        this.id = id;
        this.name = name;
        this.document = document;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
