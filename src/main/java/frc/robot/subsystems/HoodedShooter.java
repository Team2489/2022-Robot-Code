// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HoodedShooter extends SubsystemBase {
  /** Creates a new HoodedShooter. */
  // CANSparkMax shooterMotor;
  WPI_TalonSRX shooterMotor;
  RelativeEncoder shooterEncoder;
  WPI_TalonSRX feederMotor;
  Timer timer;

  public HoodedShooter() {


    // shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR_PORT, MotorType.kBrushless);
    shooterMotor = new WPI_TalonSRX(Constants.SHOOTER_MOTOR_PORT);
    feederMotor = new WPI_TalonSRX(Constants.INTAKE_FEEDER_MOTOR);
    timer = new Timer();
    // shooterMotor.enableVoltageCompensation(12);
    // shooterEncoder = shooterMotor.getEncoder();
   
  }
  public void shoot(double power){
    double shooterVoltage = shooterMotor.getBusVoltage();
    shooterMotor.setInverted(true);
    shooterMotor.set(power*shooterVoltage);
  }
  public void feed(double power){
    double feedVoltage = feederMotor.getBusVoltage();
    feederMotor.set(power*feedVoltage);
  }
  public void stopShoot(){
    shooterMotor.set(0);
    feederMotor.set(0);
  }
  
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
