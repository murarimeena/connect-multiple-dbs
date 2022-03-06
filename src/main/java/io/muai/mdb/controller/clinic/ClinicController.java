package io.muai.mdb.controller.clinic;

import io.muai.mdb.model.request.ClinicRequest;
import io.muai.mdb.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClinicController {

    @Autowired
    private ClinicService repo;

    @GetMapping("findAllClinics")
    public ResponseEntity<List<ClinicRequest>> findAll() {
        return repo.findAll();
    }

    @PostMapping(path = "/clinics", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ClinicRequest> add(@RequestBody ClinicRequest clinicRequest) {
        return repo.saveClinicData(clinicRequest);
    }
}
