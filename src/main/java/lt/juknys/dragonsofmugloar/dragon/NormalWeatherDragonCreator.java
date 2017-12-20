package lt.juknys.dragonsofmugloar.dragon;

import lt.juknys.dragonsofmugloar.model.Attribute;
import lt.juknys.dragonsofmugloar.model.AttributeType;
import lt.juknys.dragonsofmugloar.model.Dragon;
import lt.juknys.dragonsofmugloar.model.Knight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NormalWeatherDragonCreator implements DragonCreator {

    @Override
    public Dragon createDragon(Knight knight) {
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(new Attribute(knight.getAttack(), AttributeType.ATTACK));
        attributes.add(new Attribute(knight.getArmor(), AttributeType.ARMOR));
        attributes.add(new Attribute(knight.getAgility(), AttributeType.AGILITY));
        attributes.add(new Attribute(knight.getEndurance(), AttributeType.ENDURANCE));

        Collections.sort(attributes);

        DragonBuilder dragonBuilder = DragonBuilder.builder();

        Attribute firstAttribute = attributes.get(0);
        dragonBuilder.setAttributeByKnightAttribute(firstAttribute.getAttribute() + 2, firstAttribute.getAttributeType());
        Attribute secondAttribute = attributes.get(1);
        dragonBuilder.setAttributeByKnightAttribute(secondAttribute.getAttribute() - 1, secondAttribute.getAttributeType());
        Attribute thirdAttribute = attributes.get(2);
        dragonBuilder.setAttributeByKnightAttribute(thirdAttribute.getAttribute() - 1, thirdAttribute.getAttributeType());
        Attribute fourthAttribute = attributes.get(3);
        dragonBuilder.setAttributeByKnightAttribute(fourthAttribute.getAttribute(), fourthAttribute.getAttributeType());

        return dragonBuilder.build();
    }

}