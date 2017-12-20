package lt.juknys.dragonsofmugloar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Attribute implements Comparable<Attribute> {

    private int attribute;
    private AttributeType attributeType;

    @Override
    public int compareTo(Attribute o) {
        return o.getAttribute() - attribute;
    }

}
