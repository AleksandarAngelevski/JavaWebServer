import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConnectionHandler {
    ConnectionHandler(){}
    public static Map<String,Controller> endpointHandlers = new ConcurrentHashMap<>();
    public static Map<String,Controller> staticFileHandlers = new ConcurrentHashMap<>();
    public void createNewConnection(Socket ss) throws Exception{

        new Thread(()->{
            try {
                Handler.handleClient(ss);
            } catch (IOException e) {
                e.printStackTrace();
//                System.out.println("Error2");
            }
        }).start();
    }
}
