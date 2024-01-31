/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physicsengine;

/**
 *
 * @author User
 */
public class Circle {
    
    public Circle(Point center, double radius) {
        this.center = center;
        this.radiusDoub = radius;
    }

    public Point getCenter() {
        return center;
        // throw new UnsupportedOperationException("Point::getCenter needs to be implemented");
    }

    public double getRadius() {
        return radiusDoub;
        // throw new UnsupportedOperationException("Point::getRadius needs to be implemented");
    }

    /**
     * Indicates if this circle collides/overlaps with another circle
     * @param c The other circle that may overlap with this one
     * @return  True if the other circle collides/overlaps with this circle
     */
    public boolean collidesWith(Circle c) {
        Vector line = this.getCenter().calcVectorTo(c.getCenter()); // Draw a line between the two circles

        Vector radius = line.scale(1/line.length()).scale(this.getRadius()); // Shrink the line to be the radius of the circle

        Point perimeter = this.getCenter().move(radius); // Get a point on the perimeter of the circle

        return c.encloses(perimeter);   // The two shapes collide if this point is inside the other
    }

    /**
     * Indicates if the given point is inside this circle
     * @param p The point which might be inside
     * @return  True if the point is inside
     */
    public boolean encloses(Point p) {
        return this.getCenter().calcVectorTo(p).length() <= this.getRadius();
    }

    /**
     * Indicates the strength of the force exerted on this circle the other circle.
     *
     * Note: This method assumes that the two circles collide/overlap
     * @param c The other circle colliding with this one
     * @return A vector which represents the force being applied to this circle
     */
    public Vector getForceFrom(Circle c) {
        Vector line = c.getCenter().calcVectorTo(this.getCenter());
        return line.scale(1/ line.length());
    }
    
    private Point center;
    private double radiusDoub;
}
