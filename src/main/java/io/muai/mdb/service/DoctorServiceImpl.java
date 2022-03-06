package io.muai.mdb.service;

import io.muai.mdb.model.doctor.Doctor;
import io.muai.mdb.model.request.DoctorRequest;
import io.muai.mdb.repos.doctor.DoctorRepository;
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
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository repo;

    @Override
    public ResponseEntity<DoctorRequest> saveDoctorData(DoctorRequest doctorRequest) {

        Doctor doctor = Doctor.builder().build();

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(doctorRequest, doctor);
        log.info("ambulance request payload: {} ", doctor);

        Doctor respAmbulance = repo.save(doctor);

        DoctorRequest resp = DoctorRequest.builder().build();
        modelMapper.map(respAmbulance, resp);
        log.info("ambulance request payload: {} ", resp);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<DoctorRequest>> findAll() {

        List<Doctor> ambulanceList = repo.findAll();

        ModelMapper modelMapper = new ModelMapper();

        List<DoctorRequest> list =
                modelMapper.map(ambulanceList,
                        new TypeToken<List<DoctorRequest>>() {
                        }.getType());

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
