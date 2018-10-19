package domein;

public class DecoyDuck extends Duck {

//    public DecoyDuck(){
//        setQuackBehavior(new MuteQuack());
//        setFlyBehavior(new FlyNoWay());
//    }
    public DecoyDuck(QuackBehavior qb, FlyBehavior fb){
        super(qb,fb);
    }

    @Override
    public String display() {
        return "Ik ben een lokeend";
    }

}
