package main;

import main.metamodel.ConditionType;
import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {

	private Machine machine;
	private State currentState;

	public void run(Machine m) {
		machine = m;
		currentState = machine.initialState;
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String string) {
		Transition t = currentState.getTransitionByEvent(string);
		if(t!=null) {
			if (t.isConditional()) {
				if (t.type == ConditionType.EQUALS) {
					if (machine.ints.get(t.getConditionVariableName()).equals(t.getConditionComparedValue())) {
						runOperation(t);
						currentState = machine.getState(t.target.name);
					}
				}
				if (t.type == ConditionType.LESS) {
					if (machine.ints.get(t.getConditionVariableName()) < t.getConditionComparedValue()) {
						runOperation(t);
						currentState = machine.getState(t.target.name);
					}
				}
				if (t.type == ConditionType.GREATER) {
					if (machine.ints.get(t.getConditionVariableName()) > t.getConditionComparedValue()) {
						runOperation(t);
						currentState = machine.getState(t.target.name);
					}
				}

			} else {
				runOperation(t);
				currentState = machine.getState(t.target.name);
			}
		}
		
	}

	private void runOperation(Transition t){
		if(t.hasSetOperation()){
			machine.ints.put(t.opName,t.opValue);
		}
		if(t.hasIncrementOperation()){
			machine.ints.put(t.opName, machine.ints.get(t.opName) + 1);
		}
		if(t.hasDecrementOperation()){
			machine.ints.put(t.opName, machine.ints.get(t.opName) - 1);
		}
	}

	public int getInteger(String string) {
		return machine.ints.get(string);
	}

}
