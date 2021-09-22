/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class Food {
    private String id;
    private String name;
    private int weight;
    private String type;
    private String place;
    private LocalDate expiredDate;

    public Food() {
    }

    public Food(String id) {
        this.id = id;
    }

    public Food(String id, String name, int weight, String type, String place, LocalDate expiredDate) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expiredDate = expiredDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.id.equals(((Food) obj).getId());
    }
    
    @Override
    public String toString() {
        return id + ", " + name + ", " + weight + ", " + type + ", " + place + ", " + expiredDate;
    }
}
