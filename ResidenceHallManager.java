/**
 *Lysander Pena
 * Homework 1
 * CSE214 R14
 * Tayo Amuneke, Yiwen Wang
 * Grading TA
 */
import java.util.Scanner;
public class ResidenceHallManager {
    public static void main(String[] args) {
        //declarations
        Floor floor1 = new Floor();
        Floor floor2 = new Floor();
        Floor floor3 = new Floor();
        Floor currentFloor = floor1;
        int floorNum = 1;
        Scanner input = new Scanner(System.in);
        String selection = "";
        String tempName = "";
        int tempID = 0;
        int tempPosition = 0;
        int tempFloor = 0;
        boolean keepRunning = true;

        System.out.println("Welcome to Mediocre Rez, the most mediocre housing management service at SBU.");


        while(keepRunning) {
            System.out.println("Menu:\n");
            System.out.println("A) Add a student");
            System.out.println("R) Remove a student");
            System.out.println("S) Swap Students");
            System.out.println("M) Move Student");
            System.out.println("F) Select Floor");
            System.out.println("C) Copy Floor");
            System.out.println("P) Print Current Floor");
            System.out.println("W) Write Up Student");
            System.out.println("Q) Quit");

            selection = input.next();
            selection = selection.toUpperCase();
            //prompts user for option-specific information
            switch (selection) {
                case "A":
                    try {
                        System.out.print("Enter student's name: ");
                        tempName = input.next();
                        System.out.println();
                        System.out.print("Enter an ID number: ");
                        tempID = Integer.parseInt(input.next());
                        System.out.println();
                        System.out.print("Enter a position: ");
                        tempPosition = Integer.parseInt(input.next())-1;

                        currentFloor.addStudent(new Student(),tempPosition);
                        currentFloor.getStudent(tempPosition).setIdNumber(tempID);
                        currentFloor.getStudent(tempPosition).setName(tempName);
                        currentFloor.getStudent(tempPosition).setNumWriteups(0);
                        System.out.println("Student successfully added!");
                    }
                    catch(FullFloorException e) {
                        System.out.println("Floor is full, cannot add student.");
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "R":
                    try {
                        System.out.print("Enter the room of the student you wish to remove: ");
                        tempPosition = Integer.parseInt(input.next())-1;
                        currentFloor.removeStudent(tempPosition);
                    }
                    catch (EmptyFloorException e) {
                        System.out.println("Floor is empty, unable  to remove student.");
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Invalid room number.");
                    }
                    break;
                case "S":
                    try {
                        System.out.print("Enter the floor of student 1: ");
                        int floorChoice1 = Integer.parseInt(input.next());
                        System.out.print("Enter the position of student 1: ");
                        int position1 = Integer.parseInt(input.next())-1;
                        System.out.print("Enter the floor of student 2: ");
                        int floorChoice2 = Integer.parseInt(input.next());
                        System.out.print("Enter the position of student 1: ");
                        int position2 = Integer.parseInt(input.next())-1;

                        if(isValidSelection(floorChoice1,floorChoice2, position1, position2) ) {
                            switch (floorChoice1) {
                                case 1:
                                    switch (floorChoice2) {
                                        case 1:
                                            swapHelper(floor1,floor1,position1,position2);
                                            break;
                                        case 2:
                                            swapHelper(floor1,floor2,position1,position2);
                                            break;
                                        case 3:
                                            swapHelper(floor1,floor3,position1,position2);
                                            break;
                                    }
                                    break;
                                case 2:
                                    switch (floorChoice2) {
                                        case 1:
                                            swapHelper(floor2,floor1,position1,position2);
                                            break;
                                        case 2:
                                            swapHelper(floor2,floor2,position1,position2);
                                            break;
                                        case 3:
                                            swapHelper(floor2,floor3,position1,position2);
                                            break;
                                    }
                                    break;
                                case 3:
                                    switch (floorChoice2) {
                                        case 1:
                                            swapHelper(floor3,floor1,position1,position2);
                                            break;
                                        case 2:
                                            swapHelper(floor3,floor2,position1,position2);
                                            break;
                                        case 3:
                                            swapHelper(floor3,floor3,position1,position2);
                                            break;
                                    }
                                    break;
                            }
                        }
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid input.");
                    }
                    catch(CloneNotSupportedException e) {
                        System.out.println("Clone not supported.");
                    }
                    break;
                case "M":
                    try {
                        System.out.print("Enter the floor of student 1: ");
                        int floorChoice1 = Integer.parseInt(input.next());
                        System.out.print("Enter the position of student 1: ");
                        int position1 = Integer.parseInt(input.next()) - 1;
                        System.out.print("Enter the target floor number: ");
                        int floorChoice2 = Integer.parseInt(input.next());
                        System.out.print("Enter the desired room number: ");
                        int position2 = Integer.parseInt(input.next()) - 1;

                        switch(floorChoice1) {
                            case 1:
                                switch(floorChoice2) {
                                    case 1:
                                        moveStudent(floor1,position1,floor1,position2);
                                        break;
                                    case 2:
                                        moveStudent(floor1,position1,floor2,position2);
                                        break;
                                    case 3:
                                        moveStudent(floor1,position1,floor3,position2);
                                        break;
                                }
                                break;
                            case 2:
                                switch(floorChoice2) {
                                    case 1:
                                        moveStudent(floor2,position1,floor1,position2);
                                        break;
                                    case 2:
                                        moveStudent(floor2,position1,floor2,position2);
                                        break;
                                    case 3:
                                        moveStudent(floor2,position1,floor3,position2);
                                        break;
                                }
                                break;
                            case 3:
                                switch(floorChoice2) {
                                    case 1:
                                        moveStudent(floor1,position1,floor1,position2);
                                        break;
                                    case 2:
                                        moveStudent(floor1,position1,floor2,position2);
                                        break;
                                    case 3:
                                        moveStudent(floor1,position1,floor3,position2);
                                        break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid selection");
                    }
                    break;
                case "F":
                    try {
                        System.out.print("Please enter a floor number: ");
                        tempFloor = Integer.parseInt(input.next());
                        switch (tempFloor) {
                            case 1:
                                currentFloor = floor1;
                                floorNum = 1;
                                System.out.println("Floor 1 selected.");
                                break;
                            case 2:
                                currentFloor = floor2;
                                floorNum = 2;
                                System.out.println("Floor 2 selected.");
                                break;
                            case 3:
                                currentFloor = floor3;
                                floorNum = 3;
                                System.out.println("Floor 3 selected.");
                                break;
                            default:
                                System.out.println("Invalid floor choice.");
                            }
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Invalid input.");
                        }
                    break;
                case "C":
                    try {
                        int selectedFloor = 0;
                        int targetFloor = 0;
                        System.out.print("Enter the number of the floor you would to copy: ");
                        switch (Integer.parseInt(input.next())) {
                            case 1:
                                selectedFloor = 1;
                                System.out.println("Floor 1 selected.");
                                break;
                            case 2:
                                selectedFloor = 2;
                                System.out.println("Floor 2 selected.");
                                break;
                            case 3:
                                selectedFloor = 3;
                                System.out.println("Floor 3 selected.");
                                break;
                            default:
                                System.out.println("Invalid floor choice.");
                                break;
                        }
                        System.out.print("Now enter the the number of the floor you would like to copy to: ");
                        switch (Integer.parseInt(input.next())) {
                            case 1:
                                targetFloor = 1;
                                System.out.println("Floor 1 selected.");
                                break;
                            case 2:
                                targetFloor = 2;
                                System.out.println("Floor 2 selected.");
                                break;
                            case 3:
                                targetFloor = 3;
                                System.out.println("Floor 3 selected.");
                                break;
                            default:
                                System.out.println("Invalid floor choice.");
                        }
                        if(selectedFloor == 1) {
                            if(targetFloor == 1)
                                System.out.println("Why would you want to copy a floor to itself");
                            else if(targetFloor == 2)
                                floor2 = floor1.clone();
                            else if(targetFloor == 3)
                                floor3 = floor1.clone();
                        }
                        else if(selectedFloor == 2) {
                            if(targetFloor == 1)
                                floor1 = floor2.clone();
                            else if(targetFloor == 2)
                                System.out.println("Why would you want to copy a floor to itself?");
                            else if(targetFloor == 3)
                                floor3 = floor2.clone();
                        }
                        else if(selectedFloor == 3) {
                            if(targetFloor == 1)
                                floor1 = floor3.clone();
                            else if(targetFloor == 2)
                                floor2 = floor3.clone();
                            else if(targetFloor == 3)
                                System.out.println("Why would you want to copy a floor to itself?");
                        }
                        if(floorNum == 1)
                            currentFloor = floor1;
                        else if(floorNum == 2)
                            currentFloor = floor2;
                        else
                            currentFloor = floor3;
                    }
                    catch(CloneNotSupportedException e) {
                        System.out.println("lol");
                    }
                    catch(NumberFormatException e) {
                        System.out.println("Invalid input.");
                    }
                    break;
                case "P":
                    currentFloor.printFloor();
                    break;
                case "W":
                    try {
                        System.out.print("Please enter the name of the student you would like to write up: ");
                        tempName = input.next();
                        if (currentFloor.writeup(tempName)) {
                            System.out.println(tempName + " has been successfully written up.");
                        } else
                            System.out.println("Sorry, " + tempName + " does not exist in the system.");
                    }
                    catch(EmptyFloorException e){
                        System.out.println("Floor is empty, unable to write up student.");
                    }
                    break;
                case "Q":
                    System.out.println("Exiting Mediocre Rez.");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid selection, please try again.");
                    break;
            }
            System.out.println("**********************************************");
        }
    }

    /**
     * This method checks that the selection made by the user is valid and can be used to swap students between floors
     * @param floor1
     *  int representation of selected floor number
     * @param floor2
     *  int representation of target floor number
     * @param position1
     *  position of student 1
     * @param position2
     *  position of student 2
     * @return
     *  True or false depending on if the selection made can be used to swap students
     */
    public static boolean isValidSelection(int floor1, int floor2,int position1, int position2) {
        if((floor1<1 || floor1>3)||(floor1<1 || floor2>3)) {
            System.out.println("Invalid floor choice yo");
            return false;
        }
        if((position1<0 || position1 >=Floor.CAPACITY) || (position2<0 || position2 >=Floor.CAPACITY)) {
            System.out.println("not a real position yo");
            return false;
        }
        return true;
    }

    /**
     *
     * @param floorA
     *  floor for student 1
     * @param floorB
     *  floor for student 2
     * @param position1
     *  student 1 position
     * @param position2
     *  student 2 position
     * @throws CloneNotSupportedException
     *  exception is thrown if student does not support clone
     */
    public static void swapHelper(Floor floorA, Floor floorB, int position1, int position2) throws CloneNotSupportedException {
        Student temp = floorA.getStudents()[position1].clone();
        floorA.setStudent(position1,floorB.getStudent(position2));
        floorB.setStudent(position2,temp);
        System.out.println("Students successfully swapped!");
    }

    /**
     *
     * @param startingFloor
     *  floor that student lives on
     * @param startingPosition
     *  position that the student lives in
     * @param destination
     *  target floor
     * @param destinationPosition
     *  target room on target floor
     */
    public static void moveStudent(Floor startingFloor, int startingPosition, Floor destination, int destinationPosition) {
        Student temp = null;
        if(startingFloor.getStudent(startingPosition) == null) {
            System.out.println("Error, student does not exist.");
            return;
        }
        if(destinationPosition-1 >= 0) {
            if(destination.getStudent(destinationPosition) == null) {
                System.out.println("oy you done goofed");
                return;
            }
        }
        temp = startingFloor.getStudent(startingPosition);
        startingFloor.getStudents()[startingPosition] = null;
        startingFloor.shiftLeft(startingPosition);
        destination.shiftRight(destinationPosition);
        destination.setStudent(destinationPosition,temp);
    }
}
