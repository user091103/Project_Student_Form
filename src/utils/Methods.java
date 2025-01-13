package utils;

import java.util.ArrayList;
import java.util.PriorityQueue;
import model.Student;
import model.Teacher;
import view.SandTDAO;

public class Methods {

    public static boolean checkLandN(int choice, String check) {

        if (choice == 0) {    //check numbers;
            for (int i = 0; i < check.length(); i++) {
                if (check.charAt(i) >= '0' && check.charAt(i) <= '9') {
                    return false;

                }
            }
        } else {  // check letters;
            int count = 0;
            for (int i = 0; i < check.length(); i++) {
                if (check.charAt(i) == '.') {
                    count++;
                }
            }
            if (count >= 2) {
                return false;
            } else {
                for (int i = 0; i < check.length(); i++) {
                    if (!(check.charAt(i) >= '0' && check.charAt(i) <= '9') && check.charAt(i) != '.') {
                        return false;

                    }
                }
            }

        }
        return true;
    }

    public static void nameArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher;
        if (choice == 0) {
            student = new PriorityQueue<>((s1, s2) -> {
                String[] arr1 = s1.name.toLowerCase().split(" ");
                String[] arr2 = s2.name.toLowerCase().split(" ");
                int compare = arr1[arr1.length - 1].compareTo(arr2[arr2.length - 1]); // compareTo dùng để compare giữa 2 String
                if (compare == 0) {
                    int min = Math.min(arr1.length - 1, arr2.length - 1);
                    for (int i = 0; i < min && compare == 0; i++) {
                        compare = arr1[i].compareTo(arr2[i]);
                    }
                }
                if (compare == 0) {
                    compare = arr1.length - arr2.length;
                }
                return compare;
            });
            teacher = new PriorityQueue<>((s1, s2) -> {
                String[] arr1 = s1.name.toLowerCase().split(" ");
                String[] arr2 = s2.name.toLowerCase().split(" ");
                int compare = arr1[arr1.length - 1].compareTo(arr2[arr2.length - 1]);
                if (compare == 0) {
                    int min = Math.min(arr1.length - 1, arr2.length - 1);
                    for (int i = 0; i < min && compare == 0; i++) {
                        compare = arr1[i].compareTo(arr2[i]);
                    }
                }
                if (compare == 0) {
                    compare = arr1.length - arr2.length;
                }
                return compare;
            });
        } else { //choice = 1
            student = new PriorityQueue<>((s1, s2) -> {
                String[] arr1 = s1.name.toLowerCase().split(" ");
                String[] arr2 = s2.name.toLowerCase().split(" ");
                int compare = arr2[arr2.length - 1].compareTo(arr1[arr1.length - 1]);
                if (compare == 0) {
                    int min = Math.min(arr1.length - 1, arr2.length - 1);
                    for (int i = 0; i < min && compare == 0; i++) {
                        compare = arr2[i].compareTo(arr1[i]);
                    }
                }
                if (compare == 0) {
                    compare = arr2.length - arr1.length;
                }
                return compare;
            });
            teacher = new PriorityQueue<>((s1, s2) -> {
                String[] arr1 = s1.name.toLowerCase().split(" ");
                String[] arr2 = s2.name.toLowerCase().split(" ");
                int compare = arr2[arr2.length - 1].compareTo(arr1[arr1.length - 1]);
                if (compare == 0) {
                    int min = Math.min(arr1.length - 1, arr2.length - 1);
                    for (int i = 0; i < min && compare == 0; i++) {
                        compare = arr2[i].compareTo(arr1[i]);
                    }
                }
                if (compare == 0) {
                    compare = arr2.length - arr1.length;
                }
                return compare;
            });
        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;

    }

