# MarsRoverKata
Mars Rover Kata

Started as a simple classicist - TDD Kata, I decided to evolve it in a more difficult Kata,
by adding the rules of Object calisthenics (https://williamdurand.fr/2013/06/03/object-calisthenics/#3-wrap-all-primitives-and-strings)
and also some further rules of my own, like the followings:

- no "new" in domain classes: move instantiations into configuration classes
- no private methods: try to extract a class and move the method on it as public

The result is interesting although a bit overengineered, mainly becouse of the hard 'calisthenic' rule: 
- no more than two instance field in a class.
