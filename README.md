- ni howdy!
- this is pretty must just my work process
- most text is copy pasted from my docs planner :]
- AI? more like authentic intelligence...

a lot of this was initial planning, so there's obvious differences in the final code

=== process ===
- 

> this is like a general description of what resources i used
> as well as the main problems that i got along the way

> process
- thursday, 11/05
  - what i did: 
    - first i wrote down the basic structure of the code, as inserted at the bottom
    - my approach was to write a similar structure to the driver code
    - constants, subsystems, and robotcontainer 
    - lots of initial mistakes but that's ok :]
    - i held off on writing most of the commands, binding, and methods until i did more research

  - what i did at home:
    - did research on PID and bangbang logic, looked a little at the tuning processes
    - did a lil reading on the motors, looked at sample code for motor subsystems 
    - thought over the structure of the subsystems
    - decided what methods needed to be written for each subsystem

- friday, 11/06
  - changes i made:
    - initially i wanted to create one subsystem for all three motors, but i changed it into two subsytems

   - what i did:
     - added some new constants, i think the motorrotationstoangle
     - created the two subsystems, finished a good chunk but ran into errors detailed below
     - created initial command for the robotcontainer and methods for the subsystem
     - lots of red things :[
    
- saturday, 11/07
  - what i did:
      - mostly debug debug and switch some method logic, lots written below
      - finished writing the pivoter subsystem

> errors
- binding buttons
  - i used a regular ps5, not command controller; so when i tried to bind a specific function to a button, input was not the expected type
  - yesterday, i also tried to bind the commands as part of each individual subsystem (like subsystem1.command1)... that was not very smart.

- commands
  - for a while, i couldn't access the motors i created in the subsystems
  - the suggested fix was to make the motors public, but this is bad practice according to my friend
  - so i made functions in each of the subsystems that returned the motors
 
 - flywheel subsystem
  -  in general, lots of syntax errors for inverting and setting direction of follower motor
  -  i was saving writing commands for last, so i accidentally wrote their shells into the bottom of the flywheel subsystem... again, not smart
  -  my methods variable syntax (for getting current rotation, declaring the new speeds, etc.) was incorrect, so just lots of manual fixing today

- pivoter subsystems
  - similar to flywheel in the motor syntax, variable syntax problems
    
=== requirements ===
- 
- 2: flywheel (follower, leader, reverse directions), and then the pivoter (1 motor controlling)
- don't worry about first wheel sets
- not revmotors, krakens (phoenix software suite)
- pid position control > pivot, bangbang control > flywheels
- create two shooting commands (binding two buttons) > hood goes up to specific angle, flywheel speeds x2

=== general code flow ===
- 
> define flywheel subsystem with leader and follower motors, kind of similar to the drive one
> define a pivot subsystem
> define the shooter constants needed
  - flywheel: 
    - speed tolerance
    - inverted? direction?
  - pivoter: 
    - rotation of motor to angle shift
    - angle tolerance
    - PID constants
  plus specific CAN assignments for both
  - preset speeds and angles
> make commands in robotcontainer
  - each command takes the preset angle and velocities, set each motor value to such
> bind buttons in robotcontainer! yay!

=== subsystem ===
- 
> flywheel subsystem
  - obviously the motor declarations, creation of configuration
  - needs to get the speed of motor and set the rotation of motor, adjust with bangbang logic
> pivoter subsystem
  - same as above, needs to get speed and set rotation of motor, adjust with PID logic

=== PID/bangbang ===
-
> what is pid?
- feedback loop that is used for accurate operation, rather than just bangbang (go 100 or nuthin)

p- proportional: calculates the amount of voltage needed based on error right now
	-  more error, more correction needed, more voltage can afford to use
  - less error, closer to target, need to be more precise (like a braking system)

i- integral: accumulation of past error; more error = more need for correction
  - if the positioning has been off for a long time, more push needed

d - derivative: derivative of error (how fast it’s shrinking), reduces  motor power if needed
  - for example, if quickly moving towards target speed, adds counter voltage to ensure the positioning
  - doesn't overshoot at final location

> what is bangbangbang?
all or nuthin.

