package mantis.tests;

import mantis.pages.MantisSite;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

public class IssueTest extends BaseTest {
    private MantisSite mantisSite;

    @Test
    public void addAndRemoveIssueTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login("admin", "admin20");
        Thread.sleep(1000);

        SoftAssert softAssert = new SoftAssert();
        mantisSite.getMainPage().goToReportIssuesPage();
        Thread.sleep(1000);

        softAssert.assertTrue(driver.findElement(By.cssSelector(".widget-title")).isDisplayed());
        String descriptionText = "Some description";
        mantisSite.getReportIssuePage().enterIssueFields("Some summary", descriptionText);
        Thread.sleep(1000);

        softAssert.assertTrue(driver.findElement(By.xpath("//p[text()='Operation successful.']")).isDisplayed());
        mantisSite.getReportIssuePage().clickViewIssueButton();
        Thread.sleep(1000);

        softAssert.assertEquals(descriptionText, driver.findElement(By.cssSelector(".bug-description:last-child")).getText());
        mantisSite.getViewIssuePage().clickDeleteButton();
        Thread.sleep(1000);

        mantisSite.getViewIssuePage().clickDeleteIssuesButton();
        softAssert.assertAll();
        Thread.sleep(1000);
    }
}
