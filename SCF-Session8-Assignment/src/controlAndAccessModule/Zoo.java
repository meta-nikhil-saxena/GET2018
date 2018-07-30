package controlAndAccessModule;

import interfacesModule.Animal;
import interfacesModule.Zone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import zoneModule.BirdZone;
import zoneModule.MammalZone;
import zoneModule.ReptileZone;

//Class for Zoo
public class Zoo {

    public List<Zone> zoneList = new ArrayList<Zone>();
    public List<Cage> listOfCage = new ArrayList<Cage>();
    public List<Animal> listOfAnimal = new ArrayList<Animal>();

    Scanner sc = new Scanner(System.in);

    /**
     * Function to add ZONE to zoo
     * 
     * @param zone
     *            is the particular type of Zone
     */

    static int zoneId = 1;

    public void addZoneToZoo(Zone zone) {

        zone.setId(zoneId);
        System.out.println("ENTER CAPACITY OF CAGE : ");
        int capacity = sc.nextInt();

        zone.setZoneCapacity(capacity);
        zone.setSpareCapacity(capacity);

        System.out.println("ENTER STATUS OF CANTEEN : ");
        zone.setCanteenStatus(sc.nextBoolean());

        System.out.println("ENTER STATUS OF PARK : ");
        zone.setParkStatus(sc.nextBoolean());

        zoneList.add(zone);
        zoneId++;
        System.out.println("!! Zone Added !!");
    }

    /**
     * Function to add CAGE to a particular zone by its ID
     * 
     * @param index
     *            is ID of the zone
     */
    static int cageId = 1;

    public void addCageToZone(int id) throws Exception {

        Cage cage = new Cage();

        Zone zone = zoneList.get(id);

        cage.setZoneId(zone.getId());
        cage.setId(cageId);

        cage.setCategory(zone.getTypeOfZone());

        System.out.println("ENTER CAPACITY OF CAGE : ");
        cage.setCapacity(sc.nextInt());

        cage.setSparecapacity(cage.getCapacity());
        sc.nextLine();

        System.out.println("ENTER TYPE OF ANIMAL IN CAGE : ");
        String type = sc.nextLine();
        cage.setType(type);

        // Checking mammal adaptability
        if (zone.getTypeOfZone().equalsIgnoreCase("MAMMAL")) {
          //to track wether condition is satisfying
            boolean flag = false;

            for (MammalZone.zone mammal : MammalZone.zone.values()) {
                if ((mammal.name().equalsIgnoreCase(type))
                        && zone.getSpareCapacity() > 0) {

                    listOfCage.add(cage);
                    zone.setSpareCapacity(zone.getSpareCapacity() - 1);
                    cageId++;
                    System.out.println("!! Cage Added !!");
                    flag = false;
                    break;

                } else {
                    //true if type doesnot match
                    flag = true;
                }

            }
            if (flag == true) {
                throw new Exception(
                        "!! Cage type is not compatible with Zone !!");

            }

            // check reptile adaptability
        } else if (zone.getTypeOfZone().equalsIgnoreCase("REPTILE")) {
            
            //to track wether condition is satisfying
            boolean flag = false;

            for (ReptileZone.zone reptile : ReptileZone.zone.values()) {
                if ((reptile.name().equalsIgnoreCase(type))
                        && zone.getSpareCapacity() > 0) {

                    listOfCage.add(cage);
                    zone.setSpareCapacity(zone.getSpareCapacity() - 1);
                    cageId++;
                    System.out.println("!! Cage Added !!");
                    flag = false;
                    break;

                } else {
                    //true if type doesnot match
                    flag = true;
                }

            }
            if (flag == true) {
                throw new Exception(
                        "!! Cage type is not compatible with Zone !!");
            }

            // check bird adaptability
        } else if (zone.getTypeOfZone().equalsIgnoreCase("BIRD")) {
          //to track wether condition is satisfying
            boolean flag = false;

            for (BirdZone.zone bird : BirdZone.zone.values()) {
                if ((bird.name().equalsIgnoreCase(type))
                        && zone.getSpareCapacity() > 0) {

                    listOfCage.add(cage);
                    zone.setSpareCapacity(zone.getSpareCapacity() - 1);
                    cageId++;
                    System.out.println("!! Cage Added !!");
                    flag = false;
                    break;

                } else {
                    //true if type doesnot match
                    flag = true;
                }

            }
            if (flag == true) {
                throw new Exception(
                        "!! Cage type is not compatible with Zone !!");
            }
        }

    }

    /**
     * Function to Add animal to cage
     * 
     * @param index
     *            in which animal is to entered in the cage according to ID of
     *            Cage
     */

    public void addAnimalToCage(int index, Animal animal) throws Exception {

        Cage cage = listOfCage.get(index);
        animal.setAnimalCageId(cage.getId());

        // Checking suitable condition that animal can be added to cage

        if (cage.getCategory().equalsIgnoreCase(animal.getCategory())
                && cage.getType().equalsIgnoreCase(animal.getType())
                && cage.getSparecapacity() > 0) {

            listOfAnimal.add(animal);
            cage.setSparecapacity(cage.getSparecapacity() - 1);
            System.out.println("!! Animal Added !!");

        } else {

            System.out.println("!! Incompatible type to Cage !!");
            throw new Exception("Incompatible type with the Cage");

        }
    }

    /**
     * Function to remove animal along with ID
     * 
     * @param index
     */
    public void removeAnimalfromCage(int index) {

        Animal animal = listOfAnimal.get(index);

        int animalCageId = animal.getAnimalCageId();

        Iterator<Cage> iterateCage = listOfCage.iterator();

        while (iterateCage.hasNext()) {

            Cage cage = iterateCage.next();

            int cageID = cage.getId();

            // comparing cageId and animalCageId to completely remove from cage
            // and zoo
            if (animalCageId == cageID) {

                cage.setSparecapacity(cage.getSparecapacity() + 1);

                break;
            }
            iterateCage.next();
        }
        listOfAnimal.remove(index);

        System.out.println("!! Animal Removed !!");

    }
}
