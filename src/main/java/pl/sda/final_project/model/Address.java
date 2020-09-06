package pl.sda.final_project.model;

import pl.sda.final_project.RegistrationDto;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Address {

    private String city;
    private String street;
    @Enumerated(EnumType.STRING)
    private Country country;
    private String zipCode;

    public static Address apply(RegistrationDto registrationDto) {
        Address address = new Address();
        address.city = registrationDto.getCity();
        address.street = registrationDto.getStreet();
        address.country = Country.fromSymbol(registrationDto.getCountry());
        address.zipCode = registrationDto.getZipCode();
        return address;
    }
}
