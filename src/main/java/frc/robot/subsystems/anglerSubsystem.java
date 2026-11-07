package frc.robot.subsystems;
import com.ctre.phoenix6.CANBus;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.DutyCycleOut;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;
import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;

import frc.robot.constants2;

public class anglerSubsystem {

    /** creates two motors (left,right) that are representations of the physical sparkmaxes that control motors
     * using the CAN id, it assigns each motor with a physical sparkmax controller
     * the motor type is specified
     * initiation */

    /** define the two motors, one leader one follower, but now phoenix -> for speed, rotation inverted
     * and then define the side motor for the angle control
     */
    private final TalonFX mleadermotor = new TalonFX(constants2.shooterconstants.kspinleader);
    private final TalonFX mfollowermotor = new TalonFX(constants2.shooterconstants.kspinfollower);

    private final TalonFX mrotatormotor = new TalonFX(constants2.shooterconstants.krotator);

    public anglersubsystem {
        /** configure motors, invert the first one so that the velocity motors are rotating in opposite directions */
        TalonFXConfiguration mleader = new TalonFXConfiguration();
        TalonFXConfiguration mfollower = new TalonFXConfiguration();
        TalonFXConfiguration mrotator = new TalonFXConfiguration();
    
        mleadermotor.getConfigurator();
        mfollowermotor.getConfigurator();
        mrotatormotor.getConfigurator();

    }

      public void setting1yo() {}
    public void setting2yo() {}

}

    
