package com.example.fifotech.services;

import com.example.fifotech.entity.GlobalBPO;
import com.example.fifotech.repository.GlobalBpoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlobalBPOService {


    @Autowired
    private GlobalBpoRepository globalBpoRepository;


    //    create
    public GlobalBPO createNewGlobalBPO(GlobalBPO globalBPO) {
        return globalBpoRepository.save(globalBPO);
    }

    // show from db to website
    public List<GlobalBPO> getAllGlobalBPO() {
        return (List<GlobalBPO>) globalBpoRepository.findAll();

    }


    // delete by id
    public void deleteGlobalBPO(Integer id) {
        globalBpoRepository.deleteById(id);
    }


    // edit
    public GlobalBPO getGlobalBPOById(Integer id) {
        return globalBpoRepository.findById(id).get();
    }

    ;
}
