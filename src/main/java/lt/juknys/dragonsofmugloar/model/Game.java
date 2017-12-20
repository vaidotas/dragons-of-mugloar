package lt.juknys.dragonsofmugloar.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    private Long gameId;
    private Knight knight;

    @Override
    public String toString() {
        return "\nGame{" +
                "\n\tgameId=" + gameId +
                ",\n\t" + knight.toString() +
                "\n}";
    }
}
