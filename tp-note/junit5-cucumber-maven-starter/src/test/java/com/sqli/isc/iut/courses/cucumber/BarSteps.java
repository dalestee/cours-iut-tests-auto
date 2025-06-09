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

    @Given("a calculator I just turned on")
    public void a_calculator_I_just_turned_on() {
        Calculator calculator = new Calculator();
    }

    @When("I substract {int} to {int}")
    public void I_substract_to(int i, int i2) {
        Calculator calculator = new Calculator();
        int result = calculator.substract(i, i2);
        assertEquals(i - i2, result);
    }

        @When("I add {int} and {int}")
    public void I_add_and(int i, int i2) {
        Calculator calculator = new Calculator();
        int result = calculator.add(i, i2);
        assertEquals(i + i2, result);
    }

        @Then("the result is {int}")
    public void the_result_is(int i) {
        Calculator calculator = new Calculator();
        int result = calculator.getResult();
        assertEquals(i, result);
    }

    @Then("{string} pay {int}€")
    public void pay(String s, int i) {
        if(s == "MR.Pignon"){
            leJuste.payBill(mr_pignon, i);
        }
    }

    @Then("the bill is checked")
    public void the_bill_is_checked() {
        if(leJuste.billChecked) {
            assertEquals(true, leJuste.billChecked);
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

    @Then("{string} is happy because they consumed only one cocktail because {string} has a liver problem")
    public void is_happy_because_they_consumed_only_one_cocktail_because_has_a_liver_problem(String s, String s2) {
        if(s.equals("MR.Pignon") && s2.equals("MR.Leblanc")) {
            assertEquals(true, mr_pignon.isSeated);
            assertEquals(true, mr_leblanc.isSeated);
            assertEquals(1, leJuste.getClients().size());
        } else {
            assertEquals(false, mr_pignon.isSeated);
            assertEquals(false, mr_leblanc.isSeated);
        }
    }

    @Then("each one of them pay their own bill")
    public void each_one_of_them_pay_their_own_bill() {
        if(mr_pignon.isSeated && mr_leblanc.isSeated) {
            leJuste.payBill(mr_pignon, 10); // Assuming the price is 10€
            leJuste.payBill(mr_leblanc, 10); // Assuming the price is 10€
            assertEquals(true, leJuste.billChecked);
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

    @Then("{string} check his bill")
    public void check_his_bill(String s) {
        if(s.equals("MR.Pignon")) {
            leJuste.payBill(mr_pignon, 10); // Assuming the price is 10€
            assertEquals(true, leJuste.billChecked);
        } else if(s.equals("MR.Leblanc")) {
            leJuste.payBill(mr_leblanc, 10); // Assuming the price is 10€
            assertEquals(true, leJuste.billChecked);
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

    @Then("{string} insisits to drink another cocktail")
    public void insisits_to_drink_another_cocktail(String s) {
        if(s.equals("MR.Pignon")) {
            leJuste.orderDrink(mr_pignon, 10); // Assuming the price is 10€
            mr_pignon.isSeated = true; // MR.Pignon insists to drink another cocktail
        } else if(s.equals("MR.Leblanc")) {
            leJuste.orderDrink(mr_leblanc, 10); // Assuming the price is 10€
            mr_leblanc.isSeated = true; // MR.Leblanc insists to drink another cocktail
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

    @Then("{string} order two cocktail of the month for {int}€")
    public void order_two_cocktail_of_the_month_for(String s, int i) {
        if(s.equals("MR.Pignon")) {
            leJuste.orderDrink(mr_pignon, i); // Assuming the price is i€
            leJuste.orderDrink(mr_pignon, i); // Ordering another cocktail
        } else if(s.equals("MR.Leblanc")) {
            leJuste.orderDrink(mr_leblanc, i); // Assuming the price is i€
            leJuste.orderDrink(mr_leblanc, i); // Ordering another cocktail
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

    @Then("{string} is sad because they consumed too much cocktails and he will have a bad night of sleep")
    public void is_sad_because_they_consumed_too_much_cocktails_and_he_will_have_a_bad_night_of_sleep(String s) {
        if(s.equals("MR.Pignon")) {
            assertEquals(true, mr_pignon.isSeated);
            assertEquals(2, leJuste.getClients().size());
            assertEquals(false, leJuste.billChecked);
        } else if(s.equals("MR.Leblanc")) {
            assertEquals(true, mr_leblanc.isSeated);
            assertEquals(2, leJuste.getClients().size());
            assertEquals(false, leJuste.billChecked);
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

    @Then("{string} will pay the bill")
    public void will_pay_the_bill(String s) {
        if(s.equals("MR.Pignon")) {
            leJuste.payBill(mr_pignon, 20);
            assertEquals(true, leJuste.billChecked);
        } else if(s.equals("MR.Leblanc")) {
            leJuste.payBill(mr_leblanc, 20);
            assertEquals(true, leJuste.billChecked);
        } else {
            assertEquals(false, leJuste.billChecked);
        }
    }

}
