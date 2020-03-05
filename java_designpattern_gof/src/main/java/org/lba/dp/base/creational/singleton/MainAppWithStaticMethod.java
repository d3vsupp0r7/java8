package org.lba.dp.base.creational.singleton;

public class MainAppWithStaticMethod {

	public static void main(String[] args) {

		SingletonWithStaticMethod singletonWithStaticMethod = SingletonWithStaticMethod.getInstance();
		singletonWithStaticMethod.singletonBehavoir("Example 1");
		
		//Simple instance test
		SingletonWithStaticMethod singletonWithStaticMethodTwo = SingletonWithStaticMethod.getInstance();
		
		if(singletonWithStaticMethod != singletonWithStaticMethodTwo) {
			System.out.println("Objects are different");
		}else {
			System.out.println("Objects are the same");
		}
	}

}
