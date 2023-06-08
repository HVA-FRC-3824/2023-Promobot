package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick Driver;
  private Joystick Operator;
  public static WestCoast WestCoastDrive;
  public static Pneumatics PneumaticsControl;
  public static Axe AxeController;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    PneumaticsControl = new Pneumatics(Constants.PNEUMATICS_CAN_ID);
    Driver = new Joystick(Constants.CONTROLLER_ID);
    Operator = new Joystick(Constants.OPERATOR_ID);
    AxeController = new Axe();
  }

  @Override
  public void teleopPeriodic() {
    WestCoastDrive.drive(-Driver.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -Driver.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
    AxeController.move_axe(Operator.getRawAxis(5) *Constants.AXE_INPUT_MULTIPLIER);
    
    // Triggers control the solenoid 
    if(Operator.getRawAxis(2) == 1)
    {
      PneumaticsControl.void_air();
    }

    if(Operator.getRawAxis(3) == 1)
    {
      PneumaticsControl.close_solenoid();
    }
  }
}
