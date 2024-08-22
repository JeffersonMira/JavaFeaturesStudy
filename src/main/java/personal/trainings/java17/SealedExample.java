package personal.trainings.java17;


/**
 * We use a new keyword sealed to denote that this is a sealed class.
 * We define the classes that can be extended using the permits keyword.
 * Any class which extends the sealed class can be either final like PearSealed or can be
 * extended by other classes by using the non-sealed keyword when declaring the class as with AppleSealed.
 */
abstract sealed class FruitSealed permits AppleSealed, PearSealed {
}
non-sealed class AppleSealed extends FruitSealed {
}
final class PearSealed extends FruitSealed {
}