/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.physicsengine;

/**
 *
 * @author User
 */

import java.util.Objects;

public class Vector {
    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double direction() {
        return Math.atan2(this.y, this.x);
    }

    public double length() {
        return Math.sqrt( (this.x * this.x) + (this.y * this.y) );
    }

    public Vector scale(double s) {
        return new Vector(this.x * s, this.y * s);
    }

    public Vector plus(Vector v) {
        return new Vector(this.x + v.x, this.y + v.y);
    }

    @Override
    public String toString() {
        return String.format("<%.2f, %.2f>", this.x, this.y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Vector)) {
            return false;
        }

        Vector that = (Vector) o;

        double dirError = this.direction() - that.direction();
        double lenError = this.length() - that.length();

        return Math.abs(dirError) < 0.001 && Math.abs(lenError) < 0.001;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    private double x;
    private double y;
}

