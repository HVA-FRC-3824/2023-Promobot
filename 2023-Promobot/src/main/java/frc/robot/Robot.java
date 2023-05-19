package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick left_joystick;
  private Joystick right_joystick;

  public WestCoast WestCoastDrive;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();

    left_joystick  = new Joystick(Constants.LEFT_JOYSTICK_ID);
    right_joystick = new Joystick(Constants.RIGHT_JOYSTICK_ID);
  }

  @Override
  public void teleopPeriodic() {
    WestCoastDrive.Drive(-left_joystick.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -right_joystick.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
  }
}
