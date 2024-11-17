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

    @GetMapping("/compony/{index}/{compony}")
    public ArrayList<ModelTrackerSystem> display(@PathVariable int index, @PathVariable String Name) {

        for (ModelTrackerSystem model : array) {
            if (model.getComponyName().equals(Name)) {
                System.out.println("Project Name: " + model.getComponyName());
            }
        }
        return array;
    }




}
