package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;

public class Turret {
    
    private WPI_TalonSRX turret_Motor = new WPI_TalonSRX(Constants.TURRET_MOTOR_ID);

    public void rotate(double voltage) {
        turret_Motor.setVoltage(voltage);
    }

}
