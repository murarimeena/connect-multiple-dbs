package io.muai.mdb.controller.doctor;


import io.muai.mdb.payload.DoctorRequest;
import io.muai.mdb.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService repository;

    @GetMapping("findAllDoctros")
    public ResponseEntity<List<DoctorRequest>> findAll() {
        return repository.findAll();
    }

    @PostMapping(path = "/doctors", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<DoctorRequest> add(@RequestBody DoctorRequest doctor) {
        return repository.saveDoctorData(doctor);
    }

}
