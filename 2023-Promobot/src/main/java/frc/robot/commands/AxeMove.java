package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Axe;

public class AxeMove extends CommandBase{
    private Axe AXE_SUBSYSTEM;

    AxeMove(Axe AXE)
    {
        this.AXE_SUBSYSTEM = AXE;
        addRequirements(AXE);
    }

    @Override 
    public void initialize() 
    {
        // TODO: put axe in starting position if neccessary
    }
    
    @Override
    public void execute()
    {
        // TODO: write code to move the axe up and down
    }
}
