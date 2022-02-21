package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Machine {

	public ArrayList<State> states = new ArrayList<main.metamodel.State>();
	public State initialState;

	public HashMap<String, Integer> ints = new HashMap<String, Integer>();

	public List<State> getStates() {
		return states;
	}

	public State getInitialState() {
		return initialState;
	}

	public State getState(String string) {
		for (State s: states) {
			if(s.getName().equals(string)){
				return s;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return ints.size();
	}

	public boolean hasInteger(String string) {
		if(ints.containsKey(string)){
			return true;
		}
		return false;
	}

}
