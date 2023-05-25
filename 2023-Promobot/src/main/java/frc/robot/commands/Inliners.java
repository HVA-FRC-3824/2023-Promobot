package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Pneumatics;
import frc.robot.Robot;

public class Inliners {
    public final Command TOGGLE_COMPRESSOR;

    public Inliners(Pneumatics PNEUMATIC_CONTROLLER)
    {
        // CompressorEnable = new InstantCommand(() -> PNEUMATIC_CONTROLLER.Enable_Compressor(true));
        // CompressorDisable = new InstantCommand(()-> PNEUMATIC_CONTROLLER.Enable_Compressor(false));

        TOGGLE_COMPRESSOR = new InstantCommand(() -> Robot.PneumaticsControl.toggle_compressor());
    }
}
