package io.muai.mdb.service;

import io.muai.mdb.model.request.ClinicRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClinicService {

    ResponseEntity<ClinicRequest> saveClinicData(ClinicRequest clinicRequest);

    ResponseEntity<List<ClinicRequest>> findAll();

}
