// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.Constants.driveconstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.anglersubsystem;
import frc.robot.subsystems.flywheelsubsystem1;

import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.math.MathUtil;
/** 
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DriveSubsystem m_drivesubsystem = new DriveSubsystem();
  private final flywheelsubsystem1 m_flywheelsubsystem = new flywheelsubsystem1();
  private final anglersubsystem m_anglersubsystem = new anglersubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandPS5Controller m_driverController = new CommandPS5Controller(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    /** 
    m_drivesubsystem.setDefaultCommand(m_drivesubsystem.run( () ->
    m_drivesubsystem.arcadeDrive(
      MathUtil.applyDeadband(-m_driverController.getLeftY(),driveconstants.kjoystickdeadband),
      MathUtil.applyDeadband(-m_driverController.getRightX(), driveconstants.kjoystickdeadband)
    )));*/
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    /** binding the pos1, pos2 functions */
      m_driverController.circle().whileTrue(position1());
      m_driverController.triangle().whileTrue(position2());

      /** stop functions binding
       * for good measure :P, onTrue so that it doesnt have to be conitnuous hold
       */
      m_driverController.cross().onTrue(stop());}

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  /**m_driverController.circle().whileTrue(m_drivesubsystem.exampleMethodCommand());  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */


  public Command position1() {
    return edu.wpi.first.wpilibj2.command.Commands.run(
      () -> {m_flywheelsubsystem.setvelocity(constants2.presetconstants.speed1);
        m_anglersubsystem.setangle(constants2.presetconstants.angle1);}, m_flywheelsubsystem,m_anglersubsystem);}


  public Command position2() {
    return Commands.run(
      () -> {m_flywheelsubsystem.setvelocity(constants2.presetconstants.speed2);
        m_anglersubsystem.setangle(constants2.presetconstants.angle2);}, m_flywheelsubsystem,m_anglersubsystem);
}

  public Command stop() {
    return Commands.runOnce(
       () -> {m_flywheelsubsystem.getleader().stopMotor();
      m_anglersubsystem.getpivot().stopMotor();}, m_flywheelsubsystem,m_anglersubsystem);}
    
    
    }
  