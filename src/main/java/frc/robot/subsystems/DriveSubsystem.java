// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.driveconstants;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;


public class DriveSubsystem extends SubsystemBase {
  /** creates two motors (left,right) that are representations of the physical sparkmaxes that control motors
   * using the CAN id, it assigns each motor with a physical sparkmax controller
   * the motor type is specified
   */
  private final SparkMax m_leftmotorleader = new SparkMax(driveconstants.kleftmotorport, MotorType.kBrushless);
  private final SparkMax m_rightmotorleader = new SparkMax(driveconstants.krightmotorport, MotorType.kBrushless);
  private final DifferentialDrive m_drive = new DifferentialDrive(m_rightmotorleader, m_leftmotorleader);
  /** Creates a new ExampleSubsystem. */
  @SuppressWarnings("removal")
  public DriveSubsystem() {
    
    SparkMaxConfig rightsideleader = new SparkMaxConfig();
    /** invert to make sure that both are driving same direction */
    rightsideleader.inverted(true);
    m_rightmotorleader.configure(rightsideleader, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    SparkMaxConfig rightsidefollower = new SparkMaxConfig();
    m_rightmotorleader.configure(rightsidefollower, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    SparkMaxConfig leftsideleader = new SparkMaxConfig();
    m_leftmotorleader.configure(leftsideleader, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

    SparkMaxConfig leftsidefollower = new SparkMaxConfig();
    m_rightmotorleader.configure(leftsidefollower, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
  }
  public void arcadeDrive(double forward, double rotation)
    {m_drive.arcadeDrive(forward, rotation);} 
  
    /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
