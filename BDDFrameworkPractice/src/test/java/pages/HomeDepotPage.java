package pages;

import base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomeDepotPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public HomeDepotPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(id = "headerSearch")
    WebElement searchField;

    @FindBy(id = "headerSearchButton")
    WebElement searchButton;

    @FindBy(id = "allProdCount")
    WebElement productCount;

    @FindBy(xpath = "(//div[@data-rectype='product']//span[@class='bttn__content'])[last()]")
    WebElement lastItemOnResultsPage;

    @FindBy(xpath = "(//div[@data-rectype='product']//span[@class='bttn__content'])[1]")
    WebElement item;

    public void addItemToCart(String index) {
        wait.until(ExpectedConditions.elementToBeClickable(lastItemOnResultsPage));
        wait.until(ExpectedConditions.elementToBeClickable(item));
        item.click();
    }

    public void searchFor(String item) {
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.sendKeys(item);
        searchButton.click();
    }

    public boolean isOnResultPage() {
        wait.until(ExpectedConditions.visibilityOf(productCount));
        if (productCount.isDisplayed()) {
            return true;
        }
        return false;
    }
}
