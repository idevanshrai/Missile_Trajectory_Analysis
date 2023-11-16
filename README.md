# Missile_Trajectory_Analysis
This project simulates the process of repeated attempts to hit a target with a projectile. The goal is to shoot the projectile within a 1-foot distance from the target since such a short miss is accepted as a hit.


We constructted a Java program that
• Can determine the trajectory data of a projectile for a given initial velocity and a launch angle, in particular for an initial choice of a 45-degree angle;
can check whether the initial attempt is a launch angle of 45 degrees. If the first attempt is not at the launch angle of 45 degrees, the window as shown in Figure 5a displays the information, and then the program exits. Then restarted with a launch angle of 45;
• Can check if the shot of the initial attempt falls short of the target with less than -1 foot (such as target missed by -1.1, -25.0, -154.55, etc.); if so, the process terminated and then restarted with an increased initial velocity. Note that for any initial velocity, the longest range is attained if the launch angle is 45 degrees;
• Can determine the error of a shot (error = projectile range - distance to target);
• Can check if the error is less than 1 foot in absolute value; if so, the user is notified about the result and the process terminates. That is, the error is between (-1, 1);
• can offer the user four chances to modify the launch angle and try to hit the target; can keep track of the smallest error produced by the subsequent attempts; the best result is reported to the user.
