import java.net.*;
import java.io.*;

class serverFile{
    
    public serverFile(int port){
        Socket socket = null;
        ServerSocket server = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        
        try{
            
            server = new ServerSocket(port);
            System.out.println("Server Started...!");
            
            System.out.println("Waiting for connection...!");
            
            socket = server.accept();
            System.out.println("Connected to client on " + socket.getRemoteSocketAddress());
            
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            
            String line = "";
            
            while(!line.equals("Over")){
                try{
                    line = in.readUTF();
                    System.out.println(line);
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            
            System.out.println("Closing Server...!");
            socket.close();
            in.close();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args){
        serverFile serverStart = new serverFile(1234);
    }
}
