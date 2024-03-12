package src.classes;

import java.util.List;
import java.util.ArrayList;

import src.classes.Simulation.Operator;

public class Utilities {
	/**
	 * Converts a Operator enum value to its corresponding string
	 * representation.
	 *
	 * @param operator the Operator value to convert
	 * @return the string representation of the operator
	 * @throws RuntimeException if the operator is invalid
	 */
	static public String operator_to_string(Operator operator) {
		switch (operator) {
			case Operator.UP:
				return "UPPER";
			case Operator.LEFT:
				return "LEFT";
			case Operator.BOTTOM:
				return "BOTTOM";
			case Operator.RIGHT:
				return "RIGHT";
			case null:
				return "";
			default:
				throw new RuntimeException("Error: invalid operator");
		}
	}

	/**
	 * Returns the opposite operator of the given operator.
	 *
	 * @param operator The operator for which to find the opposite.
	 * @return the opposite operator.
	 * @throws RuntimeException if the operator is invalid.
	 */
	static public Operator get_opposite_operator(Operator operator) {
		switch (operator) {
			case Operator.UP:
				return Operator.BOTTOM;
			case Operator.LEFT:
				return Operator.RIGHT;
			case Operator.BOTTOM:
				return Operator.UP;
			case Operator.RIGHT:
				return Operator.LEFT;
			case null:
				return null;
			default:
				throw new RuntimeException("Error: invalid operator");
		}
	}

	/**
	 * Returns a list of operators representing the sequence of operations performed from the given node to its root.
	 *
	 * @param node The node from which to trace the performed operations.
	 * @return a list of operators representing the performed operations.
	 */
	static public List <Operator> get_performed_operations(Node node) {
		List <Operator> operations = new ArrayList <>();
		operations.add(node.get_operator());
		Node parent = node.get_parent();

		while (parent != null) {
			operations.add(0, parent.get_operator());
			parent = parent.get_parent();
		}

		return operations;
	}
}
