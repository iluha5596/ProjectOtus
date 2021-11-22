package otus.com.regressTests;
import config.ExpectedValues;
import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;
import otus.com.BaseTest;
import otus.com.dto.ActualValues;
import otus.com.pages.Authorization;
import otus.com.pages.MainPage;
import otus.com.pages.SectionTesting;
import static org.testng.AssertJUnit.assertEquals;

public class CheckNumberCourses extends BaseTest {

    //Проверка количества курсов в разделе тестирование
    @Test
    private void checkingNumberCourses() {
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
}