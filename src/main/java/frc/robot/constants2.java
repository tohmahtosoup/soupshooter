package frc.robot;

import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.MotorAlignmentValue;

public  final class constants2 {
    public final static class flywheelconstants {
        /**  ids: they are used in the drive subsystem when defining the motors (match each sparkmax 
        * to a specific can so data can be sent to it) (which port controls which motor?)*/  
        public final static int kflywheelleader = 1;
        public static final int kflywheelfollower = 2;

        /** the follower wheel has to go the opposite direction to the master */
        public static final MotorAlignmentValue opposedirection = MotorAlignmentValue.Opposed;
        public static final InvertedValue invertedvalue = InvertedValue.Clockwise_Positive;

        public static final double rpmtolerance = 1;
        
    }
    public static class pivoterconstants {
        /** motor definitions */
        public static final int kpivoter = 3;

        /** rotation of motor -> correspond to certain angle increase */
        public static final double rotationpervelocity = 1;
        public static final double angletolerance = 1;

        /** parameters for the pid controls */
        public static final double constantP = 1;
        public static final double constantI = 1;
        public static final double constantD = 1;
        public static final double constantS = 1;

    }

    public static class presetconstants {
        /** preset RPM speed and angle conditions for the two commands yay */
        public static final double speed1 = 1;
        public static final double speed2 = 1;
        public static final double angle1 = 1;
        public static final double angle2 = 1;

    }
    public static class OperatorConstants {
    /** driver controller port: which USB port the xbox controller is connected to */ 
    public static final int kDriverControllerPort = 0;
  }
}

