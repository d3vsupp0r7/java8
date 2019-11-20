# AbstractFactory: interface
- Declare an interface for operations that create/returns products.
- In the declaration of each method, the returned products are products of types AbstractProduct.

# ConcreteFactory: classes 
- Providing the operations they create and return items corresponding to specific products (ConcreteProduct).

# AbstractProduct: interfaces

- They declare the operations that characterize the different types generic products.

# ConcreteProduct: classes 
- They define the products created by each ConcreteFactory.

# Client: class Client.
- Use AbstractFactory to contact the ConcreteFactory of a product family.
- Use the products through their AbstractProduct interface.