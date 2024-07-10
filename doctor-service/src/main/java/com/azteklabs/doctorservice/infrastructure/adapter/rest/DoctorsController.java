package com.azteklabs.doctorservice.infrastructure.adapter.rest;

import com.azteklabs.doctorservice.domain.model.*;
import com.azteklabs.doctorservice.infrastructure.adapter.mapper.DoctorMapper;
import com.azteklabs.doctorservice.infrastructure.adapter.model.view.DoctorViewModel;
import com.azteklabs.doctorservice.infrastructure.adapter.rest.hateoas.DoctorViewModelAssembler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/doctors")
public class DoctorsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorsController.class);

    private final DoctorsService doctorsService;
    private final DoctorViewModelAssembler doctorViewModelAssembler;
    private final PagedResourcesAssembler<Doctor> pagedResourcesAssembler;


    public DoctorsController(DoctorsService doctorsService, DoctorViewModelAssembler doctorViewModelAssembler, PagedResourcesAssembler<Doctor> pagedResourcesAssembler) {
        this.doctorsService = doctorsService;
        this.doctorViewModelAssembler = doctorViewModelAssembler;
        this.pagedResourcesAssembler = pagedResourcesAssembler;
    }

    @GetMapping("/{doctorId}")
    public EntityModel<DoctorViewModel> retrieveDoctor(@PathVariable String doctorId) {
        Doctor doctor = doctorsService.retrieveDoctor(new DoctorIdentifier(doctorId));
        DoctorViewModel doctorViewModel = DoctorMapper.INSTANCE.doctorToViewModel(doctor);
        return EntityModel.of(doctorViewModel,
                linkTo(methodOn(DoctorsController.class).retrieveDoctor(doctorId)).withSelfRel());
    }

    @GetMapping("")
    public PagedModel<DoctorViewModel> retrieveDoctors(Pageable pageable) {
        Page<Doctor> doctors = doctorsService.retrieveDoctors(new PageRequest(pageable.getPageNumber(), pageable.getPageSize()));
        org.springframework.data.domain.Page<Doctor> doctorsData = new PageImpl<>(doctors.getContent());
        PagedModel<DoctorViewModel> pagedModel = pagedResourcesAssembler.toModel(doctorsData, doctorViewModelAssembler);
        return pagedModel;
    }
}