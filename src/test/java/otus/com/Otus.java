package otus.com;
import config.ExpectedValues;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import otus.com.dto.ActualValues;
import otus.com.pages.Authorization;
import otus.com.pages.CourseQaEngineerBasic;
import otus.com.pages.MainPage;
import otus.com.pages.SectionTesting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.AssertJUnit.assertEquals;

public class Otus extends BaseTest {

    //Проверка количества курсов в разделе тестирование
    @Test
    private void checkingNumberCourses() {
        ServerConfig cfg = ConfigFactory.create(ServerConfig.class);
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        //Авторизация
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        authorization.auth(cfg.login(), cfg.password());
        //Переход в раздел Тестирование
        MainPage mainPage = new MainPage(driver);
        mainPage.goTestingSection();
        //Проверка количества курсов
        SectionTesting sectionTesting = new SectionTesting(driver, expectedValues);
        sectionTesting.countingNumberCourses();
        SectionTesting actualData = new SectionTesting(driver, expectedValues);
        ActualValues actualValues = actualData.countingNumberCourses();
        assertEquals(actualValues.getNumberCourses(), expectedValues.numberCoursesTesting());
        logger.info("Количества курсов в разделе тестирование верное");

        }

    //Просмотр карточки курса
    @Test
    private void ViewCourseCard() {
        ExpectedValues expectedValues = ConfigFactory.create(ExpectedValues.class);
        //Открытие главной страницы Otus
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        //Переход в раздел Тестирование
        MainPage mainPage = new MainPage(driver);
        mainPage.goTestingSection();
        //Переход на курс QaEngineerBasic
        SectionTesting sectionTesting = new SectionTesting(driver, expectedValues);
        sectionTesting.goQaEngineerBasic();
        //Проверка информации по курсу QaEngineerBasic
        CourseQaEngineerBasic actualData = new CourseQaEngineerBasic(driver, expectedValues);
        ActualValues actualValues = actualData.checkingСourseInformation();
        assertEquals(actualValues.getNameCourseQaEngineerBasic(), expectedValues.nameCourseQaEngineerBasic());


    }

    @Test
    private  void tine() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }

}
