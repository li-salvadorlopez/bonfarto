package com.azteklabs.doctorservice.infrastructure.adapter.model.view;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Objects;

public class DoctorViewModel extends RepresentationModel<DoctorViewModel> {

    String id;
    String firstname;
    String lastname;
    List<AddressViewModel> addresses;
    List<String> phoneNumbers;

    public DoctorViewModel() {
    }

    public DoctorViewModel(Iterable<Link> initialLinks, String id, String firstname, String lastname, List<AddressViewModel> addresses, List<String> phoneNumbers) {
        super(initialLinks);
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<AddressViewModel> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressViewModel> addresses) {
        this.addresses = addresses;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DoctorViewModel that = (DoctorViewModel) o;
        return Objects.equals(id, that.id) && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(addresses, that.addresses) && Objects.equals(phoneNumbers, that.phoneNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, firstname, lastname, addresses, phoneNumbers);
    }

    @Override
    public String toString() {
        return "DoctorViewModel{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", addresses=" + addresses +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
