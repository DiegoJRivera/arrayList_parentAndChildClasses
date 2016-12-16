/*
 * Practical Exercise 5 developed by Diego Rivera for Programming Fundamentals class.
 * 09/09/2016
 * HotelRoom parent class provides the info of rates and room numbers to child class Suite.
 */
package practicalexercise5;

/**
 *
 * @author diegorivera
 * 09/09/2016
 * HotelRoom.java
 */
public class HotelRoom {

    public static double RATE_SMALL=69.95, RATE_LARGE=89.95;
    public static int ROOM_THRESHOLD=300;
    private int roomNo;
    private double rate;
    
    //constructor
    public HotelRoom(int roomNum, double rate) {
        this.roomNo = roomNum;
        this.rate = rate;
    }
    
    //method to select the room rates according the room number
    public HotelRoom(int roomNum){
        this.roomNo=roomNum;
        if (this.roomNo < ROOM_THRESHOLD){
            this.rate=RATE_SMALL;
        } else{
            this.rate=RATE_LARGE;
        }
    }

    //method to increase the room rates, protected method only gonna be called by Suite child class
    protected void increaseRate(double increase){
        if (this instanceof Suite)
            this.rate += increase;
    }
    
    public int getRoomNo() {
        return this.roomNo;
    }

    public double getRate() {
        return this.rate;
    }

    @Override
    public String toString() {
        return "Room No. " + this.roomNo + "\nNightly Rate $" + this.rate+"\n";
    }

}
