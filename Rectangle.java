/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physicsengine;

/**
 *
 * @author User
 */
public class Rectangle {
    public Rectangle(Point topLeft, double height, double width) {
        this.topLeftC = topLeft;
        this.height = height;
        this.width = width;
    }

    public Point getTopLeftCorner() {
        return topLeftC;
        // throw new UnsupportedOperationException("Rectangle:getTopLeftCorner is not implemented yet");
    }

    public double getHeight() {
        return height;
        // throw new UnsupportedOperationException("Rectangle:getHeight is not implemented yet");
    }

    public double getWidth() {
        return width;
        // throw new UnsupportedOperationException("Rectangle:getWidth is not implemented yet");
    }

    // TODO: Add other methods which are required by the PhysicsEngine
    
    private Point topLeftC;
    private double height;
    private double width;
}
