package com.azteklabs.doctorservice.infrastructure.adapter.rest;

import com.azteklabs.doctorservice.domain.model.Doctor;
import com.azteklabs.doctorservice.domain.model.DoctorIdentifier;
import com.azteklabs.doctorservice.domain.model.DoctorsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorsController.class);

    private DoctorsService doctorsService;

    public DoctorsController(DoctorsService doctorsService) {
        this.doctorsService = doctorsService;
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<Doctor> retrieveDoctor(@PathVariable String doctorId){
        Doctor doctor = doctorsService.retrieveDoctor(new DoctorIdentifier(doctorId));
        return new ResponseEntity<>(doctor, HttpStatus.OK);
    }
}
