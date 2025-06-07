package com.sqli.isc.iut.courses.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarSteps {
	private Bar leJuste = new Bar("Le Juste");
    private Client mr_pignon = new Client("MR.Pignon");
    private Client mr_leblanc = new Client("MR.Leblanc");

    @Given("{string} go into the {string}")
    public void go_into_the(String clientName, String barName) {
        if(barName == "Le Juste"){
            if(clientName == "MR.Pignon"){
                leJuste.addClient(mr_pignon);
            }else if(clientName == "MR.Leblanc"){
                leJuste.addClient(mr_leblanc);
            }
        }
    }

    @Given("the {string} has only {int} seats")
    public void the_has_only_seats(String barName, int seats) {
        if(barName == "Le Juste"){
            leJuste.seats = seats;
        }
    }

    @When("{int} seats are already taken")
    public void seats_are_already_taken(int seatsAlreadyTaken) {
        leJuste.availableSeats = leJuste.seats - seatsAlreadyTaken;
    }

    @Then("{string} cannot enter the {string}")
    public void cannot_enter_the(String clientName, String barName) {
        if(barName == "Le Juste"){
            if(leJuste.seats - leJuste.availableSeats < 2){
                if(clientName == "MR.Pignon"){
                leJuste.removeClient(mr_pignon);
                }else if(clientName == "MR.Leblanc"){
                    leJuste.removeClient(mr_leblanc);
                }
            }
        }
    }

    @Then("{string} can enter the {string}")
    public void can_enter_the(String clientName, String barName) {
        if(barName == "Le Juste"){
            if(clientName == "MR.Pignon"){
                leJuste.availableSeats = leJuste.availableSeats - 1;
                mr_pignon.isSeated = true;
            }else if(clientName == "MR.Leblanc"){
                leJuste.availableSeats = leJuste.availableSeats - 1;
                mr_leblanc.isSeated = true;
            }
        }
    }

    @Then("the person after {string} and {string} cannot enter the {string}")
    public void the_person_after_and_cannot_enter_the(String clientName1, String clientName2, String barName) {
        Client newClient = new Client("MR.Random");
        if(barName == "Le Juste"){
            leJuste.addClient(newClient);
            if(leJuste.availableSeats == 0){
                leJuste.removeClient(newClient);
            }
        }
    }

    @Then("the {string} is full")
    public void the_is_full(String barName) {
        if(barName == "Le Juste"){
            leJuste.isFull = true;
        }
    }

    @Then("{string} order a cocktail of the month for {int}€")
    public void order_a_cocktail_of_the_month_for(String clientName, int price) {
        if(clientName == "MR.Pignon"){
            leJuste.orderDrink(mr_pignon, price);
        }else if(clientName == "MR.Leblanc"){
            leJuste.orderDrink(mr_leblanc, price);
        }
    }

    @Then("they agree that {string} will pay the bill")
    public void they_agree_that_will_pay_the_bill(String clientName) {
        if(clientName == "MR.Pignon"){
            leJuste.onePersonPays(mr_pignon);
        }else if(clientName == "MR.Leblanc"){
            leJuste.onePersonPays(mr_leblanc);
        }
    }

    @Then("{string} finish his cocktail")
    public void finish_his_cocktail(String clientName) {
        if(clientName == "MR.Pignon"){
            leJuste.drinkFinished(mr_pignon);
        }else if(clientName == "MR.Leblanc"){
            leJuste.drinkFinished(mr_leblanc);
        }
    }

}
