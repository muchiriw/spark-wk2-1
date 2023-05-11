package models;

public class Hero {
    private String fullName;
    private String specialPower;
    private String weakness;


    public String getFullName() {
        return fullName;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }



    public Hero(String squadName, String fullName, String specialPower, String weakness){
        this.fullName = fullName;
        this.specialPower = specialPower;
        this.weakness = weakness;
        System.out.println(weakness);

    }}

