package mainAndManagement;

import interfacesModule.Animal;
import interfacesModule.Zone;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import controlAndAccessModule.Cage;
import controlAndAccessModule.Zoo;
import birdModule.Parrot;
import birdModule.Peacock;
import reptileModule.Crocodile;
import reptileModule.Lizard;
import zoneModule.BirdZone;
import zoneModule.MammalZone;
import zoneModule.ReptileZone;
import mammalModule.Lion;
import mammalModule.Tiger;

//Class for Management of Zoo
public class ZooManagement {
    static Zoo zoo = new Zoo();
    static Scanner sc = new Scanner(System.in);
    static Scanner scanLine = new Scanner(System.in);
    static ZooManagement zoomanage = new ZooManagement();
    Cage cage = new Cage();

    /**
     * Function to display list of Zone with its ID to add Cage in zone
     * 
     * @param index
     */
    public void displayListOfZone(int index) throws AssertionError {

        List<Zone> zoneList = zoo.zoneList;
        if (zoneList.size() == 0) {
            System.out
                    .println("Please enter a zone first !! No ZONE available !! ");
            throw new InputMismatchException(
                    "Please enter a zone first !! No ZONE available !!");
        }
        Iterator<Zone> iterateZone = zoneList.iterator();

        while (iterateZone.hasNext()) {

            Zone zone = zoneList.get(index);

            System.out.println("INDEX : " + index);
            System.out.println("ID : " + zone.getId());
            System.out.println("TYPE OF ZONE : " + zone.getTypeOfZone());
            System.out.println("CAPACITY OF CAGE : " + zone.getZoneCapacity());
            System.out.println("SPARE CAPACITY OF CAGE : "
                    + zone.getSpareCapacity());
            System.out.println("HAS A PARK : " + zone.isParkStatus());
            System.out.println("HAS A CANTEEN : " + zone.isCanteenStatus());

            index++;
            iterateZone.next();

        }
    }

    /**
     * Function to Set attributes of Animal
     * 
     * @param animal
     *            to set its attributes
     */
    public void setAttributes(Animal animal) throws Exception {
        Iterator<Animal> animal1 = zoo.listOfAnimal.iterator();

        System.out.println("Enter Animal Name : ");

        String name = scanLine.nextLine();

        while (animal1.hasNext()) {

            if (name.equalsIgnoreCase(animal1.next().getName())) {
                System.out
                        .println(" !! Animal with this name already exist enter another Animal with Unique name !! ");
                throw new Exception("!! Duplicate !!");
            }

        }
        animal.setName(name);
        System.out.println("Enter Age Of Animal : ");
        int age = sc.nextInt();
        animal.setAge(age);

        System.out.println("Enter Animal weight : ");
        int weight = sc.nextInt();
        animal.setWeight(weight);

    }

    /**
     * Display List of Cage along with their index
     * 
     * @param index
     * @throws NullPointerException
     */
    public void displayCage(int index) throws NullPointerException {
        List<Cage> listOfCage = zoo.listOfCage;
        if (listOfCage.size() == 0) {
            System.out
                    .println("!! There are  No cages please enter cage First !!");
            throw new NullPointerException(
                    "Sorry !! List is Empty !! Add Cages");
        }
        Iterator<Cage> iterator = listOfCage.iterator();

        while (iterator.hasNext()) {
            Cage cage = listOfCage.get(index);

            System.out.println("INDEX : " + index);
            System.out.println("ZoneID : " + cage.getZoneId());
            System.out.println("CageID : " + cage.getId());
            System.out.println("CATEGORY OF CAGE : " + cage.getCategory());
            System.out.println("TYPE OF ANIMAL IN CAGE : " + cage.getType());
            System.out.println("CAPACITY IN CAGE : " + cage.getCapacity());
            System.out.println("SPARE CAPACITY OF CAGE : "
                    + cage.getSparecapacity());

            index++;
            iterator.next();

        }
    }

    /**
     * Helper Function to display information of Animal in List
     */
    public void getInfoAnimal() throws Exception {
        Iterator<Animal> animal = zoo.listOfAnimal.iterator();
        if (zoo.listOfAnimal.size() == 0) {

            System.out.println("!! Animal list is empty !!");

            throw new Exception("!!EMPTY!!");
        }
        while (animal.hasNext()) {

            System.out.println(animal.next().getInfo());
        }
    }

    /**
     * Function to display animal List along with their index
     * 
     * @param index
     */
    public void displayAnimalList(int index) throws Exception {
        List<Animal> listOfAnimal = zoo.listOfAnimal;

        if (listOfAnimal.size() == 0) {
            System.out
                    .println("!! There are  No Animals please enter Animals !!");
            throw new NullPointerException(
                    "Sorry !! List is Empty !! Add Cages");
        }
        System.out.println("INDEX of Animal : " + index);
        this.getInfoAnimal();
        index++;
    }

