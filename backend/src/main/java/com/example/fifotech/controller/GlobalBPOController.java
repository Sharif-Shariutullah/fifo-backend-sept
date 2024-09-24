package com.example.fifotech.controller;

import com.example.fifotech.entity.GlobalBPO;
import com.example.fifotech.services.GlobalBPOService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class GlobalBPOController {


    @Autowired
    private GlobalBPOService globalBPOService;


    // create
    @PostMapping({"/postNewGlobalBPO"})
    public GlobalBPO addNewGlobalBPO(@RequestBody GlobalBPO globalBPO) {
        return globalBPOService.createNewGlobalBPO(globalBPO);

    }

    // show
    @GetMapping({"/getAllGlobalBPO"})
    public List<GlobalBPO> getAllGlobalBPO() {
        return globalBPOService.getAllGlobalBPO();
    }

    ;

    // delete
    @DeleteMapping({"/deleteGlobalBPO/{id}"})
    public void deleteGlobalBPO(@PathVariable("id") Integer id) {
        globalBPOService.deleteGlobalBPO(id);
    }

    //edit
    @GetMapping({"/getGlobalBPOById/{id}"})
    public GlobalBPO getGlobalBPOById(@PathVariable("id") Integer id) {
        return globalBPOService.getGlobalBPOById(id);
    }

    ;

}
