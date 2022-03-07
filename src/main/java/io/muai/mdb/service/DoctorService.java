package io.muai.mdb.service;

import io.muai.mdb.payload.DoctorRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DoctorService {

    ResponseEntity<DoctorRequest> saveDoctorData(DoctorRequest doctorRequest);

    ResponseEntity<List<DoctorRequest>> findAll();

}
