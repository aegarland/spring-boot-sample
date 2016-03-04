package features.step_definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Created by aeg on 3/4/2016.
 */
public class FirstSteps {

    @Given("^I go on \"([^\"]*)\"$")
    public void iGoOn(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(arg0);
    }

    @Then("^the title should equal \"([^\"]*)\"$")
    public void theTitleShouldEqual(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(arg0);
    }
}
