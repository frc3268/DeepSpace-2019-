/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3268.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team3268.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class LowerCommand extends Command {
	
	boolean finished;
	int side;
	public LowerCommand(int side_) {
		// Use requires() here to declare subsystem dependencies
	//	requires(Robot.m_subsystem);
		requires(Robot.lift);
		finished = false;
		side = side_;
		Robot.lift.SetCompressor(1);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.lift.ReversePiston(side);
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return finished;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.lift.SetCompressor(0);
		Robot.lift.stopPiston(side);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
