import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class Trooper {
    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed ;
    double marchModifier;

    public Trooper(String unit, int num){
        this.unit = unit;
        this.number = num;
        setMarchSpeed(5);
    }
    public Trooper(){
        this("AA", 0);
    }


    public static void addToUnit(HashMap<String,List<Trooper>> units, Trooper trooper){
        if (trooper.equals(null)){
            return;
        }
        if(!units.containsKey(trooper.getUnit())){
            units.put(trooper.getUnit(), new ArrayList<>());
        }
        units.get(trooper.getUnit()).add(trooper);
    }
    public abstract double march(double duration);
    public boolean attack(Trooper target, int roll){
        System.out.println(this.toString() + " is attacking " + target.toString());
        //System.out.println(this.toString() + " rolled a " + roll);

        if (target.equals(this) || roll == 1){
            System.out.println(this.toString() + " is targeting itself...\n" + this.toString() + "rolled a " + roll +
                    " and hurt itself in the confusion");
            return true;
        } else if (this.getTrooperKind() == "StormTrooper"){
            if (target.getTrooperKind() == "RebelPilot") {
                System.out.println("Rolled a " + roll + " against the rebel scum");
                if (roll > 10 && roll % 2 == 0){
                    return true;
                }
            } else if(target.getTrooperKind() == "StormTrooper"){
                System.out.println("No treason in the ranks!");
                return false;
            } else {
                System.out.println("Acceptable collateral damage in the name of the emperor!");
                    return roll > 10 && roll % 2 == 0;
            }
        } else if (this.getTrooperKind() == "RebelPilot"){
            if(target.getTrooperKind() == "RebelPilot") {
                System.out.println("Imperial Spy!");
                return false;
            } else if (target.getTrooperKind() == "StormTrooper"){
                System.out.println("Rolled a " + roll + " against the imperial scum!");
                return (roll > 5 || roll % 2 != 0);
            } else {
                System.out.println("Rebels target an innocent bystander! (typical)");
                return (roll >= 18 && roll % 2 ==0);
            }

        }
        return false;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTrooperKind() {
        return trooperKind;
    }

    public void setTrooperKind(String trooperKind) {
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed() {
        return marchSpeed;
    }

    public void setMarchSpeed(double marchSpeed) {
        this.marchSpeed = marchSpeed;
    }

    @Override
    public String toString() {
        return getUnit() + getNumber() + ":";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number && Double.compare(trooper.marchSpeed, marchSpeed) == 0 && Double.compare(trooper.marchModifier, marchModifier) == 0 && Objects.equals(unit, trooper.unit) && Objects.equals(trooperKind, trooper.trooperKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, number, trooperKind, marchSpeed, marchModifier);
    }
}
