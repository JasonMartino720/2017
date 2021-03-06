package org.usfirst.frc.team5030.robot.commands;

import org.usfirst.frc.team5030.robot.Robot;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Auto_ShootLeft extends Command {
	
	CommandGroup openServos;
	
	boolean driveComplete = true;
    boolean ShootComplete = false;

    public Auto_ShootLeft() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.ShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.ShooterMotor.reverseSensor(true);
    	Robot.robotmap.ShooterMotor.setP(0.65);
    	Robot.robotmap.ShooterMotor.setI(0.001);
    	Robot.robotmap.ShooterMotor.setD(0);
    	Robot.robotmap.ShooterMotor.setF(0.129);
    	Robot.robotmap.ShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setEncPosition(0);
    	Robot.robotmap.BLSRX.setEncPosition(0);
    	openServos = new CG_OpenServos();
    	openServos.start();
    	setTimeout(14.9);
    	}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double rEnc = Robot.robotmap.BRSRX.getEncPosition();
     	double lEnc = -Robot.robotmap.BLSRX.getEncPosition();
    	
     	if(this.timeSinceInitialized() < 2.0)
    	{
        	Robot.shooter.SpinFlywheel(-2765); //2780
        	Robot.robotmap.BLSRX.setEncPosition(0);
        	Robot.robotmap.BRSRX.setEncPosition(0);
	    	
	    }
    	else if(this.timeSinceInitialized() > 2.0 && this.timeSinceInitialized() < 10)
    	{
    		Robot.shooter.PulseFeeder();
    		System.out.println(" Shot V " + Robot.robotmap.ShooterMotor.getEncVelocity());
	    	
    	}
       	else
    	{
       		
       		Robot.shooter.AllOff();
       		if(lEnc < 600)
       		{
       			Robot.drivetrain.tankDrive(-0.5, 0.0);
       		}
       		else
       		{
       			if(lEnc < 8000)
       			{
       				Robot.drivetrain.tankDrive(-0.75, -0.75);
       			}
       			else
       			{
       				Robot.drivetrain.tankDrive(0.0, 0.0);
       			}
       		}
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
