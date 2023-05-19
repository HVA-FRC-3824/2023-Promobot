package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class WestCoast extends SubsystemBase {

    // Declare our motor controllers
    WPI_TalonSRX left_master  = new WPI_TalonSRX(Constants.L_MASTER_ID);
    WPI_TalonSRX left_slave   = new WPI_TalonSRX(Constants.L_SLAVE_ID);
    WPI_TalonSRX right_master = new WPI_TalonSRX(Constants.R_MASTER_ID);
    WPI_TalonSRX right_slave  = new WPI_TalonSRX(Constants.R_SLAVE_ID);

    DifferentialDrive drive_train;

    // Init
    public WestCoast()
    {
        // Configure controllers
        left_master.configFactoryDefault();
        left_slave.configFactoryDefault();
        right_master.configFactoryDefault();
        right_slave.configFactoryDefault();

        // Setup pseudo motor group
        left_slave.follow(left_master);
        right_slave.follow(right_master);

        // Invert voltages
        left_master.setInverted(Constants.LEFT_INVERTED);
        right_master.setInverted(Constants.RIGHT_INVERTED);
        left_slave.setInverted(InvertType.FollowMaster);
        right_slave.setInverted(InvertType.FollowMaster);

        // Init our WPILIB drive thingy
        drive_train = new DifferentialDrive(left_master,right_master);
        drive_train.setSafetyEnabled(Constants.SAFETY_ENABLED);
    }
    
    public void Drive(double forward, double sideways)
    {
        this.drive_train.arcadeDrive(forward, sideways);
    }
}
