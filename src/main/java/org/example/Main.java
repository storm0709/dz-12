package org.example;

public class Main {
    public static void main(String[] args) {
        Man joe = new Man("Joe", "Brown", 30, "Brown", false);
        Man john = new Man("John", "Doe", 65, null, true);
        Woman sarah = new Woman("Sarah", "Brown", 30, "Brown", false,"White");
        Woman lisa = new Woman("Lisa", "Yong", 60, null, false, "Yong");
        lisa.registerPartnership();
        System.out.println(joe.getPartner());
        lisa.deregisterPartnership();
        System.out.println(joe.getPartner());
    }
}