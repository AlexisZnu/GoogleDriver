package Steps;

import Pages.ListPage;
import cucumber.api.java.en.*;

import java.util.List;

public class ListSteps {

    ListPage list = new ListPage();

    @Given("^I navigate to the list page$")
    public void navigateToList(){
        list.navigateToList();
    }

    @When("^I search (.+) in the list$")
    public void searchList(String state){
        list.enterSearchCriteria(state);
    }

    @Then("^I can find (.+) in the list$")
    public void findText(String city){
        List<String> lista = list.getAllElements();
        boolean textIsThere = lista.contains(city);
    if (textIsThere){
        System.out.println("The text is on the list: PASSED");
    }else {
        throw new Error("The text is not on the list; FAILED!");
    }
    }
}
