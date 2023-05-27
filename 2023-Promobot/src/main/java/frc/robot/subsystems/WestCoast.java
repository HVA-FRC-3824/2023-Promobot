package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class WestCoast extends SubsystemBase {

    // Declare our motor controllers
    WPI_TalonSRX LEFT_MASTER  = new WPI_TalonSRX(Constants.L_MASTER_ID);
    WPI_TalonSRX LEFT_SLAVE   = new WPI_TalonSRX(Constants.L_SLAVE_ID);
    WPI_TalonSRX RIGHT_MASTER = new WPI_TalonSRX(Constants.R_MASTER_ID);
    WPI_TalonSRX RIGHT_SLAVE  = new WPI_TalonSRX(Constants.R_SLAVE_ID);

    DifferentialDrive DRIVE_TRAIN;

    // Init
    public WestCoast()
    {
        // Configure controllers
        LEFT_MASTER.configFactoryDefault();
        LEFT_SLAVE.configFactoryDefault();
        RIGHT_MASTER.configFactoryDefault();
        RIGHT_SLAVE.configFactoryDefault();

        // Setup pseudo motor group
        LEFT_SLAVE.follow(LEFT_MASTER);
        RIGHT_SLAVE.follow(RIGHT_MASTER);

        // Invert voltages
        LEFT_MASTER.setInverted(Constants.LEFT_INVERTED);
        RIGHT_MASTER.setInverted(Constants.RIGHT_INVERTED);
        LEFT_SLAVE.setInverted(InvertType.FollowMaster);
        RIGHT_SLAVE.setInverted(InvertType.FollowMaster);

        // Init our WPILIB drive thingy
        DRIVE_TRAIN = new DifferentialDrive(LEFT_MASTER,RIGHT_MASTER);
        DRIVE_TRAIN.setSafetyEnabled(Constants.SAFETY_ENABLED);
    }
    
    public void drive(double forward, double sideways)
    {
        this.DRIVE_TRAIN.arcadeDrive(forward, sideways);
    }
}
