package io.muai.mdb.controller.doctor;


import io.muai.mdb.model.doctor.Doctor;
import io.muai.mdb.repos.doctor.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {

    @Autowired
    private DoctorRepository docRepo;

    @GetMapping("findAllDoctros")
    public ResponseEntity<Iterable<Doctor>> findAll() {
        return ResponseEntity.ok(docRepo.findAll());
    }

    @PostMapping(path = "/doctors", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(docRepo.save(doctor), HttpStatus.OK);
    }

}
