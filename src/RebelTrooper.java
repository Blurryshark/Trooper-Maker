public class RebelTrooper extends Trooper{
    private String name = "Rebel";
    private static int soldierCount = 0;

    public RebelTrooper(String name) {
        this.name = name;
    }

    public RebelTrooper(String unit, int number, String name) {
        super(unit, number);
        soldierCount++;
        this.trooperKind = "Pilot";
        this.marchModifier = 0.75;
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
        RebelTrooper.soldierCount = soldierCount;
    }

    @Override
    public String toString() {
        return name + "(" + super.toString() + ") " + trooperKind;
    }
}
