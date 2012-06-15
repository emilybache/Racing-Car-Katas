package tddmicroexercises.tirepressuremonitoringsystem;

import java.util.Stack;

public class StubSensor implements ISensor {

	private Stack<Double> values = new Stack<Double>();

	public double popNextPressurePsiValue() {
		return values.pop();
	}

	public void pushPsiValue(double d) {
		values.push(d);
		
	}

}
