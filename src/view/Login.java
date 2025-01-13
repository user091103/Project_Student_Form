package view;

import controller.Main;
import java.util.*;
import model.*;
import utils.fileStore;

import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JPanel {

    public static TreeMap<String, TreeMap<String, Person>> personAccount = new TreeMap<>();
    boolean wrongusername = true;
    public static int grade;
    public static int id;
    public static int choice;

    public Login() {
        initComponents();

        fileStore.checkAndCreate("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");
        fileStore.getInforS("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");
        fileStore.checkAndCreate("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/storeRes.txt");  
        SandTDAO.restoreS.clear();
        SandTDAO.restoreT.clear();
        fileStore.getRes("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/storeRes.txt");

        this.LoginBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check username
                // Check username
                if (!checkEmpty(UsernameTF.getText(), "Username")) {

                } else {

                    // Check password
                    if (!checkEmpty(PasswordTF.getText(), "Password")) {

                    } else {

                        if (!personAccount.containsKey(UsernameTF.getText())) {
                            warningError("This username not exist");
                        } else if (!personAccount.get(UsernameTF.getText()).containsKey(PasswordTF.getText())) {
                            warningError("Wrong password, try again");
                        } else {
                            wrongusername = false;
                            // Check Teacher or Student
                            id = personAccount.get(UsernameTF.getText()).get(PasswordTF.getText()).id;
                            // nhận biết học sinh và giáo viên
                            if (personAccount.get(UsernameTF.getText()).get(PasswordTF.getText()).position.equals("Teacher")) {
                                // Check username
                                JOptionPane.showMessageDialog(LoginBT, "Hello Teacher!");

                                for (Map.Entry<Integer, Teacher> entry : SandTDAO.storeTInfor.entrySet()) {
                                    if (entry.getValue().username.equals(UsernameTF.getText())) {
                                        grade = entry.getValue().classInCharge;
                                        break;
                                    }
                                }

                                // Check username
                                choice = 0;
                                
                                SandTDAO mainshow = new SandTDAO(grade, 0, id);

                            } else {
                                // Nếu là học sinh thì show cái studentShow
                                JOptionPane.showMessageDialog(LoginBT, "Hello Student!");
                                for (Map.Entry<Integer, Student> entry : SandTDAO.storeSInfor.entrySet()) {
                                    if (entry.getValue().username.equals(UsernameTF.getText())) {
                                        grade = entry.getValue().grade;
                                        break;
                                    }
                                }
                                choice = 1;
                                SandTDAO mainshow = new SandTDAO(grade, 1, id);

                            }

                        }

                    }
                }
            }

        }
        );

        this.ClearBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsernameTF.setText("");
                PasswordTF.setText("");
                showpasswordCBB.setSelected(false);
            }
        });

    }

    public static boolean checkExist(String username) {
        if (Login.personAccount.containsKey(username)) {
            return true;
        }
        return false;
    }

    private void warningError(String message) {
        String title = "Warning";
        String content = message;
        JOptionPane.showMessageDialog(LoginBT, content, title, JOptionPane.ERROR_MESSAGE);

    }

    public void login() {
        UsernameTF.grabFocus();
    }

    public void addEventRegister(ActionListener event) {
        registerButton.addActionListener(event);
    }

    private boolean checkEmpty(String check, String message) {
        if (check.isEmpty()) {
            warningError(message + " can not be empty");
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        UsernameTF = new Swing.MyTextField();
        PasswordTF = new Swing.MyPassword();
        fullnameLable = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        loginLabel = new javax.swing.JLabel();
        LoginBT = new Swing.MyButton();
        registerButton = new javax.swing.JButton();
        ClearBT = new Swing.MyButton();
        showpasswordCBB = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(154, 182, 207));

        fullnameLable.setText("User Name");

        passwordLabel.setText("Password");

        loginLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("Login");

        LoginBT.setBackground(new java.awt.Color(0, 58, 98));
        LoginBT.setForeground(new java.awt.Color(255, 255, 255));
        LoginBT.setText("Login");
        LoginBT.setColor(new java.awt.Color(0, 58, 98));
        LoginBT.setColorOver(new java.awt.Color(0, 58, 98));
        LoginBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBTActionPerformed(evt);
            }
        });

        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(0, 58, 98));
        registerButton.setText("Register");
        registerButton.setContentAreaFilled(false);
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        ClearBT.setBackground(new java.awt.Color(0, 58, 98));
        ClearBT.setForeground(new java.awt.Color(255, 255, 255));
        ClearBT.setText("Clear");
        ClearBT.setColor(new java.awt.Color(0, 58, 98));
        ClearBT.setColorOver(new java.awt.Color(0, 58, 98));
        ClearBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearBTActionPerformed(evt);
            }
        });

        showpasswordCBB.setText("Show password");
        showpasswordCBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showpasswordCBBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordLabel)
                    .addComponent(fullnameLable, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showpasswordCBB)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(LoginBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ClearBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(loginLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fullnameLable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(showpasswordCBB)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ClearBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void LoginBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBTActionPerformed
        if (evt.getSource() == LoginBT && !wrongusername) {
            setVisible(false);
            new SandTDAO(grade, choice, id).setVisible(true);
            wrongusername = true;
        }
    }//GEN-LAST:event_LoginBTActionPerformed

    private void ClearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBTActionPerformed

    private void showpasswordCBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showpasswordCBBActionPerformed
        // TODO add your handling code here:
        if (showpasswordCBB.isSelected()) {
            PasswordTF.setEchoChar((char) 0);
        } else {
            PasswordTF.setEchoChar('*');
        }
    }//GEN-LAST:event_showpasswordCBBActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.MyButton ClearBT;
    private Swing.MyButton LoginBT;
    private Swing.MyPassword PasswordTF;
    private Swing.MyTextField UsernameTF;
    private javax.swing.JLabel fullnameLable;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JRadioButton showpasswordCBB;
    // End of variables declaration//GEN-END:variables
}
