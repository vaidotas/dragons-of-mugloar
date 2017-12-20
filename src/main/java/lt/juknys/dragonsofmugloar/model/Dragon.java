package lt.juknys.dragonsofmugloar.model;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonRootName(value = "dragon")
public class Dragon {

    private int scaleThickness;
    private int clawSharpness;
    private int wingStrength;
    private int fireBreath;

    @Override
    public String toString() {
        return "\ndragon {" +
                "\n\tscaleThickness=" + scaleThickness +
                ", \n\tclawSharpness=" + clawSharpness +
                ", \n\twingStrength=" + wingStrength +
                ", \n\tfireBreath=" + fireBreath +
                "\n}";
    }

}
