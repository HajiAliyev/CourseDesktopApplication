package az.lesson.course.dao;

import az.lesson.course.model.Lesson;
import az.lesson.course.model.Schedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;
import az.lesson.course.util1.JdbcUtility;
import java.sql.Array;

public class CourseDaoImpl implements CourseDao {

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection c = null; // baza ile elaqe yaratmaq ucun class
        PreparedStatement ps = null; // sql-i run etmek ucun hazirlayan class
        ResultSet rs = null; //  
        String sql = "SELECT ID,NAME,SURNAME,ADDRESS,DOB,PHONE,EMAIL FROM STUDENT WHERE ACTIVE= 1 ";

        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));
                    studentList.add(student);

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return studentList;
    }

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME,SURNAME,ADDRESS,DOB,PHONE FROM TEACHER WHERE ACTIVE = 1";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("ID"));
                    teacher.setName(rs.getString("NAME"));
                    teacher.setSurname(rs.getString("SURNAME"));
                    teacher.setAddress(rs.getString("ADDRESS"));
                    teacher.setDob(rs.getDate("DOB"));
                    teacher.setPhone(rs.getString("PHONE"));
                    teacherList.add(teacher);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            System.out.println("Connection is null!");
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return teacherList;
    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO STUDENT(ID,NAME,SURNAME,ADDRESS,DOB,PHONE,EMAIL)\r\n"
                + "VALUES(STUDENT_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            c = DBHelper.getConnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3, student.getAddress());
                ps.setDate(4, new java.sql.Date(student.getDob().getTime()));
                ps.setString(5, student.getPhone());
                ps.setString(6, student.getEmail());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public Student getStudentById(long studentId) throws Exception {
        Student student = new Student();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,NAME,SURNAME,ADDRESS,DOB,PHONE,EMAIL FROM STUDENT "
                + " WHERE ACTIVE = 1  AND ID = ? ";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, studentId);
                rs = ps.executeQuery();
                if (rs.next()) {
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));
                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, rs);
        }
        return student;
    }

    @Override
    public boolean updateStudent(Student student, long studentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE STUDENT SET NAME = ?, SURNAME = ?, ADDRESS = ? , DOB = ?, PHONE = ?, EMAIL = ? "
                + "WHERE ID = ?";

        try {
            c = DBHelper.getConnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, student.getName());
                ps.setString(2, student.getSurname());
                ps.setString(3, student.getAddress());
                ps.setDate(4, new java.sql.Date(student.getDob().getTime()));
                ps.setString(5, student.getPhone());
                ps.setString(6, student.getEmail());
                ps.setLong(7, studentId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;

    }

    @Override
    public boolean deleteStudent(long studentId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE STUDENT SET ACTIVE = 0 WHERE ID = ?";

        try {
            c = DBHelper.getConnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, studentId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }
        return result;
    }

    @Override
    public List<Schedule> getScheduleList() throws Exception {
        List<Schedule> scheduleList = new ArrayList<Schedule>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SC.ID,S.ID STUDENT_ID,S.NAME STUDENT_NAME,S.SURNAME STUDENT_SURNAME,\n"
                + "L.ID LESSON_ID,L.LESSON_NAME LESSON_NAME,T.ID TEACHER_ID,T.NAME TEACHER_NAME,T.SURNAME TEACHER_SURNAME,SC.DATA_DATE FROM SCHEDULE SC\n"
                + "INNER JOIN STUDENT S ON SC.S_ID = S.ID\n"
                + "INNER JOIN TEACHER T ON SC.T_ID = T.ID\n"
                + "INNER JOIN LESSON L ON SC.L_ID = L.ID\n"
                + "WHERE SC.ACTIVE = 1 AND S.ACTIVE = 1 AND T.ACTIVE = 1 AND L.ACTIVE = 1";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setId(rs.getLong("ID"));
                    schedule.setDataDate(rs.getDate("DATA_DATE"));
                    Student student = new Student();
                    student.setId(rs.getLong("STUDENT_ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("TEACHER_ID"));
                    teacher.setName(rs.getString("TEACHER_NAME"));
                    teacher.setSurname(rs.getString("TEACHER_SURNAME"));
                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("LESSON_ID"));
                    lesson.setLessonName(rs.getString("LESSON_NAME"));
                    schedule.setStudent(student);
                    schedule.setTeacher(teacher);
                    schedule.setLesson(lesson);
                    scheduleList.add(schedule);

                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return scheduleList;
    }

    @Override
    public List<Lesson> getLessonList() throws Exception {
        List<Lesson> lessonList = new ArrayList<Lesson>();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT ID,LESSON_NAME,LESSON_TIME,LESSON_PRICE FROM LESSON WHERE ACTIVE = 1";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("ID"));
                    lesson.setLessonName(rs.getString("LESSON_NAME"));
                    lesson.setLessonPrice(rs.getDouble("LESSON_PRICE"));
                    lesson.setLessonTime(rs.getInt("LESSON_TIME"));
                    lessonList.add(lesson);
                }
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            System.out.println("Connection is null!");
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return lessonList;

    }

    @Override
    public boolean addSchedule(Schedule schedule) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO SCHEDULE(ID,S_ID,T_ID,L_ID) VALUES(SCHEDULE_SEQ.NEXTVAL,?,?,?)";
        try {
            c = DBHelper.getConnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, schedule.getStudent().getId());
                ps.setLong(2, schedule.getTeacher().getId());
                ps.setLong(3, schedule.getLesson().getId());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }

        return result;
    }

    @Override
    public boolean updateSchedule(Schedule schedule, long scheduleId) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "UPDATE SCHEDULE SET S_ID =?,T_ID = ?,L_ID= ? WHERE ID = ?";
        try {
            c = DBHelper.getConnection();

            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, schedule.getStudent().getId());
                ps.setLong(2, schedule.getTeacher().getId());
                ps.setLong(3, schedule.getLesson().getId());
                ps.setLong(4, scheduleId);
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        } finally {
            c.commit();
            JdbcUtility.close(c, ps, null);
        }

        return result;

    }

    @Override
    public Schedule getScheduleById(long scheduleId) throws Exception {
        Schedule schedule = new Schedule();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SC.ID,S.ID STUDENT_ID,S.NAME STUDENT_NAME,S.SURNAME STUDENT_SURNAME,\n"
                + "L.ID LESSON_ID,L.LESSON_NAME LESSON_NAME,T.ID TEACHER_ID,T.NAME TEACHER_NAME,T.SURNAME TEACHER_SURNAME,SC.DATA_DATE FROM SCHEDULE SC\n"
                + "INNER JOIN STUDENT S ON SC.S_ID = S.ID\n"
                + "INNER JOIN TEACHER T ON SC.T_ID = T.ID\n"
                + "INNER JOIN LESSON L ON SC.L_ID = L.ID\n"
                + "WHERE SC.ACTIVE = 1 AND S.ACTIVE = 1 AND T.ACTIVE = 1 AND L.ACTIVE = 1 AND SC.ID = ?";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setLong(1, scheduleId);
                rs = ps.executeQuery();
                while (rs.next()) {
                    schedule.setId(rs.getLong("ID"));
                    schedule.setDataDate(rs.getDate("DATA_DATE"));
                    Student student = new Student();
                    student.setId(rs.getLong("STUDENT_ID"));
                    student.setName(rs.getString("STUDENT_NAME"));
                    student.setSurname(rs.getString("STUDENT_SURNAME"));
                    Teacher teacher = new Teacher();
                    teacher.setId(rs.getLong("TEACHER_ID"));
                    teacher.setName(rs.getString("TEACHER_NAME"));
                    teacher.setSurname(rs.getString("TEACHER_SURNAME"));
                    Lesson lesson = new Lesson();
                    lesson.setId(rs.getLong("LESSON_ID"));
                    lesson.setLessonName(rs.getString("LESSON_NAME"));
                    schedule.setStudent(student);
                    schedule.setTeacher(teacher);
                    schedule.setLesson(lesson);

                }
            } else {
                System.out.println("Connection is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }

        return schedule;
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        List<Student> studentList = new ArrayList<Student>();
        Connection c = null; // baza ile elaqe yaratmaq ucun class
        PreparedStatement ps = null; // sql-i run etmek ucun hazirlayan class
        ResultSet rs = null; // sql den qayidan neticeni ozunde saxlayan class
        String sql = "SELECT ID,NAME,SURNAME,ADDRESS,DOB,PHONE,EMAIL FROM STUDENT \n"
                + " WHERE ACTIVE = 1 AND (LOWER(NAME) LIKE LOWER('%"+keyword+"%') OR \n"
                + " LOWER(SURNAME) LIKE LOWER('%"+keyword+"%') OR\n"
                + " LOWER(ADDRESS) LIKE LOWER('%"+keyword+"%') OR\n"
                + " LOWER(PHONE) LIKE LOWER('%"+keyword+"%') OR\n"
                + " LOWER(EMAIL) LIKE LOWER('%"+keyword+"%'))   ";

        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    Student student = new Student();
                    student.setId(rs.getLong("ID"));
                    student.setName(rs.getString("NAME"));
                    student.setSurname(rs.getString("SURNAME"));
                    student.setAddress(rs.getString("ADDRESS"));
                    student.setDob(rs.getDate("DOB"));
                    student.setPhone(rs.getString("PHONE"));
                    student.setEmail(rs.getString("EMAIL"));
                    studentList.add(student);

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return studentList;

    }

    @Override
    public List<Teacher> searchTeacherData(String keyword) throws Exception {

        return null;
    }

    @Override
    public List<Lesson> searchLessonData(String keyword) throws Exception {

        return null;
    }

    @Override
    public List<Schedule> searchScheduleData(String keyword) throws Exception {

        return null;
    }

}
