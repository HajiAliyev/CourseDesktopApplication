package az.lesson.course.util1;

import java.util.List;

import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;

public class Methods {

	public static void getStudentList(List<Student> studentList) {
		for (Student st : studentList) {
			System.out.println(st.getId() + " " + st.getName() + " " + st.getSurname() + " " + st.getDob());
		}
	}

	public static void getTeacherList(List<Teacher> teacherList) {
		for(Teacher teacher: teacherList) {
			System.out.println(teacher.getId() + " " + teacher.getName() + " " + teacher.getSurname() + " " + teacher.getDob());
		}
	}
}
