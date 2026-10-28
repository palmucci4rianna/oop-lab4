package it.unibo.design.robot.api;

public interface RobotWithArms extends Robot {
    boolean pickUp();
    boolean dropDown();
    int getCarriedItemsCount();

    /* 
    * `boolean pickUp()`: picks an object, returns `true` if the action is successful
    * `boolean dropDown()`: drops an object, returns `true` if the action is successful
    * `int getCarriedItemsCount()`: returns the number of objects this robot is currently transporting
    */
}
