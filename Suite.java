/*
 * Practical Exercise 5 developed by Diego Rivera for Programming Fundamentals class.
 * 09/09/2016
 * Professor ------------
 * Suite child class extends from HotelRoom parent class.
 */
package practicalexercise5;

/**
 *
 * @author diegorivera
 * 09/09/2016
 * Suite.java
 */
public class Suite extends HotelRoom {

    public static double SURCHARGE = 40.00;

    /*constructor inheritance roomNum from HotelRoom parent class, as well the
    increaseRate protected method*/
    public Suite(int roomNum) {
        super(roomNum);
        increaseRate(SURCHARGE);
    }
    
    @Override
    public String toString() {
        return "Room No. " + getRoomNo() + "\nNightly Rate: $" + getRate()+"\n";
    }

    
}
