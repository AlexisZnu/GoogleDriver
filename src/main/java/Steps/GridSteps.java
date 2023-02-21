package Steps;

import Pages.GridPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class GridSteps {

    GridPage grid = new GridPage();

    @Given("^I navigate to the static table$")
        public void navigateToTable(){
            grid.navigateToGrid();
    }

    @Then("^I can return the value I wanted$")
        public void returnValue(){
        String value = grid.getValueFromGrid(3,2);
        Assert.assertEquals("r: 2, c: 1", value);
    }

    @Then("^I can validate the table is displayed$")
    public void theTableIsThere(){
        Assert.assertTrue("The text is there",grid.cellStatus());
    }


}
