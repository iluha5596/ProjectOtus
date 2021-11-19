package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:ExpectedValues.properties")
public interface ExpectedValues extends Config {

    int numberCoursesTesting();
    String nameCourseQaEngineerBasic();
    String specificationCourseQaEngineerBasic();
    String durationTrainingQaEngineerBasic();
    String formatCourseQaEngineerBasic();
    String dod();
}
