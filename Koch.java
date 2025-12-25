/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        /*
		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		curve(Integer.parseInt(args[0]),
			  Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		      Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		*/

		/*
		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));
		*/
		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0) {
		StdDraw.line(x1, y1, x2, y2);
		return;
		}
		// Points that divide the segment into thirds
        double xLeft  = x1 + (x2 - x1) / 3.0;
        double yLeft  = y1 + (y2 - y1) / 3.0;

        double xRight = x2 - (x2 - x1) / 3.0;
        double yRight = y2 - (y2 - y1) / 3.0;

		// Midpoint of the middle segment
        double midX = (xLeft + xRight) / 2.0;
        double midY = (yLeft + yRight) / 2.0;

		double offset = Math.sqrt(3) / 6.0;
        double xPeak = midX + offset * (yLeft - yRight);
        double yPeak = midY + offset * (xRight - xLeft);

		// Recursive calls on the 4 new segments
        curve(n - 1, x1, y1, xLeft, yLeft);
        curve(n - 1, xLeft, yLeft, xPeak, yPeak);
        curve(n - 1, xPeak, yPeak, xRight, yRight);
        curve(n - 1, xRight, yRight, x2, y2);

		
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(-0.2, 1.2);
		StdDraw.setXscale(-0.2, 1.2);
		// Draws a Koch snowflake of depth n
		double x1 = 0.1, y1 = 0.1;
        double x2 = 1.0, y2 = 0.1;
        double x3 = 0.55, y3 = 0.1 + 0.9 * (Math.sqrt(3) / 2.0);

		curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1); 
	}
}
