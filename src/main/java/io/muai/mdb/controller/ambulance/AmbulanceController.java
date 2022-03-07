package io.muai.mdb.controller.ambulance;

import io.muai.mdb.payload.AmbulanceRequest;
import io.muai.mdb.service.AmbulanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AmbulanceController {

    @Autowired
    private AmbulanceService ambulanceService;

    @GetMapping("findAllAmbulance")
    public ResponseEntity<List<AmbulanceRequest>> findAll() {
        return ambulanceService.findAll();
    }

    @PostMapping(path = "/ambulances", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AmbulanceRequest> add(@RequestBody AmbulanceRequest ambulanceRequest) {
        return ambulanceService.saveAmbulanceData(ambulanceRequest);
    }
}
