package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auto_GearLeftPeg extends Command {

    public Auto_GearLeftPeg() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//Robot.robotmap.BLSRX.reverseOutput(true);
    	Robot.robotmap.BRSRX.setEncPosition(0);
    	Robot.robotmap.BLSRX.setEncPosition(0);
    	//openServos = new CG_OpenServos();
    	Robot.robotmap.gearMechanismServo.setAngle(0);
    	Robot.robotmap.HopperServo.setAngle(180);
    	
    	setTimeout(14.9);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
     	double lEnc = -Robot.robotmap.BLSRX.getEncPosition();
    	System.out.println("REnc " + rEnc);
    	System.out.println("lEnc " + lEnc);
     	if(lEnc < 7300 && rEnc < 7300)
    	{
    		Robot.drivetrain.tankDrive(-0.65, -0.65);
    	}
     	else if(rEnc > 7300 && rEnc < 8380)
     	{
     		Robot.drivetrain.tankDrive(0.6, -0.6);
     	}
     	else if(rEnc > 8380 && rEnc <9800)
     	{
     		Robot.drivetrain.tankDrive(-0.4, -0.4);
     	}
     	else
     	{
     		Robot.drivetrain.tankDrive(0.0, 0.0);
     	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
