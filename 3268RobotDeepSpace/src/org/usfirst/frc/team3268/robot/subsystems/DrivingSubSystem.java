/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.subsystems;

import org.usfirst.frc.team3268.robot.OI;
import edu.wpi.first.wpilibj.CameraServer;
import org.usfirst.frc.team3268.robot.Robot;
import org.usfirst.frc.team3268.robot.RobotMap;
import org.usfirst.frc.team3268.robot.commands.DrivingCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The motors which drive the robot, and their methods of control.
 */
public class DrivingSubSystem extends Subsystem {

	Talon driveLeftFront;
	Talon driveLeftBack;
	Talon driveRightFront;
	Talon driveRightBack;
	SpeedControllerGroup driveLeft;
	SpeedControllerGroup driveRight;
	DifferentialDrive drive;
	public int cur = 1;	//	Tracker to track the current state of whether or not the robot is inverted or not.

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public DrivingSubSystem() {
		driveLeftFront = new Talon(RobotMap.PWM_driveLeftFront);
		driveLeftBack = new Talon(RobotMap.PWM_driveLeftBack);
		driveRightFront = new Talon(RobotMap.PWM_driveRightFront);
		driveRightBack = new Talon(RobotMap.PWM_driveRightBack);
		driveLeft = new SpeedControllerGroup(driveLeftFront, driveLeftBack);
		driveRight = new SpeedControllerGroup(driveRightFront, driveRightBack);
		driveLeft.setInverted(true);
		driveRight.setInverted(true);
		drive = new DifferentialDrive(driveLeft, driveRight);
	}
	public void SwapControls()
	{
		driveLeft.setInverted(!(driveLeft.getInverted()));
		driveRight.setInverted(!(driveRight.getInverted()));
		
	}
	public void tankDrive(Joystick joy) {	
		drive.arcadeDrive(
				joy.getRawAxis(1), 
				-joy.getRawAxis(0) );
	}
	public void tankDriveInv(Joystick joy) {	
		//	If the tracker is 1, we use an inverted control scheme.
		if(cur == 1)
		{
			drive.arcadeDrive(
					-joy.getRawAxis(1), 
					joy.getRawAxis(0));
		}
		//	If the tracker is 0, we use the standard control scheme.
		else if(cur == 0)
		{
			tankDrive(joy);	
		}
	}

	/**
	 * Tank drive using individual joystick axes.
	 *
	 * @param leftAxis  Left sides value
	 * @param rightAxis Right sides value
	 */

	public void stop() {
		drive.stopMotor();
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DrivingCommand());
	}
}
