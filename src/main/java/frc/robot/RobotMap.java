/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	public static final int RIGHT_FRONT_MOTOR = 1;
	public static final int RIGHT_BACK_MOTOR = 2;
	public static final int LEFT_FRONT_MOTOR = 3;
	public static final int LEFT_BACK_MOTOR = 4;

	public static final int RIGHT_JOYSTICK = 1;
	public static final int LEFT_JOYSTICK = 2;

	public static final double SPEED_MULTIPLIER = 0.5;
	
	public static double CHASSIS_GEAR_RATIO = 10.75;
	public static final double WHEEL_DIAMETER = 6.0 / 12.0; // in feet
	public static final double TRACK_WIDTH = 2.0; // in feet
	public static final double POS_SCALE_FACTOR = (WHEEL_DIAMETER * Math.PI) / 4096.0; // convert sensor unit position to feet
	public static final double V_SCALE_FACTOR = 10.0 * POS_SCALE_FACTOR; // convert sensor unit velocity to feet per second



}
