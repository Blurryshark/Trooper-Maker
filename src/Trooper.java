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

    public static void addToUnit(HashMap<String, List<Trooper>> trooperMap, Trooper t){
        System.out.println("finish later ||OR ELSE!||");
    }

    public abstract double march(double modifier);

    public boolean attack (Trooper target, int roll){
        System.out.println("finish later ||OR ELSE!||");
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

    public double getMarchModifier() {
        return marchModifier;
    }

    public void setMarchModifier(double marchModifier) {
        this.marchModifier = marchModifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trooper trooper = (Trooper) o;
        return number == trooper.number && Double.compare(trooper.marchSpeed, marchSpeed) == 0 &&
                Double.compare(trooper.marchModifier, marchModifier) == 0 && Objects.equals(unit, trooper.unit) &&
                Objects.equals(trooperKind, trooper.trooperKind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, number, trooperKind, marchSpeed, marchModifier);
    }

    @Override
    public String toString() {
        return unit + number + ":";
    }


}
