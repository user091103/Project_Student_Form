package utils;

import java.util.*;
import java.io.*;
import model.*;

import view.Login;
import view.SandTDAO;
import view.*;

public class fileStore {

    static Scanner sc = new Scanner(System.in);

    public static void checkAndCreate(String fileName) {
        File file = new File(fileName);
        File folder = new File(file.getParent());
        if (!folder.exists()) {
            folder.mkdirs();

        } else if (!file.exists()) {
            try {
                file.createNewFile();

            } catch (IOException ex) {

            }

        }
    }

    public static void saveRes(String fileName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fileName));
            for (Map.Entry<Integer, ArrayList<Student>> entry : SandTDAO.restoreS.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    pw.println(entry.getValue().get(i).toString());
                }
            }
            for (Map.Entry<Integer, ArrayList<Teacher>> entry : SandTDAO.restoreT.entrySet()) {
                for (int i = 0; i < entry.getValue().size(); i++) {
                    pw.println(entry.getValue().get(i).toString());
                }
            }
            pw.flush();
        } catch (IOException ex) {
        } finally {
            pw.close();
        }

    }

    public static void getRes(String fileName) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = br.readLine()) != null) {
                int id = Integer.parseInt(line);
                String name = br.readLine();
                String image = br.readLine();
                String dOb = br.readLine();
                String address = br.readLine();
                String gender = br.readLine();
                String username = br.readLine();
                String password = br.readLine();
                String position = br.readLine();
                if (position.equalsIgnoreCase("Student")) {
                    int grade = Integer.parseInt(br.readLine());
                    String s1 = br.readLine();
                    double score1 = Double.parseDouble(br.readLine());
                    String s2 = br.readLine();
                    double score2 = Double.parseDouble(br.readLine());
                    String s3 = br.readLine();
                    double score3 = Double.parseDouble(br.readLine());
                    Student student = new Student(id, name, image, dOb, address, gender, grade,
                            username, password, position);
                    student.store_Score.put(s1, score1);
                    student.store_Score.put(s2, score2);
                    student.store_Score.put(s3, score3);
                    if (!SandTDAO.restoreS.containsKey(id)) {
                        ArrayList<Student> arr = new ArrayList<>();
                        arr.add(student);
                        SandTDAO.restoreS.put(id, arr);
                    } else {
                        SandTDAO.restoreS.get(id).add(student);
                    }
                } else if (position.equalsIgnoreCase("Teacher")) {
                    int classInCharge = Integer.parseInt(br.readLine());
                    String degree = br.readLine();
                    String subject = br.readLine();
                    Teacher teacher = new Teacher(id, name, image, dOb, address, gender, username, password, classInCharge, degree, position, subject);
                    if (!SandTDAO.restoreT.containsKey(id)) {
                        ArrayList<Teacher> arr = new ArrayList<>();
                        arr.add(teacher);
                        SandTDAO.restoreT.put(id, arr);
                    } else {
                        SandTDAO.restoreT.get(id).add(teacher);
                    }
                }

            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public static void saveInfor(String fileName) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(fileName));
            for (Map.Entry<Integer, Student> entry : SandTDAO.storeSInfor.entrySet()) {
                pw.println(entry.getValue().toString());
            }
            for (Map.Entry<Integer, Teacher> entry : SandTDAO.storeTInfor.entrySet()) {
                pw.println(entry.getValue().toString());
            }

            pw.flush();
        } catch (IOException ex) {
        } finally {
            pw.close();
        }
    }

    public static void getInforS(String fileName) {

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));
            String line = "";
            while ((line = br.readLine()) != null) {
                TreeMap<String, Person> temp = new TreeMap<>();
                int id = Integer.parseInt(line);
                String name = br.readLine();
                String image = br.readLine();
                String dOb = br.readLine();
                String address = br.readLine();
                String gender = br.readLine();
                String username = br.readLine();
                String password = br.readLine();
                String position = br.readLine();
                if (position.equalsIgnoreCase("Student")) {
                    int grade = Integer.parseInt(br.readLine());
                    String s1 = br.readLine();
                    double score1 = Double.parseDouble(br.readLine());
                    String s2 = br.readLine();
                    double score2 = Double.parseDouble(br.readLine());
                    String s3 = br.readLine();
                    double score3 = Double.parseDouble(br.readLine());
                    Student student = new Student(id, name, image, dOb, address, gender, grade,
                            username, password, position);
                    student.store_Score.put(s1, score1);
                    student.store_Score.put(s2, score2);
                    student.store_Score.put(s3, score3);
                    temp.put(password, student);
                    SandTDAO.storeSInfor.put(id, student);
                } else if (position.equalsIgnoreCase("Teacher")) {
                    int classInCharge = Integer.parseInt(br.readLine());
                    String degree = br.readLine();
                    String subject = br.readLine();
                    Teacher teacher = new Teacher(id, name, image, dOb, address, gender, username, password, classInCharge, degree, position, subject);
                    temp.put(password, teacher);
                    SandTDAO.storeTInfor.put(id, teacher);
                }
                Login.personAccount.put(username, temp);
            }

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }

    }

    public static void saveAndGet() {
        fileStore.saveInfor("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");
        fileStore.saveRes("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/storeRes.txt");
        SandTDAO.restoreS.clear();
        SandTDAO.restoreT.clear();
        fileStore.getInforS("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/store.txt");
        fileStore.getRes("C:/Users/DELL/Documents/NetBeansProjects/ProjectCSE203/storeRes.txt");
    }

}
