package reptileModule;

/**
 * Class for Lizard
 * 
 */
public class Lizard extends Reptile {

    private String sound = "...chirp...";
    private String type = "LIZARD";

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
        return super.getCategory();
    }

    // getter setter END

    @Override
    public String getInfo() {

        return "Name : " + this.getName() + " \nType :" + this.getType()
                + " \nCategory :" + this.getCategory() + " \nAge :"
                + this.getAge() + " \nWeight :" + this.getWeight()
                + " \nSound :" + this.getSound();

    }

}
