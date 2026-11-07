package frc.robot.subsystems;
import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;

import edu.wpi.first.math.controller.BangBangController;
import frc.robot.constants2;
import frc.robot.constants2.flywheelconstants;

public class flywheelsubsystem1 {

    /** creates two motors (left,right) that are representations of the physical sparkmaxes that control motors
     * using the CAN id, it assigns each motor with a physical sparkmax controller
     * the motor type is specified
     * initiation */

    /** define the two motors, one leader one follower, but now phoenix -> for speed, rotation inverted
     * and then define the side motor for the angle control
     */
    private final TalonFX mleadermotor = new TalonFX(constants2.flywheelconstants.kflywheelleader);
    private final TalonFX mfollowermotor = new TalonFX(constants2.flywheelconstants.kflywheelfollower);
    private final BangBangController bangbangbang = new BangBangController();
    public final VoltageOut voltagerequester = new VoltageOut(null);

    public flywheelsubsystem1() {
        /** configure motors, invert the first one so that the velocity motors are rotating in opposite directions */
        TalonFXConfiguration configuration = new TalonFXConfiguration();
        configuration.MotorOutput.Inverted = constants2.flywheelconstants.invertedvalue;
        mleadermotor.getConfigurator().apply(configuration);
        mfollowermotor.setControl(new Follower(flywheelconstants.kflywheelleader,flywheelconstants.opposedirection));
        
        bangbangbang.setTolerance(constants2.flywheelconstants.rpmtolerance);
    }

    /** function for stopping the motor, if needed 
     * can be used to bind to a specific button on controller*/ 
    public void stopmotor(double targetrps) 
    {targetrps = 0;
    mleadermotor.stopMotor();}
    
    public void setvelocity(double targetrps) {
        double mvelocity = targetrps;}

    /** checking if the motor is at the desired speed, within tolerance /
    public double getRPS() {
      return mleadermotor.getVelocity().getValueAsDouble();
    }

    public boolean isatRPS() {
      if (targetrps == 0) return false;
      return bangbangbang.atSetpoint();
    }
    */

    /** periodic recalculating the target velocity using the bangbang controls*/
    public void periodic(double targetrps) {
      double calculatedvoltage;
            if (targetrps > 0) 
              calculatedvoltage = bangbangbang.calculate(mleadermotor.getVelocity().getValueAsDouble(),targetrps);

}
}
    
