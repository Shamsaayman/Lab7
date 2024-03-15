package org.example.quiz2.Controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.quiz2.Api.ApiResponse;
import org.example.quiz2.Model.Course;
import org.example.quiz2.Model.Teacher;
import org.example.quiz2.Service.CourseService;
import org.example.quiz2.Service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/course")
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getCourses(){
        ArrayList<Course> course=courseService.getCourses();
        return ResponseEntity.status(200).body(course);
    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@RequestBody @Valid Course course, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        courseService. addCourses(course);
        return ResponseEntity.status(200).body(new ApiResponse("Course added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourses( @PathVariable int id ,@RequestBody @Valid Course course, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(courseService.updateCourse(id,course)) {
            return ResponseEntity.status(200).body(new ApiResponse("Course updated"));
        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("Invalid id"));
        }
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id ){

        if(courseService.deleteCourse(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Course deleted"));

        }
        else{
            return ResponseEntity.status(400).body(new ApiResponse("Invalid id"));
        }

    }

    @GetMapping("getname/{name}")
    public ResponseEntity searchName(@PathVariable String name ){
        if(courseService.searchName(name)==null){
            return ResponseEntity.status(400).body(new ApiResponse("No Courses with this name"));
        }
        else{
            return ResponseEntity.status(200).body(courseService.searchName(name));
        }
    }



    @GetMapping("gettype/{type}")
    public ResponseEntity searchMajor(@PathVariable String type){
        if(courseService.searchType(type)==null){
            return ResponseEntity.status(400).body(new ApiResponse("No Courses with this type"));
        }
        else{
            return ResponseEntity.status(200).body(courseService.searchType(type));
        }
    }

    @GetMapping("isfull/{id}")
    public ResponseEntity isFull(@PathVariable int id ){
        if(courseService.isFull(id)){
            return ResponseEntity.status(400).body(new ApiResponse("Course is full"));
        }
        else{
            return ResponseEntity.status(200).body(new ApiResponse("Course has space"));
        }
    }

    @GetMapping("getonlinename/{name}")
    public ResponseEntity searchOnline(@PathVariable String name){
        if(courseService.searchOnlineName(name)==null){
            return ResponseEntity.status(400).body(new ApiResponse("No Online classes with this name"));
        }
        else{
            return ResponseEntity.status(200).body(courseService.searchOnlineName(name));
        }
    }
}
