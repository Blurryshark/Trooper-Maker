import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public abstract class Trooper {

    private String unit;
    private int number;
    String trooperKind;
    double marchSpeed;
    double marchModifier;

    public Trooper() { this("AA",0); }

    public Trooper(String unit, int number) {
        this.unit = unit;
        this.number = number;
        this.marchModifier = 5;
    }

    public static void addToUnit(HashMap<String, List<Trooper>> units, Trooper trooper){

        if(trooper == null){
            return;
        }

        String currentUnit = trooper.getUnit();

        if(units.containsKey(currentUnit)){
            units.get(currentUnit).add(trooper);
            return;
        }

        List<Trooper> newUnits = new ArrayList<>();
        newUnits.add(trooper);

        units.put(currentUnit,newUnits);
    }

    public abstract double march(double modifier);

    public boolean attack (Trooper target, int roll) {
        System.out.println(this + " is attacking " + target);
        System.out.println(this + " rolled a " + roll);

        if (this.equals(target) || roll == 1) {
            System.out.println(this + " is targeting itself");
            System.out.println(this + " rolled a " + roll + " and hurting itself in the confusion");
            return true;
        }

        if (this instanceof StormTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Rolled a " + roll + " against the Rebel scum!!");
                return roll > 10 && (roll % 2 == 0);
            } else if (target instanceof StormTrooper) {
                System.out.println("No friendly fire!");
                return false;
            } else {
                System.out.println("Acceptable collateral damage!");
                return roll > 10 || (roll % 2 == 0);
            }

        } else if (this instanceof RebelTrooper) {
            if (target instanceof RebelTrooper) {
                System.out.println("Imperial Spy!");
                return false;
            } else if (target instanceof StormTrooper) {
                System.out.println("Rolled a " + roll + " against the Imperial dog!");
                return roll > 5 || (roll % 2 != 0);
            } else {
                System.out.println("Headline reads: Terrorist targets innocent bystanders!");
                return roll > 18 && (roll % 2 == 0);
            }
        }
        System.out.println("eh...?");
        return false;
    }
    public String getUnit () {
        return unit;
    }

    public void setUnit (String unit){
        this.unit = unit;
    }

    public int getNumber () {
        return number;
    }

    public void setNumber( int number){
        this.number = number;
    }

    public String getTrooperKind () {
        return trooperKind;
    }

    public void setTrooperKind (String trooperKind){
        this.trooperKind = trooperKind;
    }

    public double getMarchSpeed () {
        return marchSpeed;
    }

    public void setMarchSpeed ( double marchSpeed){
        this.marchSpeed = marchSpeed;
    }

    public double getMarchModifier () {
        return marchModifier;
    }

    public void setMarchModifier ( double marchModifier){
        this.marchModifier = marchModifier;
    }

    @Override
    public boolean equals (Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number && Double.compare(trooper.marchSpeed, marchSpeed) == 0 &&
                Double.compare(trooper.marchModifier, marchModifier) == 0 && Objects.equals(unit, trooper.unit) &&
                Objects.equals(trooperKind, trooper.trooperKind);
    }

    @Override
    public int hashCode () {
        return Objects.hash(unit, number, trooperKind, marchSpeed, marchModifier);
    }

    @Override
    public String toString () {
        return unit + number + ":";
    }

}