    public static void totalScoreArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher = new PriorityQueue<>((t1, t2) -> {
            int compare = t1.id - t2.id;
            return compare;
        });
        if (choice == 0) {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = p1.calculateScore().compareTo(p2.calculateScore());
                return compare;
            });

        } else {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = p2.calculateScore().compareTo(p1.calculateScore());
                return compare;
            });

        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;
    }

    public static void psScoreArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher = new PriorityQueue<>((t1, t2) -> {
            int compare = t1.id - t2.id;
            return compare;
        });
        if (choice == 0) {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = Double.compare(p1.store_Score.get("Physics"), p2.store_Score.get("Physics"));
                return compare;
            });

        } else {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = Double.compare(p2.store_Score.get("Physics"), p1.store_Score.get("Physics"));
                return compare;
            });

        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;
    }

    public static void cmtScoreArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher = new PriorityQueue<>((t1, t2) -> {
            int compare = t1.id - t2.id;
            return compare;
        });
        if (choice == 0) {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = Double.compare(p1.store_Score.get("Chemistry"), p2.store_Score.get("Chemistry"));
                return compare;
            });

        } else {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = Double.compare(p2.store_Score.get("Chemistry"), p1.store_Score.get("Chemistry"));
                return compare;
            });

        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;
    }

    public static void mathsScoreArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher = new PriorityQueue<>((t1, t2) -> {
            int compare = t1.id - t2.id;
            return compare;
        });
        if (choice == 0) {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = Double.compare(p1.store_Score.get("Maths"), p2.store_Score.get("Maths"));
                return compare;
            });

        } else {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = Double.compare(p2.store_Score.get("Maths"), p1.store_Score.get("Maths"));
                return compare;
            });

        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;
    }

    public static void dobArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher;
        if (choice == 0) {
            student = new PriorityQueue<>((p1, p2) -> {
                String[] arr_dOb1 = p1.dOb.split("/");
                String[] arr_dOb2 = p2.dOb.split("/");
                int compare = Integer.parseInt(arr_dOb1[2]) - Integer.parseInt(arr_dOb2[2]);
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb1[1]) - Integer.parseInt(arr_dOb2[1]);
                }
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb1[0]) - Integer.parseInt(arr_dOb2[0]);
                }
                return compare;
            });
            teacher = new PriorityQueue<>((p1, p2) -> {
                String[] arr_dOb1 = p1.dOb.split("/");
                String[] arr_dOb2 = p2.dOb.split("/");
                int compare = Integer.parseInt(arr_dOb1[2]) - Integer.parseInt(arr_dOb2[2]);
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb1[1]) - Integer.parseInt(arr_dOb2[1]);
                }
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb1[0]) - Integer.parseInt(arr_dOb2[0]);
                }
                return compare;
            });
        } else {
            student = new PriorityQueue<>((p1, p2) -> {
                String[] arr_dOb1 = p1.dOb.split("/");
                String[] arr_dOb2 = p2.dOb.split("/");
                int compare = Integer.parseInt(arr_dOb2[2]) - Integer.parseInt(arr_dOb1[2]);
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb2[1]) - Integer.parseInt(arr_dOb1[1]);
                }
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb2[0]) - Integer.parseInt(arr_dOb1[0]);
                }
                return compare;
            });
            teacher = new PriorityQueue<>((p1, p2) -> {
                String[] arr_dOb1 = p1.dOb.split("/");
                String[] arr_dOb2 = p2.dOb.split("/");
                int compare = Integer.parseInt(arr_dOb2[2]) - Integer.parseInt(arr_dOb1[2]);
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb2[1]) - Integer.parseInt(arr_dOb1[1]);
                }
                if (compare == 0) {
                    compare = Integer.parseInt(arr_dOb2[0]) - Integer.parseInt(arr_dOb1[0]);
                }
                return compare;
            });
        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;
    }

    public static void idArrangement(int choice) {
        PriorityQueue<Student> student;
        PriorityQueue<Teacher> teacher;
        if (choice == 0) {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = p1.id - p2.id;
                return compare;
            });
            teacher = new PriorityQueue<>((p1, p2) -> {
                int compare = p1.id - p2.id;
                return compare;
            });
        } else {
            student = new PriorityQueue<>((p1, p2) -> {
                int compare = p2.id - p1.id;
                return compare;
            });
            teacher = new PriorityQueue<>((p1, p2) -> {
                int compare = p2.id - p1.id;
                return compare;
            });
        }
        SandTDAO.pqS = student;
        SandTDAO.pqT = teacher;
    }
}
