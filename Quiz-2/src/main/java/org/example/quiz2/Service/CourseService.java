package org.example.quiz2.Service;

import org.example.quiz2.Model.Course;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses=new ArrayList<>();

    public ArrayList<Course> getCourses(){

        return courses ;
    }
    public void addCourses(Course course){

        courses.add(course);
    }

    public boolean updateCourse(int id ,  Course course){
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getId()==id){
                courses.set(i,course);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(int id){
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getId()==id){
                courses.remove(i);
                return true;
            }
        }
        return false;
    }

    public Course searchName(String name){
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getName().equalsIgnoreCase(name)){
                return courses.get(i);
            }
        }
        return null;
    }


    public ArrayList<Course> searchType(String type){
        ArrayList<Course>search=new ArrayList<>();
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getType().equalsIgnoreCase(type)){
                search.add(courses.get(i));
                return search;
            }
        }
        return null;
    }

    public boolean isFull(int id){
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getId()==id){
            if(courses.get(i).getCapacity()==100) {
           return true;
}
            }
        }
        return false;
    }

    public ArrayList<Course> searchOnlineName(String name){
        ArrayList<Course>search=new ArrayList<>();
        for (int i = 0; i <courses.size() ; i++) {
            if(courses.get(i).getType().equalsIgnoreCase("Online") && courses.get(i).getName().equalsIgnoreCase(name)){
                search.add(courses.get(i));
                return search;
            }
        }
        return null;
    }

}
