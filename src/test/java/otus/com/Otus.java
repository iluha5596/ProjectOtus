package otus.com;
import config.ExpectedValues;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import otus.com.BaseTest;
import otus.com.dto.ActualValues;
import otus.com.pages.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.testng.AssertJUnit.assertEquals;

public class Otus extends BaseTest {

    //Проверка количества курсов в разделе тестирование
    @Test
    private void checkingNumberCourses() {
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        //Открытие главной страницы Otus
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        //Переход в раздел Тестирование
        MainPage mainPage = new MainPage(driver);
        mainPage.goTestingSection();
        //Проверка количества курсов
        SectionTesting sectionTesting = new SectionTesting(driver);
        sectionTesting.countingNumberCourses();
        SectionTesting actualNumberCourses = new SectionTesting(driver);
        ActualValues actualValues = actualNumberCourses.countingNumberCourses();
        assertEquals(actualValues.getNumberCourses(), expectedValues.numberCoursesTesting());
        logger.info("Количества курсов в разделе тестирование верное");

    }

    //Просмотр карточки курса
    @Test
    private void сheckingCourseInformation() {
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        //Открытие главной страницы Otus
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        //Переход в раздел Тестирование
        MainPage mainPage = new MainPage(driver);
        mainPage.goTestingSection();
        //Переход на курс QaEngineerBasic
        SectionTesting sectionTesting = new SectionTesting(driver);
        sectionTesting.goQaEngineerBasic();
        //Проверка информации по курсу QaEngineerBasic
        CourseQaEngineerBasic actualValueQaEngineerBasic = new CourseQaEngineerBasic(driver);
        ActualValues actualValues = actualValueQaEngineerBasic.setСourseInformation();
        assertEquals(expectedValues.nameCourseQaEngineerBasic(), actualValues.getNameCourseQaEngineerBasic());
        assertEquals(expectedValues.specificationCourseQaEngineerBasic(), actualValues.getSpecificationQaEngineerBasic());
        assertEquals(expectedValues.durationTrainingQaEngineerBasic(), actualValues.getDurationTrainingQaEngineerBasic());
        assertEquals(expectedValues.formatCourseQaEngineerBasic(), actualValues.getFormatQaEngineerBasic());
        logger.info("Данные в карточке курса QaEngineerBasic верные");
        driver.navigate().back();
        //Переход на курс GameQAEngineer
        sectionTesting.goGameQAEngineer();
        //Проверка информации по курсу GameQAEngineer
        CourseGameQAEngineer actualValue = new CourseGameQAEngineer(driver);
        ActualValues actualValuesGameQAEngineer = actualValue.setСourseInformationGameQAEngineer();
        assertEquals(expectedValues.nameCourseGameQAEngineer(), actualValuesGameQAEngineer.getNameCourseGameQAEngineer());
        assertEquals(expectedValues.durationTrainingGameQAEngineer(), actualValuesGameQAEngineer.getDurationTrainingGameQAEngineer());
        assertEquals(expectedValues.formatCourseGameQAEngineer(), actualValuesGameQAEngineer.getFormatGameQAEngineer());
        logger.info("Данные в карточке курса GameQAEngineer верные");


    }

    //Валидация дат предстоящих мероприятий
    @Test
    private void checkingDatesUpcomingEvents() throws ParseException {
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

