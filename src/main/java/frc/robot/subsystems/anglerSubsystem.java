package frc.robot.subsystems;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants2;

public class anglersubsystem extends SubsystemBase{
    private final TalonFX m_pivoter = new TalonFX(constants2.pivoterconstants.kpivoter);
    private final PositionVoltage mpositionrequest = new PositionVoltage(0);

    public anglersubsystem() {
        TalonFXConfiguration configurationangler = new TalonFXConfiguration();}

public void setangle(double targetangle) {
    double mangle = targetangle;
}

}

