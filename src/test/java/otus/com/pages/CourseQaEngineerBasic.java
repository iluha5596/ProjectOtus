package otus.com.pages;

import config.ExpectedValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import otus.com.BaseTest;
import otus.com.dto.ActualValues;

public class CourseQaEngineerBasic extends BasePage {

    public CourseQaEngineerBasic(WebDriver driver, ExpectedValues expectedValuesQaEngineerBasic) {
        super(driver);
    }
    private By classNameCourse = By.xpath("//h1[@class=\"course-header2__title\"]");
    private By classSpecificationCourse = By.xpath("//div[@class=\"course-header2__admin-text\"]");
    private By classDurationTraining  = By.xpath("(//div[@class=\"course-header2-bottom__item\"])[2]");
    private By classFormatCourse = By.xpath("(//p[@class=\"course-header2-bottom__item-text\"])[2]");

    public ActualValues checkingСourseInformation() {
        ActualValues actualValues = new ActualValues();
        String actualNameCourse = driver.findElement(classNameCourse).getText();
        String actualSpecificationCourse = driver.findElement(classSpecificationCourse).getText();
        String actualDurationTraining = driver.findElement(classDurationTraining).getText();
        String actualFormatCourse = driver.findElement(classFormatCourse).getText();

        actualValues.setNameCourseQaEngineerBasic(actualNameCourse);
        actualValues.setSpecificationQaEngineerBasic(actualSpecificationCourse);
        actualValues.setDurationTrainingQaEngineerBasic(actualDurationTraining);
        actualValues.setFormatQaEngineerBasic(actualFormatCourse);

        return actualValues;
    }




}
