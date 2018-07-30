package mammalModule;

//Class for Tiger
public class Tiger extends Mammals {
    private String type = "TIGER";
    private String sound = "...GROWL...GROWL...ROAR...";

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

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public String getInfo() {

        return "Name : " + this.getName() + "\nAnimalCageID : "
                + this.getAnimalCageId() + " \nType :" + this.getType()
                + " \nCategory :" + this.getCategory() + " \nAge :"
                + this.getAge() + " \nWeight :" + this.getWeight()
                + " \nSound :" + this.getSound();

    }
}
