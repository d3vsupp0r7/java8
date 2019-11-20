package org.lba.dp.base.creational.prototype;

public abstract class Prototype implements Cloneable {

	/**/
	public abstract String getBehaviorLiteral();
	public abstract int getBehaviorInteger();
	
	public abstract void setBehavior(String literalBehavior, int numberBehavior);
	
	
	/**/
	public Prototype cloneItself() throws CloneNotSupportedException {
		Prototype prototype = (Prototype)super.clone();
		return prototype;
	}
}
