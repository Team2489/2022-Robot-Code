package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class NEODrivetrain extends SubsystemBase {
  /** Creates a new NEODrivetrain. */

  CANSparkMax rightFrontMax;
  CANSparkMax rightBackMax;
  CANSparkMax leftFrontMax;
  CANSparkMax leftBackMax;
  RelativeEncoder rightEncoder;
  RelativeEncoder leftEncoder;
  MotorControllerGroup rightMotors;
  MotorControllerGroup leftMotors;
  DifferentialDrive dDrive;
  SlewRateLimiter filter;
  



  public NEODrivetrain() {
    rightFrontMax = new CANSparkMax(Constants.RIGHT_FRONT_MAX, MotorType.kBrushless);
    rightBackMax = new CANSparkMax(Constants.RIGHT_BACK_MAX, MotorType.kBrushless);
    leftFrontMax = new CANSparkMax(Constants.LEFT_FRONT_MAX, MotorType.kBrushless);
    leftBackMax = new CANSparkMax(Constants.LEFT_BACK_MAX, MotorType.kBrushless);

    rightFrontMax.setIdleMode(IdleMode.kCoast);
    rightBackMax.setIdleMode(IdleMode.kCoast);
    leftFrontMax.setIdleMode(IdleMode.kCoast);
    leftBackMax.setIdleMode(IdleMode.kCoast);

    rightMotors = new MotorControllerGroup(rightFrontMax, rightBackMax);
    leftMotors = new MotorControllerGroup(leftFrontMax, leftBackMax);
    dDrive = new DifferentialDrive(leftMotors, rightMotors);
    rightFrontMax.enableVoltageCompensation(12);
    rightBackMax.enableVoltageCompensation(12);
    leftFrontMax.enableVoltageCompensation(12);
    leftBackMax.enableVoltageCompensation(12);

    
    rightBackMax.follow(rightFrontMax);
    leftBackMax.follow(leftFrontMax);
    filter = new SlewRateLimiter(0.75);
  }
  public void arcadeDrive(double speed, double rotation){

    
 
    double kRVoltage = rightFrontMax.getBusVoltage();
    double kLVoltage = leftFrontMax.getBusVoltage();
  

      dDrive.curvatureDrive(speed*0.25, -rotation*0.4, true);
    // dDrive.curvatureDrive(filter.calculate(speed), filter.calculate(rotation), false);
      // dDrive.arcadeDrive(filter.calculate(speed), filter.calculate(rotation));
    
  }
  public void stop(){
    rightBackMax.set(0);
    rightFrontMax.set(0);
    leftBackMax.set(0);
    leftFrontMax.set(0);
  }

  public double getLeftVelocity() {
    return leftEncoder.getVelocity() / Constants.CHASSIS_GEAR_RATIO;
  }

  public double getRightVelocity() {
    return rightEncoder.getVelocity() / Constants.CHASSIS_GEAR_RATIO;
  }

  public double getLeftPosition() {
    return leftEncoder.getPosition() / Constants.CHASSIS_GEAR_RATIO;
  }

  public double getRightPosition() {
    return rightEncoder.getPosition() / Constants.CHASSIS_GEAR_RATIO;
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}