package main.test.ru.miet.testing;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import main.java.ru.miet.testing.GUI;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStepdefs {
    GUI app;
    @Given("^I have entered first number ([0-9.,-]+) into the calculator$")
    public void enterFirst(double arg1) throws InterruptedException {
        app = new GUI();
        app.setVisible(true);
        app.setSize(500,200);
        //Thread.sleep(1000);
        app.first_argument.setText(Double.toString(arg1));

        //throw new PendingException();
    }
    @And("^I have entered second number ([0-9.,-]+) into the calculator$")
    public void enterSecond(double arg1) {
        app.second_argument.setText(Double.toString(arg1));
        //throw new PendingException();
    }
    @When("^I press plus$")
    public void pressPlus() {
        app.button_sum.doClick();
        //throw new PendingException();
    }
    @When("^I press minus$")
    public void pressMinus() {
        app.button_minus.doClick();
    }
    @When("^I press multiply$")
    public void pressMultiply() {
        app.button_multiply.doClick();
    }
    @When("^I press divide$")
    public void pressDivide() {
        app.button_divide.doClick();
    }
    @Then("^the result should be ([0-9.,-]+) on the screen$")
    public void result(double arg1) throws InterruptedException {
        Thread.sleep(1000);
        assertEquals(Double.toString(arg1), app.Summary.getText());
        //throw new PendingException();
    }
}
