package com.sqli.isc.iut.courses.cucumber;

public class Command {
    public int price;
    public Client ordered;
    public Client pays;
    public boolean cocktailFinished = false;

    public Command(int price){
        this.price = price;
    }
    
}
