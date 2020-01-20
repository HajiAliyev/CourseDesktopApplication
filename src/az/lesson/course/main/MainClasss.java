package az.lesson.course.main;

import az.lesson.course.gui.LoginFrame;
import az.lesson.course.gui.MainFrame;
import az.lesson.course.dao.CourseDao;
import az.lesson.course.dao.CourseDaoImpl;
import az.lesson.course.service.CourseService;
import az.lesson.course.service.CourseServiceImpl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class MainClasss {

    public static void main(String[] args) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            CourseDao courseDao = new CourseDaoImpl();
            CourseService courseService = new CourseServiceImpl(courseDao);
            //System.out.println(courseDao.getStudentList());
            LoginFrame loginFrame = new LoginFrame(courseService);
            loginFrame.setVisible(true);
//            MainFrame mainFrame = new MainFrame(courseService);
//            mainFrame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
