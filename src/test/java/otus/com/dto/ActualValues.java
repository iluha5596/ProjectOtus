package otus.com.dto;

import java.util.Date;

public class ActualValues {
    public int getNumberCourses() {
        return numberCourses;
    }

    public void setNumberCourses(int numberCourses) {
        this.numberCourses = numberCourses;
    }

    private int numberCourses;
    private String nameCourseQaEngineerBasic;
    private String specificationQaEngineerBasic;

    public String getNameCourseQaEngineerBasic() {
        return nameCourseQaEngineerBasic;
    }

    public void setNameCourseQaEngineerBasic(String nameCourseQaEngineerBasic) {
        this.nameCourseQaEngineerBasic = nameCourseQaEngineerBasic;
    }

    public String getSpecificationQaEngineerBasic() {
        return specificationQaEngineerBasic;
    }

    public void setSpecificationQaEngineerBasic(String specificationQaEngineerBasic) {
        this.specificationQaEngineerBasic = specificationQaEngineerBasic;
    }

    public String getDurationTrainingQaEngineerBasic() {
        return durationTrainingQaEngineerBasic;
    }

    public void setDurationTrainingQaEngineerBasic(String durationTrainingQaEngineerBasic) {
        this.durationTrainingQaEngineerBasic = durationTrainingQaEngineerBasic;
    }

    public String getFormatQaEngineerBasic() {
        return formatQaEngineerBasic;
    }

    public void setFormatQaEngineerBasic(String formatQaEngineerBasic) {
        this.formatQaEngineerBasic = formatQaEngineerBasic;
    }

    private String durationTrainingQaEngineerBasic;
    private String formatQaEngineerBasic;


    public Date getActualDataEvent() {
        return actualDataEvent;
    }

    public void setActualDataEvent(Date actualDataEvats) {
        this.actualDataEvent = actualDataEvats;
    }

    private Date actualDataEvent;


}
