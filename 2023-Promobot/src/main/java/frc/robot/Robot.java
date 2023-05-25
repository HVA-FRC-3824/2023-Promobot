package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.commands.Inliners;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick Joystick;

  public static WestCoast WestCoastDrive;
  public static Pneumatics PneumaticsControl;

  public static Inliners InlineCommands;
  public static OI OperatorInterface;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    PneumaticsControl = new Pneumatics(Constants.PNEUMATICS_CAN_ID);
    Joystick = new Joystick(Constants.CONTROLLER_ID);
    InlineCommands = new Inliners(PneumaticsControl);
    OperatorInterface = new OI(); // Assumes InlineCommands has already been initialized! 
  }

  @Override
  public void teleopPeriodic() {
    WestCoastDrive.Drive(-Joystick.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -Joystick.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
  }
}
