package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.OI;
import org.usfirst.frc.team5030.robot.Robot;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team5030.robot.commands.FlywheelOff;

/**
 *
 */
public class Shooter extends Subsystem {

	
	public void AllOff()
    {
    	Robot.robotmap.ShooterMotor.set(0.0);
    	Robot.robotmap.feederMotor.set(0.0);
    	Robot.robotmap.SploosherMotor.set(0.0);
    }
    
    public void SpinFlywheel()
    {
    	Robot.robotmap.ShooterMotor.set(-0.5);
    }
    
    public void PulseFeeder()
    {
    
    	Robot.robotmap.feederMotor.set(-0.5);
    	/*
    	Robot.timer.delay(0.25);
    	Robot.robotmap.feederMotor.set(0.0);
    	Robot.timer.delay(0.25);
    	*/
    	Robot.robotmap.SploosherMotor.set(-1.0);
    	
    }
    
    public void FlywheelOff()
    {
    	Robot.robotmap.ShooterMotor.set(0.0);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new FlywheelOff());
    }
}


