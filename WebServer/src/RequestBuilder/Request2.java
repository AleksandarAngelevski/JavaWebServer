package RequestBuilder;

import java.util.Map;

public record Request2(String method, String route, Map<String,String> headers){
};
