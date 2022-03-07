package io.muai.mdb.service;

import io.muai.mdb.payload.AmbulanceRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AmbulanceService {
    ResponseEntity<AmbulanceRequest> saveAmbulanceData(AmbulanceRequest ambulanceRequest);

    ResponseEntity<List<AmbulanceRequest>> findAll();
}
