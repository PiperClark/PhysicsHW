public class PhysicsEngine {
    public PhysicsEngine(Circle[] circles) {
        this.circles = circles;
    }

    /**
     * Calculates the forces being applied to all Circles.
     *
     * The returned array is parallel to the array provided to the constructor. So, the Vector at index "i" represents
     * the force being applied to the Circle at index "i". If the index is null, this means that no force is being
     * applied to the Circle.
     *
     * @return An array of Vectors parallel to the Circles array representing the forces on each circle.
     */
    public Vector[] calcCollisions() {
        Vector[] forces = new Vector[this.circles.length];

        for (int i = 0; i < this.circles.length; i++) {
            Circle ci = this.circles[i];
            forces[i] = new Vector(0.0, 0.0);

            for (int j = 0; j < this.circles.length; j++) {
                if (i == j) {
                    continue;   // Circles can't collide with themselves
                }

                Circle cj = this.circles[j];

                if (ci.collidesWith(cj)) {
                    forces[i] = forces[i].plus( ci.getForceFrom(cj) );
                }
            }
        }

        return forces;
    }

    private Circle[] circles;
}
