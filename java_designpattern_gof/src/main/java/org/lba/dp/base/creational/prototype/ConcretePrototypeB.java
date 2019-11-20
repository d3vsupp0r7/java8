package org.lba.dp.base.creational.prototype;

public class ConcretePrototypeB extends Prototype {

	private String behaviorLiteral;
	private int behaviorInteger;
	
	@Override
	public String getBehaviorLiteral() {
		return behaviorLiteral;
	}

	@Override
	public int getBehaviorInteger() {
		return behaviorInteger;
	}

	@Override
	public void setBehavior(String literalBehavior, int numberBehavior) {

		this.behaviorLiteral = literalBehavior;
		this.behaviorInteger = numberBehavior + 5;
	}

	@Override
	public String toString() {
		return "ConcretePrototypeB [behaviorLiteral=" + behaviorLiteral + ", behaviorInteger=" + behaviorInteger + "]";
	}
	
	

}
