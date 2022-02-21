package main.metamodel;

public class Transition {

	public String event;
	public State target;

	public boolean hasCondition = false;

	public String conditionName;
	public Integer conditionComp;

	public boolean hasOp = false;
	private boolean hasSet = false;
	public String opName = null;
	public int opValue = 0;

	private boolean hasIncr = false;
	private boolean hasDecr = false;

	public ConditionType type = ConditionType.NONE;

	public Object getEvent() {
		return event;
	}

	public State getTarget() {
		return target;
	}

	public boolean hasSetOperation() {
		return hasSet;
	}

	public void setOperation(String string,int value ){
		opName = string;
		opValue = value;
		hasSet = true;
		hasOp = true;
	}

	public boolean hasIncrementOperation() {
		return hasIncr;
	}
	public void incrOperation(String string){
		opName = string;
		hasOp = true;
		hasIncr = true;
	}
	public boolean hasDecrementOperation() {
		return hasDecr;
	}
	public void decrOperation(String string){
		opName = string;
		hasOp = true;
		hasDecr = true;
	}

	public Object getOperationVariableName() {
		return opName;
	}

	public boolean isConditional() {
		return hasCondition;
	}

	public Object getConditionVariableName() {
		return conditionName;
	}

	public Integer getConditionComparedValue() {
		return conditionComp;
	}

	public boolean isConditionEqual() {
		if(type == ConditionType.EQUALS){
			return true;
		}
		return false;
	}

	public boolean isConditionGreaterThan() {
		if(type == ConditionType.GREATER){
			return true;
		}
		return false;
	}

	public boolean isConditionLessThan() {
		if(type == ConditionType.LESS){
			return true;
		}
		return false;
	}

	public boolean hasOperation() {
		return hasOp;
	}

}
