package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Axe extends SubsystemBase{
    private TalonFX AXE_CONTROLLER;
    private boolean CONSTANT_MOVE = false;

    public Axe()
    {
        AXE_CONTROLLER = new TalonFX(Constants.AXE_MOTOR_ID);
    }

    public void move_axe(double input)
    {
        AXE_CONTROLLER.set(ControlMode.PercentOutput,input);
    }

    public void toggle_axe()
    {
        this.CONSTANT_MOVE = !this.CONSTANT_MOVE;
    }

    @Override
    public void periodic() {
        if(CONSTANT_MOVE)
        {
            System.out.println("Moving the axe!");
            move_axe(1 * Constants.AXE_INPUT_MULTIPLIER);
        }
    }
}
