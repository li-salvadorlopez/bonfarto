package com.azteklabs.doctorservice.infrastructure.adapter.rest.hateoas;

import com.azteklabs.doctorservice.domain.model.Doctor;
import com.azteklabs.doctorservice.infrastructure.adapter.model.view.DoctorViewModel;
import com.azteklabs.doctorservice.infrastructure.adapter.rest.DoctorsController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DoctorViewModelAssembler extends RepresentationModelAssemblerSupport<Doctor, DoctorViewModel> {

    public DoctorViewModelAssembler() {
        super(DoctorsController.class, DoctorViewModel.class);
    }

    @Override
    public DoctorViewModel toModel(Doctor entity) {
        DoctorViewModel doctorViewModel = instantiateModel(entity);
        doctorViewModel.add(linkTo(methodOn(DoctorsController.class).retrieveDoctor(entity.getDoctorIdentifier().id())).withSelfRel());
        doctorViewModel.setId(entity.getDoctorIdentifier().id());
        doctorViewModel.setFirstname(entity.getName().getFirstname());
        doctorViewModel.setLastname(entity.getName().getLastname());
        return doctorViewModel;
    }
}
