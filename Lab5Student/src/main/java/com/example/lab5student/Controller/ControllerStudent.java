package com.example.lab5student.Controller;

import com.example.lab5student.ApiResponse.ApiResponse;
import com.example.lab5student.Model.StudentModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
public class ControllerStudent {


    ArrayList<StudentModel> array = new ArrayList<>();
    StudentModel student = new StudentModel("1116442797", "Aishtiaq", 22, "B", 3.75);



    @GetMapping("/get")
    public ArrayList<StudentModel> getStudent() {

        return array;
    }

    @PostMapping("/add")
    public ApiResponse addStudent(@RequestBody StudentModel model) {
        array.add(model);

        return new ApiResponse(("add success"));
    }


    @PutMapping("/update/{index}")
    public ApiResponse updateStudent(@RequestBody StudentModel model, @PathVariable int index) {
        array.set(index, model);
        return new ApiResponse(("update success"));
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteStudent(@PathVariable int index) {
        array.remove(index);
        return new ApiResponse(("delete success"));
    }


    @GetMapping("/honors/{index}")
    public ApiResponse getHonors(@PathVariable int index) {
        if (index >= 0 && index < array.size()) {
            StudentModel student = array.get(index);

            if (student.getGPA() >= 4.75) {
                return new ApiResponse("First Honors "+array) ;
            } else if (student.getGPA() >= 4.25) {
                return new ApiResponse("Second Honors "+array) ;
            }
        }
        return new ApiResponse(  "No Honors "+array) ;
    }






}














