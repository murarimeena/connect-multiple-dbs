package io.muai.mdb.service;

import io.muai.mdb.model.clinic.Ambulance;
import io.muai.mdb.model.request.AmbulanceRequest;
import io.muai.mdb.repos.clinic.AmbulanceRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

//    @Override
//    public ResponseEntity<List<AmbulanceRequest>> findAll() {
//        List<Ambulance> ambulanceList = repo.findAll();
//
//        List<AmbulanceRequest> resp = new ArrayList<>();
//        Type type = new TypeToken<List<AmbulanceRequest>>() {
//        }.getType();
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.map(ambulanceList, new TypeToken<List<AmbulanceRequest>>() {
//        }.getType());
//
//        return resp;
//    }
}
