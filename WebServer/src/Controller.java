import java.io.IOException;
import java.io.OutputStream;

public interface Controller {
     void handleRequest(OutputStream os) throws IOException;
}
