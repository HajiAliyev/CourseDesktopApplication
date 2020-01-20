package az.lesson.course.model;

import az.lesson.course.model.CourseModel;
import az.lesson.course.model.Lesson;
import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;
import java.util.Date;

public class Schedule extends CourseModel{

    private Student student;
    private Teacher teacher;
    private Lesson lesson;
    private Date dataDate;
    

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Date getDataDate() {
        return dataDate;
    }

    public void setDataDate(Date dataDate) {
        this.dataDate = dataDate;
    }


    
    @Override
    public String toString() {
        return "Schedule{" + "student=" + student + ", teacher=" + teacher + ", lesson=" + lesson + ", dataDate=" + dataDate + '}';
    }

}
