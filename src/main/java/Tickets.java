import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Tickets implements Serializable {

    @JsonProperty("origin")
    public String origin;

    @JsonCreator
    public Tickets(@JsonProperty("origin") String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "origin='" + origin + '\'' +
                '}';
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}