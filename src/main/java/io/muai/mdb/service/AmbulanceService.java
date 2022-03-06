package io.muai.mdb.service;

import io.muai.mdb.model.request.AmbulanceRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AmbulanceService {
    ResponseEntity<AmbulanceRequest> saveAmbulanceData(AmbulanceRequest ambulanceRequest);

    ResponseEntity<List<AmbulanceRequest>> findAll();
}
