import java.nio.file.Files;
import java.nio.file.Path;

public class RoutesHandlers {
    public static Controller home = (outputStream) ->{
        System.out.println("HOME ROUTE");
        Path path = Path.of("views/home.html");
        byte[] body = Files.readAllBytes(path);
        System.out.println("Length of html file "+ body.length);
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        outputStream.write("ContentType: text/html\r\n".getBytes());
        outputStream.write(("Content-Length: "+body.length).getBytes());
        outputStream.write("\r\n\r\n".getBytes());
        outputStream.write(body);
        outputStream.flush();
    };
    public static Controller homeStyle = (outputStream) ->{
        System.out.println("Styles handler");
        Path path = Path.of("style/home.css");
        byte[] body = Files.readAllBytes(path);
        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
        outputStream.write("ContentType: text/html\r\n".getBytes());
        outputStream.write(("Content-Length: "+body.length).getBytes());
        outputStream.write("\r\n\r\n".getBytes());
        outputStream.write(body);
        outputStream.flush();
    };
}
