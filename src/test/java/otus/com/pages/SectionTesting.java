package otus.com.pages;

import config.ExpectedValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otus.com.dto.ActualValues;

public class SectionTesting extends BasePage {

    private ExpectedValues expectedValues;
    public SectionTesting(WebDriver driver, ExpectedValues expectedValues) {
        super(driver);
        this.expectedValues = expectedValues;
    }
    private By classCourse = By.xpath("//div[@class=\"lessons__new-item-bg-right\"]");
    private By hrefQaEngineerBasic = By.xpath("//a[@href=\"/lessons/qa-engineer/?int_source=courses_catalog&int_term=testing\"]");
    private By titleLeaveRequest  = By.xpath("//button[@title=\"Оставить заявку\"]");


    public ActualValues countingNumberCourses () {
        ActualValues actualValues = new ActualValues();
        int actualNumberCourses  = driver.findElements(classCourse).size();
        actualValues.setNumberCourses(actualNumberCourses);
        return actualValues;
    }

    public void goQaEngineerBasic() {
        wait.until(ExpectedConditions.elementToBeClickable(hrefQaEngineerBasic));
        driver.findElement(hrefQaEngineerBasic).click();
        logger.info("Курс QaEngineerBasic открыт");
        wait.until(ExpectedConditions.elementToBeClickable(titleLeaveRequest));

    }

}
