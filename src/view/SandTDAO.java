package view;

import controller.Main;

import utils.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Vector;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.Timer;

import java.io.File;
import java.io.IOException;
import model.*;

import javax.imageio.ImageIO;

import view.ShowSIn;

public class SandTDAO extends javax.swing.JFrame {

    public static TreeMap<Integer, ArrayList<Student>> restoreS = new TreeMap<>();

    public static TreeMap<Integer, ArrayList<Teacher>> restoreT = new TreeMap<>();

    public static TreeMap<Integer, Student> storeSInfor = new TreeMap<>();

    public static TreeMap<Integer, Teacher> storeTInfor = new TreeMap<>();

    public static PriorityQueue<Student> pqS = new PriorityQueue<>((p1, p2) -> {
        int compare = p1.id - p2.id;
        return compare;
    });
    public static PriorityQueue<Teacher> pqT = new PriorityQueue<>((p1, p2) -> {
        int compare = p1.id - p2.id;
        return compare;
    });
    public static int grade;
    public static int choice;
    File file;
    String image;
    public static boolean changeImage;
    int index = 0;
    boolean restore = false;

    public static int id;
    public static int id_s;
    boolean chemistry;
    boolean physics;
    boolean maths;

    public SandTDAO(int grade, int choice, int id) {
        initComponents();
        this.id = id;
        this.choice = choice;
        this.grade = grade;
        this.setTitle("List of Students & Teachers");

        searchTF1.setVisible(false);
        titleLabel.setText("WELCOME TO OUR CLASS!");
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        dayCBB.setVisible(false);
        monthCBB.setVisible(false);
        yearTF.setVisible(false);
        genderCBB.setVisible(false);
        homeTabPane.setVisible(false);
        scholarshipTabPane.setVisible(false);
        editTeacherInforPanel.setVisible(false);
        editStudentInforPanel.setVisible(false);
        blankTabPane.setVisible(true);
        if (this.choice == 1) {
            editPanel.setVisible(false);
            scholershipLabel.setVisible(false);
        }

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.saveBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                fileStore.saveInfor("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");

                fileStore.saveRes("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/storeRes.txt");
                JOptionPane.showMessageDialog(saveBT1, "Save Successfully");
                
            }

        });

        this.applyBT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SandTDAO.this.setVisible(false);
                // changeCBB = 0 là sắp xếp giảm
                if (changeCBB.getSelectedIndex() == 0) {

                    if (sellectCBB.getSelectedIndex() == 0) {
                        typeOfShowing(0, 0);
                    } else if (sellectCBB.getSelectedIndex() == 1) {
                        typeOfShowing(0, 1);
                    } else if (sellectCBB.getSelectedIndex() == 2) {
                        typeOfShowing(0, 2);
                    } else if (sellectCBB.getSelectedIndex() == 3 || sellectCBB.getSelectedIndex() == 4) {
                        typeOfShowing(0, 3);
                    } else if (sellectCBB.getSelectedIndex() == 5) {
                        typeOfShowing(0, 5);
                    } else if (sellectCBB.getSelectedIndex() == 6) {
                        typeOfShowing(0, 6);
                    } else if (sellectCBB.getSelectedIndex() == 7) {
                        typeOfShowing(0, 7);
                    } else if (sellectCBB.getSelectedIndex() == 8) {
                        typeOfShowing(0, 8);
                    }
                    // changeCBB = 1 là sắp xếp tăng
                } else if (changeCBB.getSelectedIndex() == 1) {

                    if (sellectCBB.getSelectedIndex() == 0) {
                        typeOfShowing(1, 0);
                    } else if (sellectCBB.getSelectedIndex() == 1) {
                        typeOfShowing(1, 1);
                    } else if (sellectCBB.getSelectedIndex() == 2) {
                        typeOfShowing(1, 2);
                    } else if (sellectCBB.getSelectedIndex() == 3 || sellectCBB.getSelectedIndex() == 4) {
                        typeOfShowing(1, 3);
                    } else if (sellectCBB.getSelectedIndex() == 5) {
                        typeOfShowing(1, 5);
                    } else if (sellectCBB.getSelectedIndex() == 6) {
                        typeOfShowing(1, 6);
                    } else if (sellectCBB.getSelectedIndex() == 7) {
                        typeOfShowing(1, 7);
                    } else if (sellectCBB.getSelectedIndex() == 8) {
                        typeOfShowing(1, 8);
                    }
                } else {
                    if (sellectCBB.getSelectedIndex() == 0) {
                        if (!checkEmpty(searchTF1.getText(), "ID")) {

                        } else {
                            if (!Methods.checkLandN(1, searchTF1.getText())) {
                                warningError("ID only contains numbers");
                            } else if (Integer.parseInt(searchTF1.getText()) <= 0 || Integer.parseInt(searchTF1.getText()) > storeSInfor.size()) {
                                warningError("This id not exist");
                            } else if (storeSInfor.get(Integer.parseInt(searchTF1.getText())).grade != grade) {
                                warningError("This student's id is not in this class");
                            } else {
                                DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
                                int id = Integer.parseInt(searchTF1.getText());
                                Student student = storeSInfor.get(id);
                                tableS.setRowCount(0);
                                Vector rowS = new Vector<>();
                                tableS.addRow(print(rowS, student));
                            }
                        }
                    } else if (sellectCBB.getSelectedIndex() == 1) {
                        if (!checkEmpty(searchTF1.getText(), "Name")) {

                        } else {
                            if (!Methods.checkLandN(0, searchTF1.getText())) {
                                warningError("Name only contains letters");
                            } else {
                                DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
                                tableS.setRowCount(0);
                                Vector rowS = null;
                                for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                                    if (entry.getValue().grade == grade) {
                                        int count = 0;
                                        String[] name = searchTF1.getText().toLowerCase().split(" ");
                                        String[] storename = entry.getValue().name.toLowerCase().split(" ");
                                        int min = Math.min(name.length, storename.length);
                                        for (int i = min, k = 1; i > 0; i--, k++) {
                                            min = Math.min(storename[storename.length - k].length(), name[name.length - k].length());
                                            for (int j = 0; j < min; j++) {
                                                if (storename[storename.length - k].charAt(j) == name[name.length - k].charAt(j)) {
                                                    count++;
                                                }
                                            }
                                        }
                                        if (count == searchTF1.getText().replaceAll(" ", "").length()) {
                                            Student student = entry.getValue();
                                            tableS.addRow(print(rowS, student));
                                        }
                                    }
                                }
                            }
                        }
                    } else if (sellectCBB.getSelectedIndex() == 2) {
                        if (!Methods.checkLandN(1, yearTF.getText())) {
                            warningError("Year only contains numbers");
                        } else {
                            int c_day = dayCBB.getSelectedIndex();
                            int c_month = monthCBB.getSelectedIndex();
                            int c_year = 0;
                            if (yearTF.getText().isEmpty()) {
                                c_year = 0;
                            } else {
                                c_year = Integer.parseInt(yearTF.getText());
                            }

                            if (c_day == 30
                                    && (c_month == 1 || c_month == 3 || c_month == 5 || c_month == 8 || c_month == 10)) {
                                warningError("This month does not have this day");
                            } else if ((c_day == 29 || c_day == 30)
                                    && c_month == 1) {
                                warningError("This month does not have this day");

                            } else if (((c_year % 4 != 0 && c_year % 100 == 0) || c_year % 400 != 0) && c_day == 28 && c_month == 1) {
                                warningError("This year does not have this day");
                            } else if (c_year < 0) {
                                warningError("This year not exist");
                            } else {
                                String check;
                                if (yearTF.getText().isEmpty() || c_year == 0) {
                                    check = String.format("%d", dayCBB.getSelectedIndex() + 1) + String.format("%d", monthCBB.getSelectedIndex() + 1);

                                } else {
                                    String day = String.format("%d", dayCBB.getSelectedIndex() + 1);
                                    String month = String.format("%d", monthCBB.getSelectedIndex() + 1);
                                    String year = yearTF.getText();
                                    check = day + month + year;

                                }
                                DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
                                tableS.setRowCount(0);
                                Vector rowS = null;
                                for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                                    if (entry.getValue().grade == grade) {
                                        String[] store = entry.getValue().dOb.split("/");
                                        String main = store[0] + store[1] + store[2];
                                        int count = 0;
                                        int min = Math.min(main.length(), check.length());
                                        for (int i = 0; i < min; i++) {
                                            if (main.charAt(i) == check.charAt(i)) {
                                                count++;
                                            }
                                        }
                                        if (count == check.length()) {
                                            Student student = entry.getValue();
                                            tableS.addRow(print(rowS, student));
                                        }

                                    }
                                }

                            }
                        }
                    } else if (sellectCBB.getSelectedIndex() == 4) {
                        String check;
                        if (genderCBB.getSelectedIndex() == 0) {
                            check = "male";
                        } else if (genderCBB.getSelectedIndex() == 1) {
                            check = "female";
                        } else {
                            check = "other";
                        }
                        DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
                        tableS.setRowCount(0);
                        Vector rowS = null;
                        for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                            if (entry.getValue().grade == grade && entry.getValue().gender.equalsIgnoreCase(check)) {
                                Student student = entry.getValue();
                                tableS.addRow(print(rowS, student));

                            }
                        }

                    } else if (sellectCBB.getSelectedIndex() == 5 || sellectCBB.getSelectedIndex() == 6
                            || sellectCBB.getSelectedIndex() == 7 || sellectCBB.getSelectedIndex() == 8) {
                        if (!checkEmpty(searchTF1.getText(), "Score")) {
                        } else {
                            if (!Methods.checkLandN(1, searchTF1.getText())) {
                                warningError("Score only contains numbers");
                            } else if (Double.parseDouble(searchTF1.getText()) < 0 || Double.parseDouble(searchTF1.getText()) > 100) {
                                warningError("This score not exist");
                            } else {
                                if (sellectCBB.getSelectedIndex() == 5) {
                                    searchScore("Maths", 0);
                                } else if (sellectCBB.getSelectedIndex() == 6) {
                                    searchScore("Chemistry", 0);
                                } else if (sellectCBB.getSelectedIndex() == 7) {
                                    searchScore("Physics", 0);
                                } else {
                                    searchScore("1", 1);
                                }
                            }
                        }
                    } else if (sellectCBB.getSelectedIndex() == 3) {
                        if (!checkEmpty(searchTF1.getText(), "Address")) {
                        } else {
                            if (!Methods.checkLandN(0, searchTF1.getText())) {
                                warningError("Address only contains letters");
                            } else {
                                DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
                                tableS.setRowCount(0);
                                Vector rowS = null;
                                for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                                    if (entry.getValue().grade == grade) {
                                        int count = 0;
                                        String[] address = searchTF1.getText().toLowerCase().split(" ");
                                        String[] storeaddress = entry.getValue().address.toLowerCase().split(" ");
                                        int min = Math.min(address.length, storeaddress.length);
                                        for (int i = min, k = 1; i > 0; i--, k++) {
                                            min = Math.min(storeaddress[storeaddress.length - k].length(), address[address.length - k].length());
                                            for (int j = 0; j < min; j++) {
                                                if (storeaddress[storeaddress.length - k].charAt(j) == address[address.length - k].charAt(j)) {
                                                    count++;
                                                }
                                            }
                                        }
                                        if (count == searchTF1.getText().replaceAll(" ", "").length()) {
                                            Student student = entry.getValue();
                                            tableS.addRow(print(rowS, student));
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
                SandTDAO.this.setVisible(true);

            }
        }
        );

    }

    @SuppressWarnings("unchecked")
    private boolean checkEmpty(String check, String message) {
        if (check.isEmpty()) {
            warningError(message + " can not be empty");
            return false;
        }
        return true;
    }

    private void searchScore(String subject, int choice) {
        DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
        tableS.setRowCount(0);
        Vector rowS = null;
        double check = Math.floor(Double.parseDouble(searchTF1.getText()));
        if (choice == 0) {  // Score subject

            for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                if (entry.getValue().grade == grade) {
                    double temp = Math.floor(entry.getValue().store_Score.get(subject));
                    if (check == temp) {
                        Student student = entry.getValue();
                        tableS.addRow(print(rowS, student));
                    }
                }
            }
        } else {  // total score           
            for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                double temp = Math.floor(Double.parseDouble(entry.getValue().calculateScore()));
                if (entry.getValue().grade == grade) {
                    if (check == temp) {
                        Student student = entry.getValue();
                        tableS.addRow(print(rowS, student));
                    }

                }
            }

        }

    }

    private void convertTMtoPQ() {
        for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
            this.pqS.add(entry.getValue());
        }
        for (Map.Entry<Integer, Teacher> entry : storeTInfor.entrySet()) {
            this.pqT.add(entry.getValue());
        }
        showing();
    }

    private void typeOfShowing(int change, int choice) {
        // sắp xếp giảm
        if (change == 0) {
            if (choice == 0) {
                Methods.idArrangement(0);

            } else if (choice == 1) { // sắp xếp theo Name
                Methods.nameArrangement(0);
            } else if (choice == 2) {
                Methods.dobArrangement(0);
            } else if (choice == 3) {
                warningError("Address or Gender can not be arranged");
            } else if (choice == 5) {
                Methods.mathsScoreArrangement(0);
            } else if (choice == 6) {
                Methods.cmtScoreArrangement(0);
            } else if (choice == 7) {
                Methods.psScoreArrangement(0);
            } else if (choice == 8) {
                Methods.totalScoreArrangement(0);
            }
            // sắp xếp tăng
        } else if (change == 1) {
            if (choice == 0) {
                Methods.idArrangement(1);
            } else if (choice == 1) {
                Methods.nameArrangement(1);
            } else if (choice == 2) {
                Methods.dobArrangement(1);
            } else if (choice == 3 || choice == 4) {
                warningError("Address or Gender can not be arranged");
            } else if (choice == 5) {
                Methods.mathsScoreArrangement(1);
            } else if (choice == 6) {
                Methods.cmtScoreArrangement(1);
            } else if (choice == 7) {
                Methods.psScoreArrangement(1);
            } else if (choice == 8) {
                Methods.totalScoreArrangement(1);
            }
        }
        if (change != 2 && choice != 3) {
            convertTMtoPQ();
        }
    }

    private void warningError(String message) {
        String title = "Warning";
        String content = message;
        JOptionPane.showMessageDialog(rootPane, content, title, JOptionPane.ERROR_MESSAGE);

    }

    private boolean notExist(String check) {
        if (Double.parseDouble(check) < 0 || Double.parseDouble(check) > 100) {
            warningError("This score not exist");
            return false;
        }
        return true;
    }

    private void showing() {

        DefaultTableModel tableS = (DefaultTableModel) studentShow.getModel();
        tableS.setRowCount(0);
        Vector rowS;
        while (pqS.size() != 0) {
            if (pqS.peek().grade == grade) {
                rowS = new Vector<>();
                rowS.add(pqS.peek().id);
                rowS.add(pqS.peek().name);
                rowS.add(pqS.peek().dOb);
                rowS.add(pqS.peek().address);
                rowS.add(pqS.peek().gender);
                rowS.add(pqS.peek().grade);
                rowS.add(String.format("%.2f", pqS.peek().store_Score.get("Maths")));
                rowS.add(String.format("%.2f", pqS.peek().store_Score.get("Chemistry")));
                rowS.add(String.format("%.2f", pqS.peek().store_Score.get("Physics")));

                rowS.add(pqS.poll().calculateScore());
                tableS.addRow(rowS);
            } else {
                pqS.poll();
            }
        }

        DefaultTableModel tableT = (DefaultTableModel) teacherShow.getModel();
        tableT.setRowCount(0);
        Vector rowT;
        while (pqT.size() != 0) {
            if (pqT.peek().classInCharge == grade) {
                rowT = new Vector<>();
                rowT.add(pqT.peek().id);
                rowT.add(pqT.peek().name);
                rowT.add(pqT.peek().dOb);
                rowT.add(pqT.peek().address);
                rowT.add(pqT.peek().gender);
                rowT.add(pqT.peek().subject);
                rowT.add(pqT.poll().degree);
                tableT.addRow(rowT);
            } else {
                pqT.poll();
            }

        }
        this.setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ClearBT = new Swing.MyButton();
        bg = new javax.swing.JPanel();
        sidePanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        homeLabel = new javax.swing.JLabel();
        scholershipLabel = new javax.swing.JPanel();
        homeLabel5 = new javax.swing.JLabel();
        leaveLabel = new javax.swing.JPanel();
        homeLabel2 = new javax.swing.JLabel();
        crossLineSeparator = new javax.swing.JSeparator();
        EIULabel = new javax.swing.JLabel();
        editPanel = new javax.swing.JPanel();
        editLabel = new javax.swing.JLabel();
        editTeacherInforPanel = new javax.swing.JPanel();
        editTeacherInforLabel = new javax.swing.JLabel();
        editStudentInforPanel = new javax.swing.JPanel();
        editStudentInforLabel = new javax.swing.JLabel();
        changePasswordPanel = new javax.swing.JPanel();
        changePasswordLabel = new javax.swing.JLabel();
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        changeTabPane = new javax.swing.JPanel();
        scholarshipTabPane = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        schoShow = new javax.swing.JTable();
        scoreTF = new javax.swing.JTextField();
        numberschoTF = new javax.swing.JTextField();
        applyBT1 = new Swing.MyButton();
        homeTabPane = new javax.swing.JPanel();
        monthCBB = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentShow = new javax.swing.JTable();
        yearTF = new javax.swing.JTextField();
        genderCBB = new javax.swing.JComboBox<>();
        sellectCBB = new javax.swing.JComboBox<>();
        searchTF1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        teacherShow = new javax.swing.JTable();
        changeCBB = new javax.swing.JComboBox<>();
        saveBT1 = new Swing.MyButton();
        applyBT = new Swing.MyButton();
        dayCBB = new javax.swing.JComboBox<>();
        editTeacherInforTabPane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        teacherShow1 = new javax.swing.JTable();
        dayCBB1 = new javax.swing.JComboBox<>();
        genderLabel1 = new javax.swing.JLabel();
        monthCBB1 = new javax.swing.JComboBox<>();
        addressLabel1 = new javax.swing.JLabel();
        yearTF1 = new javax.swing.JTextField();
        imageLabel1 = new javax.swing.JLabel();
        bwRDB1 = new javax.swing.JRadioButton();
        fwRDB1 = new javax.swing.JRadioButton();
        nameLabel1 = new javax.swing.JLabel();
        genderCBB1 = new javax.swing.JComboBox<>();
        DOBTF1 = new javax.swing.JLabel();
        degreeCBB1 = new javax.swing.JComboBox<>();
        degreeLabel = new javax.swing.JLabel();
        changeBT1 = new Swing.MyButton();
        restoreBT2 = new Swing.MyButton();
        registerLabel = new javax.swing.JLabel();
        addressTF1 = new Swing.MyTextField();
        nameTF1 = new Swing.MyTextField();
        editStudentInforTabPane = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        studentShow1 = new javax.swing.JTable();
        genderCBB2 = new javax.swing.JComboBox<>();
        nameLabel = new javax.swing.JLabel();
        DOBLabel = new javax.swing.JLabel();
        dayCBB2 = new javax.swing.JComboBox<>();
        monthCBB2 = new javax.swing.JComboBox<>();
        yearTF2 = new javax.swing.JTextField();
        addressLabel = new javax.swing.JLabel();
        bwRDB = new javax.swing.JRadioButton();
        genderLabel = new javax.swing.JLabel();
        fwRDB = new javax.swing.JRadioButton();
        changeInforLabel = new javax.swing.JLabel();
        restoreBT = new Swing.MyButton();
        changeBT = new Swing.MyButton();
        physicLabel = new javax.swing.JLabel();
        mathLabel = new javax.swing.JLabel();
        chemistryLabel = new javax.swing.JLabel();
        addressTF = new Swing.MyTextField();
        chemistryTF = new Swing.MyTextField();
        nameTF = new Swing.MyTextField();
        mathsTF = new Swing.MyTextField();
        physicsTF = new Swing.MyTextField();
        imageLabel = new javax.swing.JLabel();
        deleteBT = new Swing.MyButton();
        genderLabel2 = new javax.swing.JLabel();
        gradechangeCBB = new javax.swing.JComboBox<>();
        blankTabPane = new javax.swing.JPanel();
        changePasswordTabPane = new javax.swing.JPanel();
        conPassLabel = new javax.swing.JLabel();
        newPassLabel = new javax.swing.JLabel();
        clearBT1 = new Swing.MyButton();
        changeBT2 = new Swing.MyButton();
        repassTF = new Swing.MyPassword();
        newpassTF = new Swing.MyPassword();
        userNameLabel = new javax.swing.JLabel();
        userchangeTF = new Swing.MyTextField();
        curPassLabel = new javax.swing.JLabel();
        curpassTF = new Swing.MyPassword();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidePanel.setBackground(new java.awt.Color(0, 58, 98));
        sidePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homePanel.setBackground(new java.awt.Color(72, 117, 158));
        homePanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                homePanelMouseMoved(evt);
            }
        });
        homePanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                homePanelFocusLost(evt);
            }
        });
        homePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                homePanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                homePanelMousePressed(evt);
            }
        });

        homeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeLabel.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel.setText("Home");

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addComponent(homeLabel)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addComponent(homeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidePanel.add(homePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 270, -1));

        scholershipLabel.setBackground(new java.awt.Color(69, 103, 134));
        scholershipLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                scholershipLabelMouseMoved(evt);
            }
        });
        scholershipLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scholershipLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                scholershipLabelMousePressed(evt);
            }
        });
        scholershipLabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeLabel5.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel5.setText("Scholarship");
        scholershipLabel.add(homeLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 40));

        sidePanel.add(scholershipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 185, 270, -1));

        leaveLabel.setBackground(new java.awt.Color(39, 74, 107));
        leaveLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                leaveLabelMouseMoved(evt);
            }
        });
        leaveLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                leaveLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leaveLabelMousePressed(evt);
            }
        });
        leaveLabel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        homeLabel2.setForeground(new java.awt.Color(255, 255, 255));
        homeLabel2.setText("Leave");
        leaveLabel.add(homeLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 40, 40));

        sidePanel.add(leaveLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 270, -1));
        sidePanel.add(crossLineSeparator, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 94, 199, -1));

        EIULabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\DELL\\Documents\\NetBeansProjects\\ProjectCSE203\\src\\Icon\\eiu.png")); // NOI18N
        sidePanel.add(EIULabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, -1, -1));

        editPanel.setBackground(new java.awt.Color(69, 103, 134));
        editPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                editPanelMouseMoved(evt);
            }
        });
        editPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editPanelMousePressed(evt);
            }
        });
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        editLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editLabel.setForeground(new java.awt.Color(255, 255, 255));
        editLabel.setText("Edit Information");
        editPanel.add(editLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 40));

        sidePanel.add(editPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 270, -1));

        editTeacherInforPanel.setBackground(new java.awt.Color(61, 99, 133));
        editTeacherInforPanel.setPreferredSize(new java.awt.Dimension(200, 40));
        editTeacherInforPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                editTeacherInforPanelMouseMoved(evt);
            }
        });
        editTeacherInforPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editTeacherInforPanelMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editTeacherInforPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editTeacherInforPanelMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editTeacherInforPanelMouseReleased(evt);
            }
        });

        editTeacherInforLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editTeacherInforLabel.setForeground(new java.awt.Color(255, 255, 255));
        editTeacherInforLabel.setText("Teacher");

        javax.swing.GroupLayout editTeacherInforPanelLayout = new javax.swing.GroupLayout(editTeacherInforPanel);
        editTeacherInforPanel.setLayout(editTeacherInforPanelLayout);
        editTeacherInforPanelLayout.setHorizontalGroup(
            editTeacherInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTeacherInforPanelLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(editTeacherInforLabel)
                .addGap(107, 107, 107))
        );
        editTeacherInforPanelLayout.setVerticalGroup(
            editTeacherInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTeacherInforPanelLayout.createSequentialGroup()
                .addComponent(editTeacherInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidePanel.add(editTeacherInforPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 270, 0));

        editStudentInforPanel.setBackground(new java.awt.Color(61, 99, 133));
        editStudentInforPanel.setPreferredSize(new java.awt.Dimension(200, 40));
        editStudentInforPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                editStudentInforPanelMouseMoved(evt);
            }
        });
        editStudentInforPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editStudentInforPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editStudentInforPanelMousePressed(evt);
            }
        });

        editStudentInforLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editStudentInforLabel.setForeground(new java.awt.Color(255, 255, 255));
        editStudentInforLabel.setText("Student");

        javax.swing.GroupLayout editStudentInforPanelLayout = new javax.swing.GroupLayout(editStudentInforPanel);
        editStudentInforPanel.setLayout(editStudentInforPanelLayout);
        editStudentInforPanelLayout.setHorizontalGroup(
            editStudentInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editStudentInforPanelLayout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(editStudentInforLabel)
                .addGap(107, 107, 107))
        );
        editStudentInforPanelLayout.setVerticalGroup(
            editStudentInforPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editStudentInforPanelLayout.createSequentialGroup()
                .addComponent(editStudentInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        sidePanel.add(editStudentInforPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 270, 0));

        changePasswordPanel.setBackground(new java.awt.Color(39, 74, 107));
        changePasswordPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                changePasswordPanelMouseMoved(evt);
            }
        });
        changePasswordPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePasswordPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changePasswordPanelMousePressed(evt);
            }
        });
        changePasswordPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        changePasswordLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        changePasswordLabel.setText("Change Password");
        changePasswordPanel.add(changePasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 120, 40));

        sidePanel.add(changePasswordPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 270, -1));

        titlePanel.setBackground(new java.awt.Color(154, 182, 207));
        titlePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("WELCOME TO OUR CLASS!!");
        titlePanel.add(titleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, -1, 80));

        changeTabPane.setLayout(new java.awt.CardLayout());

        schoShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rank", "ID", "Fullname", "DOB", "Address", "Gender", "Grade", "Maths", "Chemistry", "Physics", "TScore"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        schoShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schoShowMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(schoShow);
        if (schoShow.getColumnModel().getColumnCount() > 0) {
            schoShow.getColumnModel().getColumn(0).setResizable(false);
            schoShow.getColumnModel().getColumn(0).setPreferredWidth(2);
            schoShow.getColumnModel().getColumn(1).setResizable(false);
            schoShow.getColumnModel().getColumn(1).setPreferredWidth(2);
            schoShow.getColumnModel().getColumn(2).setResizable(false);
            schoShow.getColumnModel().getColumn(3).setResizable(false);
            schoShow.getColumnModel().getColumn(3).setPreferredWidth(20);
            schoShow.getColumnModel().getColumn(4).setResizable(false);
            schoShow.getColumnModel().getColumn(4).setPreferredWidth(20);
            schoShow.getColumnModel().getColumn(5).setResizable(false);
            schoShow.getColumnModel().getColumn(5).setPreferredWidth(15);
            schoShow.getColumnModel().getColumn(6).setResizable(false);
            schoShow.getColumnModel().getColumn(6).setPreferredWidth(5);
            schoShow.getColumnModel().getColumn(7).setResizable(false);
            schoShow.getColumnModel().getColumn(7).setPreferredWidth(20);
            schoShow.getColumnModel().getColumn(8).setResizable(false);
            schoShow.getColumnModel().getColumn(8).setPreferredWidth(20);
            schoShow.getColumnModel().getColumn(9).setResizable(false);
            schoShow.getColumnModel().getColumn(9).setPreferredWidth(20);
            schoShow.getColumnModel().getColumn(10).setResizable(false);
            schoShow.getColumnModel().getColumn(10).setPreferredWidth(20);
        }

        scoreTF.setText("Score");
        scoreTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreTFActionPerformed(evt);
            }
        });

        numberschoTF.setText("Number of Scho");

        applyBT1.setText("Apply");
        applyBT1.setColor(new java.awt.Color(255, 255, 255));
        applyBT1.setColorOver(new java.awt.Color(255, 255, 255));
        applyBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyBT1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scholarshipTabPaneLayout = new javax.swing.GroupLayout(scholarshipTabPane);
        scholarshipTabPane.setLayout(scholarshipTabPaneLayout);
        scholarshipTabPaneLayout.setHorizontalGroup(
            scholarshipTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scholarshipTabPaneLayout.createSequentialGroup()
                .addGroup(scholarshipTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(scholarshipTabPaneLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(scoreTF, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(numberschoTF, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(applyBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        scholarshipTabPaneLayout.setVerticalGroup(
            scholarshipTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, scholarshipTabPaneLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(scholarshipTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(scoreTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numberschoTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        changeTabPane.add(scholarshipTabPane, "card3");

        monthCBB.setBackground(new java.awt.Color(204, 204, 204));
        monthCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jScrollPane1.setBorder(null);

        studentShow.setAutoCreateRowSorter(true);
        studentShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Fullname", "DOB", "Address", "Gender", "Grade", "Maths", "Chemistry", "Physics", "TScore"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentShowMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentShow);
        if (studentShow.getColumnModel().getColumnCount() > 0) {
            studentShow.getColumnModel().getColumn(0).setResizable(false);
            studentShow.getColumnModel().getColumn(0).setPreferredWidth(5);
            studentShow.getColumnModel().getColumn(1).setResizable(false);
            studentShow.getColumnModel().getColumn(2).setResizable(false);
            studentShow.getColumnModel().getColumn(2).setPreferredWidth(20);
            studentShow.getColumnModel().getColumn(3).setResizable(false);
            studentShow.getColumnModel().getColumn(3).setPreferredWidth(25);
            studentShow.getColumnModel().getColumn(4).setResizable(false);
            studentShow.getColumnModel().getColumn(4).setPreferredWidth(10);
            studentShow.getColumnModel().getColumn(5).setResizable(false);
            studentShow.getColumnModel().getColumn(5).setPreferredWidth(5);
            studentShow.getColumnModel().getColumn(6).setResizable(false);
            studentShow.getColumnModel().getColumn(6).setPreferredWidth(15);
            studentShow.getColumnModel().getColumn(7).setResizable(false);
            studentShow.getColumnModel().getColumn(7).setPreferredWidth(15);
            studentShow.getColumnModel().getColumn(8).setResizable(false);
            studentShow.getColumnModel().getColumn(8).setPreferredWidth(15);
            studentShow.getColumnModel().getColumn(9).setResizable(false);
            studentShow.getColumnModel().getColumn(9).setPreferredWidth(15);
        }

        yearTF.setText("Year");

        genderCBB.setBackground(new java.awt.Color(204, 204, 204));
        genderCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        sellectCBB.setBackground(new java.awt.Color(204, 204, 204));
        sellectCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Name", "Date of Birth", "Address", "Gender", "Maths", "Chemistry", "Physics", "Total" }));
        sellectCBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sellectCBBActionPerformed(evt);
            }
        });

        searchTF1.setText("Searching");

        teacherShow.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fullname", "Date of Birth", "Address", "Gender", "SubjectIC", "Degree"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teacherShow.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                teacherShowAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        teacherShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherShowMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(teacherShow);
        if (teacherShow.getColumnModel().getColumnCount() > 0) {
            teacherShow.getColumnModel().getColumn(0).setResizable(false);
            teacherShow.getColumnModel().getColumn(0).setPreferredWidth(5);
            teacherShow.getColumnModel().getColumn(1).setResizable(false);
            teacherShow.getColumnModel().getColumn(2).setResizable(false);
            teacherShow.getColumnModel().getColumn(2).setPreferredWidth(20);
            teacherShow.getColumnModel().getColumn(3).setResizable(false);
            teacherShow.getColumnModel().getColumn(3).setPreferredWidth(20);
            teacherShow.getColumnModel().getColumn(4).setResizable(false);
            teacherShow.getColumnModel().getColumn(4).setPreferredWidth(10);
            teacherShow.getColumnModel().getColumn(5).setResizable(false);
            teacherShow.getColumnModel().getColumn(5).setPreferredWidth(30);
            teacherShow.getColumnModel().getColumn(6).setResizable(false);
        }

        changeCBB.setBackground(new java.awt.Color(204, 204, 204));
        changeCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending", "Searching" }));
        changeCBB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeCBBMouseClicked(evt);
            }
        });
        changeCBB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCBBActionPerformed(evt);
            }
        });

        saveBT1.setText("Save");
        saveBT1.setColor(new java.awt.Color(255, 255, 255));
        saveBT1.setColorOver(new java.awt.Color(255, 255, 255));

        applyBT.setText("Apply");
        applyBT.setColor(new java.awt.Color(255, 255, 255));
        applyBT.setColorOver(new java.awt.Color(255, 255, 255));

        dayCBB.setBackground(new java.awt.Color(204, 204, 204));
        dayCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        javax.swing.GroupLayout homeTabPaneLayout = new javax.swing.GroupLayout(homeTabPane);
        homeTabPane.setLayout(homeTabPaneLayout);
        homeTabPaneLayout.setHorizontalGroup(
            homeTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeTabPaneLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(homeTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homeTabPaneLayout.createSequentialGroup()
                        .addComponent(dayCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(homeTabPaneLayout.createSequentialGroup()
                        .addComponent(sellectCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changeCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(genderCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(applyBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))))
            .addGroup(homeTabPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1023, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homeTabPaneLayout.setVerticalGroup(
            homeTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeTabPaneLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(homeTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellectCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changeCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(genderCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(applyBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dayCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        changeTabPane.add(homeTabPane, "card2");

        teacherShow1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fullname", "Date of Birth", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        teacherShow1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                teacherShow1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        teacherShow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherShow1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(teacherShow1);
        if (teacherShow1.getColumnModel().getColumnCount() > 0) {
            teacherShow1.getColumnModel().getColumn(0).setResizable(false);
            teacherShow1.getColumnModel().getColumn(0).setPreferredWidth(2);
            teacherShow1.getColumnModel().getColumn(1).setResizable(false);
            teacherShow1.getColumnModel().getColumn(2).setResizable(false);
            teacherShow1.getColumnModel().getColumn(2).setPreferredWidth(20);
            teacherShow1.getColumnModel().getColumn(3).setResizable(false);
            teacherShow1.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        dayCBB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        genderLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderLabel1.setText("Gender:");

        monthCBB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        addressLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addressLabel1.setText("Address:");

        yearTF1.setText("Year");

        imageLabel1.setBackground(new java.awt.Color(0, 0, 0));
        imageLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        imageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel1.setText("Change Image");
        imageLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imageLabel1.setMaximumSize(new java.awt.Dimension(145, 126));
        imageLabel1.setMinimumSize(new java.awt.Dimension(145, 126));
        imageLabel1.setPreferredSize(new java.awt.Dimension(145, 126));
        imageLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabel1MouseClicked(evt);
            }
        });

        bwRDB1.setText("Backward");
        bwRDB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bwRDB1ActionPerformed(evt);
            }
        });

        fwRDB1.setText("Forward");
        fwRDB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fwRDB1ActionPerformed(evt);
            }
        });

        nameLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameLabel1.setText("Name:");

        genderCBB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        DOBTF1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DOBTF1.setText("Date of Birth:");

        degreeCBB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bachelor", "Engineering" }));

        degreeLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        degreeLabel.setText("Degree:");

        changeBT1.setBackground(new java.awt.Color(0, 58, 98));
        changeBT1.setForeground(new java.awt.Color(255, 255, 255));
        changeBT1.setText("Change");
        changeBT1.setColor(new java.awt.Color(0, 58, 98));
        changeBT1.setColorOver(new java.awt.Color(0, 58, 98));
        changeBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBT1ActionPerformed(evt);
            }
        });

        restoreBT2.setBackground(new java.awt.Color(0, 58, 98));
        restoreBT2.setForeground(new java.awt.Color(255, 255, 255));
        restoreBT2.setText("Restore");
        restoreBT2.setColor(new java.awt.Color(0, 58, 98));
        restoreBT2.setColorOver(new java.awt.Color(0, 58, 98));
        restoreBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBT2ActionPerformed(evt);
            }
        });

        registerLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        registerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registerLabel.setText("Teacher Infor ");
        registerLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        addressTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTF1ActionPerformed(evt);
            }
        });

        nameTF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTF1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editTeacherInforTabPaneLayout = new javax.swing.GroupLayout(editTeacherInforTabPane);
        editTeacherInforTabPane.setLayout(editTeacherInforTabPaneLayout);
        editTeacherInforTabPaneLayout.setHorizontalGroup(
            editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addComponent(nameLabel1))
                                    .addComponent(DOBTF1)
                                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(addressLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                        .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(dayCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(monthCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(yearTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(addressTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(nameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editTeacherInforTabPaneLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(registerLabel)
                                        .addGap(74, 74, 74))))
                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(genderLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                        .addComponent(genderCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(degreeLabel))
                                    .addComponent(bwRDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fwRDB1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(145, 145, 145))))
                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(changeBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(restoreBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135)))
                .addGap(33, 42, Short.MAX_VALUE))
        );
        editTeacherInforTabPaneLayout.setVerticalGroup(
            editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                        .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(nameLabel1)
                                .addGap(25, 25, 25)
                                .addComponent(DOBTF1)
                                .addGap(28, 28, 28)
                                .addComponent(addressLabel1)
                                .addGap(32, 32, 32)
                                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(genderLabel1)
                                    .addComponent(genderCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(degreeLabel)
                                    .addComponent(degreeCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(registerLabel)
                                .addGap(30, 30, 30)
                                .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editTeacherInforTabPaneLayout.createSequentialGroup()
                                        .addComponent(nameTF1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dayCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(monthCBB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yearTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(addressTF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(imageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bwRDB1)
                            .addComponent(fwRDB1))
                        .addGap(18, 18, 18)
                        .addGroup(editTeacherInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(changeBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restoreBT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        changeTabPane.add(editTeacherInforTabPane, "card8");

        jScrollPane5.setBorder(null);

        studentShow1.setAutoCreateRowSorter(true);
        studentShow1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fullname", "DOB", "Gender"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        studentShow1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentShow1MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(studentShow1);
        if (studentShow1.getColumnModel().getColumnCount() > 0) {
            studentShow1.getColumnModel().getColumn(0).setResizable(false);
            studentShow1.getColumnModel().getColumn(0).setPreferredWidth(2);
            studentShow1.getColumnModel().getColumn(1).setResizable(false);
            studentShow1.getColumnModel().getColumn(2).setResizable(false);
            studentShow1.getColumnModel().getColumn(2).setPreferredWidth(30);
            studentShow1.getColumnModel().getColumn(3).setResizable(false);
            studentShow1.getColumnModel().getColumn(3).setPreferredWidth(10);
        }

        genderCBB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));

        nameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nameLabel.setText("Name");

        DOBLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        DOBLabel.setText("Date of Birth");

        dayCBB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        monthCBB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        yearTF2.setText("Year");
        yearTF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearTF2ActionPerformed(evt);
            }
        });

        addressLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        addressLabel.setText("Address");

        bwRDB.setText("Backward");
        bwRDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bwRDBActionPerformed(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderLabel.setText("Gender");

        fwRDB.setText("Forward");
        fwRDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fwRDBActionPerformed(evt);
            }
        });

        changeInforLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        changeInforLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        changeInforLabel.setText("Change Student's Infor");
        changeInforLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        restoreBT.setBackground(new java.awt.Color(0, 58, 98));
        restoreBT.setForeground(new java.awt.Color(255, 255, 255));
        restoreBT.setText("Restore");
        restoreBT.setColor(new java.awt.Color(0, 58, 98));
        restoreBT.setColorOver(new java.awt.Color(0, 58, 98));
        restoreBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreBTActionPerformed(evt);
            }
        });

        changeBT.setBackground(new java.awt.Color(0, 58, 98));
        changeBT.setForeground(new java.awt.Color(255, 255, 255));
        changeBT.setText("Change");
        changeBT.setColor(new java.awt.Color(0, 58, 98));
        changeBT.setColorOver(new java.awt.Color(0, 58, 98));
        changeBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBTActionPerformed(evt);
            }
        });

        physicLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        physicLabel.setText("Physic");

        mathLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mathLabel.setText("Maths");

        chemistryLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chemistryLabel.setText("Chemistry");

        addressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressTFActionPerformed(evt);
            }
        });

        chemistryTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chemistryTFActionPerformed(evt);
            }
        });

        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        mathsTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mathsTFActionPerformed(evt);
            }
        });

        physicsTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                physicsTFActionPerformed(evt);
            }
        });

        imageLabel.setBackground(new java.awt.Color(0, 0, 0));
        imageLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setText("Change Image");
        imageLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelMouseClicked(evt);
            }
        });

        deleteBT.setBackground(new java.awt.Color(0, 58, 98));
        deleteBT.setForeground(new java.awt.Color(255, 255, 255));
        deleteBT.setText("Delete");
        deleteBT.setColor(new java.awt.Color(0, 58, 98));
        deleteBT.setColorOver(new java.awt.Color(0, 58, 98));
        deleteBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTActionPerformed(evt);
            }
        });

        genderLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        genderLabel2.setText("Grade");

        gradechangeCBB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        javax.swing.GroupLayout editStudentInforTabPaneLayout = new javax.swing.GroupLayout(editStudentInforTabPane);
        editStudentInforTabPane.setLayout(editStudentInforTabPaneLayout);
        editStudentInforTabPaneLayout.setHorizontalGroup(
            editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editStudentInforTabPaneLayout.createSequentialGroup()
                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DOBLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(genderLabel))
                                    .addComponent(addressLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                                .addComponent(dayCBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(monthCBB2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(yearTF2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(genderCBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(genderLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(gradechangeCBB, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGap(15, 15, 15)
                                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                        .addComponent(changeBT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(restoreBT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(deleteBT, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))
                                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(bwRDB)
                                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                                .addComponent(mathLabel)
                                                .addGap(18, 18, 18)
                                                .addComponent(mathsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(chemistryLabel)))
                                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(chemistryTF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(physicLabel)
                                                .addGap(12, 12, 12)
                                                .addComponent(physicsTF, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                                .addGap(75, 75, 75)
                                                .addComponent(fwRDB)))))))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editStudentInforTabPaneLayout.createSequentialGroup()
                        .addComponent(changeInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        editStudentInforTabPaneLayout.setVerticalGroup(
            editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                        .addComponent(changeInforLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(nameLabel)
                                .addGap(17, 17, 17)
                                .addComponent(DOBLabel)
                                .addGap(54, 54, 54)
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(genderLabel)
                                    .addComponent(genderCBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderLabel2)
                                    .addComponent(gradechangeCBB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dayCBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(monthCBB2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(yearTF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressLabel)))
                            .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(editStudentInforTabPaneLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mathLabel)
                                    .addComponent(chemistryLabel)
                                    .addComponent(physicLabel)))
                            .addComponent(mathsTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chemistryTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(physicsTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fwRDB)
                            .addComponent(bwRDB))
                        .addGap(12, 12, 12)
                        .addGroup(editStudentInforTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(changeBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restoreBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteBT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        changeTabPane.add(editStudentInforTabPane, "card6");

        javax.swing.GroupLayout blankTabPaneLayout = new javax.swing.GroupLayout(blankTabPane);
        blankTabPane.setLayout(blankTabPaneLayout);
        blankTabPaneLayout.setHorizontalGroup(
            blankTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1036, Short.MAX_VALUE)
        );
        blankTabPaneLayout.setVerticalGroup(
            blankTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );

        changeTabPane.add(blankTabPane, "card5");

        conPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        conPassLabel.setText("Confirm Password");

        newPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        newPassLabel.setText("New Password");

        clearBT1.setBackground(new java.awt.Color(0, 58, 98));
        clearBT1.setForeground(new java.awt.Color(255, 255, 255));
        clearBT1.setText("Clear");
        clearBT1.setColor(new java.awt.Color(0, 58, 98));
        clearBT1.setColorOver(new java.awt.Color(0, 58, 98));
        clearBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBT1ActionPerformed(evt);
            }
        });

        changeBT2.setBackground(new java.awt.Color(0, 58, 98));
        changeBT2.setForeground(new java.awt.Color(255, 255, 255));
        changeBT2.setText("Change");
        changeBT2.setColor(new java.awt.Color(0, 58, 98));
        changeBT2.setColorOver(new java.awt.Color(0, 58, 98));
        changeBT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeBT2ActionPerformed(evt);
            }
        });

        userNameLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userNameLabel.setText("Username");

        userchangeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userchangeTFActionPerformed(evt);
            }
        });

        curPassLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        curPassLabel.setText("Current Password");

        javax.swing.GroupLayout changePasswordTabPaneLayout = new javax.swing.GroupLayout(changePasswordTabPane);
        changePasswordTabPane.setLayout(changePasswordTabPaneLayout);
        changePasswordTabPaneLayout.setHorizontalGroup(
            changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePasswordTabPaneLayout.createSequentialGroup()
                .addContainerGap(296, Short.MAX_VALUE)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(newPassLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(conPassLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(curPassLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(changePasswordTabPaneLayout.createSequentialGroup()
                            .addComponent(changeBT2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(clearBT1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(repassTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(userchangeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(curpassTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newpassTF, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(391, 391, 391))
        );
        changePasswordTabPaneLayout.setVerticalGroup(
            changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(changePasswordTabPaneLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userchangeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(curPassLabel)
                    .addComponent(curpassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPassLabel))
                .addGap(18, 18, 18)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(repassTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conPassLabel))
                .addGap(18, 18, 18)
                .addGroup(changePasswordTabPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changeBT2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clearBT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(160, Short.MAX_VALUE))
        );

        changeTabPane.add(changePasswordTabPane, "card7");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(changeTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(changeTabPane, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 1340, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homePanelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_homePanelFocusLost

    }//GEN-LAST:event_homePanelFocusLost

    private void homePanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanelMousePressed
        changeImage = false;
        titleLabel.setText("LIST OF STUDENTS & TEACHERS");
        setColor(homePanel);
        resetColor1(homeTabPane);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
        changePasswordTabPane.setVisible(false);
        homeTabPane.setVisible(true);
        scholarshipTabPane.setVisible(false);
        editTeacherInforTabPane.setVisible(false);
        editStudentInforTabPane.setVisible(false);
        editStudentInforPanel.setVisible(false);
        editTeacherInforPanel.setVisible(false);
        blankTabPane.setVisible(false);
        pqS = new PriorityQueue<>((p1, p2) -> {
            int compare = p1.id - p2.id;
            return compare;
        });
        pqT = new PriorityQueue<>((p1, p2) -> {
            int compare = p1.id - p2.id;
            return compare;
        });
        convertTMtoPQ();
    }//GEN-LAST:event_homePanelMousePressed

    private void scholershipLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scholershipLabelMousePressed
        changeImage = false;
        setColor(scholershipLabel);
        resetColor(homePanel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
        resetColor1(scholarshipTabPane);
        DefaultTableModel tableS = (DefaultTableModel) schoShow.getModel();
        tableS.setRowCount(0);
        scoreTF.setText("Score");
        changePasswordTabPane.setVisible(false);
        numberschoTF.setText("Number of Scho");
        homeTabPane.setVisible(false);
        scholarshipTabPane.setVisible(true);
        editTeacherInforTabPane.setVisible(false);
        editStudentInforTabPane.setVisible(false);
        editStudentInforPanel.setVisible(false);
        editTeacherInforPanel.setVisible(false);
        blankTabPane.setVisible(false);
        titleLabel.setText("LIST OF SCHOLARSHIPS");


    }//GEN-LAST:event_scholershipLabelMousePressed

    private void editPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMousePressed

    }//GEN-LAST:event_editPanelMousePressed

    private void leaveLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveLabelMousePressed
        setColor(leaveLabel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
        changePasswordTabPane.setVisible(false);
        editStudentInforPanel.setVisible(false);
        editTeacherInforPanel.setVisible(false);
        if (leaveLabel.isBackgroundSet()) {
            new Main().setVisible(true);
            changeTabPane.setVisible(false);
            this.setVisible(false);
        }
    }//GEN-LAST:event_leaveLabelMousePressed

    private void homePanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanelMouseMoved
        setColor(homePanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_homePanelMouseMoved

    private void scholershipLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scholershipLabelMouseMoved
        setColor(scholershipLabel);
        resetColor(homePanel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_scholershipLabelMouseMoved

    private void editPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseMoved
        setColor(editPanel);
        resetColor1(scholershipLabel);
        resetColor(homePanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_editPanelMouseMoved

    private void leaveLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveLabelMouseMoved
        setColor(leaveLabel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_leaveLabelMouseMoved

    private void schoShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schoShowMouseClicked
        // TODO add your handling code here:

        int store = schoShow.rowAtPoint(evt.getPoint());
        int id = Integer.parseInt(schoShow.getValueAt(store, 1).toString());
        ShowSIn ssi = new ShowSIn();
        ssi.setTextInforS(storeSInfor.get(id));
    }//GEN-LAST:event_schoShowMouseClicked

    private void sellectCBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sellectCBBActionPerformed
        // TODO add your handling code here:
        if (sellectCBB.getSelectedIndex() == 2 && changeCBB.getSelectedIndex() == 2) {
            dayCBB.setVisible(true);
            monthCBB.setVisible(true);
            yearTF.setVisible(true);
            searchTF1.setVisible(false);
            genderCBB.setVisible(false);
        } else if (sellectCBB.getSelectedIndex() == 4) {
            genderCBB.setVisible(true);
            searchTF1.setVisible(false);
            dayCBB.setVisible(false);
            monthCBB.setVisible(false);
            yearTF.setVisible(false);
        } else if (changeCBB.getSelectedIndex() == 2 && sellectCBB.getSelectedIndex()!=4 && sellectCBB.getSelectedIndex()!=2) {
            searchTF1.setVisible(true);
            dayCBB.setVisible(false);
            monthCBB.setVisible(false);
            yearTF.setVisible(false);
            genderCBB.setVisible(false);

        } else {
            dayCBB.setVisible(false);
            monthCBB.setVisible(false);
            yearTF.setVisible(false);
            searchTF1.setVisible(false);
            genderCBB.setVisible(false);
        }
    }//GEN-LAST:event_sellectCBBActionPerformed

    private void teacherShowAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_teacherShowAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherShowAncestorAdded

    private void teacherShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherShowMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int store = teacherShow.rowAtPoint(evt.getPoint());
            int id = Integer.parseInt(teacherShow.getValueAt(store, 0).toString());
            ShowTIn tCIS = new ShowTIn();
            tCIS.setTextInfor(storeTInfor.get(id));
        }

    }//GEN-LAST:event_teacherShowMouseClicked

    private void studentShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentShowMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int store = studentShow.rowAtPoint(evt.getPoint());
            int id = Integer.parseInt(studentShow.getValueAt(store, 0).toString());
            ShowSIn cIS = new ShowSIn();
            cIS.setTextInforS(storeSInfor.get(id));
        }

    }//GEN-LAST:event_studentShowMouseClicked

    private void editPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseEntered

    }//GEN-LAST:event_editPanelMouseEntered

    private void editPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseExited
        // TODO add your handling code here:
        resetColor(homePanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editTeacherInforPanel);
        resetColor3(editStudentInforPanel);
    }//GEN-LAST:event_editPanelMouseExited

    private void editPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseClicked
        // TODO add your handling code here:
        setColor(editPanel);
        if (evt.getClickCount() == 2) {
            titleLabel.setText("EDIT INFORMATION");
        }
        changePasswordTabPane.setVisible(false);
        homeTabPane.setVisible(false);
        scholarshipTabPane.setVisible(false);
        blankTabPane.setVisible(true);
        resetColor1(scholershipLabel);
        resetColor(homePanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
        editStudentInforPanel.setVisible(true);
        editTeacherInforPanel.setVisible(true);
        editStudentInforPanel.setSize(270, 50);
        editTeacherInforPanel.setSize(270, 50);

    }//GEN-LAST:event_editPanelMouseClicked

    private void editTeacherInforPanelMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTeacherInforPanelMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_editTeacherInforPanelMouseReleased

    private void editStudentInforPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editStudentInforPanelMousePressed
        // TODO add your handling code here:
        changeImage = true;
        changePasswordTabPane.setVisible(false);
        homeTabPane.setVisible(false);
        scholarshipTabPane.setVisible(false);
        titleLabel.setText("EDIT STUDENT INFORMATION");
        deleteBT.setVisible(false);
        printPerson(1);
    }//GEN-LAST:event_editStudentInforPanelMousePressed


    private void editTeacherInforPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTeacherInforPanelMousePressed
        // TODO add your handling code here:


    }//GEN-LAST:event_editTeacherInforPanelMousePressed

    private void editTeacherInforPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTeacherInforPanelMouseMoved
        // TODO add your handling code here:
        setColor(editTeacherInforPanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor(homePanel);
        resetColor2(leaveLabel);
        resetColor3(editStudentInforPanel);
    }//GEN-LAST:event_editTeacherInforPanelMouseMoved

    private void editStudentInforPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editStudentInforPanelMouseMoved
        // TODO add your handling code here:
        setColor(editStudentInforPanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor(homePanel);
        resetColor2(leaveLabel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_editStudentInforPanelMouseMoved

    private void teacherShow1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_teacherShow1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherShow1AncestorAdded

    private void teacherShow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherShow1MouseClicked
        // TODO add your handling code here:
        int store = teacherShow1.rowAtPoint(evt.getPoint());
        int id_check = Integer.parseInt(teacherShow1.getValueAt(store, 0).toString());
        if (id != id_check) {
            warningError("You can not change other teachers' infor");
        } else {
            firstShow(0);
        }
    }//GEN-LAST:event_teacherShow1MouseClicked

    private void imageLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabel1MouseClicked
        setImage(0);
    }//GEN-LAST:event_imageLabel1MouseClicked

    private void setImage(int choice) {
        if (changeImage) {
            try {
                JFileChooser jfc = new JFileChooser("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/Images");
                jfc.showOpenDialog(null);
                if (jfc.getSelectedFile() == null) {
                    file = new File("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/Images/defaultimage.jpg");
                } else {
                    file = jfc.getSelectedFile();
                }
                Image img = ImageIO.read(file);
                if (choice == 0) {
                    imageLabel1.setText("");
                    this.image = file.getPath();
                    imageLabel1.setIcon(new ImageIcon(img.getScaledInstance(imageLabel1.getWidth(), imageLabel1.getHeight(), 0)));
                } else {
                    imageLabel.setText("");
                    this.image = file.getPath();
                    imageLabel.setIcon(new ImageIcon(img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), 0)));

                }
            } catch (IOException ex) {
                Logger.getLogger(SandTDAO.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void firstShow(int choice) {
        if (choice == 0) {
            if (!restoreT.containsKey(id)) {
                ArrayList<Teacher> temp = new ArrayList<>();
                Teacher newone = new Teacher(storeTInfor.get(id).id, storeTInfor.get(id).name, storeTInfor.get(id).image, storeTInfor.get(id).dOb,
                        storeTInfor.get(id).address, storeTInfor.get(id).gender,
                        storeTInfor.get(id).username, storeTInfor.get(id).password, storeTInfor.get(id).classInCharge,
                        storeTInfor.get(id).degree, storeTInfor.get(id).position, storeTInfor.get(id).subject);
                temp.add(newone);
                restoreT.put(id, temp);
                setText(0);
            } else {
                setText(0);
            }
        } else {
            if (storeTInfor.get(id).subject.equalsIgnoreCase("Maths")) {
                chemistry = false;
                maths = true;
                physics = false;
                chemistryTF.setEditable(false);
                physicsTF.setEditable(false);
            } else if (storeTInfor.get(id).subject.equalsIgnoreCase("Chemistry")) {
                chemistry = true;
                maths = false;
                physics = false;
                mathsTF.setEditable(false);
                physicsTF.setEditable(false);
            } else {
                chemistry = false;
                maths = false;
                physics = true;
                mathsTF.setEditable(false);
                chemistryTF.setEditable(false);
            }
            if (!restoreS.containsKey(id_s)) {
                ArrayList<Student> temp = new ArrayList<>();
                Student newone = new Student(storeSInfor.get(id_s).id, storeSInfor.get(id_s).name, storeSInfor.get(id_s).image,
                        storeSInfor.get(id_s).dOb, storeSInfor.get(id_s).address, storeSInfor.get(id_s).gender,
                        storeSInfor.get(id_s).grade, storeSInfor.get(id_s).username, storeSInfor.get(id_s).password,
                        storeSInfor.get(id_s).position);
                changeNewOneInforS(newone);
                temp.add(newone);
                restoreS.put(id_s, temp);
                setText(1);
            } else {
                setText(1);
            }
        }
    }

    private void changeNewOneInforS(Student newone) {
        newone.store_Score.put("Maths", storeSInfor.get(id_s).store_Score.get("Maths"));
        newone.store_Score.put("Chemistry", storeSInfor.get(id_s).store_Score.get("Chemistry"));
        newone.store_Score.put("Physics", storeSInfor.get(id_s).store_Score.get("Physics"));

    }

    private void setRestore(int choice) {
        restore = true;
        if (choice == 0) {
            try {

                nameTF1.setText(restoreT.get(id).get(index).name);
                String[] dob = restoreT.get(id).get(index).dOb.split("/");
                dayCBB1.setSelectedIndex(Integer.parseInt(dob[0]) - 1);
                monthCBB1.setSelectedIndex(Integer.parseInt(dob[1]) - 1);
                yearTF1.setText(dob[2]);
                addressTF1.setText(restoreT.get(id).get(index).address);
                if (restoreT.get(id).get(index).gender.equalsIgnoreCase("Male")) {
                    genderCBB1.setSelectedIndex(0);
                } else if (restoreT.get(id).get(index).gender.equalsIgnoreCase("Female")) {
                    genderCBB1.setSelectedIndex(1);
                } else {
                    genderCBB1.setSelectedIndex(2);
                }
                if (restoreT.get(id).get(index).degree.equalsIgnoreCase("Bachelor")) {
                    degreeCBB1.setSelectedIndex(0);
                } else {
                    degreeCBB1.setSelectedIndex(1);
                }
                imageLabel1.setText("");
                image = restoreT.get(id).get(index).image;
                File f = new File(restoreT.get(id).get(index).image);
                Image img = ImageIO.read(f);
                imageLabel1.setIcon(new ImageIcon(img.getScaledInstance(imageLabel1.getWidth(), imageLabel1.getHeight(), 0)));

            } catch (IOException ex) {
                Logger.getLogger(ShowTIn.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {

                nameTF.setText(restoreS.get(id_s).get(index).name);
                String[] dob = restoreS.get(id_s).get(index).dOb.split("/");
                dayCBB2.setSelectedIndex(Integer.parseInt(dob[0]) - 1);
                monthCBB2.setSelectedIndex(Integer.parseInt(dob[1]) - 1);
                yearTF2.setText(dob[2]);
                addressTF.setText(restoreS.get(id_s).get(index).address);
                if (restoreS.get(id_s).get(index).gender.equalsIgnoreCase("Male")) {
                    genderCBB2.setSelectedIndex(0);
                } else if (restoreS.get(id_s).get(index).gender.equalsIgnoreCase("Female")) {
                    genderCBB2.setSelectedIndex(1);
                } else {
                    genderCBB2.setSelectedIndex(2);
                }
                if (restoreS.get(id_s).get(index).grade == 10) {
                    gradechangeCBB.setSelectedIndex(0);
                } else if (restoreS.get(id_s).get(index).grade == 11) {
                    gradechangeCBB.setSelectedIndex(1);
                } else {
                    gradechangeCBB.setSelectedIndex(2);
                }
                mathsTF.setText(String.format("%.2f", restoreS.get(id_s).get(index).store_Score.get("Maths")));
                chemistryTF.setText(String.format("%.2f", restoreS.get(id_s).get(index).store_Score.get("Chemistry")));
                physicsTF.setText(String.format("%.2f", restoreS.get(id_s).get(index).store_Score.get("Physics")));
                imageLabel.setText("");
                image = restoreS.get(id_s).get(index).image;
                File f = new File(restoreS.get(id_s).get(index).image);
                Image img = ImageIO.read(f);
                imageLabel.setIcon(new ImageIcon(img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), 0)));

            } catch (IOException ex) {
                Logger.getLogger(ShowSIn.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void setInforPerson(int choice) {
        if (choice == 0) {
            storeTInfor.get(id).name = nameTF1.getText();
            storeTInfor.get(id).dOb = String.format("%d", (dayCBB1.getSelectedIndex() + 1)) + "/" + String.format("%d", (monthCBB1.getSelectedIndex() + 1)) + "/" + yearTF1.getText();
            storeTInfor.get(id).address = addressTF1.getText();
            storeTInfor.get(id).gender = genderCBB1.getItemAt(genderCBB1.getSelectedIndex());
            storeTInfor.get(id).degree = degreeCBB1.getItemAt(degreeCBB1.getSelectedIndex());
            storeTInfor.get(id).image = image;
        } else {
            storeSInfor.get(id_s).grade = Integer.parseInt(gradechangeCBB.getItemAt(gradechangeCBB.getSelectedIndex()));
            storeSInfor.get(id_s).name = nameTF.getText();
            storeSInfor.get(id_s).address = addressTF.getText();
            storeSInfor.get(id_s).gender = genderCBB2.getItemAt(genderCBB2.getSelectedIndex());
            storeSInfor.get(id_s).dOb = String.format("%d", (dayCBB2.getSelectedIndex() + 1)) + "/" + String.format("%d", (monthCBB2.getSelectedIndex() + 1)) + "/" + yearTF2.getText();
            if (maths) {
                storeSInfor.get(id_s).store_Score.put("Maths", Double.parseDouble(mathsTF.getText()));
            } else if (chemistry) {
                storeSInfor.get(id_s).store_Score.put("Chemistry", Double.parseDouble(chemistryTF.getText()));
            } else {
                storeSInfor.get(id_s).store_Score.put("Physics", Double.parseDouble(physicsTF.getText()));
            }

            storeSInfor.get(id_s).image = image;
        }
        restore = false;
    }

    private void setText(int choice) {
        if (choice == 0) {
            try {
                nameTF1.setText(storeTInfor.get(id).name);
                String[] dob = storeTInfor.get(id).dOb.split("/");
                dayCBB1.setSelectedIndex(Integer.parseInt(dob[0]) - 1);
                monthCBB1.setSelectedIndex(Integer.parseInt(dob[1]) - 1);
                yearTF1.setText(dob[2]);
                addressTF1.setText(storeTInfor.get(id).address);
                if (storeTInfor.get(id).gender.equalsIgnoreCase("Male")) {
                    genderCBB1.setSelectedIndex(0);
                } else if (storeTInfor.get(id).gender.equalsIgnoreCase("Female")) {
                    genderCBB1.setSelectedIndex(1);
                } else {
                    genderCBB1.setSelectedIndex(2);
                }
                if (storeTInfor.get(id).degree.equalsIgnoreCase("Bachelor")) {
                    degreeCBB1.setSelectedIndex(0);
                } else {
                    degreeCBB1.setSelectedIndex(1);
                }
                imageLabel1.setText("");
                File f = new File(storeTInfor.get(id).image);
                this.image = storeTInfor.get(id).image;
                Image img = ImageIO.read(f);
                imageLabel1.setIcon(new ImageIcon(img.getScaledInstance(imageLabel1.getWidth(), imageLabel1.getHeight(), 0)));

            } catch (IOException ex) {
                Logger.getLogger(ShowTIn.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                nameTF.setText(storeSInfor.get(id_s).name);
                String[] dob = storeSInfor.get(id_s).dOb.split("/");
                dayCBB2.setSelectedIndex(Integer.parseInt(dob[0]) - 1);
                monthCBB2.setSelectedIndex(Integer.parseInt(dob[1]) - 1);
                yearTF2.setText(dob[2]);
                addressTF.setText(storeSInfor.get(id_s).address);
                if (storeSInfor.get(id_s).gender.equalsIgnoreCase("Male")) {
                    genderCBB2.setSelectedIndex(0);
                } else if (storeSInfor.get(id_s).gender.equalsIgnoreCase("Female")) {
                    genderCBB2.setSelectedIndex(1);
                } else {
                    genderCBB2.setSelectedIndex(2);
                }
                mathsTF.setText(String.format("%.2f", storeSInfor.get(id_s).store_Score.get("Maths")));
                chemistryTF.setText(String.format("%.2f", storeSInfor.get(id_s).store_Score.get("Chemistry")));
                physicsTF.setText(String.format("%.2f", storeSInfor.get(id_s).store_Score.get("Physics")));
                if (storeSInfor.get(id_s).grade == 10) {
                    gradechangeCBB.setSelectedIndex(0);
                } else if (storeSInfor.get(id_s).grade == 11) {
                    gradechangeCBB.setSelectedIndex(1);
                } else {
                    gradechangeCBB.setSelectedIndex(2);
                }
                imageLabel.setText("");
                image = storeSInfor.get(id_s).image;
                File f = new File(storeSInfor.get(id_s).image);
                Image img = ImageIO.read(f);
                imageLabel.setIcon(new ImageIcon(img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), 0)));

            } catch (IOException ex) {
                Logger.getLogger(ShowSIn.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void printPerson(int choice) {
        if (choice == 0) {
            setColor(editTeacherInforPanel);
            resetColor4(editTeacherInforTabPane);
            resetColor1(scholershipLabel);
            resetColor1(editPanel);
            resetColor(homePanel);
            resetColor3(editStudentInforPanel);
            DefaultTableModel tableT = (DefaultTableModel) teacherShow1.getModel();
            tableT.setRowCount(0);
            Vector rowT;
            for (Map.Entry<Integer, Teacher> entry : storeTInfor.entrySet()) {
                this.pqT.add(entry.getValue());
            }
            while (pqT.size() != 0) {
                rowT = new Vector<>();
                rowT.add(pqT.peek().id);
                rowT.add(pqT.peek().name);
                rowT.add(pqT.peek().dOb);
                rowT.add(pqT.peek().gender);
                tableT.addRow(rowT);

                pqT.poll();
            }
            homeTabPane.setVisible(false);
            scholarshipTabPane.setVisible(false);
            editStudentInforTabPane.setVisible(false);
            editTeacherInforTabPane.setVisible(true);
        } else {
            setColor(editStudentInforPanel);
            resetColor4(editStudentInforTabPane);
            resetColor1(scholershipLabel);
            resetColor1(editPanel);
            resetColor(homePanel);
            resetColor3(editTeacherInforPanel);
            for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                if (entry.getValue().grade == storeTInfor.get(id).classInCharge) {
                    this.pqS.add(entry.getValue());
                }

            }
            DefaultTableModel tableS = (DefaultTableModel) studentShow1.getModel();
            tableS.setRowCount(0);
            Vector rowS;
            while (pqS.size() != 0) {
                rowS = new Vector<>();
                rowS.add(pqS.peek().id);
                rowS.add(pqS.peek().name);
                rowS.add(pqS.peek().dOb);
                rowS.add(pqS.peek().gender);
                tableS.addRow(rowS);
                pqS.poll();
            }

            homeTabPane.setVisible(false);
            scholarshipTabPane.setVisible(false);
            editStudentInforTabPane.setVisible(true);
            editTeacherInforTabPane.setVisible(false);
        }
    }

    private void setTextRestore(int choice) {
        if (choice == 0) {

            if (bwRDB1.isSelected()) {
                index--;
                if (index < 0) {
                    warningError("Restore backward too far,please choose restore forward");
                } else {
                    setRestore(0);
                }
            } else {
                index++;
                if (index >= restoreT.get(id).size()) {
                    warningError("Restore forward too far,please choose restore backward");
                } else {
                    setRestore(0);
                }

            }
        } else {

            if (bwRDB.isSelected()) {
                index--;
                if (index < 0) {
                    warningError("Restore backward too far,please choose restore forward");
                } else {
                    setRestore(1);

                }
            } else {
                index++;
                if (index >= restoreS.get(id_s).size()) {
                    warningError("Restore forward too far,please choose restore backward");
                } else {
                    setRestore(1);
                }
            }

        }
    }

    private void changePerson(int choice) {
        if (choice == 0) {
            if (!checkEmpty(nameTF1.getText(), "Username")) {

            } else {
                if (!Methods.checkLandN(0, nameTF1.getText())) {
                    warningError("Name only contains letters");
                } else {

                    if (!Methods.checkLandN(1, yearTF1.getText())) {
                        warningError("Year only contains numbers");
                    } else {
                        if (dayCBB1.getSelectedIndex() == 30
                                && (monthCBB1.getSelectedIndex() == 1 || monthCBB1.getSelectedIndex() == 3
                                || monthCBB1.getSelectedIndex() == 5 || monthCBB1.getSelectedIndex() == 8 || monthCBB1.getSelectedIndex() == 10)) {
                            warningError("This month does not have this day");
                        } else if ((dayCBB1.getSelectedIndex() == 29 || dayCBB1.getSelectedIndex() == 30)
                                && monthCBB1.getSelectedIndex() == 1) {
                            warningError("This month does not have this day");

                        } else if (((Integer.parseInt(yearTF1.getText()) % 4 != 0
                                && Integer.parseInt(yearTF1.getText()) % 100 == 0) || Integer.parseInt(yearTF1.getText())
                                % 400 != 0) && dayCBB1.getSelectedIndex() == 28 && monthCBB1.getSelectedIndex() == 1) {
                            warningError("This year does not have this day");
                        } else if (Integer.parseInt(yearTF1.getText()) <= 0) {
                            warningError("This year not exist");
                        } else {
                            if (!checkEmpty(addressTF1.getText(), "Address")) {

                            } else {
                                if (restore) {
                                    setInforPerson(0);
                                    JOptionPane.showMessageDialog(rootPane, "Restore successfully");
                                } else {
                                    setInforPerson(0);
                                    Teacher newone = new Teacher(storeTInfor.get(id).id, storeTInfor.get(id).name, storeTInfor.get(id).image,
                                            storeTInfor.get(id).dOb, storeTInfor.get(id).address, storeTInfor.get(id).gender,
                                            storeTInfor.get(id).username, storeTInfor.get(id).password, storeTInfor.get(id).classInCharge,
                                            storeTInfor.get(id).degree, "Teacher", storeTInfor.get(id).subject);
                                    restoreT.get(id).add(newone);
                                    setText(0);
                                    JOptionPane.showMessageDialog(rootPane, "Change successfully");
                                }
                                fileStore.saveAndGet();
                                printPerson(0);

                            }

                        }
                    }

                }

            }
        } else {
            if (!checkEmpty(nameTF.getText(), "Username")) {
            } else if (!Methods.checkLandN(0, nameTF.getText())) {
                warningError("Name only contains letters");
            } else {
                if (!checkEmpty(yearTF2.getText(), "Year")) {
                } else if (!Methods.checkLandN(1, yearTF2.getText())) {
                    warningError("Year only contains numbers");
                } else {
                    if (!checkEmpty(mathsTF.getText(), "Maths's score")) {
                    } else if (!Methods.checkLandN(1, mathsTF.getText())) {
                        warningError("Maths's score only contains numbers");
                    } else if (!notExist(mathsTF.getText())) {

                    } else {
                        if (!checkEmpty(chemistryTF.getText(), "Chemistry's score")) {
                        } else if (!Methods.checkLandN(1, chemistryTF.getText())) {
                            warningError("Chemistry's score only contains numbers");
                        } else if (!notExist(chemistryTF.getText())) {

                        } else {
                            if (!checkEmpty(physicsTF.getText(), "Physics's score")) {
                            } else if (!Methods.checkLandN(1, physicsTF.getText())) {
                                warningError("Physics's score only contains numbers");
                            } else if (!notExist(physicsTF.getText())) {

                            } else {

                                if (restore) {
                                    setInforPerson(1);
                                    JOptionPane.showMessageDialog(rootPane, "Restore successfully");
                                } else {
                                    setInforPerson(1);
                                    Student newone = new Student(storeSInfor.get(id_s).id, storeSInfor.get(id_s).name, storeSInfor.get(id_s).image,
                                            storeSInfor.get(id_s).dOb, storeSInfor.get(id_s).address, storeSInfor.get(id_s).gender,
                                            storeSInfor.get(id_s).grade, storeSInfor.get(id_s).username, storeSInfor.get(id_s).password,
                                            storeSInfor.get(id_s).position);

                                    changeNewOneInforS(newone);
                                    restoreS.get(id_s).add(newone);
                                    setText(1);
                                    JOptionPane.showMessageDialog(rootPane, "Change successfully");
                                }
                                fileStore.saveAndGet();
                                printPerson(1);

                            }
                        }
                    }
                }
            }
        }
    }


    private void changeBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBT1ActionPerformed
        // TODO add your handling code here:
        changePerson(0);

    }//GEN-LAST:event_changeBT1ActionPerformed

    private void restoreBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBT2ActionPerformed
        // TODO add your handling code here:
        setTextRestore(0);
    }//GEN-LAST:event_restoreBT2ActionPerformed

    private void addressTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTF1ActionPerformed

    private void nameTF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTF1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTF1ActionPerformed

    private void homePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePanelMouseExited
        // TODO add your handling code here:
        resetColor(homePanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editTeacherInforPanel);
        resetColor3(editStudentInforPanel);
    }//GEN-LAST:event_homePanelMouseExited

    private void scholershipLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scholershipLabelMouseExited
        // TODO add your handling code here:
        resetColor(homePanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor3(editTeacherInforPanel);
        resetColor3(editStudentInforPanel);
    }//GEN-LAST:event_scholershipLabelMouseExited

    private void studentShow1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentShow1MouseClicked
        // TODO add your handling code here:
        deleteBT.setVisible(true);
        int store = studentShow1.rowAtPoint(evt.getPoint());
        id_s = Integer.parseInt(studentShow1.getValueAt(store, 0).toString());
        firstShow(1);


    }//GEN-LAST:event_studentShow1MouseClicked

    private void yearTF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearTF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearTF2ActionPerformed

    private void restoreBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreBTActionPerformed
        // TODO add your handling code here:
        setTextRestore(1);

    }//GEN-LAST:event_restoreBTActionPerformed

    private void changeBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBTActionPerformed
        // TODO add your handling code here:

        changePerson(1);


    }//GEN-LAST:event_changeBTActionPerformed

    private void addressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressTFActionPerformed

    private void chemistryTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chemistryTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chemistryTFActionPerformed

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void mathsTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mathsTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mathsTFActionPerformed

    private void physicsTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_physicsTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_physicsTFActionPerformed

    private void imageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseClicked
        setImage(1);
    }//GEN-LAST:event_imageLabelMouseClicked

    private void editTeacherInforPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTeacherInforPanelMouseClicked
        // TODO add your handling code here:
        changeImage = true;
        titleLabel.setText("EDIT TEACHER INFORMATION");
        printPerson(0);
        changePasswordTabPane.setVisible(false);
        changePasswordTabPane.setVisible(false);
        homeTabPane.setVisible(false);
        scholarshipTabPane.setVisible(false);

    }//GEN-LAST:event_editTeacherInforPanelMouseClicked

    private void scoreTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scoreTFActionPerformed

    private void applyBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyBT1ActionPerformed
        // TODO add your handling code here:
        if (!checkEmpty(scoreTF.getText(), "Score")) {
        } else if (!Methods.checkLandN(1, scoreTF.getText())) {
            warningError("Score only contains numbers");
        } else if (!notExist(scoreTF.getText())) {

        } else {
            if (!checkEmpty(numberschoTF.getText(), "Number of Scholarship")) {
            } else if (!Methods.checkLandN(1, numberschoTF.getText())) {
                warningError("Scholarship only contains numbers");
            } else if (Integer.parseInt(numberschoTF.getText()) <= 0) {
                warningError("Scholarship can not be negative or zero");
            } else {
                double score = Double.parseDouble(scoreTF.getText());
                int number = Integer.parseInt(numberschoTF.getText());
                PriorityQueue<Student> pq = new PriorityQueue<>((p1, p2) -> {
                    int compare = Double.compare(Double.parseDouble(p2.calculateScore()), Double.parseDouble(p1.calculateScore()));
                    if (compare == 0) {
                        compare = p1.id - p2.id;
                    }
                    return compare;
                });
                DefaultTableModel tableS = (DefaultTableModel) schoShow.getModel();
                tableS.setRowCount(0);
                Vector rowS = null;
                for (Map.Entry<Integer, Student> entry : storeSInfor.entrySet()) {
                    pq.add(entry.getValue());
                }
                int rank = 1;
                int count_num = 0;
                double max_check = (double) Math.round(Double.parseDouble(pq.peek().calculateScore()) * 100) / 100;
                if (Double.compare(max_check, score) >= 0) {
                    while (pq.size() != 0 && count_num <number) {
                        int count_rank = 0;
                        while (Double.compare(max_check, (double) Math.round(Double.parseDouble(pq.peek().calculateScore()) * 100) / 100) == 0) {
                            count_num++;
                            count_rank++;
                            rowS = new Vector<>();
                            rowS.add(rank);
                            rowS.add(pq.peek().id);
                            rowS.add(pq.peek().name);
                            rowS.add(pq.peek().dOb);
                            rowS.add(pq.peek().address);
                            rowS.add(pq.peek().gender);
                            rowS.add(pq.peek().grade);
                            rowS.add(String.format("%.2f", pq.peek().store_Score.get("Maths")));
                            rowS.add(String.format("%.2f", pq.peek().store_Score.get("Chemistry")));
                            rowS.add(String.format("%.2f", pq.peek().store_Score.get("Physics")));
                            rowS.add(pq.poll().calculateScore());
                            tableS.addRow(rowS);
                            if (pq.size() == 0) {
                                break;
                            }
                        }
                        rank += count_rank;
                        if (pq.size() == 0) {
                            break;
                        }
                        max_check = (double) Math.round(Double.parseDouble(pq.peek().calculateScore()) * 100) / 100;;
                        if (Double.compare(max_check, score) < 0) {
                            break;
                        }

                    }
                }
            }
        }

    }//GEN-LAST:event_applyBT1ActionPerformed

    private void changePasswordPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordPanelMouseMoved
        // TODO add your handling code here:
        setColor(changePasswordPanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_changePasswordPanelMouseMoved

    private void changePasswordPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordPanelMousePressed
        // TODO add your handling code here:
        setColor(changePasswordPanel);
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
        resetColor1(changePasswordTabPane);
        homeTabPane.setVisible(false);
        scholarshipTabPane.setVisible(false);
        editStudentInforTabPane.setVisible(false);
        editTeacherInforTabPane.setVisible(false);
        changePasswordTabPane.setVisible(true);
        blankTabPane.setVisible(false);
        if (choice == 0) {
            userchangeTF.setText(storeTInfor.get(id).username);

        } else {
            userchangeTF.setText(storeSInfor.get(id).username);
        }
        userchangeTF.setEditable(false);
        titleLabel.setText("CHANGE PASSWORD");
    }//GEN-LAST:event_changePasswordPanelMousePressed

    private void changePasswordPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePasswordPanelMouseExited
        // TODO add your handling code here:
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor2(changePasswordPanel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_changePasswordPanelMouseExited

    private void leaveLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveLabelMouseExited
        // TODO add your handling code here:
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor2(changePasswordPanel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_leaveLabelMouseExited

    private void editTeacherInforPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editTeacherInforPanelMouseExited
        // TODO add your handling code here:
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor2(changePasswordPanel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_editTeacherInforPanelMouseExited

    private void editStudentInforPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editStudentInforPanelMouseExited
        // TODO add your handling code here:
        resetColor1(scholershipLabel);
        resetColor1(editPanel);
        resetColor2(leaveLabel);
        resetColor2(changePasswordPanel);
        resetColor(homePanel);
        resetColor3(editStudentInforPanel);
        resetColor3(editTeacherInforPanel);
    }//GEN-LAST:event_editStudentInforPanelMouseExited

    private void changeCBBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCBBActionPerformed
        // TODO add your handling code here:
        if (changeCBB.getSelectedIndex() == 2 && sellectCBB.getSelectedIndex() != 2 && sellectCBB.getSelectedIndex() != 4) {
            dayCBB.setVisible(false);
            monthCBB.setVisible(false);
            yearTF.setVisible(false);
            genderCBB.setVisible(false);
            searchTF1.setVisible(true);
        } else if (changeCBB.getSelectedIndex() == 2 && sellectCBB.getSelectedIndex() == 2) {
            searchTF1.setVisible(false);
            dayCBB.setVisible(true);
            monthCBB.setVisible(true);
            genderCBB.setVisible(false);
            yearTF.setVisible(true);
        } else {
            searchTF1.setVisible(false);
            dayCBB.setVisible(false);
            monthCBB.setVisible(false);
            yearTF.setVisible(false);
            genderCBB.setVisible(false);
        }

    }//GEN-LAST:event_changeCBBActionPerformed

    private void changeCBBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeCBBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_changeCBBMouseClicked

    private void ClearBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearBTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ClearBTActionPerformed

    private void clearBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBT1ActionPerformed
        // TODO add your handling code here:
        repassTF.setText("");
        newpassTF.setText("");
        curpassTF.setText("");

    }//GEN-LAST:event_clearBT1ActionPerformed

    private void changeBT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeBT2ActionPerformed
        // TODO add your handling code here:
        if (choice == 1) {
            if (!storeSInfor.get(id_s).password.equals(curpassTF.getText())) {
                warningError("Wrong password");
            } else {
                if (!checkpassTF()) {

                } else {
                    Person person = null;
                    TreeMap<String, Person> temp = new TreeMap<>();
                    person = Login.personAccount.get(storeSInfor.get(id).username).firstEntry().getValue();
                    person.password = repassTF.getText();
                    Login.personAccount.remove(storeSInfor.get(id).username);
                    temp.put(repassTF.getText(), person);
                    Login.personAccount.put(storeSInfor.get(id).username, temp);
                    storeSInfor.get(id).password = repassTF.getText();
                    fileStore.saveInfor("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");

                    JOptionPane.showMessageDialog(rootPane, "Change successfully");
                }
            }
        } else {
            if (!storeTInfor.get(id).password.equals(curpassTF.getText())) {
                warningError("Wrong password");
            } else {
                if (!checkpassTF()) {

                } else {
                    Person person = null;
                    TreeMap<String, Person> temp = new TreeMap<>();
                    person = Login.personAccount.get(storeTInfor.get(id).username).firstEntry().getValue();
                    person.password = repassTF.getText();
                    Login.personAccount.remove(storeTInfor.get(id).username);
                    temp.put(repassTF.getText(), person);
                    Login.personAccount.put(storeTInfor.get(id).username, temp);
                    storeTInfor.get(id).password = repassTF.getText();
                    fileStore.saveInfor("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");

                    JOptionPane.showMessageDialog(rootPane, "Change successfully");
                }
            }

        }


    }//GEN-LAST:event_changeBT2ActionPerformed

    private boolean checkpassTF() {
        if (!checkEmpty(newpassTF.getText(), "Password") || !checkEmpty(repassTF.getText(), "Password")) {
            return false;
        } else if (!newpassTF.getText().equalsIgnoreCase(repassTF.getText())) {
            warningError("Rewrite password not match");
            return false;
        }
        return true;
    }
    private void bwRDB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bwRDB1ActionPerformed
        // TODO add your handling code here:
        fwRDB1.setSelected(false);
    }//GEN-LAST:event_bwRDB1ActionPerformed

    private void fwRDB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fwRDB1ActionPerformed
        // TODO add your handling code here:
        bwRDB1.setSelected(false);
    }//GEN-LAST:event_fwRDB1ActionPerformed

    private void userchangeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userchangeTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userchangeTFActionPerformed

    private void deleteBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTActionPerformed
        // TODO add your handling code here:
        Login.personAccount.remove(SandTDAO.storeSInfor.get(id_s).username);
        SandTDAO.storeSInfor.remove(id_s);
        SandTDAO.restoreS.remove(id_s);
        fileStore.saveAndGet();
        deleteBT.setVisible(false);
        JOptionPane.showMessageDialog(restoreBT, "Delete Successfully");
        printPerson(1);
        
    }//GEN-LAST:event_deleteBTActionPerformed

    private void bwRDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bwRDBActionPerformed
        // TODO add your handling code here:
        fwRDB.setSelected(false);
    }//GEN-LAST:event_bwRDBActionPerformed

    private void fwRDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fwRDBActionPerformed
        // TODO add your handling code here:
        bwRDB.setSelected(false);
    }//GEN-LAST:event_fwRDBActionPerformed

    public static Vector print(Vector row, Student student) {
        row = new Vector<>();
        row.add(student.id);
        row.add(student.name);
        row.add(student.dOb);
        row.add(student.address);
        row.add(student.gender);
        row.add(student.grade);
        row.add(String.format("%.2f", student.store_Score.get("Maths")));
        row.add(String.format("%.2f", student.store_Score.get("Chemistry")));
        row.add(String.format("%.2f", student.store_Score.get("Physics")));

        row.add(student.calculateScore());

        return row;
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(88, 135, 178));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(72, 117, 158));
    }

    void resetColor1(JPanel panel) {
        panel.setBackground(new Color(69, 103, 134));
    }

    void resetColor2(JPanel panel) {
        panel.setBackground(new Color(39, 74, 107));
    }

    void resetColor3(JPanel panel) {
        panel.setBackground(new Color(61, 99, 133));
    }

    void resetColor4(JPanel panel) {
        panel.setBackground(new Color(86, 123, 157));
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SandTDAO.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SandTDAO.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SandTDAO.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SandTDAO.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new SandTDAO().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.MyButton ClearBT;
    private javax.swing.JLabel DOBLabel;
    private javax.swing.JLabel DOBTF1;
    private javax.swing.JLabel EIULabel;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private Swing.MyTextField addressTF;
    private Swing.MyTextField addressTF1;
    private Swing.MyButton applyBT;
    private Swing.MyButton applyBT1;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel blankTabPane;
    private javax.swing.JRadioButton bwRDB;
    private javax.swing.JRadioButton bwRDB1;
    private Swing.MyButton changeBT;
    private Swing.MyButton changeBT1;
    private Swing.MyButton changeBT2;
    private javax.swing.JComboBox<String> changeCBB;
    private javax.swing.JLabel changeInforLabel;
    private javax.swing.JLabel changePasswordLabel;
    private javax.swing.JPanel changePasswordPanel;
    private javax.swing.JPanel changePasswordTabPane;
    private javax.swing.JPanel changeTabPane;
    private javax.swing.JLabel chemistryLabel;
    private Swing.MyTextField chemistryTF;
    private Swing.MyButton clearBT1;
    private javax.swing.JLabel conPassLabel;
    private javax.swing.JSeparator crossLineSeparator;
    private javax.swing.JLabel curPassLabel;
    private Swing.MyPassword curpassTF;
    private javax.swing.JComboBox<String> dayCBB;
    private javax.swing.JComboBox<String> dayCBB1;
    private javax.swing.JComboBox<String> dayCBB2;
    private javax.swing.JComboBox<String> degreeCBB1;
    private javax.swing.JLabel degreeLabel;
    private Swing.MyButton deleteBT;
    private javax.swing.JLabel editLabel;
    private javax.swing.JPanel editPanel;
    private javax.swing.JLabel editStudentInforLabel;
    private javax.swing.JPanel editStudentInforPanel;
    private javax.swing.JPanel editStudentInforTabPane;
    private javax.swing.JLabel editTeacherInforLabel;
    private javax.swing.JPanel editTeacherInforPanel;
    private javax.swing.JPanel editTeacherInforTabPane;
    private javax.swing.JRadioButton fwRDB;
    private javax.swing.JRadioButton fwRDB1;
    private javax.swing.JComboBox<String> genderCBB;
    private javax.swing.JComboBox<String> genderCBB1;
    private javax.swing.JComboBox<String> genderCBB2;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel genderLabel1;
    private javax.swing.JLabel genderLabel2;
    private javax.swing.JComboBox<String> gradechangeCBB;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel homeLabel2;
    private javax.swing.JLabel homeLabel5;
    private javax.swing.JPanel homePanel;
    private javax.swing.JPanel homeTabPane;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JLabel imageLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPanel leaveLabel;
    private javax.swing.JLabel mathLabel;
    private Swing.MyTextField mathsTF;
    private javax.swing.JComboBox<String> monthCBB;
    private javax.swing.JComboBox<String> monthCBB1;
    private javax.swing.JComboBox<String> monthCBB2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private Swing.MyTextField nameTF;
    private Swing.MyTextField nameTF1;
    private javax.swing.JLabel newPassLabel;
    private Swing.MyPassword newpassTF;
    private javax.swing.JTextField numberschoTF;
    private javax.swing.JLabel physicLabel;
    private Swing.MyTextField physicsTF;
    private javax.swing.JLabel registerLabel;
    private Swing.MyPassword repassTF;
    private Swing.MyButton restoreBT;
    private Swing.MyButton restoreBT2;
    private Swing.MyButton saveBT1;
    private javax.swing.JTable schoShow;
    private javax.swing.JPanel scholarshipTabPane;
    private javax.swing.JPanel scholershipLabel;
    private javax.swing.JTextField scoreTF;
    private javax.swing.JTextField searchTF1;
    private javax.swing.JComboBox<String> sellectCBB;
    private javax.swing.JPanel sidePanel;
    private javax.swing.JTable studentShow;
    private javax.swing.JTable studentShow1;
    private javax.swing.JTable teacherShow;
    private javax.swing.JTable teacherShow1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel userNameLabel;
    private Swing.MyTextField userchangeTF;
    private javax.swing.JTextField yearTF;
    private javax.swing.JTextField yearTF1;
    private javax.swing.JTextField yearTF2;
    // End of variables declaration//GEN-END:variables
}
