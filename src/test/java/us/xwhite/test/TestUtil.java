package us.xwhite.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import java.nio.charset.Charset;
import org.springframework.http.MediaType;

/**
 * Utility class for testing
 *
 * @author Joel
 */
public class TestUtil {

    public static String objectToJson(Object o) throws JsonProcessingException {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(o);
        return json;
    }
}
