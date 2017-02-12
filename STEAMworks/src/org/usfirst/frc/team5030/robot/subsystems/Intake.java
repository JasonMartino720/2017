 package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

static final int intakeHoodDefault = 0;
static final int intakeHoodToHopper = 45;


	public void IntakeOff()
	{
		Robot.robotmap.intakeBack.set(0.0);
		Robot.robotmap.intakeFront.set(0.0);
		RobotMap.intakeHood.setAngle(intakeHoodDefault);
	}
	
	public void IntakeIn()
	{
		Robot.robotmap.intakeBack.set(0.75);
		Robot.robotmap.intakeFront.set(0.75);
		RobotMap.intakeHood.setAngle(intakeHoodToHopper);
	}
	
	public void IntakeOut()
	{
		Robot.robotmap.intakeBack.set(1.0);
		Robot.robotmap.intakeFront.set(-1.0);
		RobotMap.intakeHood.setAngle(intakeHoodDefault);
	}
	

    public void initDefaultCommand() 
    {
        
    	
    	
    }
}

