package frc.robot;

public class Constants {
    // Joystick Ids
    public static final int LEFT_JOYSTICK_ID  = 0;
    public static final int RIGHT_JOYSTICK_ID = 1;

    // WestCoast Motors
    public static final int L_MASTER_ID = 6;
    public static final int L_SLAVE_ID  = 7;
    public static final int R_MASTER_ID = 1;
    public static final int R_SLAVE_ID  = 4;
    public static final boolean SAFETY_ENABLED = false; // suppresses warning, not needed to be on

    // WestCoast invert type
    public static final boolean RIGHT_INVERTED = true;
    public static final boolean LEFT_INVERTED  = false;

    // WestCoast input multiplier TODO: lower and tune these for the stage
    public static final double INPUT_MULTIPLIER_FORWARD  = 1.0;
    public static final double INPUT_MULTIPLIER_SIDEWAYS = 1.0;

    // Axe Motors
    public static final int AXE_MOTOR_ID = 5;
}
