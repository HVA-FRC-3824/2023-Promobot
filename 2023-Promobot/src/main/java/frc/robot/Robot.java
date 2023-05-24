package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick left_joystick;
  private Joystick right_joystick;
  private JoystickButton compressor_button;

  public WestCoast WestCoastDrive;
  public Pneumatics PneumaticsControl;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    PneumaticsControl = new Pneumatics(0,0);

    left_joystick  = new Joystick(Constants.LEFT_JOYSTICK_ID);
    right_joystick = new Joystick(Constants.RIGHT_JOYSTICK_ID);
    compressor_button = new JoystickButton(left_joystick, 0);
  }

  @Override
  public void teleopPeriodic() {
    // TODO: Fix right_joystick!
    WestCoastDrive.Drive(-left_joystick.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -right_joystick.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
    
  }
}
