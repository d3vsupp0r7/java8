package org.lba.dp.base.creational.prototype;

public class MainAppPrototype {

	public static void main(String[] args) throws CloneNotSupportedException {

		Prototype prototype = new ConcretePrototype();
		prototype.setBehavior("literalBehaviorA", 10);
		System.out.println("First prototype: " + prototype.toString());
		/*Note: The difference between passed parameter and result.
		 * The logic to manage Prototype specific changes will be applied into 
		 * ConcretePrototype*/
		Prototype prototypeCloned = Client.anOperation(prototype, "behaviorLiteralB", 15);
		System.out.println("PrototypeCloned out: " + prototypeCloned.toString());
		
		/**/
		System.out.println("** PrototypeB Example **");
		Prototype prototypeB = new ConcretePrototypeB();
		prototypeB.setBehavior("literalBehaviorAPrototypeB", 10);
		System.out.println("First prototype: " + prototypeB.toString());
		Prototype prototypeBCloned = Client.anOperation(prototypeB, "behaviorLiteralBPrototypeB", 10);
		System.out.println("PrototypeClonedB out: " + prototypeBCloned.toString());
		
	}

}
