package com.example.lab5eventsystem.Controller;


import com.example.lab5eventsystem.ApiResponse.ApiResponse;
import com.example.lab5eventsystem.Model.ModelEventSystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/eventSystem")
public class ControllerEventSystem {


    ArrayList<ModelEventSystem>array=new ArrayList<>();

    //باقي اري المودل

    @GetMapping("/get")
    public ArrayList<ModelEventSystem> getEventSystem(){
        return array;
    }

    @PostMapping("/add")
    public ApiResponse addEventSystem(@RequestBody ModelEventSystem model){
        array.add(model);

        return new ApiResponse("add success");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateEventSystem(@PathVariable int index,@RequestBody ModelEventSystem model){
        array.set(index, model);
        return new ApiResponse("update success");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteEventSystem(@PathVariable int index){
        array.remove(index);
        return new ApiResponse("delete success");
    }


    @GetMapping("/search/{ID}")
    public ApiResponse searchTask(@PathVariable String ID) {

        for (ModelEventSystem search : array) {
            if (search.getID().equals(ID)) {
                return new ApiResponse(" ID  found  " + search);
            }
        }
        return new ApiResponse(" ID not found ");
    }


    //بافي مطلوب

    @PutMapping("/change/{index}/{Capacity}")
    public ArrayList<ModelEventSystem> changeStauts(@PathVariable int index,@PathVariable String Capacitys) {
        ModelEventSystem change = array.get(index);
        change.setCapacity(Capacitys);
        return array;
    }
}
