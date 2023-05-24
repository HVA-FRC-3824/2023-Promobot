package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private XboxController Controller;

  public WestCoast WestCoastDrive;
  public Pneumatics PneumaticsControl;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    PneumaticsControl = new Pneumatics(0,0);

    Controller = new XboxController(Constants.CONTROLLER_ID);
  }

  @Override
  public void teleopPeriodic() {
    // TODO: Fix right_joystick!
    WestCoastDrive.Drive(-Controller.getLeftY() * Constants.INPUT_MULTIPLIER_FORWARD, Controller.getRightX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
    if(Controller.getAButtonPressed())
    {
      PneumaticsControl.Enable_Compressor(true);
    }
    else
    {
      PneumaticsControl.Enable_Compressor(false);
    }
  }
}
