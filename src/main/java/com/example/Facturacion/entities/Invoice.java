package com.example.Facturacion.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date created_at;
    private double total;
    @ManyToOne
    @JoinColumn(name="client_id")
     private Clients clients;

    public Invoice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Clients getClient() {
        return clients;
    }

    public void setClient(Clients clients) {
        this.clients = clients;
    }
}
