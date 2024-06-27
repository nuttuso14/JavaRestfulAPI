package org.matt.restmongo.restfulmongo;

import org.springframework.data.annotation.Id;

public class Footballer {
    @Id
    private String id;  // Change from Long to String for MongoDB compatibility

    private int shirtNumber;
    private String firstName;
    private String lastName;
    private String position;
    private int price;

    public Footballer() {
    }

    public Footballer(int shirtNumber, String firstName, String lastName, String position, int price) {
        this.shirtNumber = shirtNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(int shirtNumber) {
        this.shirtNumber = shirtNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Footballer{" +
                "id='" + id + '\'' +
                ", shirtNumber=" + shirtNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", price=" + price +
                '}';
    }
}
