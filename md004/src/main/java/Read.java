import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read {
	
	public static String read() throws IOException {
    	String fileName = "C:\\Users\\anest\\eclipse-workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\submit.html";

        byte[] bytes = Files.readAllBytes(Paths.get(fileName));
        String content = new String(bytes, StandardCharsets.UTF_8);
        return content;
    }

}
