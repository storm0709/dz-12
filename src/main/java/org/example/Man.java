package org.example;

public class Man extends Person{
    public Man(String firstName, String lastName, int age, String partner, boolean isDevorced){
        super(firstName, lastName, age, partner, isDevorced);
    }

    @Override
    public boolean isRetired() {
        if (getAge() >=65){
            System.out.println("Already retired");
            return true;
        }
        System.out.println("Not retired yet");
        return false;
    }
    public void registerPartnership(String lastName){
        setPartner(getLastName());
        System.out.println("This man is married to "+getPartner());
    }

    public void deregisterPartnership(){
        if (getPartner() == null){
            return;
        }
        setPartner(null);
        setIsDevorced(true);
        System.out.println("Partner is "+getPartner()+" isDivorced status is "+getIsDevorced());
    }
}
