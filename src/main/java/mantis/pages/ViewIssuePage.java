package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//input[@value='Delete']")
    private WebElement deleteButton;

    @FindBy(xpath = "//input[@value='Delete Issues']")
    private WebElement deleteIssuesButton;

    public ViewIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void clickDeleteButton(){
        deleteButton.click();
    }

    public void clickDeleteIssuesButton(){
        deleteIssuesButton.click();
    }
}
