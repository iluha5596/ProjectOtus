package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import otus.com.dto.ActualValues;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class СalendarEvents extends BasePage {

    public СalendarEvents(WebDriver driver) {
        super(driver);
    }
    private By classEvent = By.xpath("(//div[@class=\"dod_new-event-content\"])[1]");
    private By classAllEvent = By.xpath("//div[@class=\"dod_new-event-content\"]");
    private By classDataEvent = By.xpath("(//span[@class=\"dod_new-event__date-text\"])[1]");
    private By classChoiceEvent = By.xpath("(//span[@class=\"dod_new-events-dropdown__input-selected\"])[1]");
    private By hrefDod = By.xpath("(//a[@href=\"/events/near/open_doors/\"])[1]");

    public ActualValues setDataСalendarEvents () throws ParseException {
        wait.until(ExpectedConditions.elementToBeClickable(classEvent));
        ActualValues actualValues = new ActualValues();
        String actualDataСalendarEvents = driver.findElement(classDataEvent).getText();
        //Отделение дня от месяцы
        String day = actualDataСalendarEvents.split(" ")[0];
        //Отделение месяца от дня
        String mouth = actualDataСalendarEvents.split(" ")[1];
        //Получение даты в формате d.M в String
        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM");
        Calendar cal = Calendar.getInstance();
        String marth  = "марта";
        String august = "августа";
        String may = "мая";
        String monthName = mouth;
        if (monthName==  marth | monthName == august ) {
            String monthNameActual =  monthName.replaceFirst(".$"," ");
            cal.setTime(inputFormat.parse(monthNameActual));
            SimpleDateFormat outputFormat = new SimpleDateFormat("M"); // 01-12
            String month = outputFormat.format(cal.getTime());
            String actualData = day + "." + month;
            //Преобразование String в Date
            Date actualDataEvent  = new SimpleDateFormat("d.M").parse(actualData);
            actualValues.setActualDataEvent(actualDataEvent);
        }
        else if (monthName == may) {
            String monthNameActual =  monthName.replaceFirst(".$","й");
            cal.setTime(inputFormat.parse(monthNameActual));
            SimpleDateFormat outputFormat = new SimpleDateFormat("M"); // 01-12
            String month = outputFormat.format(cal.getTime());
            String actualData = day + "." + month;
            //Преобразование String в Date
            Date actualDataEvent  = new SimpleDateFormat("d.M").parse(actualData);
            actualValues.setActualDataEvent(actualDataEvent);
        }
        else {
            String monthNameActual =  monthName.replaceFirst(".$","ь");
            cal.setTime(inputFormat.parse(monthNameActual));
            SimpleDateFormat outputFormat = new SimpleDateFormat("M"); // 01-12
            String month = outputFormat.format(cal.getTime());
            String actualData = day + "." + month;
            //Преобразование String в Date
            Date actualDataEvent  = new SimpleDateFormat("d.M").parse(actualData);
            actualValues.setActualDataEvent(actualDataEvent);
        }
        return actualValues;
    }

    public void goDod() {
        wait.until(ExpectedConditions.elementToBeClickable(classEvent));
        driver.findElement(classChoiceEvent).click();
        driver.findElement(hrefDod).click();
        wait.until(ExpectedConditions.elementToBeClickable(classEvent));

    }

    public ActualValues countingEventDod () {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        ActualValues actualValues = new ActualValues();
        int actualNumberEventDod  = driver.findElements(classAllEvent).size();
        actualValues.setActualNumberEventDod(actualNumberEventDod);
        return actualValues;
    }


}
