package io.muai.mdb.service.impl;

import io.muai.mdb.model.clinic.Clinic;
import io.muai.mdb.payload.ClinicRequest;
import io.muai.mdb.repos.clinic.ClinicRepository;
import io.muai.mdb.service.ClinicService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository repo;

    @Override
    public ResponseEntity<ClinicRequest> saveClinicData(ClinicRequest clinicRequest) {
        Clinic clinic = Clinic.builder().build();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(clinicRequest, clinic);
        log.info("clinic request payload: {} ", clinic);

        Clinic respClinic = repo.save(clinic);

        ClinicRequest resp = ClinicRequest.builder().build();
        modelMapper.map(respClinic, resp);
        log.info("clinic request payload: {} ", resp);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ClinicRequest>> findAll() {

        List<Clinic> clinicList = repo.findAll();

        ModelMapper modelMapper = new ModelMapper();

        List<ClinicRequest> list =
                modelMapper.map(clinicList,
                        new TypeToken<List<ClinicRequest>>() {
                        }.getType());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
