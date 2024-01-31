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
    public Point getCenter(){
        return location;
    }
    public abstract double getRadius();

    //public abstract void getEdge();
    
    
    public  boolean collidesWith(Shape s) {
        
    }

    public abstract boolean encloses(Point p);
    

    private Point location;
}
