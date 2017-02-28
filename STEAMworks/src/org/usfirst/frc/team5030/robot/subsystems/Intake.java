 package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

static final int intakeHoodPosR = 105;
static final int intakeHoodPosL = 75;
static final int intakeHoodDefaultRight = 80;
static final int intakeHoodDefaultLeft = 100;


	public void IntakeOff()
	{
		Robot.robotmap.intakeBack.set(0.0);
		Robot.robotmap.intakeFront.set(0.0);
		RobotMap.intakeHoodRight.setAngle(intakeHoodDefaultRight);
		RobotMap.intakeHoodLeft.setAngle(intakeHoodDefaultLeft);
	}
	
	public void IntakeIn()
	{
		Robot.robotmap.intakeBack.set(-0.4);
		Robot.robotmap.intakeFront.set(-0.4);
		RobotMap.intakeHoodRight.setAngle(intakeHoodPosR);
		//obot.robotmap.intakeHoodLeft.set
		RobotMap.intakeHoodLeft.setAngle(intakeHoodPosL);
	}
	
	public void IntakeOut()
	{
		Robot.robotmap.intakeBack.set(0.6);
		Robot.robotmap.intakeFront.set(0.6);
		RobotMap.intakeHoodRight.setAngle(intakeHoodPosR);
		RobotMap.intakeHoodLeft.setAngle(intakeHoodPosL);
	}
	

    public void initDefaultCommand() 
    {
        
    	
    	
    }
}

