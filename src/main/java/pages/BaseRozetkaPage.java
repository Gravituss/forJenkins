package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BaseRozetkaPage {

    private WebDriver driver;

    public BaseRozetkaPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement getMenuElement (String text) {
        String xpath = ".//*[@class='m-top']//a[contains(@class, 'novisited') and text()[contains(.,'" +
                text + "')]]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement getDismissBtn() {
        return dismissBtn;
    }
    public WebElement getSearchField(){
        return searchField;
    }

    public WebElement getCategoriesDropdown() {
        return categoriesDropdown;
    }

    public WebElement getCategorySportItem() {
        return categorySportItem;
    }

    @FindBy(xpath = "//div[contains(@class,'notificationPanel') and text()[contains(.,'Отказаться')]]")
    private WebElement dismissBtn;
    @FindBy (xpath = "//div[@class = 'rz-header-search-inner']//input[@name = 'text']")
    private WebElement searchField;
    @FindBy (xpath = "//div[@class = 'rz-header-search-category']//span[@name = 'rz-search-category-value']")
    private WebElement categoriesDropdown;
    @FindBy (xpath = "//div[@class = 'rz-header-search-category']//a[contains(@class," +
            "'rz-header-search-category') and text()[contains(.,'Спортивные тов')]]")
    private WebElement categorySportItem;

    public WebElement getCheckTextBlock() {
        return checkTextBlock;
    }

    @FindBy (xpath = ".//*[@id='deliveries-payments-container']/section[1]/ul/li[2]")
    private WebElement checkTextBlock;
}
