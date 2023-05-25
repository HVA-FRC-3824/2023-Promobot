package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;

import static edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
    private DoubleSolenoid RELEASE_SOLENOID;
    private PneumaticHub HUB;
    private boolean COMPRESSOR_STATUS = true;

    // Init
    public Pneumatics(int can_id)
    {
        RELEASE_SOLENOID = new DoubleSolenoid(can_id,PneumaticsModuleType.REVPH, 0, 1);
        HUB = new PneumaticHub(can_id);
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

    public void toggle_compressor(){
        if(COMPRESSOR_STATUS){
            HUB.enableCompressorAnalog(0, Constants.MAX_PRESSURE);
            COMPRESSOR_STATUS = false;
        }else{
            HUB.disableCompressor();
           COMPRESSOR_STATUS = true;
        }
    }
}