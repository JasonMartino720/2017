package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ShootSequence extends Command {

    public ShootSequence() {
       requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	/*Robot.shooter.SpinFlywheel();
    	Robot.timer.delay(1.0);
    	*/

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	Robot.shooter.PulseFeeder();
    	    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.AllOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
