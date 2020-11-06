package telran.dto;

import telran.validation.constraints.Min;
import telran.validation.constraints.NotEmpty;
import telran.validation.constraints.NotNull;

public class Address {
    private static final int MIN_BUILDING_AND_APARTMENT_NUMBER = 1;

    @NotEmpty(message = "City can't be empty")
    @NotNull(message = "City can't be null")
    private String city;

    @NotEmpty(message = "Street can't be empty")
    @NotNull(message = "Street can't be null")
    private String street;

    @Min(value = MIN_BUILDING_AND_APARTMENT_NUMBER, message = "Building number can't be less than " + MIN_BUILDING_AND_APARTMENT_NUMBER)
    private int building;

    @Min(value = MIN_BUILDING_AND_APARTMENT_NUMBER,  message = "Apartment number can't be less than " + MIN_BUILDING_AND_APARTMENT_NUMBER)
    private int apartment;


    public Address(String city, String street, int building, int apartment) {
        super();
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building=" + building +
                ", apartment=" + apartment +
                '}';
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getBuilding() {
        return building;
    }

    public int getApartment() {
        return apartment;
    }
}
