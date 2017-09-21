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
public class ShootandGearRed extends Command {

	CommandGroup openServos;
	boolean flag1 = false;
	
    public ShootandGearRed() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
        requires(Robot.shooter);
        requires(Robot.gearmechanism);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.robotmap.ShooterMotor.changeControlMode(TalonControlMode.Speed);
    	Robot.robotmap.ShooterMotor.setNominalClosedLoopVoltage(12.0);
    	Robot.robotmap.ShooterMotor.reverseSensor(true);
    	Robot.robotmap.ShooterMotor.setP(0.65); // 0.25
    	Robot.robotmap.ShooterMotor.setI(0.0001);
    	Robot.robotmap.ShooterMotor.setD(4.0);
    	Robot.robotmap.ShooterMotor.setF(0.10);//0.129
    	Robot.robotmap.ShooterMotor.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BLSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	Robot.robotmap.BRSRX.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    	//Robot.robotmap.BLSRX.reverseOutput(true);
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
    	
    	if(this.timeSinceInitialized() < 1.25)
    	{
        	Robot.shooter.SpinFlywheel(-3100); //2780
        	
	    }
      	else if(this.timeSinceInitialized() > 1.25 && this.timeSinceInitialized() < 5.0)
    	{
    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		Robot.shooter.PulseFeeder();
    		System.out.println("Shooter Velocity " + Robot.robotmap.ShooterMotor.getEncVelocity());
	    	
    	}
    	else
    	{
    		Robot.shooter.AllOff();
    		if(lEnc < 7930)
    		{
    			Robot.drivetrain.tankDrive(-0.73, -0.85);
    		}
    		else
    		{
    				Robot.drivetrain.tankDrive(0.0, 0.0);		    	
    		    	if((rEnc < 12600 && lEnc < 12600) && !flag1)
    		    	{
    		    		Robot.drivetrain.tankDrive(-0.3, -0.70);
    		    	}
    		    	else
    		    	{
    		    		
    		    		if(!flag1)
    		    		{
    		    		Robot.drivetrain.tankDrive(-0.3, -0.3);
    		    		Timer.delay(0.5);
    		    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		    		Robot.gearmechanism.GearMechJoyControl(0.6);
    		    		Timer.delay(0.75);    
    		    		Robot.gearmechanism.GearMechJoyControl(0.0);
    		    		Robot.drivetrain.tankDrive(0.5, 0.5);
    		    		Timer.delay(1.0);
    		    		Robot.drivetrain.tankDrive(0.0, 0.0);
    		    		flag1 = true;
    		    		
    		    		}
    		    		else
    		    		{
    		    			Robot.drivetrain.tankDrive(0.0, 0.0);
    		    			Robot.gearmechanism.GearMechJoyControl(0.0);
    		    		}
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
