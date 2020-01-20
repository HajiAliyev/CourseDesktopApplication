package az.lesson.course.gui;

import az.lesson.course.model.Lesson;
import az.lesson.course.model.Login;
import az.lesson.course.model.Schedule;
import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;
import az.lesson.course.service.CourseService;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MainFrame extends javax.swing.JFrame {

    private CourseService courseService;
    private String globBtnName = "test";

    public MainFrame() {
        initComponents();

    }

    public MainFrame(CourseService courseService) {
        try {

            initComponents();
            this.setLocationRelativeTo(null);
            this.courseService = courseService;
            List<Student> studentList = courseService.getStudentList();
            showStudentData(studentList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MainFrame(CourseService courseService, Login login) {
        try {
            initComponents();
            this.courseService = courseService;
//            List<Student> studentList = courseService.getStudentList();
//            showStudentData(studentList);
            jLabel2.setText(login.getName() + " " + login.getSurname());
            checkRole(login);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        studentDataBtn = new javax.swing.JButton();
        teacherDataBtn = new javax.swing.JButton();
        lessonDataBtn = new javax.swing.JButton();
        scheduleDataBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        newBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        delBtn = new javax.swing.JButton();
        keywordTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        studentDataBtn.setText("StudentData");
        studentDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDataBtnActionPerformed(evt);
            }
        });

        teacherDataBtn.setText("TeacherData");
        teacherDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherDataBtnActionPerformed(evt);
            }
        });

        lessonDataBtn.setText("LessonData");
        lessonDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessonDataBtnActionPerformed(evt);
            }
        });

        scheduleDataBtn.setText("ScheduleData");
        scheduleDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scheduleDataBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teacherDataBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(studentDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lessonDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scheduleDataBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(studentDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(teacherDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lessonDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(scheduleDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        editBtn.setText("Edit");
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        delBtn.setText("Delete");
        delBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtnActionPerformed(evt);
            }
        });

        keywordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keywordTxtActionPerformed(evt);
            }
        });
        keywordTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keywordTxtKeyReleased(evt);
            }
        });

        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Password");

        jLabel3.setText("Welcome");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(delBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(searchBtn)
                .addGap(255, 255, 255)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBtn)
                    .addComponent(editBtn)
                    .addComponent(delBtn)
                    .addComponent(keywordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn)
                    .addComponent(jButton1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentDataBtnActionPerformed
        try {
            keywordTxt.setText("");
            List<Student> studentList = courseService.getStudentList();
            showStudentData(studentList);
            globBtnName = "student";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_studentDataBtnActionPerformed

    private void teacherDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherDataBtnActionPerformed
        try {
            keywordTxt.setText("");
            List<Teacher> teacherList = courseService.getTeacherList();
            showTeacherData(teacherList);
            globBtnName = "teacher";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_teacherDataBtnActionPerformed

    private void lessonDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessonDataBtnActionPerformed

        try {
            keywordTxt.setText("");
            List<Lesson> lessonList = courseService.getLessonList();
            showLessonData(lessonList);
            globBtnName = "lesson";
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lessonDataBtnActionPerformed

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        switch (globBtnName) {
            case "student":
                NewStudentFrame newStudentFrame = new NewStudentFrame(courseService);
                newStudentFrame.setVisible(true);
                break;
            case "teacher":
                NewTeacherFrame newTeacherFrame = new NewTeacherFrame();
                newTeacherFrame.setVisible(true);
                break;
            case "lesson":
                NewLessonFrame newLessonFrame = new NewLessonFrame(courseService);
                newLessonFrame.setVisible(true);
                break;
            case "schedule":
                NewScheduleFrame newScheduleFrame = new NewScheduleFrame(courseService);
                newScheduleFrame.setVisible(true);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please first select menu", "Warning", JOptionPane.WARNING_MESSAGE);
                break;
        }
    }//GEN-LAST:event_newBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        int rowIndex = jTable1.getSelectedRow();
        long selectedRow = (long) jTable1.getValueAt(rowIndex, 0);
        switch (globBtnName) {
            case "student":
                EditStudentFrame editStudentFrame = new EditStudentFrame(selectedRow, courseService);
                editStudentFrame.setVisible(true);
                break;
            case "teacher":

                break;
            case "lesson":

                break;
            case "schedule":
                EditScheduleFrame editScheduleFrame = new EditScheduleFrame(selectedRow, courseService);
                editScheduleFrame.setVisible(true);
                break;

        }


    }//GEN-LAST:event_editBtnActionPerformed

    private void delBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtnActionPerformed
        try {
            int rowIndex = jTable1.getSelectedRow();
            long selectedRow = (long) jTable1.getValueAt(rowIndex, 0);
            switch (globBtnName) {
                case "student":
                    int isConfirm = JOptionPane.showConfirmDialog(null, "Are you sure?", "Student delete", JOptionPane.YES_NO_OPTION);
                    if (isConfirm == JOptionPane.YES_OPTION) {
                        boolean isDeleted = courseService.deleteStudent(selectedRow);
                        if (isDeleted) {
                            JOptionPane.showMessageDialog(null, "Student silindi");
                            studentDataBtnActionPerformed(evt);
                        } else {
                            JOptionPane.showMessageDialog(null, "Problem.Student silinmedi", "error", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    break;
                case "teacher":

                    break;
                case "lesson":

                    break;
                case "schedule":

                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_delBtnActionPerformed

    private void scheduleDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scheduleDataBtnActionPerformed
        try {
            keywordTxt.setText("");
            List<Schedule> scheduleList = courseService.getScheduleList();
            showScheduleData(scheduleList);
            globBtnName = "schedule";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_scheduleDataBtnActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (evt.getClickCount() == 2) {
            editBtnActionPerformed(null);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void keywordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keywordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keywordTxtActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        try {
            String keyword = keywordTxt.getText();
            switch (globBtnName) {
                case "student":
                    List<Student> studentList = courseService.searchStudentData(keyword);
                    showStudentData(studentList);

                    break;
                case "teacher":
                    List<Teacher> teacherList = courseService.searchTeacherData(keyword);
                    showTeacherData(teacherList);

                    break;
                case "lesson":
                    List<Lesson> lessonList = courseService.searchLessonData(keyword);

                    break;
                case "schedule":
                    List<Schedule> scheduleList = courseService.searchScheduleData(keyword);

                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void keywordTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keywordTxtKeyReleased
        searchBtnActionPerformed(null);
    }//GEN-LAST:event_keywordTxtKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        LoginFrame loginFrame = new LoginFrame(courseService);
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void showStudentData(List<Student> studentList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            jTable1.setModel(model);
            model.addColumn("No");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("Date Of Birth");
            model.addColumn("Phone");
            model.addColumn("Email");
            for (Student student : studentList) {
                Object[] data = new Object[]{
                    student.getId(), student.getName(), student.getSurname(),
                    student.getAddress(), student.getDob(), student.getPhone()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showTeacherData(List<Teacher> teacherList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            jTable1.setModel(model);
            model.addColumn("No");
            model.addColumn("Name");
            model.addColumn("Surname");
            model.addColumn("Date Of Birth");
            model.addColumn("Phone");
            model.addColumn("Email");
            for (Teacher teacher : teacherList) {
                Object[] data = new Object[]{
                    teacher.getId(), teacher.getName(), teacher.getSurname(),
                    teacher.getAddress(), teacher.getDob(), teacher.getPhone()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField keywordTxt;
    private javax.swing.JButton lessonDataBtn;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton scheduleDataBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton studentDataBtn;
    private javax.swing.JButton teacherDataBtn;
    // End of variables declaration//GEN-END:variables

    private void showScheduleData(List<Schedule> scheduleList) {
        try {
            DefaultTableModel model = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            jTable1.setModel(model);
            model.addColumn("No");
            model.addColumn("Student_Fullname");
            model.addColumn("Lesson_Name");
            model.addColumn("Teacher_Fullname");
            model.addColumn("Date");
            for (Schedule schedule : scheduleList) {
                Object[] data = new Object[]{
                    schedule.getId(), schedule.getStudent().getName() + " " + schedule.getStudent().getSurname(), schedule.getLesson().getLessonName(),
                    schedule.getTeacher().getName() + " " + schedule.getTeacher().getSurname(), schedule.getDataDate()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void checkRole(Login login) {

        if (login.getRole().getRoleName().equalsIgnoreCase("ROLE_STUDENT")) {
            teacherDataBtn.setVisible(false);
            newBtn.setVisible(false);
            editBtn.setVisible(false);
            delBtn.setVisible(false);
        } else if (login.getRole().getRoleName().equalsIgnoreCase("ROLE_TEACHER")) {
            studentDataBtn.setVisible(false);
            newBtn.setVisible(false);
            editBtn.setVisible(false);
            delBtn.setVisible(false);
        }

    }

   

  

    private void showLessonData(List<Lesson> lessonList) {

    try {
            DefaultTableModel model = new DefaultTableModel() {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
            jTable1.setModel(model);
            model.addColumn("No");
            model.addColumn("Lesson_name");
            model.addColumn("Lesson_time");
            model.addColumn("Lesson_price");

            for (Lesson lesson : lessonList) {
                Object[] data = new Object[]{
                    lesson.getId(), lesson.getLessonName(), lesson.getLessonTime(), lesson.getLessonPrice()
                };
                model.addRow(data);
            }
            model.fireTableDataChanged();
        } catch (Exception ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
