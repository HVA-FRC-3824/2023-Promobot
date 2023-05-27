package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick Joystick;
  public static WestCoast WestCoastDrive;
  public static Pneumatics PneumaticsControl;
  public static Axe AxeController;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    PneumaticsControl = new Pneumatics(Constants.PNEUMATICS_CAN_ID);
    Joystick = new Joystick(Constants.CONTROLLER_ID);
    AxeController = new Axe();
  }

  @Override
  public void teleopPeriodic() {
    WestCoastDrive.drive(-Joystick.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -Joystick.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
    AxeController.move_axe(Joystick.getRawAxis(5)*Constants.AXE_INPUT_MULTIPLIER);
    
    // Triggers control the solenoid 
    if(Joystick.getRawAxis(2) == 1)
    {
      PneumaticsControl.void_air();
    }

    if(Joystick.getRawAxis(3) == 1)
    {
      PneumaticsControl.close_solenoid();
    }
  }
}
