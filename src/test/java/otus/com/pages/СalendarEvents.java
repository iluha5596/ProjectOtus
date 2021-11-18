package otus.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otus.com.dto.ActualValues;

import java.text.DateFormat;

public class СalendarEvents extends BasePage {

    public СalendarEvents(WebDriver driver) {
        super(driver);
    }
    private By classEvant = By.xpath("(//div[@class=\"dod_new-event-content\"])[1]");
    private By classDataEvant = By.xpath("(//span[@class=\"dod_new-event__date-text\"])[1]");

    public ActualValues dataСalendarEvents () {
        wait.until(ExpectedConditions.elementToBeClickable(classEvant));
        ActualValues actualValues = new ActualValues();
        String actualDataСalendarEvents = driver.findElement(classDataEvant).getText();

        actualValues.setDataСalendarEvents(actualDataСalendarEvents);


        return actualValues;
    }
}
