package frc.subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Solenoid;
import static frc.utility.Pneumatics.getPneumaticsHub;

public class Intake extends AbstractSubsystem{
    private final Solenoid intakeSol;
    private TalonFX intakeMotorFalcon;
    private static Intake instance = new Intake();
    public Intake() {
        super(-1, 4);
        intakeSol = getPneumaticsHub().makeSolenoid(3);
    }

    @Override
    public void close() throws Exception {
        intakeSol.close();
        instance = new Intake();
    }

    public void toggle() {
        intakeSol.toggle();
    }

    public void setIntakeMotorFalcon(double speed) {
        if(intakeSol.get()){
            intakeMotorFalcon.set(ControlMode.PercentOutput, speed);
        }
    }


    public static Intake getInstance() {
        return instance;
    }
}
