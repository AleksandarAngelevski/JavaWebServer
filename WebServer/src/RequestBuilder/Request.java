package RequestBuilder;

import java.util.Map;
//*TODO Finish the factory method for the building the Requests!!!!!! *//
//FIXME Add GoodRequest && BadRequest Classes:

public abstract class Request {
    private String method;
    private String route;
    private Map<String,String> headers;

    Request(String method, String route, Map<String,String> headers){
        this.method = method;
        this.route = route;
        this.headers = headers;
    }
    public String getMethod() {
        return method;
    }
    public String getRoute() {
        return route;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
    public String getHeader(String header){
        return this.headers.computeIfAbsent(header,k -> "HEADER NOT FOUND");
    }
}


