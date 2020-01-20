package az.lesson.course.service;

import az.lesson.course.model.Lesson;
import az.lesson.course.model.Schedule;
import java.util.List;

import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;

public interface CourseService {

    List<Student> getStudentList() throws Exception;

    List<Teacher> getTeacherList() throws Exception;

    List<Schedule> getScheduleList() throws Exception;

    List<Lesson> getLessonList() throws Exception;

    boolean addStudent(Student student) throws Exception;

    Student getStudentById(long studentId) throws Exception;

    boolean updateStudent(Student student, long studentId) throws Exception;

    boolean deleteStudent(long studentId) throws Exception;

    public boolean addSchedule(Schedule schedule) throws Exception;

    boolean updateSchedule(Schedule schedule, long scheduleId) throws Exception;

    public Schedule getScheduleById(long scheduleId) throws Exception;

    public List<Student> searchStudentData(String keyword)throws Exception;

    public List<Teacher> searchTeacherData(String keyword)throws Exception;

    public List<Lesson> searchLessonData(String keyword)throws Exception;

    public List<Schedule> searchScheduleData(String keyword)throws Exception;

}
