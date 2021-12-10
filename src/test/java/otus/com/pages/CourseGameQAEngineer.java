package otus.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otus.com.dto.ActualValues;

public class CourseGameQAEngineer extends BasePage{

    public CourseGameQAEngineer(WebDriver driver) {
        super(driver);
    }
    private By classNameCourse = By.xpath("//h1[@class=\"course-header2__title\"]");
    private By classSpecificationCourse = By.xpath("//div[@class=\"course-header2__admin-text\"]");
    private By classDurationTraining  = By.xpath("(//div[@class=\"course-header2-bottom__item\"])[2]");
    private By classFormatCourse = By.xpath("(//p[@class=\"course-header2-bottom__item-text\"])[2]");
    private By titleLeaveRequest  = By.xpath("(//button[@data-goal=\"click_course_start-remind\"])[1]");

    public ActualValues setСourseInformationGameQAEngineer() {
        ActualValues actualValues = new ActualValues();
        wait.until(ExpectedConditions.elementToBeClickable(titleLeaveRequest));
        String actualNameCourse = driver.findElement(classNameCourse).getText();
        String actualSpecificationCourse = driver.findElement(classSpecificationCourse).getText();
        String actualDurationTraining = driver.findElement(classDurationTraining).getText();
        String actualFormatCourse = driver.findElement(classFormatCourse).getText();

        actualValues.setNameCourseGameQAEngineer(actualNameCourse);
        actualValues.setSpecificationGameQAEngineer(actualSpecificationCourse);
        actualValues.setDurationTrainingGameQAEngineer(actualDurationTraining);
        actualValues.setFormatGameQAEngineer(actualFormatCourse);

        return actualValues;
    }

}
