/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.RobotMap;

public class Drivetrain {
  public TalonSRX rightFrontMotor;
  public TalonSRX rightBackMotor;
  public TalonSRX leftFrontMotor;
  public TalonSRX leftBackMotor;

  public Drivetrain() {
    rightFrontMotor = new TalonSRX(RobotMap.RIGHT_FRONT_MOTOR);
    rightBackMotor = new TalonSRX(RobotMap.RIGHT_BACK_MOTOR);
    leftFrontMotor = new TalonSRX(RobotMap.LEFT_FRONT_MOTOR);
    leftBackMotor = new TalonSRX(RobotMap.LEFT_BACK_MOTOR);

    rightBackMotor.set(ControlMode.Follower, RobotMap.RIGHT_FRONT_MOTOR);
    leftBackMotor.set(ControlMode.Follower, RobotMap.LEFT_FRONT_MOTOR);
  }
  
  public void tankDrive(double leftSpeed, double rightSpeed) {
    double kLVoltage = 12 / leftFrontMotor.getBusVoltage();
    double kRVoltage = 12 / rightFrontMotor.getBusVoltage();
    leftFrontMotor.set(ControlMode.PercentOutput, leftSpeed * kLVoltage);
    rightFrontMotor.set(ControlMode.PercentOutput, -rightSpeed * kRVoltage);
  }

  public double getLeftVelocity() {
    return leftFrontMotor.getSelectedSensorVelocity() * RobotMap.V_SCALE_FACTOR;
  }

  public double getRightVelocity() {
    return rightFrontMotor.getSelectedSensorVelocity() * RobotMap.V_SCALE_FACTOR;
  }

  public double getTotalVelocity() {
    return (getLeftVelocity() + getRightVelocity()) / 2.0;
  }

  public double getAngularVelocity() {
    return (getLeftVelocity() - getRightVelocity()) / RobotMap.TRACK_WIDTH;
  }

  public double getLeftPosition() {
    return leftFrontMotor.getSelectedSensorPosition() * RobotMap.POS_SCALE_FACTOR;
  }

  public double getRightPosition() {
    return rightFrontMotor.getSelectedSensorPosition() * RobotMap.POS_SCALE_FACTOR;
  }

  public double getAveragePosition() {
    return (getLeftPosition() + getRightPosition()) / 2;
  }
}
