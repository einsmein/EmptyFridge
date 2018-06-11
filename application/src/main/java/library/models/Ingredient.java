package library.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient {
    @Id private String id;
    protected String name;
    protected double wastePenalty;
    protected int dayTillExp;
    protected double portion;

    public Ingredient(String name, double wastePenalty, int dayTillExp, double portion){
        this.name = name;
        this.wastePenalty = wastePenalty;
        this.dayTillExp = dayTillExp;
        this.portion = portion;
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
