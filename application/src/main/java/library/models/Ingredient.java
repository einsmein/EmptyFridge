package library.models;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {
    @Id private String id;
    @UniqueElements protected String name;
    protected double wastePenalty;
    protected int dayTillExp;
    protected double portion;
    protected double price;

    public Ingredient(String name, double wastePenalty, int dayTillExp, double portion,  double price){
        this.name = name;
        this.wastePenalty = wastePenalty;
        this.dayTillExp = dayTillExp;
        this.portion = portion;
        this.price = Math.round(price*100.0)/100.0;
    }

    public String getName() {return name; }
    public double getWastePenalty(){
        return wastePenalty;
    }
    public int getDayTillExp(){
        return dayTillExp;
    }
    public double getPortion(){
        return portion;
    }
    public double getPrice() { return price; }
    public void setName(String name){
        this.name = name;
    }

    public void setWastePenalty(double penalty){
        this.wastePenalty = penalty;
    }

    public void setDayTillExp(int day){
        this.dayTillExp = day;
    }

    public void setPortion(double portion){
        this.portion = portion;
    }
}
