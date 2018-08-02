package zoneModule;

import interfacesModule.Zone;

import java.util.List;

import controlAndAccessModule.Cage;
import controlAndAccessModule.Zoo;

public class ReptileZone implements Zone {
    
    //enum for arranging type at one place
    public enum zone {
        CROCODILE,LIZARD
    }

    Zoo zoo = new Zoo();

    private int zoneCapacity;
    private int spareCapacity;
    private boolean canteenStatus;
    private boolean parkStatus;
    private int id;

    private List<Cage> listOfCage = zoo.listOfCage;

    private String typeOfZone = "REPTILE";

    // setters and getters START
    public int getZoneCapacity() {
        return zoneCapacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setZoneCapacity(int capacityOfCage) {
        this.zoneCapacity = capacityOfCage;
    }

    public String getTypeOfZone() {
        return typeOfZone;
    }

    public int getSpareCapacity() {
        return spareCapacity;
    }

    public void setSpareCapacity(int spareCapacity) {
        this.spareCapacity = spareCapacity;
    }

    public boolean isCanteenStatus() {
        return canteenStatus;
    }

    public void setCanteenStatus(boolean canteenStatus) {
        this.canteenStatus = canteenStatus;
    }

    public boolean isParkStatus() {
        return parkStatus;
    }

    public void setParkStatus(boolean parkStatus) {
        this.parkStatus = parkStatus;
    }

    // setters and getters END

    public List<Cage> getInfo() {
        return listOfCage;
    }

}
