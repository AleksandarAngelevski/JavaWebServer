import RequestBuilder.Request;
import RequestBuilder.Request2;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class Handler {
    enum AcceptTypes{
        TEXT_HTML("text/html"),
        TEXT_CSS("text/css");
        private final String value;
        private AcceptTypes(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }

    }
    enum MethodTypes{
        ACCEPT("Accept");
        private final String value;
        private MethodTypes(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
    }
    public static void handleClient(Socket client) throws IOException{
        System.out.println("Debug: got new client " + client.toString());
        Request2 requestObj = parseRequest(client.getInputStream());
        if(requestObj.headers().get(MethodTypes.ACCEPT.getValue()).contains(AcceptTypes.TEXT_CSS.getValue())){
            ConnectionHandler.staticFileHandlers.get(requestObj.route()).handleRequest(client.getOutputStream());
        }
        else if(requestObj.headers().get(MethodTypes.ACCEPT.getValue()).contains(AcceptTypes.TEXT_HTML.getValue())){
            ConnectionHandler.endpointHandlers.get(requestObj.route()).handleRequest(client.getOutputStream());
        }
        client.close();
    }
    private static Request2 parseRequest(InputStream inputStream) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder rb = new StringBuilder();
        String line;
        while(!(line = br.readLine()).isBlank()){
            rb.append(line+ "\r\n");
        }
        String request = rb.toString();
        String[] requestLines = request.split("\r\n");
        String[] requestLine = requestLines[0].split(" ");
        String method = requestLine[0];
        String path = requestLine[1];
        String version = requestLine[2];
        String host = requestLines[1].split(" ")[1];
        Map<String,String> headers = new HashMap<>();
        for(int i =2; i < requestLines.length; i++){
            System.out.println(requestLines[i].split(":")[1]);
            headers.put(requestLines[i].split(":")[0],requestLines[i].split(":")[1]);
        }
        return new Request2(method,path,headers);
    }

}
