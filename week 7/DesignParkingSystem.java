/*
 * WEEK 7 - TASK 1
 * Problem: Design Parking System
 * Platform: LeetCode 1603
 *
 * Question:
 * Design a parking system with big, medium, and small spaces. The constructor
 * receives the number of spaces of each type. addCar(carType) should return
 * true and consume one matching space when available; otherwise return false.
 * Car types are 1 = big, 2 = medium, and 3 = small.
 *
 * Solution:
 * Store the available spaces in an array indexed by car type. Each successful
 * addCar call decrements the corresponding count.
 */

class ParkingSystem {
    private int[] spaces;

    public ParkingSystem(int big, int medium, int small) {
        spaces = new int[]{0, big, medium, small};
    }

    public boolean addCar(int carType) {
        if (spaces[carType] > 0) {
            spaces[carType]--;
            return true;
        }
        return false;
    }
}

/*
 * Example:
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // true
 * parkingSystem.addCar(2); // true
 * parkingSystem.addCar(3); // false
 * parkingSystem.addCar(1); // false
 */
