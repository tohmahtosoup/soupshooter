package frc.robot.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.controller.BangBangController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants2;
import frc.robot.constants2.flywheelconstants;

public class flywheelsubsystem1 extends SubsystemBase{

    /** creates two motors (left,right) that are representations of the physical sparkmaxes that control motors
     * using the CAN id, it assigns each motor with a physical sparkmax controller
     * the motor type is specified
     * initiation */

    /** define the two motors, one leader one follower, but now phoenix -> for speed, rotation inverted
     * and then define the bangbangbang controller
     */
    private final TalonFX mleadermotor = new TalonFX(constants2.flywheelconstants.kflywheelleader);
    private final TalonFX mfollowermotor = new TalonFX(constants2.flywheelconstants.kflywheelfollower);
    private final BangBangController bangbangbang = new BangBangController();
    
    private double m_targetrps = 0;

    public flywheelsubsystem1() {
        /** configure motors*/
        TalonFXConfiguration configuration = new TalonFXConfiguration();
        
        /** invert, coast yay for follower, more comments below */
        configuration.MotorOutput.Inverted = constants2.flywheelconstants.invertedvalue;
        configuration.MotorOutput.NeutralMode = NeutralModeValue.Coast;

        /** apply configuation, invert the follower one counterclockwise so that the flywheels are rotating in opposite directions 
         * set the coast (flywheel continue spinning, naturally slow down) as neutral (0V behavior), then apply
         */
        mleadermotor.getConfigurator().apply(configuration);
        mfollowermotor.setControl(new Follower(flywheelconstants.kflywheelleader,flywheelconstants.opposedirection));
        mfollowermotor.setNeutralMode(NeutralModeValue.Coast);

        bangbangbang.setTolerance(constants2.flywheelconstants.rpmtolerance);

        
    }

    /** function for stopping the motor, if needed 
     * can be used to bind to a specific button on controller*/ 
    public void stopmotor(double targetrps) 
    {targetrps = 0;
    mleadermotor.stopMotor();}
    
      /** so the target velocity can be updated in the commands */
    public void setvelocity(double targetrps) {
        m_targetrps = targetrps;}

    /** checking if the motor is at the desired speed, within tolerance /*/
    
    public double getrps() {
      return mleadermotor.getVelocity().getValueAsDouble();
    }

    public TalonFX getleader() {
      return mleadermotor;}

    /** periodic recalculating the target velocity using the bangbang controls*/
    public void periodic() {
      double rps = getrps();
      /** if the current motor speed is not at target rps, then we BANG and go to 12 full speed ahead*/
            if (m_targetrps > rps) {
              mleadermotor.setControl(new VoltageOut(12));}
            /** if below, then go to 0. continuously adjust between 12 and 0 as needed */
              else {
              mleadermotor.setControl(new VoltageOut(0));
            }
}
}
    
