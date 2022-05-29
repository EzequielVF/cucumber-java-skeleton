package io.cucumber.skeleton;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileTest {

    private Mobile mobile;
    private Boolean faltoBateria;
    private Boolean duracionNegativa;

    @Before
    public void setup() {
        System.out.println("Before any test execution");
    }

    @Given("^Mobile with a porcentage of (\\d+) battery$")
    public void mobile_with_a_porcentage_of_battery(int arg1) {
        mobile = new Mobile(arg1);
        faltoBateria = false;
        duracionNegativa = false;
    }

    @When("^Trying to texting$")
    public void trying_to_texting() {
        int aux = mobile.mandarMensaje();
        if(aux == -1) {
            faltoBateria = true;
        }
    }

    @When("^Trying to call (.*) minutes$")
    public void trying_to_call(int duracion) {
        int aux = mobile.llamar(duracion);
        if(aux == -2)
            faltoBateria = true;

        if(aux == -1)
            duracionNegativa = true;

    }

    @Then("^Mobile battery charge should be (\\d+)$")
    public void mobile_battery_charge_should_be(int arg1) {
        assertEquals(arg1, mobile.preguntarCarga());
    }

    @Then("^Message should be denied due to insufficient battery$")
    public void message_should_be_denied_due_to_insufficient_battery() {
        assertTrue(faltoBateria);
    }

    @Then("^Call should be cut down due to insufficient battery$")
    public void call_should_be_cut_down_due_to_insufficient_battery() {
        assertTrue(faltoBateria);
    }

    @Then("^Call should be denied due to negative duration$")
    public void call_should_be_denied_due_to_negative_duration() {
        assertTrue(duracionNegativa);
    }

    @And("^Mobile battery shoud remain (\\d+)$")
    public void mobile_battery_should_remain(int arg1) {
        assertEquals(arg1, mobile.preguntarCarga());
    }

    @After
    public void tearDown() {
        System.out.println("After all test execution");
    }
}
