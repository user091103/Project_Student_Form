package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import utils.Methods;
import model.*;
import java.util.TreeMap;

public class Register extends javax.swing.JPanel {

    public String dOb;
    public String gender;
    boolean notcomplete = true;

    public Register() {
        initComponents();

    }

    public void register() {
        fullnameTF.grabFocus();
    }

    private boolean checkEmpty(String check, String message) {
        if (check.isEmpty()) {
            warningError(message + " can not be empty");
            return false;
        }
        return true;
    }

    private void warningError(String message) {
        String title = "Warning";
        String content = message;
        JOptionPane.showMessageDialog(continueBT, content, title, JOptionPane.ERROR_MESSAGE);

    }

    public void addEventBackLogin(ActionListener event) {
        if (!notcomplete) {
            continueBT.addActionListener(event);
        }

    }

    public void backLoginBT(ActionListener event) {
        backLoginBT.addActionListener(event);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monthCBB = new javax.swing.JComboBox<>();
        registerLabel = new javax.swing.JLabel();
        yearTF = new javax.swing.JTextField();
        clearBT = new Swing.MyButton();
        studentRBT = new javax.swing.JRadioButton();
        passwordTF = new Swing.MyPassword();
        teacherRBT = new javax.swing.JRadioButton();
        passwordLabel1 = new javax.swing.JLabel();
        genderCBB = new javax.swing.JComboBox<>();
        passwordLabel2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        continueBT = new Swing.MyButton();
        Position = new javax.swing.JLabel();
        usernameTF = new Swing.MyTextField();
        fullnameTF = new Swing.MyTextField();
        addressTF = new Swing.MyTextField();
        jLabel1 = new javax.swing.JLabel();
        myTextLabel = new javax.swing.JLabel();
        dayCBB = new javax.swing.JComboBox<>();
        passwordLabel = new javax.swing.JLabel();
        backLoginBT = new javax.swing.JButton();

        setBackground(new java.awt.Color(154, 182, 207));

        monthCBB.setBackground(new java.awt.Color(154, 182, 207));
        monthCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        monthCBB.setDoubleBuffered(true);
        monthCBB.setOpaque(true);

        registerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setText("Register");
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        yearTF.setText("Year");

        clearBT.setBackground(new java.awt.Color(0, 58, 98));
        clearBT.setForeground(new java.awt.Color(255, 255, 255));
        clearBT.setText("Clear");
        clearBT.setColor(new java.awt.Color(0, 58, 98));
        clearBT.setColorOver(new java.awt.Color(0, 58, 98));
        clearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBTActionPerformed(evt);
            }
        });

        studentRBT.setText("Student");
        studentRBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentRBTActionPerformed(evt);
            }
        });

        passwordTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTFActionPerformed(evt);
            }
        });

        teacherRBT.setText("Teacher");
        teacherRBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherRBTActionPerformed(evt);
            }
        });

        passwordLabel1.setText("Password");

        genderCBB.setBackground(new java.awt.Color(154, 182, 207));
        genderCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        genderCBB.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        genderCBB.setDoubleBuffered(true);
        genderCBB.setOpaque(true);

        passwordLabel2.setText("Address");

        jLabel2.setText("Gender");

        continueBT.setBackground(new java.awt.Color(0, 58, 98));
        continueBT.setForeground(new java.awt.Color(255, 255, 255));
        continueBT.setText("Continue");
        continueBT.setColor(new java.awt.Color(0, 58, 98));
        continueBT.setColorOver(new java.awt.Color(0, 58, 98));
        continueBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBTActionPerformed(evt);
            }
        });

        Position.setText("Position");

        usernameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTFActionPerformed(evt);
            }
        });

        fullnameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullnameTFActionPerformed(evt);
            }
        });

        addressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTFActionPerformed(evt);
            }
        });

        jLabel1.setText("DOB");

        myTextLabel.setText("Fullname");

        dayCBB.setBackground(new java.awt.Color(154, 182, 207));
        dayCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dayCBB.setOpaque(true);
        dayCBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayCBBActionPerformed(evt);
            }
        });

        passwordLabel.setText("Username");

        backLoginBT.setBackground(new java.awt.Color(0, 58, 98));
        backLoginBT.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        backLoginBT.setText("<<");
        backLoginBT.setContentAreaFilled(false);
        backLoginBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backLoginBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(clearBT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dayCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(monthCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(passwordLabel2)
                                .addComponent(passwordLabel1)
                                .addComponent(passwordLabel)
                                .addComponent(myTextLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(addressTF, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addComponent(usernameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addComponent(fullnameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                .addComponent(passwordTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backLoginBT, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(continueBT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(Position)
                                    .addGap(14, 14, 14))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(studentRBT)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(teacherRBT))
                                .addComponent(genderCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backLoginBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myTextLabel)
                .addGap(0, 0, 0)
                .addComponent(fullnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel)
                .addGap(0, 0, 0)
                .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel1)
                .addGap(0, 0, 0)
                .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordLabel2)
                .addGap(0, 0, 0)
                .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Position)
                    .addComponent(studentRBT)
                    .addComponent(teacherRBT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(continueBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBTActionPerformed
        // TODO add your handling code here:
        fullnameTF.setText("");
        usernameTF.setText("");
        passwordTF.setText("");
        addressTF.setText("");
        dayCBB.setSelectedIndex(0);
        monthCBB.setSelectedIndex(0);
        yearTF.setText("Year");
        studentRBT.setSelected(false);
        teacherRBT.setSelected(false);
        genderCBB.setSelectedIndex(0);

    }//GEN-LAST:event_clearBTActionPerformed

    private void continueBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBTActionPerformed
        if (!checkEmpty(fullnameTF.getText(), "Fullname")) {
        } else {
            if (!Methods.checkLandN(0, fullnameTF.getText())) {
                warningError("Fullname only contains letters");
            } else {
                if (!checkEmpty(usernameTF.getText(), "Username")) {
                } else {
                    if (Login.checkExist(usernameTF.getText())) {
                        warningError("This username already exist");
                    } else {
                        if (!checkEmpty(passwordTF.getText(), "Password")) {
                        } else {
                            if (!checkEmpty(addressTF.getText(), "Address")) {
                            } else {
                                if (!Methods.checkLandN(1, yearTF.getText())) {
                                    warningError("Year only contains numbers");
                                } else {
                                    if (dayCBB.getSelectedIndex() == 30
                                            && (monthCBB.getSelectedIndex() == 1 || monthCBB.getSelectedIndex() == 3 
                                            || monthCBB.getSelectedIndex() == 5 || monthCBB.getSelectedIndex() == 8 || monthCBB.getSelectedIndex() == 10)) {
                                        warningError("This month does not have this day");
                                    } else if ((dayCBB.getSelectedIndex() == 29 || dayCBB.getSelectedIndex() == 30)
                                            && monthCBB.getSelectedIndex() == 1) {
                                        warningError("This month does not have this day");
                                    } else if (((Integer.parseInt(yearTF.getText()) % 4 != 0 && 
                                            Integer.parseInt(yearTF.getText()) % 100 == 0) || Integer.parseInt(yearTF.getText())
                                            % 400 != 0) && dayCBB.getSelectedIndex() == 28 && monthCBB.getSelectedIndex() == 1) {
                                        warningError("This year does not have this day");
                                    } else if (Integer.parseInt(yearTF.getText()) <= 0) {
                                        warningError("This year not exist");
                                    } else {
                                        dOb = String.format("%d", dayCBB.getSelectedIndex() + 1) + "/" + String.format("%d", monthCBB.getSelectedIndex() + 1) + "/" + yearTF.getText();

                                        if (genderCBB.getSelectedIndex() == 0) {
                                            gender = "Male";
                                        } else if (genderCBB.getSelectedIndex() == 1) {
                                            gender = "Female";
                                        } else {
                                            gender = "Other";
                                        }
                                        // Lựa chọn đối tượng đăng kí là học sinh hoặc là giáo viên
                                        if (studentRBT.isSelected()) {

                                            // học sinh
                                            new StudentRes(fullnameTF.getText(), dOb, addressTF.getText(), gender,
                                                     usernameTF.getText(), passwordTF.getText()).setVisible(true);

                                        } else {
                                            // giáo viên

                                            new TeacherRes(fullnameTF.getText(), dOb, addressTF.getText(), gender,
                                                     usernameTF.getText(), passwordTF.getText()).setVisible(true);

                                        }

                                    }
                                }

                            }

                        }
                    }

                }
            }

        }
    }//GEN-LAST:event_continueBTActionPerformed

    private void usernameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTFActionPerformed

    private void fullnameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullnameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fullnameTFActionPerformed

    private void addressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTFActionPerformed

    private void dayCBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayCBBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayCBBActionPerformed

    private void passwordTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTFActionPerformed

    private void backLoginBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backLoginBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backLoginBTActionPerformed

    private void studentRBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentRBTActionPerformed
        // TODO add your handling code here:
        teacherRBT.setSelected(false);
    }//GEN-LAST:event_studentRBTActionPerformed

    private void teacherRBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherRBTActionPerformed
        // TODO add your handling code here:
        studentRBT.setSelected(false);
    }//GEN-LAST:event_teacherRBTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Position;
    private Swing.MyTextField addressTF;
    private javax.swing.JButton backLoginBT;
    private Swing.MyButton clearBT;
    private Swing.MyButton continueBT;
    private javax.swing.JComboBox<String> dayCBB;
    private Swing.MyTextField fullnameTF;
    private javax.swing.JComboBox<String> genderCBB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<String> monthCBB;
    private javax.swing.JLabel myTextLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JLabel passwordLabel2;
    private Swing.MyPassword passwordTF;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JRadioButton studentRBT;
    private javax.swing.JRadioButton teacherRBT;
    private Swing.MyTextField usernameTF;
    private javax.swing.JTextField yearTF;
    // End of variables declaration//GEN-END:variables
}
