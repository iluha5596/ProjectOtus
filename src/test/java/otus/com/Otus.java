package otus.com;
import config.ExpectedValues;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import otus.com.dto.ActualValues;
import otus.com.pages.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
        ActualValues actualValues = actualValueQaEngineerBasic.checkingСourseInformation();
        assertEquals(expectedValues.nameCourseQaEngineerBasic(), actualValues.getNameCourseQaEngineerBasic());
        assertEquals(expectedValues.specificationCourseQaEngineerBasic(), actualValues.getSpecificationQaEngineerBasic());
        assertEquals(expectedValues.durationTrainingQaEngineerBasic(), actualValues.getDurationTrainingQaEngineerBasic());
        assertEquals(expectedValues.formatCourse(), actualValues.getFormatQaEngineerBasic());
        logger.info("Данные в карточке курса QaEngineerBasic верные");

    }

    //Валидация дат предстоящих мероприятий
    @Test
    private void checkingDatesUpcomingEvents() {
        //Открытие главной страницы Otus
        Authorization authorization = new Authorization(driver);
        authorization.openOtus();
        //Переход в раздел Календарь мероприятий
        MainPage mainPage = new MainPage(driver);
        mainPage.goСalendarEvents();
        //Дата предстоящего мероприятия
        СalendarEvents actualDatesUpcomingEvents = new СalendarEvents(driver);
        ActualValues actualValues = actualDatesUpcomingEvents.dataСalendarEvents();

        //Определение сегодняшнего дня
        DateFormat dateFormat = new SimpleDateFormat("d M");
        Date date = new Date();
        String nowDate = dateFormat.format(date);
        //Проверка даты предстоящего мероприятия с сегодняшней датой

    }

    @Test
    private void month() throws ParseException {

        SimpleDateFormat inputFormat = new SimpleDateFormat("MMM");
        Calendar cal = Calendar.getInstance();
        String monthName = "февраля";
        String monthName2 =  monthName.replaceFirst(".$","ь");

        cal.setTime(inputFormat.parse(monthName2));
        SimpleDateFormat outputFormat = new SimpleDateFormat("M"); // 01-12
        String month = outputFormat.format(cal.getTime());
        System.out.println(month);
        String actualData = "18." + month;
        System.out.println(actualData);

        //Определение сегодняшнего дня
        DateFormat dateFormat = new SimpleDateFormat("d.M");
        Date date = new Date();
        String nowDate = dateFormat.format(date);
        System.out.println(nowDate);


        Date date1 = new SimpleDateFormat("d.M").parse(nowDate);
        System.out.println(date1);

        Date date2 = new SimpleDateFormat("d.M").parse(actualData);
        System.out.println(date2);

        if (date1.compareTo(date2) >= 0) {
            System.out.println("Date1 больше или равна Date2"); }
            else if (date1.compareTo(date2) < 0) {
            System.out.println("Date1 меньше Date2");
        }



        }


    @Test
    private void tst() {
        String s = "11 ноября";
        String firstString = s.split(" ")[0];
        System.out.println(firstString);
        String lastString = s.split(" ")[1];
        System.out.println(lastString);

    }
}

