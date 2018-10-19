package domein;

public class DuckFactory {

    public Duck createDuck(DuckSpecies type) {
        switch (type)
        {
            case REDHEAD:
                return new RedheadDuck(new Quack(), new FlyWithWings());
            case MALLARD:
                return new MallardDuck(new Quack(), new FlyWithWings());
            case RUBBER:
                return new RubberDuck(new Squeak(), new FlyNoWay());
            case DECOY:
                return new DecoyDuck(new MuteQuack(), new FlyNoWay());
            default:
                return null;
        }

    }
}
