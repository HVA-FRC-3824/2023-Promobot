package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase {
    private DoubleSolenoid RELEASE_SOLENOID;
    private PneumaticHub HUB;

    // Init
    public Pneumatics(int can_id)
    {
        RELEASE_SOLENOID = new DoubleSolenoid(can_id,PneumaticsModuleType.REVPH, 1, 3);
        HUB = new PneumaticHub(can_id);
    }

    // Opens solenoid
    public void void_air()
    {
        RELEASE_SOLENOID.set(Value.kForward);
        RELEASE_SOLENOID.set(Value.kReverse);
    }

    // Close solenoid
    public void close_solenoid()
    {
        RELEASE_SOLENOID.set(Value.kOff);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("PSI:", HUB.getPressure(Constants.ANALONG_PORT));
    }
}