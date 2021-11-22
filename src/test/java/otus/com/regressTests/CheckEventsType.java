package otus.com.regressTests;

import config.ExpectedValues;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import otus.com.BaseTest;
import otus.com.dto.ActualValues;
import otus.com.pages.Authorization;
import otus.com.pages.MainPage;
import otus.com.pages.СalendarEvents;

import static org.testng.AssertJUnit.assertEquals;

public class CheckEventsType extends BaseTest {
    @Test
    private void viewEventsType() {
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        //Открытие главной страницы Otus
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        //Переход в раздел Календарь мероприятий
        MainPage mainPage = new MainPage(driver);
        mainPage.goСalendarEvents();
        //Выбрать ДОД
        СalendarEvents сalendarEvents = new СalendarEvents(driver);
        сalendarEvents.goDod();
        //Проверка мероприятий по типу
        СalendarEvents actualNumberEventDod = new СalendarEvents(driver);
        ActualValues actualValues = actualNumberEventDod.countingEventDod();
        for (int i=1; i<=actualValues.getActualNumberEventDod(); i++){
            String actualDod = driver.findElement(By.xpath("//div[@class=\"dod_new-type__text\"]")).getText();
            assertEquals(expectedValues.dod(),actualDod);
        }
        logger.info("Проверка мероприятий по типу прошла успешно");
    }
}
