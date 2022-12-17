import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
 
public class SocketClient {
 

    public static void main(String[] args) throws IOException {
        try {
           
            Socket socket = new Socket("172.17.0.2", 5209);
            System.out.println("Client enable Success");
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            PrintWriter write = new PrintWriter(socket.getOutputStream());
          
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
           
            String readline;
            readline = br.readLine(); 
            while (!readline.equals("end")) {
               
                write.println(readline);
               
                write.flush();
           
                System.out.println("Client:" + readline);
               
                System.out.println("Service:" + in.readLine());
                
                readline = br.readLine(); 
            } 
        
            write.close(); 
            in.close(); 
            socket.close(); 
        } catch (Exception e) {
            System.out.println("can not listen to:" + e);
        }
    }
 
}
