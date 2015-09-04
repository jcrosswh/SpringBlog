package us.xwhite.test;

import java.nio.charset.Charset;
import org.springframework.http.MediaType;

/**
 * Utility class for testing
 * 
 * @author Joel
 */
public class TestUtil {
   
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
}
