/*
 * Practical Exercise 5 developed by Diego Rivera for Programming Fundamentals class.
 * 09/09/2016
 * Professor: ----------
 * HotelBookings aplication allows the creation of the different hotel objects.
 * Objects created are to be added to an ArrayList called "hotel".
 * There is menu system that allows to the user select the type of room followed
 * by imputing the room number from the keyboard.
 * The menu also have a rates section listing the different room rates, as well
 * an option to list all currently booked out rooms and an exit button.
 */
package practicalexercise5;

/**
 *
 * @author diegorivera
 * 09/09/2016
 * HotelBookings.java
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class HotelBookings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ArrayList hotel declaration
        ArrayList<HotelRoom> hotel = new ArrayList<>();
        while (true) {
            //Display input menu
            int choice = Integer.parseInt(
                    JOptionPane.showInputDialog(null,
                            "--HOTEL RENTAL SYSTEM--\n\n"
                            + "1. Choose a room type\n"
                            + "2. Room rates information\n"
                            + "3. Rooms currently booked\n\n"
                            + "4. Exit"));
       
            if (choice != 4) {

                switch (choice) {
                    case 1://Option 1 Choose a room type
                        int select = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "1. Normal Hotel room\n"
                                + "2. Suite\n\n"
                                + "Choose room type"));
                        int roomNo;
                        //conditional to pass values to select rooms 
                        if (select == 1 || select == 2) {
                            roomNo = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter room number"));
                            HotelRoom room = null;
                                switch (select) {
                                    case 1:
                                        room = new HotelRoom(roomNo);//Option 1 Hotel Room
                                        break;
                                    case 2:
                                        room = new Suite(roomNo);//Option 2 Suite
                                        break;
                            }
                            hotel.add(room);
                            //Display room booked
                            JOptionPane.showMessageDialog(null, "--Rooms Booked out--\n\n" + room.toString());
                        }
                        break;
                    case 2://Option 2 Room rates info
                        JOptionPane.showMessageDialog(null,
                                "NIGHTLY ROOM RATES\n\n"
                                + "Rooms numbered 1-" + (HotelRoom.ROOM_THRESHOLD - 1) + "= $" + HotelRoom.RATE_SMALL
                                + "\nAll other rooms are $" + HotelRoom.RATE_LARGE + "\n\n"
                                + "Suites have an extra $" + Suite.SURCHARGE + " surcharge applied");
                        break;
                    case 3://Option 3 display Currently rooms booked
                        String searchResults = "",
                         searchList = "";
                        searchResults += hotel.toString();
                        if (searchResults.length() < 4) {
                            JOptionPane.showMessageDialog(null, "No Rooms Booked yet");
                        } else {
                            for (int i = 0; i < hotel.size(); i++) {
                                HotelRoom hotelroom = hotel.get(i);
                                searchList += hotelroom.toString() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, "--Rooms Booked out--\n\n" + searchList);
                        }
                        break;
                }

            } else {
                System.exit(0);//Exit the program
            }//end else

        }
        //end while
    }//end main

}
