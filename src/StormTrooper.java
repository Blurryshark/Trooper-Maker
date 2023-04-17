public class StormTrooper extends Trooper{
    private String name = "";
    private static int soldierCount = 0;

    public StormTrooper(String name) {
        this.name = name;
    }

    public StormTrooper(String unit, int number, String name) {
        super(unit, number);
        soldierCount++;
        this.trooperKind = "StormTrooper";
        this.marchModifier = 1.10;
    }

    @Override
    public double march(double duration){
        return marchSpeed * duration * marchModifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getSoldierCount() {
        return soldierCount;
    }

    public static void setSoldierCount(int soldierCount) {
        StormTrooper.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return name + "(" + super.toString() + ") " + trooperKind;
    }
}
