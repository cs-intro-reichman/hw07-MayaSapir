/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
		StdDraw.clear(StdDraw.WHITE);
        StdDraw.setPenColor(StdDraw.BLACK);

        double h = Math.sqrt(3) / 2.0;
        sierpinski(n, 0.0, 1.0, 0.5, 0.0, 0.0, h);

	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		//if (n == 0) return; // Base case
		 if (n <= 0) {
            StdDraw.line(x1, y1, x2, y2);
            StdDraw.line(x1, y1, x3, y3);
            StdDraw.line(x3, y3, x2, y2);
            return;
		 }
			//midpoints
		double x12 = (x1 + x2) / 2.0, y12 = (y1 + y2) / 2.0;
        double x23 = (x2 + x3) / 2.0, y23 = (y2 + y3) / 2.0;
        double x31 = (x3 + x1) / 2.0, y31 = (y3 + y1) / 2.0;

		sierpinski(n - 1, x1,  x12, x31, y1,  y12, y31); // bottom-left
        sierpinski(n - 1, x12, x2,  x23, y12, y2,  y23); // bottom-right
        sierpinski(n - 1, x31, x23, x3,  y31, y23, y3 ); // top


	}
}
