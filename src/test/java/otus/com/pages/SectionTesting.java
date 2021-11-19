package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otus.com.dto.ActualValues;

public class SectionTesting extends BasePage {

    public SectionTesting(WebDriver driver) {
        super(driver);

    }
    private By classCourse = By.xpath("//div[@class=\"lessons__new-item-bg-right\"]");
    private By hrefQaEngineerBasic = By.xpath("//a[@href=\"/lessons/qa-engineer/?int_source=courses_catalog&int_term=testing\"]");
    private By imgGameQAEngineer  = By.xpath("//a[@href=\"/lessons/qa-game/?int_source=courses_catalog&int_term=testing\"]");


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

    }

    public void goGameQAEngineer() {
        wait.until(ExpectedConditions.elementToBeClickable(imgGameQAEngineer));
        driver.findElement(imgGameQAEngineer).click();
        logger.info("Курс GameQAEngineer открыт");



    }

}
