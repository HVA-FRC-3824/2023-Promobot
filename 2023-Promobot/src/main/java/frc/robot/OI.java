package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/* OI = Operator Interface */

public class OI {
    private static Joystick Joystick;
    private static JoystickButton CompressorButton;
    
    // Init
    public OI()
    {
        Joystick = new Joystick(0);
        CompressorButton = new JoystickButton(Joystick, 0);
    
        confiure_button_bindings();
    }


    public void confiure_button_bindings()
    {
        CompressorButton.onTrue(Robot.InlineCommands.TOGGLE_COMPRESSOR);
    }
}
