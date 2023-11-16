/*
* Prakhar Verma
* CS 16000-01 – 03, Fall Semester 2023 
* Project 1: Compute the Projectile Motion
*
* This program simulates projectile motion given an initial velocity, distance to target, 
* and launch angle. It calculates and displays trajectory data. If the first shot misses, 
* it allows 4 more attempts to hit the target.
*/

import javax.swing.JOptionPane;
import java.lang.Math;

public class Projectile {

	/**
	 * The main method
	 * 
	 * @param
	 */
	public static void main(String[] args) {

		// Defining variable
		final double GRAVITATION = 32;
		double distanceToTarget;
		double initialVelocity;
		double launchAngle;
		double radian;
		double flightTime;
		double highestPoint;
		double distanceTraveled;
		double error;
		double minError;
		String attempt = ""; // For the first attempt
		String title = "Modified Input";

		// Input the initial detail from user
		distanceToTarget = Double.parseDouble(JOptionPane.showInputDialog("Enter distance to target in feet:"));
		initialVelocity = Double.parseDouble(JOptionPane.showInputDialog("Enter initial velocity in feet/sec:"));
		launchAngle = Double.parseDouble(JOptionPane
				.showInputDialog("Enter launch angle in degrees \n The initial choice must be a 45-degree angle.:"));

		if (launchAngle != 45) {
			JOptionPane.showMessageDialog(null,
					"Failed to enter 45 degrees on 1st attempt. \nRestart the program with an initial launch angle of 45 degrees!",
					"Error", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// Calculating the error using the formula provided.
		radian = (launchAngle * Math.PI) / 180;
		flightTime = (2 * initialVelocity * Math.sin(radian)) / GRAVITATION;
		highestPoint = (initialVelocity * Math.sin(radian)) * (flightTime / 2)
				- (0.5 * GRAVITATION * Math.pow(flightTime / 2, 2));
		distanceTraveled = (initialVelocity * Math.cos(radian)) * flightTime;
		error = distanceTraveled - distanceToTarget;
		minError = Math.abs(error);

		// Output for 45 degrees
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);
		errorAnalysis(attempt, error, launchAngle);

		if (error < 0) {
			JOptionPane.showMessageDialog(null,
					"Target is too far. Restart the program with a greater initial velocity.", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		// Second Attempt

		launchAngle = reenterLaunchAngle(attempt);
		radian = Math.toRadians(launchAngle);
		flightTime = (2 * initialVelocity * Math.sin(radian)) / GRAVITATION;
		highestPoint = (initialVelocity * Math.sin(radian)) * (flightTime / 2)
				- (0.5 * GRAVITATION * Math.pow(flightTime / 2, 2));
		distanceTraveled = (initialVelocity * Math.cos(radian)) * flightTime;
		error = distanceTraveled - distanceToTarget;
		minError = Math.min(minError, Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		if (Math.abs(error) <= 1) {
			System.out.println ("Target is hit within an error of 1 foot! \nThe program terminates.");

			JOptionPane.showMessageDialog(null, "Target is hit within an error of 1 foot!", "The program terminates.",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		attempt = "Second Attempt:";
		errorAnalysis(attempt, error, launchAngle);

		// Third Attempt
		launchAngle = reenterLaunchAngle(attempt);
		radian = Math.toRadians(launchAngle);
		flightTime = (2 * initialVelocity * Math.sin(radian)) / GRAVITATION;
		highestPoint = (initialVelocity * Math.sin(radian)) * (flightTime / 2)
				- (0.5 * GRAVITATION * Math.pow(flightTime / 2, 2));
		distanceTraveled = (initialVelocity * Math.cos(radian)) * flightTime;
		error = distanceTraveled - distanceToTarget;
		minError = Math.min(minError, Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		if (Math.abs(error) <= 1) {
			System.out.println ("Target is hit within an error of 1 foot! \nThe program terminates.");

			JOptionPane.showMessageDialog(null, "Target is hit within an error of 1 foot!", "The program terminates.",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		attempt = "Third Attempt:";
		errorAnalysis(attempt, error, launchAngle);

		// Fourth Attempt
		launchAngle = reenterLaunchAngle(attempt);
		radian = Math.toRadians(launchAngle);
		flightTime = (2 * initialVelocity * Math.sin(radian)) / GRAVITATION;
		highestPoint = (initialVelocity * Math.sin(radian)) * (flightTime / 2)
				- (0.5 * GRAVITATION * Math.pow(flightTime / 2, 2));
		distanceTraveled = (initialVelocity * Math.cos(radian)) * flightTime;
		error = distanceTraveled - distanceToTarget;
		minError = Math.min(minError, Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		if (Math.abs(error) <= 1) {
			System.out.println ("Target is hit within an error of 1 foot! \nThe program terminates.");

			JOptionPane.showMessageDialog(null, "Target is hit within an error of 1 foot!", "The program terminates.",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}

		attempt = "Fourth Attempt:";
		errorAnalysis(attempt, error, launchAngle);

		// Fifth Attempt
		launchAngle = reenterLaunchAngle(attempt);
		radian = Math.toRadians(launchAngle);
		flightTime = (2 * initialVelocity * Math.sin(radian)) / GRAVITATION;
		highestPoint = (initialVelocity * Math.sin(radian)) * (flightTime / 2)
				- (0.5 * GRAVITATION * Math.pow(flightTime / 2, 2));
		distanceTraveled = (initialVelocity * Math.cos(radian)) * flightTime;
		error = distanceTraveled - distanceToTarget;
		minError = Math.min(minError, Math.abs(error));
		trajectoryDataReport(initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		if (Math.abs(error) <= 1) {
			System.out.println ("Target is hit within an error of 1 foot! \nThe program terminates.");

			JOptionPane.showMessageDialog(null, "Target is hit within an error of 1 foot! \n The program terminates.", "",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null,
					"Your best shot missed the target by " + minError
							+ " feet.\nEnd of 5 attempts. Restart the program and try again.",
					"Result", JOptionPane.INFORMATION_MESSAGE);
		}
		System.exit(0);
	} // End of main method

	/**
	 * 
	 * @param attempt : storing the attempt name
	 * @return
	 */
	public static double reenterLaunchAngle(String attempt) {
		return Double.parseDouble(JOptionPane.showInputDialog(null, "Enter launch angle in degrees", attempt,
				JOptionPane.QUESTION_MESSAGE));
	}

	/**
	 * 
	 * @param initialVelocity-  stores initial velocity
	 * @param launchAngle-      launch angle in degree
	 * @param flightTime-       flight time in second
	 * @param highestPoint-     highest point in feet
	 * @param distanceTraveled- distance travelled in feet
	 * @param error-            error in feet
	 */
	public static void trajectoryDataReport(double initialVelocity, double launchAngle, double flightTime,
			double highestPoint, double distanceTraveled, double error) {

		String trajectory = String.format(
				"Initial velocity: %.2f feet/sec\nLaunch angle: %.2f degrees\n"
						+ "Flight time: %.2f seconds\nMaximum height: %.2f feet\n"
						+ "Distance traveled: %.2f feet\nTarget missed by: %.2f feet",
				initialVelocity, launchAngle, flightTime, highestPoint, distanceTraveled, error);

		String title = "Trajectory Data Report";

		JOptionPane.showMessageDialog(null, trajectory, title, JOptionPane.INFORMATION_MESSAGE);

	}

	/**
	 * 
	 * @param attempt-     attempt name
	 * @param error-       error in feet
	 * @param launchAngle- launch angle in degrees
	 */
	public static void errorAnalysis(String attempt, double error, double launchAngle) {

		if (error > 0) {

			System.out
					.println(attempt + " Shot went beyond the target. Decrease launch angle from " + launchAngle + "!");
			JOptionPane.showMessageDialog(null,
					attempt + " Shot went beyond the target. Decrease launch angle from " + launchAngle, "Error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			System.out.println(
					attempt + " Shot fell short of the target. Increase launch angle from " + launchAngle + "!");
			JOptionPane.showMessageDialog(null,
					attempt + " Shot fell short of target. Increase launch angle from " + launchAngle, "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}// end of class Projectile
