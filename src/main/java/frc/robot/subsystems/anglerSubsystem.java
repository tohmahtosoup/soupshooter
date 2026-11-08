package frc.robot.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants2;

/** similar logic to the flywheel subsystem
 * define motors, create config, create target angle variable
 * then functions to change/get current angle
 */
public class anglersubsystem extends SubsystemBase{
    private final TalonFX m_pivoter = new TalonFX(constants2.pivoterconstants.kpivoter);
    private double m_targetdegrees = 0;

    public anglersubsystem() {
        TalonFXConfiguration configurationangler = new TalonFXConfiguration();
        /** setting the PID constants
         *  i added an additional S constant, which should calculate error due to static friction
         * maybe unused, who knows
         */
        configurationangler.Slot0.kP = constants2.pivoterconstants.constantP;
        configurationangler.Slot0.kI = constants2.pivoterconstants.constantI;
        configurationangler.Slot0.kD = constants2.pivoterconstants.constantD;
        configurationangler.Slot0.kS = constants2.pivoterconstants.constantS;
    
        /** similar how the 
         * flywheel uses coast -> if stopped, will continue to spin naturally, slow down eventually
         * the pivot needs brake -> when stopped, will stay in place rather than fall down
         */
        configurationangler.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        /** apply */
        m_pivoter.getConfigurator().apply(configurationangler);}

 /** set the target angle */
public void setangle(double targetdegrees) {
    m_targetdegrees = targetdegrees;

    /** set the angle to whatever the target is, but must tell motor in rotations 
     * bang bang -> set RPM was in periodic, but PID can perform at higher frequency so put here
    */
    double targetrotations = targetdegrees*constants2.pivoterconstants.rotationpervelocity;
    m_pivoter.setControl(new PositionVoltage(targetrotations));}


    /** get the current velocity of motor, convert to angles based on scaling factor */
public double getangle() {
    double currentdegrees = m_pivoter.getPosition().getValueAsDouble();
    return currentdegrees/constants2.pivoterconstants.rotationpervelocity;}

    /** so can be used in the robotcontainer yippee 
     * this is the reason my robotcontainer an ugly red line for an hour yesterday
    */
public TalonFX getpivot()
    {return m_pivoter;}

}



