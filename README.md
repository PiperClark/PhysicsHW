# Collision Detection 

## Goals 

- Use inheritance to reduce code 
- Use polymorphism to reduce code 
- Learn about collision detection and physics engines 

# Description

Simulating physics can be a lot of fun. Scientists have used physics simulators to predict what will happen and they are often used in movies to add effects like fire, smoke, and water. This homework will be centered around a very simple physics engine and focus on designing a system for detecting collisions. This is the kind of system which could eventually be used in a simple 2D platform game. 

## General Requirements

This homework will require no previous physics knowledge, I have already built the "physics" portion of this very simple collision engine. As a result, the calculations requiring vectors and forces are already provided and **should not** be modified. The most advanced mathematics you will need to remember is how to work with rectangles, circles, and points. If you need help, don't hesitate to send me an email. 

There are 4 main coding tasks.

### 1. Finish the `Circle` Class

The Circle class is nearly complete. You will need to fill-in the constructor and any remaining accessor methods. 

Do **NOT** change the code in the following methods 

- `boolean collidesWith(Circle c)`
- `boolean encloses(Point p)`
- `Vector getForceFrom(Circle c)`

### 3. Build the `Rectangle` Class 

In graphics, we usually only store rectangles using just the top-left corner along with its height and width. The other corners and the center of the rectangle can be calculated as needed. Finish making the constructor and accessor methods for these fields. 

The `PhysicsEngine` class uses several of the `Circle` class' methods to perform the needed calculations. Make sure that these methods are also available in the `Rectangle` class. This way the engine can simulate collisions between both shapes. Don't forget that the signature or body of the methods will be different in the `Rectangle` class. 

Hint: If you are having difficulty determining when two rectangles collide/overlap, either use the methods in `Circle` for ideas, try drawing a picture of two overlapping rectangles, or send me an email. 

### 3. Simplify `Circle` and `Rectangle` using Inheritance 

We want `Circle` and `Rectangle` to share some functionality _(collide with each other)_. Our collision engine is not concerned about their exact shape but if they are colliding and what forces they exert on each other. Create a new ADT which generalizes this collision behavior and use inheritance to connect `Circle` and `Rectangle`. 

Begin by examining both `Circle` and `PhysicsEngine` to identify which methods need to exist on both. 

Think carefully about how to represent this new ADT in Java. 

- Should it a concrete or an abstract class? 
- If it is an abstract class, should any of its methods be abstract as well? 

### 4. Upgrade `PhysicsEngine` using Polymorphism 

The `PhysicsEngine` class can only use Circles right now but we want to allow Circles and Rectangles to collide with each other  

Use polymorphism to allow the `PhysicsEngine` to find collisions between Circles, Rectangles, and **any other collision shapes** that may be added in the future. 

## Technical Requirements 

- The code should compile without errors 
- The code should run without errors 
- Create a UML diagram showing how all four ADTs relate to each other. 
    - Be sure to mark any abstract class or method appropriately 

## Submission 

There should be 10 files in the repository:
- Assignment information: `Test.java` and `README.md`
- Physics Engine: `Circle.java`, `Rectangle.java`, `<parent>.java`, and `PhysicsEngine.java`
    - where `<parent>.java` is the name of the new ADT you add. 
- OOP Design: `diagram.png`
- Git Management: `.gitignore`

## Grading

You will be graded in three areas

- Correctness _(5 points)_
    - Code compiles and appropriate use of Java syntax
- Functionality _(5 points)_
    - Meeting the requirements described by the specification
    - `Test.java` can check a few of these requirements, but you are responsible for ensuring all functionality is correct.
- Use of OOP Principles _(5 points)_
    - Correct use and documentation of abstraction, encapsulation, inheritance, and polymorphism.
