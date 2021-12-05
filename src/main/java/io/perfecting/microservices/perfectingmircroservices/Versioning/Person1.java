package io.perfecting.microservices.perfectingmircroservices.Versioning;

public class Person1 {
    private Name name;

    public Person1() {
    }

    public Person1(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
