package features.step_definitions;

import com.aegarland.sample.vending.VendingMachineRestApplication;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriverBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aeg on 3/4/2016.
 */
@WebAppConfiguration
@ContextConfiguration(classes=VendingMachineRestApplication.class, loader=SpringApplicationContextLoader.class)
public class FirstSteps {

    @Autowired
    WebApplicationContext context;

    WebDriver driver;

    @Before
    public void setup() {
        assertNotNull(context);
        driver = MockMvcHtmlUnitDriverBuilder
                .webAppContextSetup(context)
                .build();
    }

    @After
    public void destroy() {
        if(driver != null) {
            driver.close();
        }
    }

    String url;

    @When("^I go on \"([^\"]*)\"$")
    public void iGoOn(String url) throws Throwable {
        assertNotNull(driver);
        driver.get("http://localhost:8080/"+url);
    }

    @Then("^the title should equal \"([^\"]*)\"$")
    public void theTitleShouldEqual(String title) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(title,is(equalTo(driver.getTitle())));
    }
}
