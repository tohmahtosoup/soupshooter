package frc.robot;

public  final class constants2 {
    public final static class shooterconstants {
        /**  ids: they are used in the drive subsystem when defining the motors (match each sparkmax 
        * to a specific can so data can be sent to it) (which port controls which motor?)*/  
        public final static int kspinleader = 1;
        public static final int kspinfollower = 2;

        public static final int krotator = 3;

        /** speed and angle conditions for the two commands yay */
        public static final double speed1 = 1;
        public static final double angle1 = 1;
        public static final double speed2 = 1;
        public static final double angle2 = 1;

        public static final double voltageconvert = 1;
    }

    public static class OperatorConstants {
    /** driver controller port: which USB port the xbox controller is connected to */ 
    public static final int kDriverControllerPort = 0;
  }
}

