package otus.com.regressTests;

import config.ExpectedValues;
import org.aeonbits.owner.ConfigFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import otus.com.BaseTest;
import otus.com.dto.ActualValues;
import otus.com.pages.*;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CheckCourseInformation extends BaseTest {

    //Проверка карточки курса
    @Test
    public void сheckingCourseInformation() {
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
        assertTrue((actualValuesGameQAEngineer.getSpecificationGameQAEngineer()).contains("Стань тестировщиком любых игр: мобильные, консольные, браузерные и ПК"));
       // assertEquals(expectedValues.specificationGameQAEngineer(), actualValuesGameQAEngineer.getSpecificationGameQAEngineer());
        logger.info("Данные в карточке курса GameQAEngineer верные");
    }
}
