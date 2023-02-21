package Steps;

import Pages.GooglePage;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google search page$")
        public void navigateToGoogle(){
            google.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
        public void searchCriteria(){
        google.enterSearchCriteria("Argentina campeon");
    }

    @And("^click on the search button$")
        public void searchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
        public void validateResults(){
        Assert.assertEquals("Texto que esperamos", google.firstResult());
    }
}
