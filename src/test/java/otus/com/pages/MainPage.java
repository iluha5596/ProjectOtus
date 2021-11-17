package otus.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends  BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    private By textСourse = By.xpath("(//p[text()=\"Курсы\"])[1]");
    private By titleTesting = By.xpath("(//a[@title=\"Тестирование\"])[1]");

    public void goTestingSection() {
        driver.findElement(textСourse).click();
        driver.findElement(titleTesting).click();
        logger.info("Раздел тестирование открыт");

    }



}