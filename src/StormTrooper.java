public class StormTrooper extends Trooper{
    private String name = "";
    private static int soldierCounter = 0;

    public StormTrooper(String unit, int num){
        super(unit, num);
        soldierCounter++;
        setTrooperKind("StormTrooper");
        marchModifier = 1.10;
    }
    @Override
    public double march(double duration){
        return getMarchSpeed()*duration*marchModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount(){
        return soldierCounter;
    }

    @Override
    public String toString() {
        return getName() + "(" + super.toString() + getTrooperKind() + " ";
    }
}
