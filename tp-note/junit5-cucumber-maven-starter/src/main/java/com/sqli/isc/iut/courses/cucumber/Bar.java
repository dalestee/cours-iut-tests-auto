package com.sqli.isc.iut.courses.cucumber;

import java.util.List;

public class Bar {
    private String name;
    public int seats;
    public int availableSeats;
    public boolean isFull = false;
    private List<Client> clients;
    private List<Command> commands;
    public boolean billChecked;
    
    public Bar(String name) {
        this.name = name;
    }

    public String getBarName() {
        return name;
    }

    public void setBarName(String name) {
        this.name = name;
    }

    public List<Client> getClients(){
        return clients;
    }

    public void addClient(Client c){
        clients.add(c);
    }

    public void removeClient(Client c){
        clients.remove(c);
    }

    public void orderDrink(Client c, int price){
        Command command = new Command(price);
        command.ordered = c;
        commands.add(command);
    }

    public void onePersonPays(Client c){
        for (Command command : commands) {
            command.pays = c;
        }
    }

    public void drinkFinished(Client c){
        for (Command command : commands) {
            if (command.ordered.equals(c)) {
                command.cocktailFinished = true;
            }
        }
    }

    public void payBill(Client mr_pignon, int i) {
        for (Command command : commands) {
            if (command.pays.equals(mr_pignon)) {
                if (command.price == i) {
                    billChecked = true;
                } else {
                    billChecked = false;
                }
            }
        }
    }
}
