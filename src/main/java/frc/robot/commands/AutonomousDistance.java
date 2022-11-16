// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import edu.wpi.first.wpilibj2.command.Command;

public class AutonomousDistance extends SequentialCommandGroup {
  private final Drivetrain drivetrain;

  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a
   * specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public AutonomousDistance(Drivetrain drivetrain) {
    this.drivetrain = drivetrain;
    // addCommands(
    //     new TurnDegrees(0, 0, drivetrain),
    //     new DriveDistance(1, 35, drivetrain),
    //     new TurnDegrees(1, 30, drivetrain),
    //     new DriveDistance(1, 25, drivetrain),
    //     new TurnDegrees(-1, 45, drivetrain),
    //     new DriveDistance(1, 20, drivetrain),
    //     new TurnDegrees(-1, 50.2, drivetrain),
    //     new DriveDistance(1, 30, drivetrain));
    addCommands(
                turnAndMove(0, 0, 1, 35),
                turnAndMove(1, 30, 1, 25),
                turnAndMove(-1, 45, 1, 20),
                turnAndMove(-1, 50.2, 1, 30)
              );
  }
  
  private Command turnAndMove (double turnSpeed, double degrees, double driveSpeed, double inches) {
    return new SequentialCommandGroup (
      new TurnDegrees(turnSpeed, degrees, drivetrain), 
      new DriveDistance(driveSpeed, inches, drivetrain)
    );
  }
}