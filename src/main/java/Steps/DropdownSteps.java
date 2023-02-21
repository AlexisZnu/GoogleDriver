package Steps;

import Pages.DropdownPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class DropdownSteps {

    DropdownPage dropdownPage = new DropdownPage();

    @Given("^I navigate to the sandbox page$")
        public void navigateToSandboxPage(){
        dropdownPage.navigateToDropDownPage();
    }

    @And("^select a value from the dropdown$")
        public void selectValue(){
        dropdownPage.selectCategory("Haryana");

    }
}
