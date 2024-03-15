package org.example.quiz2.Service;

import org.example.quiz2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {
    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public boolean updateStudent(String id, Student student) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equalsIgnoreCase(id)) {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchName(String name) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                return students.get(i);
            }
        }
        return null;
    }


    public ArrayList<Student> searchMajor(String major) {
        ArrayList<Student> search = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getMajor().equalsIgnoreCase(major)) {
                search.add(students.get(i));
                return search;
            }
        }
        return null;
    }


    public String getBatch(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().startsWith("24")) {
                return "Batch of 2024";
            } else if (students.get(i).getId().startsWith("23")) {
                return "Batch of 2023";
            } else if (students.get(i).getId().startsWith("22")) {
                return "Batch of 2022";
            } else if (students.get(i).getId().startsWith("21")) {
                return "Batch of 2021";
            } else if (students.get(i).getId().startsWith("20")) {
                return "Batch of 2020";
            }
        }
        return null;
    }

    public boolean isGraduate(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().startsWith("20")) {
return true;
            }
        }
        return false;
    }
}
