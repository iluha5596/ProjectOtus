package otus.com.regressTests;

import org.testng.annotations.Test;
import otus.com.BaseTest;
import otus.com.dto.ActualValues;
import otus.com.pages.Authorization;
import otus.com.pages.MainPage;
import otus.com.pages.СalendarEvents;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckDatesUpcomingEvents extends BaseTest {

    //Валидация дат предстоящих мероприятий
    @Test
    public void checkingDatesUpcomingEvents() throws ParseException {
        //Открытие главной страницы Otus
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        //Переход в раздел Календарь мероприятий
        MainPage mainPage = new MainPage(driver);
        mainPage.goСalendarEvents();
        //Дата предстоящего мероприятия
        СalendarEvents actualDatesUpcomingEvents = new СalendarEvents(driver);
        ActualValues actualValues = actualDatesUpcomingEvents.setDataСalendarEvents();
        //Определение сегодняшнего дня
        DateFormat dateFormat = new SimpleDateFormat("d.M");
        Date date = new Date();
        String nowDate = dateFormat.format(date);
        Date dateExpected = new SimpleDateFormat("d.M").parse(nowDate);
        //Проверка даты предстоящего мероприятия с сегодняшней датой
        if (dateExpected.compareTo(actualValues.getActualDataEvent()) <= 0) {
            logger.info("Валидация дат предстоящих мероприятий пройдена"); }
        else if (dateExpected.compareTo(actualValues.getActualDataEvent()) > 0) {
            logger.info("Валидация дат предстоящих мероприятий НЕ пройдена");
        }
    }
}
