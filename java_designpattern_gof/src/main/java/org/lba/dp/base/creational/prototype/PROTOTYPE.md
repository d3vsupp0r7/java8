# Prototype: abstract class

* It states that it implements the interface to clone itself (it must implement 
the java.lang.Cloneable interface to use the cloning mechanism provided by Java).

* Implement the method that will be called to clone the object (cloneItself), which makes a call to the protected method clone inherited from java.lang.Object.

# ConcretePrototype: concrete class

* They implement the particular versions of objects to be used and cloned. This type of classes extends the Prtotype.

# Client

* Recall the object cloning method to create a new object.


# Useful notes
https://javaconceptoftheday.com/difference-between-shallow-copy-vs-deep-copy-in-java/