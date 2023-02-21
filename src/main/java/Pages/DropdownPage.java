package Pages;

import MainPage.BasePage;

public class DropdownPage extends BasePage {

    private String categoryDropdown ="//div[@id='react-select-3-option-2']";

    public DropdownPage(){
        super(driver);
    }

    public void navigateToDropDownPage(){
        navigateTo("https://demoqa.com/automation-practice-form");
    }


    public void selectCategory(String category){
        selectFromDropdownByVisibleText(categoryDropdown, category);
    }
}
