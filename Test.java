public class Test {
    public static void main(String[] args) {
        int totalTests = 13;
        int numFails = 0;

        // Circle tests
        numFails += testCircleProperties();
        numFails += testCircleEncloses();
        numFails += testCircleCollidesWith();

        // Rectangle tests
        numFails += testRectangleProperties();

        // Physics tests
        numFails += testPhysicsEngine();

        if (numFails == 0) {
            System.out.println("All Tests Passed!");
        } else {
            int numPassed = totalTests - numFails;
            double passPercent = 100 * ((double) numPassed / totalTests);
            System.out.printf("%d of %d tests are passing (%.2f%%)\n", numPassed, totalTests, passPercent);
        }
    }

    /**
     * Test getters and setters of the Circle class
     * @return  The number of failed tests
     */
    public static int testCircleProperties() {
        int numFails = 0;

        Point p = new Point(1, 0);
        int radius = 2;
        Circle c = new Circle(p, radius);

        // Test center point
        try {
            if (!c.getCenter().equals(p)) {
                numFails += 1;
                System.out.println("ERROR - Circle::getPoint is broken");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Test radius
        try {
            if (c.getRadius() != radius) {
                numFails += 1;
                System.out.println("ERROR - Circle::getRadius is broken");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        return numFails;
    }

    /**
     * Test Circle::encloses
     * @return  The number of failed tests
     */
    public static int testCircleEncloses() {
        int numFails = 0;

        Circle c = new Circle(new Point(0, 0), 1);

        // Center point
        try {
            if (!c.encloses(new Point(0, 0))) {
                numFails += 1;
                System.out.println("ERROR: A circle should enclose it's center");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Interior point
        try {
            if (!c.encloses(new Point(0, 0))) {
                numFails += 1;
                System.out.println("ERROR: A circle should enclose a point within it's radius");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Edge point
        try {
            if (!c.encloses(new Point(0, 0))) {
                numFails += 1;
                System.out.println("ERROR: A circle should enclose a point on it's perimeter");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Exterior point
        try {
            if (!c.encloses(new Point(0, 0))) {
                numFails += 1;
                System.out.println("ERROR: A circle should not enclose a point beyond it's perimeter");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        return numFails;
    }

    /**
     * Test Circle::collidesWith
     * @return  The number of failed tests
     */
    public static int testCircleCollidesWith() {
        int numFails = 0;

        Circle c1 = new Circle(new Point(0, 0), 1);
        Circle c2 = new Circle(new Point(1, 1), 1);

        // Test collision
        try {
            if (!c1.collidesWith(c2)) {
                numFails += 1;
                System.out.println("ERROR: Circle overlap failed to detect overlap between two circles");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Test collision going the other way
        try {
            if (!c2.collidesWith(c1)) {
                numFails += 1;
                System.out.println("ERROR: Circle overlap is not communative");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        Circle c3 = new Circle(new Point(2, 2), 1);

        // Test for no collision
        try {
            if (c1.collidesWith(c3)) {
                numFails += 1;
                System.out.println("ERROR: Circle overlap falsely reported an overlap");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        return numFails;
    }

    /**
     * Test getters and setters of the Rectangle class
     */
    public static int testRectangleProperties() {
        int numFails = 0;

        Point p = new Point(2, 1);
        int height = 2;
        int width = 3;
        Rectangle rect = new Rectangle(p, height, width);

        // Test top-left corner
        try {
            if (!rect.getTopLeftCorner().equals(p)) {
                numFails += 1;
                System.out.println("ERROR - Rectangle::getTopLeftCorner is broken");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Test height
        try {
            if (rect.getHeight() != height) {
                numFails += 1;
                System.out.println("ERROR - Rectangle::getHeight is broken");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        // Test width
        try {
            if (rect.getWidth() != width) {
                numFails += 1;
                System.out.println("ERROR - Rectangle::getWidth is broken");
            }
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            numFails += 1;
        }

        return numFails;
    }

    /**
     * Test the forces calculated by PhysicsEngine
     * @return  The number of failed tests
     */
    public static int testPhysicsEngine() {
        // Define what the forces should be
        Vector[] expectedForces = new Vector[]{
            new Vector(-Math.sqrt(2)/2, -Math.sqrt(2)/2),
            new Vector(0.0, 0.0),
            new Vector(Math.sqrt(2)/2, Math.sqrt(2)/2)
        };

        // Define the shapes which exist
        Circle[] circles = new Circle[]{
            new Circle(new Point(0, 0), 1),
            new Circle(new Point(5, 2), 1),
            new Circle(new Point(1, 1), 1)
        };
        
        // Get the actual forces calcualted by PhysicsEngine
        Vector[] actualforces;
        try {
            PhysicsEngine pe = new PhysicsEngine(circles);
            actualforces = pe.calcCollisions();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
            return 1;
        }

        // Make sure that the correct number of forces were calculated
        if (actualforces.length != expectedForces.length) {
            System.out.println("ERROR - PhysicsEngine::calcCollisions did not return " + expectedForces.length + " Vectors");
            return 1;
        }

        // Check each actual force calculated by the PhysicsEngine to what the force was excepcted to be
        for (int i = 0; i < expectedForces.length; i++) {
            if (!expectedForces[i].equals(actualforces[i])) {
                Vector actual = actualforces[i];
                Vector expected = expectedForces[i];
                System.out.printf("ERROR - Got %s at index %d from PhysicsEngine::calcCollisions instead of %s\n", actual, i, expected);
                return 1;
            }
        }

        return 0;
    }
}