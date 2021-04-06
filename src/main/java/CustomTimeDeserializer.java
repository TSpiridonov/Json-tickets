import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;

public class CustomTimeDeserializer extends StdDeserializer<LocalTime> {

    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("HH:mm");

    public CustomTimeDeserializer(){
        this(null);
    }

    protected CustomTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String time = jsonParser.getText();

        return formatter.parseLocalTime(time);
    }
}
