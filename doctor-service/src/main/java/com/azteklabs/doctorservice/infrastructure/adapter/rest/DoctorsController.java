package com.azteklabs.doctorservice.infrastructure.adapter.rest;

import com.azteklabs.doctorservice.domain.model.*;
import com.azteklabs.doctorservice.infrastructure.adapter.mapper.DoctorMapper;
import com.azteklabs.doctorservice.infrastructure.adapter.model.view.DoctorViewModel;
import com.azteklabs.doctorservice.infrastructure.adapter.rest.hateoas.DoctorViewModelAssembler;
import org.hibernate.validator.constraints.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/doctors")
@Validated
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

    /**
     * Retrieves all doctors paginated
     *
     * @param pageable
     * @return a collection of doctor's representation
     */
    @GetMapping(value = "", name = "retrieve doctors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PagedModel<DoctorViewModel> retrieveDoctors(Pageable pageable) {
        Page<Doctor> doctors = doctorsService.retrieveDoctors(new PageRequest(pageable.getPageNumber(), pageable.getPageSize()));
        org.springframework.data.domain.Page<Doctor> doctorsData = new PageImpl<>(doctors.getContent());
        PagedModel<DoctorViewModel> pagedModel = pagedResourcesAssembler.toModel(doctorsData, doctorViewModelAssembler);
        return pagedModel;
    }

    /**
     * Retrieves a Doctor by its ID
     *
     * @param doctorId
     * @return a doctor's representation
     */
    @GetMapping(value = "/{doctorId}", name = "retrieve doctors", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EntityModel<DoctorViewModel> retrieveDoctor(@PathVariable @UUID(message = "doctorId must be a valid UUID") String doctorId) {
        Doctor doctor = doctorsService.retrieveDoctor(new DoctorIdentifier(doctorId));
        DoctorViewModel doctorViewModel = DoctorMapper.INSTANCE.doctorToViewModel(doctor);
        return EntityModel.of(doctorViewModel,
                linkTo(methodOn(DoctorsController.class).retrieveDoctor(doctorId)).withSelfRel());
    }

}
