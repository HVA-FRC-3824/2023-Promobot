package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class WestCoast extends SubsystemBase {

    /* declare our motors */
    WPI_TalonSRX left_master  = new WPI_TalonSRX(Constants.L_MASTER_ID);
    WPI_TalonSRX left_slave   = new WPI_TalonSRX(Constants.L_SLAVE_ID);
    WPI_TalonSRX right_master = new WPI_TalonSRX(Constants.R_MASTER_ID);
    WPI_TalonSRX right_slave  = new WPI_TalonSRX(Constants.R_SLAVE_ID);

    DifferentialDrive drive_train;

    /* init */
    public WestCoast()
    {
        left_slave.follow(left_master);
        right_slave.follow(right_master);

        /* invert voltages for driving TODO: test this */
        left_master.setInverted(Constants.LEFT_INVERTED);
        right_master.setInverted(Constants.RIGHT_INVERTED);

        /* same for slaves */
        left_slave.setInverted(InvertType.FollowMaster);
        right_slave.setInverted(InvertType.FollowMaster);

        /* once following is initialized setup drive */
        drive_train = new DifferentialDrive(left_master,right_master);
    }
    
    public void Drive(double forward, double sideways)
    {
        this.drive_train.arcadeDrive(forward, sideways);
    }
}
