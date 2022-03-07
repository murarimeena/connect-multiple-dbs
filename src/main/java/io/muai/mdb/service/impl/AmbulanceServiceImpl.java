package io.muai.mdb.service.impl;

import io.muai.mdb.model.clinic.Ambulance;
import io.muai.mdb.payload.AmbulanceRequest;
import io.muai.mdb.repos.clinic.AmbulanceRepository;
import io.muai.mdb.service.AmbulanceService;
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
public class AmbulanceServiceImpl implements AmbulanceService {

    @Autowired
    private AmbulanceRepository repo;

    @Override
    public ResponseEntity<AmbulanceRequest> saveAmbulanceData(AmbulanceRequest ambulanceRequest) {

        Ambulance ambulance = Ambulance.builder().build();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(ambulanceRequest, ambulance);
        log.info("ambulance request payload: {} ", ambulance);

        Ambulance respAmbulance = repo.save(ambulance);

        AmbulanceRequest resp = AmbulanceRequest.builder().build();
        modelMapper.map(respAmbulance, resp);
        log.info("ambulance request payload: {} ", resp);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AmbulanceRequest>> findAll() {
        List<Ambulance> ambulanceList = repo.findAll();

        ModelMapper modelMapper = new ModelMapper();

        List<AmbulanceRequest> list =
                modelMapper.map(ambulanceList,
                        new TypeToken<List<AmbulanceRequest>>() {
                        }.getType());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
