package main;

import main.metamodel.ConditionType;
import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class StateMachine {

	private Machine tempMachine = new Machine();
	private State latestState = null;
	private Transition latestTransition = null;

	public Machine build() {
		return tempMachine;
	}

	public StateMachine state(String string) {
		State newState = new State();
		newState.name = string;
		tempMachine.states.add(newState);
		latestState = newState;
		return this;
	}

	public StateMachine initial() {
		tempMachine.initialState = latestState;
		return this;
	}

	public StateMachine when(String string) {
		Transition newTrans = new Transition();
		newTrans.event = string;
		latestState.transitions.add(newTrans);
		latestTransition = newTrans;
		return this;
	}

	public StateMachine to(String string) {
		State newState = new State();
		newState.name = string;
		latestTransition.target = newState;
		return this;
	}

	public StateMachine integer(String string) {
		tempMachine.ints.put(string,0);
		return this;
	}

	public StateMachine set(String string, int i) {
		latestTransition.setOperation(string, i);
		return this;
	}

	public StateMachine increment(String string) {
		latestTransition.incrOperation(string);
		return this;
	}

	public StateMachine decrement(String string) {
		latestTransition.decrOperation(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		latestTransition.hasCondition = true;
		latestTransition.conditionName = string;
		latestTransition.conditionComp = i;
		latestTransition.type = ConditionType.EQUALS;
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		latestTransition.hasCondition = true;
		latestTransition.conditionName = string;
		latestTransition.conditionComp = i;
		latestTransition.type = ConditionType.GREATER;
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		latestTransition.hasCondition = true;
		latestTransition.conditionName = string;
		latestTransition.conditionComp = i;
		latestTransition.type = ConditionType.LESS;
		return this;
	}

}
