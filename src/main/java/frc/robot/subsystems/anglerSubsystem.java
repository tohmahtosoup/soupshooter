package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.constants2;

public class anglersubsystem {
    private final TalonFX m_pivoter = new TalonFX(constants2.pivoterconstants.kpivoter);

    public anglersubsystem() {}

}
