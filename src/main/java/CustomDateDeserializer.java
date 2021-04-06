import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;


public class CustomDateDeserializer extends StdDeserializer<LocalDate> {

    private final DateTimeFormatter formatter = DateTimeFormat.forPattern("dd.MM.yy");

    public CustomDateDeserializer(){
        this(null);
    }

    protected CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        String date = jsonParser.getText();

        return formatter.parseLocalDate(date);

    }
}
