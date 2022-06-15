package com.edocode.oop.hw.books;

public class Publisher {

    private final int id;
    private String publisherName;

    public Publisher() {
        this.id = -1;
        this.publisherName = "undefined";
    }

    public Publisher(int id, String publisherName) {
        this.id = id;
        this.publisherName = publisherName;
    }

    public int getId() {
        return id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (!(o instanceof Publisher)) return false;

        Publisher p = (Publisher) o;

        return (this.getId() == p.getId()) && (this.getPublisherName().equals(p.getPublisherName()));
    }

}
