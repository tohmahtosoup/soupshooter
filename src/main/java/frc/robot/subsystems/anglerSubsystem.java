package frc.robot.subsystems;

import java.lang.module.Configuration;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import frc.robot.constants2;

public class anglersubsystem {
    private final TalonFX m_pivoter = new TalonFX(constants2.pivoterconstants.kpivoter);
    private final PositionVoltage mpositionrequest = new PositionVoltage(0);

    public anglersubsystem() {
        TalonFXConfiguration configurationangler = new TalonFXConfiguration();}

public void stop() {
    m_pivoter.stopMotor();
}
public void setangle(double targetangle) {
    double mangle = targetangle;
}

}

