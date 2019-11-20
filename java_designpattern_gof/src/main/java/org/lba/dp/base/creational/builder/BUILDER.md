# Design Pattern: Builder 

## Scope

# Implementation

## Builder: abstract class.
* Declares an interface for the operations that create the parts of the Product object.
* Implement the default behavior for each operation.
 
## ConcreteBuilder: classes

* Provide the concrete operations of the interface corresponding to the Builder.
* Build and assemble parts of the Product.
* They provide a method to return the created Product.

## Director: class

* Builds the Product by invoking the interface methods of the Builder.

## Product: classes

* Represents the complex object under construction. The ConcreteBuilders build the internal representation of Product.

* Includes classes that define the constituent parts of the Product

## UML

# Notes

## Technical Notes

## Useful notes