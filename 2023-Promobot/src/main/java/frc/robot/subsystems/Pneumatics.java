package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
    private Compressor COMPRESSOR;
    private DoubleSolenoid RELEASE_SOLENOID;

    // Init
    public Pneumatics(int forward_channel, int reverse_channel)
    {
        // ASSUMES THAT PCM CAN ID IS 0!
        COMPRESSOR = new Compressor(PneumaticsModuleType.REVPH);
        RELEASE_SOLENOID = new DoubleSolenoid(PneumaticsModuleType.REVPH, forward_channel, reverse_channel);
    }

    public void Void_Air()
    {
        // Releases both solenoids TODO: figure out if they need to be opened or closed (solenoid is configured weird)
        RELEASE_SOLENOID.set(Value.kForward);
        RELEASE_SOLENOID.set(Value.kReverse);
    }

    public void Close_Solenoid()
    {
        RELEASE_SOLENOID.close();
    }

    public void Enable_Compressor(boolean e_or_d)
    {
        if(e_or_d)
        {
            COMPRESSOR.enableAnalog(0, Constants.MAX_PRESSURE);
        } else {
            COMPRESSOR.close();
        }
    }
}