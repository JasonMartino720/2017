package org.usfirst.frc.team5030.robot;


import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Talon;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Servo;

public class RobotMap 
{
	//Front Talon in the left transmission ID = 0
	
	public static CANTalon FLSRX;
		
		
	//Back Talon in the left transmission ID = 1
		
	public static CANTalon BLSRX;
		
		
	//Front Talon in the right transmission ID = 2
		
	public static CANTalon FRSRX;
		
		
	//Back Talon in the right transmission ID = 3
		
	public static CANTalon BRSRX;
		
		
	//Talon SRX for the shooter motor ID = 4
		
	public static CANTalon ShooterMotor;
	
	//Talon SR for the climber
	int climber = 0;
	public Talon climberMotor = new Talon(climber);
	
	//Talon SR for the front of the intake
	int intakefront = 2;
	public Talon intakeFront = new Talon(intakefront);
	
	//Talon SR for the back of the intake
	int intakeback = 3; 
	public Talon intakeBack = new Talon(intakeback);
	
	//Talon SR for motor to feed the shooter
	int feeder = 1;
	public Talon feederMotor = new Talon(feeder);
	
	//Servo for intake hood
	public static final Servo intakeHood = new Servo(4);
	
	//Servo for Gear Mechanism
	public static final Servo gearMechanism = new Servo(5);
	
	//Servo for Hopper Actuation
	public static final Servo Hopper = new Servo(6);
	
	//Temporary Motor for Shooter on Talon SE
	int tempShooter = 7;
	public Talon TempShooter = new Talon(tempShooter);
	
	public RobotMap()
	{
		FLSRX = new CANTalon(0);
		BLSRX = new CANTalon(1);
		FRSRX = new CANTalon(2);
		BRSRX = new CANTalon(3);
		ShooterMotor = new CANTalon(4);
	}
	
	
		
	
}
