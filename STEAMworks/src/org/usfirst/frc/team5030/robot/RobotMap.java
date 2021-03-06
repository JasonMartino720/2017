package org.usfirst.frc.team5030.robot;

import edu.wpi.first.wpilibj.Talon;
import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;

public class RobotMap 
{
	//Front Talon in the left transmission ID = 0
	
	public CANTalon FLSRX;
		
		
	//Back Talon in the left transmission ID = 1
		
	public CANTalon BLSRX;
		
		
	//Front Talon in the right transmission ID = 2
		
	public CANTalon FRSRX;
		
		
	//Back Talon in the right transmission ID = 3
		
	public CANTalon BRSRX;
		
		
	//Talon SRX for the shooter motor ID = 4
		
	public CANTalon ShooterMotor;
	
	//Talon SR for the climber
	final int climber = 0;
	public Talon climberMotor = new Talon(climber);
	
	//Talon SR for the front of the intake
	final int intakefront = 1;
	public Talon intakeFront = new Talon(intakefront);
	
	//Talon SR for the back of the intake
	final int intakeback = 2; 
	public Talon intakeBack = new Talon(intakeback);
	
	//Talon SR for motor to feed the shooter
	final int Kicker = 3;
	public Talon KickerMotor = new Talon(Kicker);
	
	//Servo for left intake hood
	public final Servo intakeHoodLeft = new Servo(6);
	
	//Servo for Right intake hood
	public final Servo intakeHoodRight = new Servo(5);
	
	//Servo for Gear Mechanism
	public final Servo gearMechanismServo = new Servo(9);
	
	//Servo for Hopper Actuation
	public final Servo HopperServo = new Servo(7);
	
	int Blender = 3;
	public Relay BlenderMotor = new Relay(Blender);
	
	int Sploosher = 4;
	public Talon SploosherMotor = new Talon(Sploosher);
	
	int GearMech = 8;
	public Talon GearMechMotor = new Talon(GearMech);
	
	public DigitalInput GearMechBottom;
	
	public DigitalInput GearMechTop;
	
	public RobotMap()
	{
		FLSRX = new CANTalon(0);
		BLSRX = new CANTalon(1);
		FRSRX = new CANTalon(2);
		BRSRX = new CANTalon(3);
		ShooterMotor = new CANTalon(4);
		GearMechBottom = new DigitalInput(0);
		GearMechTop = new DigitalInput(1);
	}
	
	
		
	
}
