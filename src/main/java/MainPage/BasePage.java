package MainPage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//Lo que hace el "static" es que haya un solo valor para todas las instancias del objeto de esta clase
//De esta manera lo que estamos haciendo es que haya una sola instancia del webDriver compartida para todas las clases
public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

//este bloque estático va a hacer que se ejecute al comienzo de esto

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver,10);
    }
    //Acá en el wait lo que estamos haciendo es pasarle el objeto del webDriver, en este caso el driver que cree mas arriba
    // despues creamos el objeto del driver usando las opciones de chrome
    //despues le decimos que use esta espera cuando usemos el driver.


    //El constructor de la clase
    //Cada vez que creemos la instancia del webDriver, va a crear el objeto que la instanciamos una sola vez en esta página
    public BasePage(WebDriver driver){
        BasePage.driver= driver;
        wait = new WebDriverWait(driver,10);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public void goToLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public static void navigateTo(String url){
        driver.get(url);
    }

    private WebElement Find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        Find(locator).click();
    }

    public void write(String locator, String textToWrite){
        Find(locator).clear();
        Find(locator).sendKeys(textToWrite);
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByVisibleText(String locator, String valueToSelect){
        Select dropdown = new Select(Find(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        actions.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        actions.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        actions.contextClick(Find(locator));
    }

    public String getValueFromTable(String locator, int row, int column){
        String cellINeed = locator+"/table/tbody/tr["+row+"]/td["+column+"]";
        return Find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column,String stringToSend){

        String cellToFill = locator+"/table/tbody/tr["+row+"]/td["+column+"]";

        Find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToIFrame(int iFrameIndex){
        driver.switchTo().frame(iFrameIndex);
    }

    public void  switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        try {
            driver.switchTo().alert().dismiss();
        }catch (NoAlertPresentException e){
            e.printStackTrace();
        }
    }

    public String textFromElement(String locator){
        return Find(locator).getText();
    }

    public  boolean elementEnabled(String locator){
        return Find(locator).isEnabled();
    }

    public boolean elementIsDisplayed(String locator){
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        return Find(locator).isSelected();
    }

    public List<WebElement>bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    public void selectNthElement(String locator, int index){
        List<WebElement> results = driver.findElements(By.xpath(locator));
        results.get(index).click();
    }

}
