// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class driveconstants {
    /** !!!! placeholders, remember to change, REMOVE WHEN DONE */
    /** physical constants
    wheel diameter: converts rotations to actual meters travelled, used in drive subsystem
    gearbox reduction ratio: (how many times the motor turned in relation to the wheel), also used in drive subsystem
    track width: distance from wheels to center of chassis, used for kinematics */

    /**public static final double ktrackwidth = 1;
    public static final double kdrivegearratio = 1;
    public static final double kwheeldiameter = 1;*/

    /** !!!! placeholders, remember to change, REMOVE WHEN DONE */
/** CAN ids: they are used in the drive subsystem when defining the motors (match each sparkmax 
 * to a specific can so data can be sent to it) (which port controls which motor?)*/    
    public static final int kleftmotorport = 3;
    public static final int krightmotorport = 11;
    public static final int kleftmotorport2 = 10;
    public static final int krightmotorport2 = 1;
    
    /** max speed limits? */
    public final static double kmaxspeed = 10;
    public final static double kjoystickdeadband = 0.1;
  }
  public static class OperatorConstants {
  /** driver controller port: which USB port the xbox controller is connected to */ 
    public static final int kDriverControllerPort = 0;
  }
}
