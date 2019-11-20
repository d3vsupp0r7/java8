package org.lba.dp.base.creational.prototype;

public class Client {
	
	public static Prototype anOperation( Prototype prototype, String behaviorLiteral, int behaviorInteger) throws CloneNotSupportedException{
		
		Prototype prototypeCloned = prototype.cloneItself();
		
		/*An example cloning only BehaviorInteger*/
		prototypeCloned.setBehavior(behaviorLiteral, prototype.getBehaviorInteger());
		/**/
		
		return prototypeCloned;
	}

}
