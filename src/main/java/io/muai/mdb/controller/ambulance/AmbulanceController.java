package io.muai.mdb.controller.ambulance;

import io.muai.mdb.model.clinic.Ambulance;
import io.muai.mdb.repos.clinic.AmbulanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AmbulanceController {

    @Autowired
    private AmbulanceRepository repo;

    @GetMapping("findAllAmbulance")
    public ResponseEntity<Iterable<Ambulance>> findAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    @PostMapping(path = "/ambulances", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Ambulance> add(@RequestBody Ambulance clinic) {
        return new ResponseEntity<>(repo.save(clinic), HttpStatus.OK);
    }
}
