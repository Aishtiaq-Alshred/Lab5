package com.example.lab5trackersystem.Controller;


import com.example.lab5trackersystem.ApiResponse.ApiResponse;
import com.example.lab5trackersystem.Model.ModelTrackerSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/TrackerSystem")
public class ControllerTrackerSystem {

    ArrayList<ModelTrackerSystem> array=new ArrayList<>();

    ModelTrackerSystem Tracker=new ModelTrackerSystem("11116442797","Title","Null","non","Name");

    @GetMapping("/get")
    public ArrayList<ModelTrackerSystem> getTrackerSystem(){
        return array;
    }


    @PostMapping("/add")
    public ApiResponse addTrackerSystem(@RequestBody ModelTrackerSystem model){
        array.add(model);
        return new ApiResponse("add success");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTrackerSystem(@RequestBody ModelTrackerSystem model,@PathVariable int index){

        array.set(index, model);
        return new ApiResponse("update success");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTrackerSystem(@PathVariable int index){
        array.remove(index);

        return new ApiResponse("delete success");
    }

    @PutMapping("/change/{index}")
    public ApiResponse changeStauts(@PathVariable int index) {
        ModelTrackerSystem task = array.get(index);

        if (task.getStatus().equals("not done")) {
            task.setStatus(" done");
            array.set(index, task);
            return new ApiResponse("Task  found ");
        } else {
            task.setStatus("done");
            array.set(index, task);
            return new ApiResponse("Task  found ");

        }
    }

    @GetMapping("/search/{titles}")
    public ApiResponse searchTask(@PathVariable String titles) {

        for (ModelTrackerSystem search : array) {
            if (search.getTitle().equals(titles)) {
                return new ApiResponse(" Task  found  " + search);
            }
        }
        return new ApiResponse(" Task not found ");
    }

   
////هنا الخطأ يبي كل اسماء المشاريع في الشركه هنا بس طلع اسم اول شركه
//    @GetMapping("/compony/{company}")
//    public ArrayList<ModelTrackerSystem> display( @PathVariable String company) {
//
//        for (ModelTrackerSystem model : array) {
//            if (model.getComponyName().equals(company)) {
//                System.out.println("Project Name: " + model.getComponyName());
//            }
//        }
//        return array;
//    }


    @GetMapping("/company/{company}")
    public ApiResponse display(@PathVariable String company) {
        ArrayList<String> projectNames = new ArrayList<>();

        for (ModelTrackerSystem model : array) {
            if (model.getComponyName().equals(company)) {

                projectNames.add(model.getComponyName());
            }
        }

        if (projectNames.isEmpty()) {
            projectNames.add("No projects found for the specified company.");
        }

        return new ApiResponse("All project  one company Name "+projectNames) ;
    }



}
