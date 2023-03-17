package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class IssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void addAndRemoveIssueTest() throws InterruptedException {
        String descriptionText = "Some description";
        String summaryText = "Some summary";

        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        Thread.sleep(1000);

        SoftAssert softAssert = new SoftAssert();
        mantisSite.getMainPage().goToReportIssuesPage();
        Thread.sleep(1000);

        softAssert.assertTrue(driver.findElement(By.cssSelector(".widget-title")).isDisplayed());
        mantisSite.getReportIssuePage().enterIssueFields(summaryText, descriptionText);
        Thread.sleep(1000);

        softAssert.assertTrue(driver.findElement(By.xpath("//p[text()='Operation successful.']")).isDisplayed());
        mantisSite.getReportIssuePage().clickViewIssueButton();
        Thread.sleep(1000);

        String bugId = driver.findElement(By.cssSelector("td.bug-id")).getText();
        softAssert.assertEquals(descriptionText, driver.findElement(By.cssSelector(".bug-description:last-child")).getText());
        softAssert.assertTrue(driver.findElement(By.cssSelector(".bug-summary:last-child")).getText().contains(summaryText));
        mantisSite.getViewIssuePage().clickDeleteButton();
        Thread.sleep(1000);

        mantisSite.getViewIssuePage().clickDeleteIssuesButton();

        List<WebElement> issueList = driver.findElements(By.cssSelector("td.column-id"));
        for (WebElement e : issueList) {
            softAssert.assertFalse(bugId.equals(e.getText()));
        }

        softAssert.assertAll();
        Thread.sleep(1000);
    }
}
