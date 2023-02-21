package Pages;

import MainPage.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage {

    private String searchField = "";
    private String searchResults = "";
    public ListPage(){
        super(driver);
    }

    public void navigateToList(){
        navigateTo("");
    }

    public void enterSearchCriteria(String state){
        try {
            write(searchField, state);
        }catch (NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found.");
            e.printStackTrace();
        }
    }

    public List<String> getAllElements(){
        List<WebElement> list = bringMeAllElements(searchResults);
        List<String> stringsFromList = new ArrayList<String>();

        for (WebElement e : list){
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }
}
