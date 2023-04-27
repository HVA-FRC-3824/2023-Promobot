// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.subsystems.*;

/**
 * This is a demo program showing the use of the DifferentialDrive class, specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
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