    /**
     * Function to Add Animal in Cage and Zone
     */
    public void addAnimalLoop() {
        do {
            try {
                System.out.println("1. Add Lion");
                System.out.println("2. Add Lion");

                System.out.println("3. Add Crocodile");
                System.out.println("4. Add Lion");

                System.out.println("5. Add Peacock");
                System.out.println("6. Add Lion");

                System.out.println("7. EXIT");

                System.out.println("Enter your choice : ");
                int choice1 = sc.nextInt();

                switch (choice1) {
                case 1: {
                    Animal animal = new Lion();
                    zoomanage.setAttributes(animal);

                    int id = 0;
                    zoomanage.displayCage(id);

                    System.out.println("Enter Index to ADD Lion : ");
                    int index = sc.nextInt();

                    zoo.addAnimalToCage(index, animal);
                    break;
                }
                case 2: {
                    Animal animal = new Tiger();
                    zoomanage.setAttributes(animal);

                    int id = 0;
                    zoomanage.displayCage(id);

                    System.out.println("Enter Index to ADD Tiger : ");
                    int index = sc.nextInt();

                    zoo.addAnimalToCage(index, animal);

                    break;
                }
                case 3: {
                    Animal animal = new Crocodile();
                    zoomanage.setAttributes(animal);

                    int id = 0;
                    zoomanage.displayCage(id);

                    System.out.println("Enter Index to ADD Crocodile : ");
                    int index = sc.nextInt();

                    zoo.addAnimalToCage(index, animal);
                }
                case 4: {
                    Animal animal = new Lizard();
                    zoomanage.setAttributes(animal);

                    int id = 0;
                    zoomanage.displayCage(id);

                    System.out.println("Enter Index to ADD Lizard : ");
                    int index = sc.nextInt();

                    zoo.addAnimalToCage(index, animal);
                    break;
                }
                case 5: {
                    Animal animal = new Peacock();
                    zoomanage.setAttributes(animal);

                    int id = 0;
                    zoomanage.displayCage(id);

                    System.out.println("Enter Index to ADD Peacock : ");
                    int index = sc.nextInt();

                    zoo.addAnimalToCage(index, animal);
                    break;
                }

                case 6: {
                    Animal animal = new Parrot();
                    zoomanage.setAttributes(animal);

                    int id = 0;
                    zoomanage.displayCage(id);

                    System.out.println("Enter Index to ADD Parrot : ");
                    int index = sc.nextInt();

                    zoo.addAnimalToCage(index, animal);
                    break;
                }
                case 7: {
                    break;
                }

                default:
                    System.out.println("Invalid choice");
                }
                break;
            } catch (Exception e) {
                System.out.println("Please input correct Input !! ");
                sc.nextLine();
            }
        } while (true);
    }

    /**
     * Function to add Zone to zoo
     */
    public void addZoneLoop() {

        try {
            do {

                System.out.println("1. Add Mammal Zone");
                System.out.println("2. Add Reptile Zone");
                System.out.println("3. Add Bird Zone");
                System.out.println("4. EXIT");

                System.out.println("Enter your choice : ");
                int choice2 = sc.nextInt();

                switch (choice2) {
                case 1: {
                    Zone zone = new MammalZone();
                    zoo.addZoneToZoo(zone);
                    break;
                }
                case 2: {
                    Zone zone = new ReptileZone();
                    zoo.addZoneToZoo(zone);
                    break;
                }
                case 3: {
                    Zone zone = new BirdZone();
                    zoo.addZoneToZoo(zone);
                    break;
                }
                case 4: {
                    break;
                }
                default:
                    System.out.println("Invalid choice");
                }
                break;
            } while (true);
        } catch (Exception e) {

            System.out.println("Please input correct Input !! ");
            sc.nextLine();

        }

    }

    public static void main(String args[]) {

        do {
            try {
                System.out.println("1. Add Zone");
                System.out.println("2. Add Cage");
                System.out.println("3. Add Animal");
                System.out.println("4. GET Info of Animals");
                System.out.println("5. Remove Animal");
                System.out.println("6. EXIT");

                System.out.println("Enter your choice : ");
                int choice = sc.nextInt();

                switch (choice) {
                case 1: {
                    zoomanage.addZoneLoop();
                    break;
                }
                case 2: {

                    int index = 0;
                    zoomanage.displayListOfZone(index);

                    int id;
                    System.out
                            .println("Select Index of ZONE in which you want to ADD Cage : ");
                    id = sc.nextInt();

                    zoo.addCageToZone(id);
                    break;

                }
                case 3: {
                    zoomanage.addAnimalLoop();
                    break;
                }
                case 4: {
                    zoomanage.getInfoAnimal();
                    break;

                }

                case 5: {
                    // Here 0 is initial index of Animal List

                    zoomanage.displayAnimalList(0);
                    System.out.println("Enter the index to remove Animal : ");
                    int index = sc.nextInt();
                    zoo.removeAnimalfromCage(index);
                    break;

                }

                case 6: {
                    break;
                }
                default: {
                    System.out.println("Invalid choice");

                }
                }
            } catch (Exception e) {

                System.out.println("Please input correct Input !! ");
                sc.nextLine();

            }
        } while (true);

    }
}
