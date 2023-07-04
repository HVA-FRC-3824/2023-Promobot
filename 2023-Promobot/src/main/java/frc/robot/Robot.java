package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.AxeToggle;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {
  private Joystick Driver;
  private WestCoast WestCoastDrive;
  public static Axe AxeControl;
  private Trigger AxeToggler;

  @Override
  public void robotInit() {
    WestCoastDrive = new WestCoast();
    Driver = new Joystick(Constants.CONTROLLER_ID);
    AxeControl = new Axe(); 
    AxeToggler = new JoystickButton(Driver, 1);
    AxeToggler.onTrue(new AxeToggle());
  }

  // TODO: Test above triggers - boolean AxeOn = false;

  @Override
  public void teleopPeriodic() {
    WestCoastDrive.drive(-Driver.getY() * Constants.INPUT_MULTIPLIER_FORWARD, -Driver.getX() * Constants.INPUT_MULTIPLIER_SIDEWAYS);
    //AxeControl.move_axe(Driver.getRawAxis(4) * Constants.AXE_INPUT_MULTIPLIER);
  
    /* if(AxeOn)
    {
      AxeControl.move_axe(1 * Constants.AXE_INPUT_MULTIPLIER);
    }

    if(Driver.getRawAxis(3) == 1)
    {
      AxeOn = true;
    }
    if(Driver.getRawAxis(2) == 1)
    {
      AxeOn = false;
    } */
  }
}
