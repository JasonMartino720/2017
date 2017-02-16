 package org.usfirst.frc.team5030.robot.subsystems;

import org.usfirst.frc.team5030.robot.Robot;
import org.usfirst.frc.team5030.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

static final int intakeHoodPosR = 90;
static final int intakeHoodPosL = 90;
static final int intakeHoodDefaultRight = 145;
static final int intakeHoodDefaultLeft = 35;


	public void IntakeOff()
	{
		Robot.robotmap.intakeBack.set(0.0);
		Robot.robotmap.intakeFront.set(0.0);
		RobotMap.intakeHoodRight.setAngle(intakeHoodDefaultRight);
		RobotMap.intakeHoodLeft.setAngle(intakeHoodDefaultLeft);
	}
	
	public void IntakeIn()
	{
		Robot.robotmap.intakeBack.set(0.60);
		Robot.robotmap.intakeFront.set(0.60);
		RobotMap.intakeHoodRight.setAngle(intakeHoodPosR);
		//obot.robotmap.intakeHoodLeft.set
		RobotMap.intakeHoodLeft.setAngle(intakeHoodPosL);
	}
	
	public void IntakeOut()
	{
		Robot.robotmap.intakeBack.set(1.0);
		Robot.robotmap.intakeFront.set(-1.0);
		RobotMap.intakeHoodRight.setAngle(intakeHoodPosR);
		RobotMap.intakeHoodLeft.setAngle(intakeHoodPosL);
	}
	

    public void initDefaultCommand() 
    {
        
    	
    	
    }
}

