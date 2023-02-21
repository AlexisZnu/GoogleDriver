package Steps;

import Pages.AmazonPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class AmazonSteps {

    AmazonPage amazon = new AmazonPage();
    @Given("^the user navigate to www.amazon.com$")
    public void navigateToAmazon(){
        amazon.navigateToAmazon();
    }

    @And("^searches for (.+)$")
    public void enterSearchCriteria(String criteria){
        amazon.enterSearchCriteria(criteria);
        amazon.clickSearch();
    }

    @And("^navigate to the page number (.+)$")
    public void navigateToSecondPage(String pageNumber){
        amazon.goToPage(pageNumber);
    }

    @And("^selects the third item$")
    public void selectsThirdItem(){
        amazon.pickFirstItem();
    }

    @Then("^the user is able to add it to the cart$")
    public void itemCanBeAddedToTheCart(){
        amazon.addToCart();
        Assert.assertEquals("Agregado al carrito", amazon.addedToCartMessage());
    }
}
