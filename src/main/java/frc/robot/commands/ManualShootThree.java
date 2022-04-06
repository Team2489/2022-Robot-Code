package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.HoodedShooter;
import frc.robot.subsystems.Intake;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class ManualShootThree extends SequentialCommandGroup {
  /** Creates a new ManualShootTwo. */
  HoodedShooter hoodedShooter;
  Intake intake;
  public ManualShootThree(HoodedShooter hoodedShooter, Intake intake, double intakePower, double shooterPower, double feederPower, double rampUpTime, double feedTime) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    
    addCommands(
      new RunShooter(hoodedShooter, shooterPower).withTimeout(rampUpTime),
      new RunShooterFeederIntake(hoodedShooter, intake, shooterPower, feederPower, intakePower).withTimeout(feedTime)

    );
  }
}
