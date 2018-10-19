package domain;

public class PizzaFactory {

    public Pizza createPizza(String type) {

        switch (type.toLowerCase()) {
            case "cheese":
                return new CheesePizza();
            case "pepperoni":
                return new PepperoniPizza();
            case "clam":
                return new ClamPizza();
            case "veggie":
                return new VeggiePizza();
            default:
                return null;
        }

    }

}
