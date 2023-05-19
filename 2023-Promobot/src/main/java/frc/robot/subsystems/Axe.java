package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class Axe extends SubsystemBase{
    WPI_TalonSRX AXE_CONTROLLER;
    
    Axe()
    {
        AXE_CONTROLLER = new WPI_TalonSRX(Constants.AXE_MOTOR_ID);
    }

    public void Move_Axe(double voltage)
    {
        AXE_CONTROLLER.setVoltage(voltage);
    }
}
