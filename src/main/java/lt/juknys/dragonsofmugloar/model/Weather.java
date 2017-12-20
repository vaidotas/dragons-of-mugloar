package lt.juknys.dragonsofmugloar.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Weather {

    private LocalDate time;
    private Coords coords;
    private String code;
    private String message;
    @JacksonXmlProperty(localName = "varX-Rating")
    private Double varXRating;

    @Override
    public String toString() {
        return "\nWeather{" +
                "\n\ttime=" + time +
                ", \n\tcoords=" + coords +
                ", \n\tcode='" + code + '\'' +
                ", \n\tmessage='" + message + '\'' +
                ", \n\tvarXRating=" + varXRating +
                '}';
    }

}
