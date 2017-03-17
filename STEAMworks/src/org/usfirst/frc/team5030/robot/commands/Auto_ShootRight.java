package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;

import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_ShootRight extends Command {
	
	CommandGroup openServos;
	
	Timer timer;
	
	double rEnc = Robot.robotmap.FRSRX.getEncPosition();
	double lEnc = Robot.robotmap.BLSRX.getEncPosition();
	
	boolean turnComplete = false;
    

    public Auto_ShootRight() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.FRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setPosition(0);
    	Robot.robotmap.FRSRX.setPosition(0);
    	openServos = new CG_OpenServos();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.SpinFlywheel(2800);
    	timer.delay(2.0);
    	Robot.shooter.PulseFeeder();
    	timer.delay(12.0);
    	Robot.shooter.AllOff();
    	timer.delay(1);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
