package Pages;

import MainPage.BasePage;

public class AmazonPage extends BasePage {

    private String searchBox = "//input[@id='twotabsearchtextbox']";
    private String searchButton = "//input[@id='nav-search-submit-button']";
    private String firstResults = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]";
    private String addToCartButton = "//input[@id='add-to-cart-button']";
    private String addedMessageText = "//span[contains(text(),'Agregado al carrito')]";

    public AmazonPage(){
        super(driver);
    }

    public void navigateToAmazon(){
        navigateTo("https://www.amazon.com");
    }

    public void enterSearchCriteria(String criteria){
        write(searchBox,criteria);
    }

    public void clickSearch(){
        clickElement(searchButton);
    }

    public void goToPage(String pageNumber){
        goToLinkText(pageNumber);
    }

    public void pickFirstItem(){
        clickElement(firstResults);
    }

    public void addToCart(){
        clickElement(addToCartButton);
    }

    public String addedToCartMessage(){
        return textFromElement(addedMessageText);
    }

}
