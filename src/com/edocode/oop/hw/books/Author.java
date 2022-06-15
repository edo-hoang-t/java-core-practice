package com.edocode.oop.hw.books;

public class Author {

    private final int id;
    private String firstName;
    private String lastName;

    public Author() {
        this.id = -1;
        this.firstName = "undefined";
        this.lastName = "undefined";
    }

    public Author(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Author)) return false;
        Author other = (Author) o;
        return this.firstName.equals(other.getFirstName()) && (id == other.id) && this.lastName.equals(other.getLastName());
    }

}
