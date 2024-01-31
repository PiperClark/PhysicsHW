/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physicsengine;

/**
 *
 * @author User
 */
public abstract class Shape {
    public Shape(Point location) {
        this.location = location;
    }

    public abstract void getEdge();
    
    public abstract boolean encloses(Point p);
    public abstract boolean collidesWith(Shape s);

    public Point getLocation() {
        return location;
    }

    private Point location;
}
