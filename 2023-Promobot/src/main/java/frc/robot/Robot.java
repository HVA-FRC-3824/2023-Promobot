package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick Driver;
  private WestCoast WestCoastDrive;
  private Axe AxeControl;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    Driver = new Joystick(Constants.CONTROLLER_ID);
    AxeControl = new Axe();
  }

  boolean AxeOn = false;

  @Override
  public void teleopPeriodic() {
    WestCoastDrive.drive(-Driver.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -Driver.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
    AxeControl.move_axe(Driver.getRawAxis(4) * Constants.AXE_INPUT_MULTIPLIER);
  
    if(AxeOn)
    {
      /* Set axe movement to max */
      AxeControl.move_axe(1 * Constants.AXE_INPUT_MULTIPLIER);
    }

    if(Driver.getRawAxis(3) == 1)
    {
      AxeOn = true;
    }
    if(Driver.getRawAxis(2) == 1)
    {
      AxeOn = false;
    }
  }
}
