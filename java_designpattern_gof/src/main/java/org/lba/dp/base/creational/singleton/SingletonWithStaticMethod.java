package org.lba.dp.base.creational.singleton;

public class SingletonWithStaticMethod {

	private static SingletonWithStaticMethod instance;

	private SingletonWithStaticMethod() {
		//
	}

	public static SingletonWithStaticMethod getInstance() {

		if (instance == null) {
			instance = new SingletonWithStaticMethod();
		}

		return instance;
	}

	public void singletonBehavoir(String msg) {
		System.out.println(msg);
	}

}
