package it.unibo.design.robot.test;

//java -cp build/classes/java/main:build/classes/java/test it.unibo.design.robot.test.TestRobotWithArms
//java -cp build/classes/java/main it.unibo.design.robot.test.TestRobotWithArms

import static it.unibo.design.robot.test.Assertions.assertEquals;
import it.unibo.design.robot.impl.BaseRobot;
import it.unibo.design.robot.api.RobotWithArms;
import it.unibo.design.robot.impl.RobotWithTwoArms;
import it.unibo.design.robot.environment.impl.RobotPosition;

/**
 * Utility class for testing componible robots
 */
public final class TestRobotWithArms {

    // Tolerance for double comparisons, to account for floating-point rounding errors  
    private static final double EPSILON = 1e-7;

    private static final int CYCLES = 10;

    private TestRobotWithArms() {
    }

    public static void main(final String[] args) {
    
        System.out.println("=== TEST START ===");

        final RobotWithArms walle = new RobotWithTwoArms("Wall-e");

        System.out.println("Testing initial position...");
        assertEquals("Wall-e's position", new RobotPosition(0, 0), walle.getPosition());
        System.out.println("Initial position OK!");

        System.out.println("Testing initial battery level...");
        assertEquals("Wall-e's consumption", BaseRobot.BATTERY_FULL, walle.getBatteryLevel(), EPSILON);
        System.out.println("Initial battery level OK!");

        double consumptionEmpty = walle.getBatteryLevel();
        System.out.println("Moving right " + CYCLES + " times...");
        for (int i = 0; i < CYCLES; i++) {
            walle.moveRight();
        }
        consumptionEmpty -= walle.getBatteryLevel();
        System.out.println("Movement consumption: " + consumptionEmpty);

        System.out.println("Picking up first item...");
        walle.pickUp();
        assertEquals("Wall-e's items carried", 1, walle.getCarriedItemsCount());
        System.out.println("First item picked up OK!");

        double consumption1Item = walle.getBatteryLevel();
        System.out.println("Moving up " + CYCLES + " times with 1 item...");
        for (int i = 0; i < CYCLES; i++) {
            walle.moveUp();
        }
        consumption1Item -= walle.getBatteryLevel();
        assertEquals("Wall-e's consumption", true, consumption1Item > consumptionEmpty);
        System.out.println("Movement with 1 item OK!");

        System.out.println("Picking up second item...");
        walle.pickUp();
        assertEquals("Wall-e's items carried", 2, walle.getCarriedItemsCount());
        System.out.println("Second item picked up OK!");

        double consumption2Item = walle.getBatteryLevel();
        System.out.println("Moving up " + CYCLES + " times with 2 items...");
        for (int i = 0; i < CYCLES; i++) {
            walle.moveUp();
        }
        consumption2Item -= walle.getBatteryLevel();
        assertEquals("Wall-e's consumption", true, consumption2Item > consumption1Item);
        System.out.println("Movement with 2 items OK!");

        System.out.println("Attempting to pick up a third item (should stay 2)...");
        walle.pickUp();
        assertEquals("Wall-e's items carried", 2, walle.getCarriedItemsCount());
        System.out.println("Third pick-up correctly prevented!");

        System.out.println("Dropping down items...");
        walle.dropDown();
        assertEquals("Wall-e's items carried", 1, walle.getCarriedItemsCount());
    }
}