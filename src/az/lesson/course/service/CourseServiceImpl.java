package az.lesson.course.service;

import java.util.List;

import az.lesson.course.dao.CourseDao;
import az.lesson.course.model.Lesson;
import az.lesson.course.model.Schedule;
import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;
import az.lesson.course.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Student> getStudentList() throws Exception {

        return courseDao.getStudentList();
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {

        return courseDao.getTeacherList();
    }

    @Override
    public boolean addStudent(Student student) throws Exception {

        return courseDao.addStudent(student);
    }

    @Override
    public Student getStudentById(long studentId) throws Exception {

        return courseDao.getStudentById(studentId);
    }

    @Override
    public boolean updateStudent(Student student, long studentId) throws Exception {

        return courseDao.updateStudent(student, studentId);
    }

    @Override
    public boolean deleteStudent(long studentId) throws Exception {

        return courseDao.deleteStudent(studentId);
    }

    @Override
    public List<Schedule> getScheduleList() throws Exception {

        return courseDao.getScheduleList();
    }

    @Override
    public List<Lesson> getLessonList() throws Exception {
        return courseDao.getLessonList();
    }

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        return courseDao.addSchedule(schedule);
    }

    @Override
    public boolean updateSchedule(Schedule schedule, long scheduleId) throws Exception {
        return courseDao.updateSchedule(schedule, scheduleId);
    }

    @Override
    public Schedule getScheduleById(long scheduleId) throws Exception {
        return courseDao.getScheduleById(scheduleId);
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        return courseDao.searchStudentData(keyword);
    }

    @Override
    public List<Teacher> searchTeacherData(String keyword) throws Exception {
        return courseDao.searchTeacherData(keyword);
    }

    @Override
    public List<Lesson> searchLessonData(String keyword) throws Exception {
        return courseDao.searchLessonData(keyword);
    }

    @Override
    public List<Schedule> searchScheduleData(String keyword) throws Exception {
        return courseDao.searchScheduleData(keyword);
    }

}
