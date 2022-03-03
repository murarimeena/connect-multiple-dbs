package io.muai.mdb.controller.clinic;

import io.muai.mdb.model.clinic.Clinic;
import io.muai.mdb.repos.clinic.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClinicController {

    @Autowired
    private ClinicRepository repo;

    @GetMapping("findAllClinics")
    public ResponseEntity<Iterable<Clinic>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping(path = "/clinics", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Clinic> add(@RequestBody Clinic clinic) {
        return new ResponseEntity<>(repo.save(clinic), HttpStatus.OK);
    }
}
