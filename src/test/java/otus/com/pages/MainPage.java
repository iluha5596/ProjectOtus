package otus.com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends  BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    private By textСourse = By.xpath("(//p[text()=\"Курсы\"])[1]");
    private By titleTesting = By.xpath("(//a[@title=\"Тестирование\"])[1]");
    private By textEvent = By.xpath("(//p[text()=\"События\"])[1]");
    private By hrefСalendarEvents = By.xpath("//a[@href=\"/events/near/\"]");

    public void goTestingSection() {
        driver.findElement(textСourse).click();
        driver.findElement(titleTesting).click();
        logger.info("Раздел тестирование открыт");

    }

    public void goСalendarEvents() {
        driver.findElement(textEvent).click();
        driver.findElement(hrefСalendarEvents).click();

    }

}
