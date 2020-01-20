/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.lesson.course.gui;

import az.lesson.course.model.Item;
import az.lesson.course.model.Lesson;
import az.lesson.course.model.Schedule;
import az.lesson.course.model.Student;
import az.lesson.course.model.Teacher;
import az.lesson.course.service.CourseService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class NewScheduleFrame extends javax.swing.JFrame {

    private CourseService courseService;

    public NewScheduleFrame() {
        initComponents();
    }

    NewScheduleFrame(CourseService courseService) {
        this.courseService = courseService;
        initComponents();
        showStudentCombo();
        showTeaherCombo();
        showLessonCombo();
         this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Student" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Teacher" }));

        jLabel1.setText("Stuent");

        jLabel2.setText("Teacher");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Lesson" }));

        jLabel4.setText("Lesson");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(saveBtn)
                .addGap(89, 89, 89)
                .addComponent(clearBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(clearBtn))
                .addContainerGap(154, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
       try{
        Item studentCombo = (Item) jComboBox1.getSelectedItem();
        Item teacherCombo = (Item) jComboBox2.getSelectedItem();
        Item lessonCombo = (Item) jComboBox3.getSelectedItem();
        Schedule schedule = new Schedule();
        Student student = new Student();
        student.setId(studentCombo.getId());
        Teacher teacher = new Teacher();
        teacher.setId(teacherCombo.getId());
        Lesson lesson = new Lesson();
        lesson.setId(lessonCombo.getId());
        schedule.setStudent(student);
        schedule.setTeacher(teacher);
        schedule.setLesson(lesson);
        boolean isAdded =  courseService.addSchedule(schedule);
          if(isAdded){
              JOptionPane.showMessageDialog(null, "Schedule ugurla elave edildi","Message",JOptionPane.INFORMATION_MESSAGE);
              this.dispose();
          }else{
              JOptionPane.showMessageDialog(null, "Problem. Schedule elave edilmedi","Message",JOptionPane.ERROR_MESSAGE);
          }
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        
    }//GEN-LAST:event_clearBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables

    private void showStudentCombo() {
        try {
            DefaultComboBoxModel comboModel = (DefaultComboBoxModel) jComboBox1.getModel();
            List<Student> studentList = courseService.getStudentList();
            for (Student student : studentList) {
                comboModel.addElement(new Item(student.getId(), student.getName() + " " + student.getSurname()));
            }
        } catch (Exception ex) {
            Logger.getLogger(NewScheduleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void showTeaherCombo() {
        try {
            DefaultComboBoxModel comboModel = (DefaultComboBoxModel) jComboBox2.getModel();
            List<Teacher> teacherList = courseService.getTeacherList();
            for (Teacher teacher : teacherList) {
                comboModel.addElement(new Item(teacher.getId(), teacher.getName() + " " + teacher.getSurname()));
            }
        } catch (Exception ex) {
            Logger.getLogger(NewScheduleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void showLessonCombo() {
        try {
            DefaultComboBoxModel comboModel = (DefaultComboBoxModel) jComboBox3.getModel();
            List<Lesson> lessonList = courseService.getLessonList();
            for (Lesson lesson : lessonList) {
                comboModel.addElement(new Item(lesson.getId(), lesson.getLessonName()));
            }
        } catch (Exception ex) {
            Logger.getLogger(NewScheduleFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
