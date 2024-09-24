package com.example.fifotech.controller;

import com.example.fifotech.entity.FifoServices;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.services.FifoServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class FifoServiceController {

    @Autowired
    private FifoServicesService fifoServicesService;

    // create
    @PostMapping({"/postService"})
    public FifoServices addNewService(@RequestBody FifoServices fifoServices) {
        return fifoServicesService.postNewService(fifoServices);  }

    // show
    @GetMapping({"/getAllServices"})
    public List<FifoServices> getAllServices() {
        return fifoServicesService.getAllServices();
    }

    ;

    // delete
    @DeleteMapping({"/deleteService/{id}"})
    public void deleteService(@PathVariable("id") Integer id) {
        fifoServicesService.deleteFifoService(id);
    }

    //edit
    @GetMapping({"/getServiceById/{id}"})
    public FifoServices getServiceById(@PathVariable("id") Integer id) {

        return fifoServicesService.getFifoServiceById(id);
    } ;
}
