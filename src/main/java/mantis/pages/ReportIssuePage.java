package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(css = "input[type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//a[contains(text(),'View Submitted Issue')]")
    private WebElement viewIssueButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void enterIssueFields(String summaryFieldText, String descriptionFieldText){
        summaryField.sendKeys(summaryFieldText);
        descriptionField.sendKeys(descriptionFieldText);
        submitButton.click();
    }

    public void clickViewIssueButton(){
        viewIssueButton.click();
    }
}
