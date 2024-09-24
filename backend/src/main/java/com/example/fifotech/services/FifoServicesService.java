package com.example.fifotech.services;

import com.example.fifotech.entity.FifoServices;
import com.example.fifotech.entity.JobPosting;
import com.example.fifotech.repository.FifoServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FifoServicesService {

    @Autowired
    private FifoServicesRepository fifoServicesRepository;

    // create
    public FifoServices postNewService(FifoServices fifoServices) {
        return fifoServicesRepository.save(fifoServices);
    }

    // show from db to website
    public List<FifoServices> getAllServices() {
        return (List<FifoServices>) fifoServicesRepository.findAll();
    }

    // delete by id
    public void deleteFifoService(Integer id) {
        fifoServicesRepository.deleteById(id);
    }

    // edit

    public FifoServices getFifoServiceById(Integer id) {
        return fifoServicesRepository.findById(id).get();
    }

}
