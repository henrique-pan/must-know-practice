package algorithms.designPatterns.decorator;

public class DecoratorPatternTest {

    public static void main(String[] args) {
        Car car = new BasicCar();

        Car luxuryCar = new LuxuryCar(car);
        luxuryCar.assemble();

        Car sportsCar = new SportsCar(car);
        sportsCar.assemble();

        System.out.println("\n*****");

        Car sportsLuxuryCar = new SportsCar(luxuryCar);
        sportsLuxuryCar.assemble();
    }

}
