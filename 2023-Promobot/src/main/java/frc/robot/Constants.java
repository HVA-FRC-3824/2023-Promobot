package frc.robot;

public class Constants {
    // Joystick Ids
    public static final int CONTROLLER_ID  = 1;
    public static final int OPERATOR_ID    = 0;

    // WestCoast Motors
    public static final int L_MASTER_ID = 6;
    public static final int L_SLAVE_ID  = 7;
    public static final int R_MASTER_ID = 1;
    public static final int R_SLAVE_ID  = 4;
    public static final boolean SAFETY_ENABLED = false; // suppresses warning, not needed to be on

    // WestCoast invert type
    public static final boolean RIGHT_INVERTED = true;
    public static final boolean LEFT_INVERTED  = false;

    // WestCoast input multiplier 
    public static final double INPUT_MULTIPLIER_FORWARD  = .725;
    public static final double INPUT_MULTIPLIER_SIDEWAYS = .725;

    // Axe Motors
    public static final int AXE_MOTOR_ID            = 17;
    public static final double AXE_INPUT_MULTIPLIER = .1; 

    // Pneumatics
    public static final int PNEUMATICS_CAN_ID = 9;
    public static final int MAX_PRESSURE      = 110;
    public static final int ANALONG_PORT      = 0;
}
