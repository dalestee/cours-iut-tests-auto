package com.sqli.isc.iut.courses.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BarSteps {
	private Bar leJuste;
	private Client mr_pignon;
	private Client mr_leblanc;

    @Given("{string} go into the bar")
    public void go_into_the_bar(String s) {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("the bar has only {int} seats")
    public void the_bar_has_only_seats(int i) {
        // Write code here that turns the phrase above into concrete actions
    }

}
