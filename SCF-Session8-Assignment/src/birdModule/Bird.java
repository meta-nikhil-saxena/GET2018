package birdModule;

import interfacesModule.Animal;

/**
 * 
 * Class for bird
 * 
 */
public class Bird implements Animal {

    protected String name;
    protected int weight;
    protected int age;
    protected final String category = "Bird";
    protected int animalCageId;

    // getter setter START

    public String getName() {
        return name;
    }

    public int getAnimalCageId() {
        return animalCageId;
    }

    public void setAnimalCageId(int animalCageId) {
        this.animalCageId = animalCageId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public String getInfo() {

        return "Name : " + this.name + " \nCategory :" + this.category
                + " \nAge :" + this.age + " \nWeight :" + this.weight;

    }

    public String getType() {

        return this.category;
    }
    // getter setter END

}
