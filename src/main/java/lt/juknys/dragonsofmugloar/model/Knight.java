package lt.juknys.dragonsofmugloar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Knight {

    private String name;
    private int attack;
    private int armor;
    private int agility;
    private int endurance;

    @Override
    public String toString() {
        return "Knight{" +
                "\n\t\tname='" + name + '\'' +
                ", \n\t\tattack=" + attack +
                ", \n\t\tarmor=" + armor +
                ", \n\t\tagility=" + agility +
                ", \n\t\tendurance=" + endurance +
                "\n\t}";
    }
}
