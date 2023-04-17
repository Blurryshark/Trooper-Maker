public class RebelTrooper extends Trooper{
    private String name = "Rebel";
    private static int soldierCounter = 0;

    public RebelTrooper(String unit, int num, String name){
        super(unit, num);
        soldierCounter++;
        trooperKind = "RebelPilot";
        marchModifier = 0.75;
        this.name = name;
    }

    @Override
    public String toString() {
        return getName() + "(" + super.toString() + getTrooperKind() + " ";
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

    public static int getSoldierCount() {
        return soldierCounter;
    }

    public static void setSoldierCounter(int soldierCounter) {
        RebelTrooper.soldierCounter = soldierCounter;
    }
}
