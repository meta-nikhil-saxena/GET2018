package birdModule;

public class Peacock extends Bird {
    private String type = "PEACOCK";
    private String sound = "...HOOT...";

    // getter setter START

    @Override
    public int getAnimalCageId() {
        return animalCageId;
    }

    @Override
    public void setAnimalCageId(int animalCageId) {
        this.animalCageId = animalCageId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getSound() {
        return sound;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getCategory() {
        return super.category;
    }

    // getter setter END

    @Override
    public String getInfo() {

        return "Name : " + this.name + " \nType :" + this.type
                + " \nCategory :" + this.category + " \nAge :" + this.age
                + " \nWeight :" + this.weight + " \nSound :" + this.sound;

    }

}
