package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AxeToggle extends CommandBase {
    
    public AxeToggle()
    {
        addRequirements(Robot.AxeControl);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        Robot.AxeControl.toggle_axe();
    }
}
