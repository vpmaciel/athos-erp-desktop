package erp.aop.util;

import java.awt.Component;
import java.awt.Container;

import javax.swing.Spring;
import javax.swing.SpringLayout;

public class SpringUtilities {

	private static SpringLayout.Constraints getConstraintsForCell(int row, int col, Container parent, int cols) {
		SpringLayout layout = (SpringLayout) parent.getLayout();
		Component c = parent.getComponent(row * cols + col);
		return layout.getConstraints(c);
	}

	public static void makeCompactGrid(Container parent, int rows, int cols, int initialX, int initialY, int xPad,
			int yPad) {
		SpringLayout layout;
		try {
			layout = (SpringLayout) parent.getLayout();
		} catch (ClassCastException exc) {
			System.err.println("The first argument to makeCompactGrid must use SpringLayout.");
			return;
		}
		Spring x = Spring.constant(initialX);
		for (int c = 0; c < cols; ++c) {
			int r;
			Spring width = Spring.constant(0);
			for (r = 0; r < rows; ++r) {
				width = Spring.max(width, SpringUtilities.getConstraintsForCell(r, c, parent, cols).getWidth());
			}
			for (r = 0; r < rows; ++r) {
				SpringLayout.Constraints constraints = SpringUtilities.getConstraintsForCell(r, c, parent, cols);
				constraints.setX(x);
				constraints.setWidth(width);
			}
			x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
		}
		Spring y = Spring.constant(initialY);
		for (int r = 0; r < rows; ++r) {
			int c2;
			Spring height = Spring.constant(0);
			for (c2 = 0; c2 < cols; ++c2) {
				height = Spring.max(height, SpringUtilities.getConstraintsForCell(r, c2, parent, cols).getHeight());
			}
			for (c2 = 0; c2 < cols; ++c2) {
				SpringLayout.Constraints constraints = SpringUtilities.getConstraintsForCell(r, c2, parent, cols);
				constraints.setY(y);
				constraints.setHeight(height);
			}
			y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
		}
		SpringLayout.Constraints pCons = layout.getConstraints(parent);
		pCons.setConstraint("South", y);
		pCons.setConstraint("East", x);
	}

	public static void makeGrid(Container parent, int rows, int cols, int initialX, int initialY, int xPad, int yPad) {
		SpringLayout layout;
		int i;
		SpringLayout.Constraints cons;
		try {
			layout = (SpringLayout) parent.getLayout();
		} catch (ClassCastException exc) {
			System.err.println("The first argument to makeGrid must use SpringLayout.");
			return;
		}
		Spring xPadSpring = Spring.constant(xPad);
		Spring yPadSpring = Spring.constant(yPad);
		Spring initialXSpring = Spring.constant(initialX);
		Spring initialYSpring = Spring.constant(initialY);
		int max = rows * cols;
		Spring maxWidthSpring = layout.getConstraints(parent.getComponent(0)).getWidth();
		Spring maxHeightSpring = layout.getConstraints(parent.getComponent(0)).getWidth();
		for (i = 1; i < max; ++i) {
			cons = layout.getConstraints(parent.getComponent(i));
			maxWidthSpring = Spring.max(maxWidthSpring, cons.getWidth());
			maxHeightSpring = Spring.max(maxHeightSpring, cons.getHeight());
		}
		for (i = 0; i < max; ++i) {
			cons = layout.getConstraints(parent.getComponent(i));
			cons.setWidth(maxWidthSpring);
			cons.setHeight(maxHeightSpring);
		}
		SpringLayout.Constraints lastCons = null;
		SpringLayout.Constraints lastRowCons = null;
		for (int i2 = 0; i2 < max; ++i2) {
			SpringLayout.Constraints cons2 = layout.getConstraints(parent.getComponent(i2));
			if (i2 % cols == 0) {
				lastRowCons = lastCons;
				cons2.setX(initialXSpring);
			} else {
				cons2.setX(Spring.sum(lastCons.getConstraint("East"), xPadSpring));
			}
			if (i2 / cols == 0) {
				cons2.setY(initialYSpring);
			} else {
				cons2.setY(Spring.sum(lastRowCons.getConstraint("South"), yPadSpring));
			}
			lastCons = cons2;
		}
		SpringLayout.Constraints pCons = layout.getConstraints(parent);
		pCons.setConstraint("South", Spring.sum(Spring.constant(yPad), lastCons.getConstraint("South")));
		pCons.setConstraint("East", Spring.sum(Spring.constant(xPad), lastCons.getConstraint("East")));
	}

	public static void printSizes(Component c) {
		System.out.println("minimumSize = " + c.getMinimumSize());
		System.out.println("preferredSize = " + c.getPreferredSize());
		System.out.println("maximumSize = " + c.getMaximumSize());
	}
}
