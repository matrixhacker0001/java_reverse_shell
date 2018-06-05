import java.net.*;
import java.io.*;

class clientFile{
    
    private Socket socket = null;
    private DataInputStream in = null;
    private DataOutputStream out = null;
    
    public clientFile(String serverAddr, int port){
        
        try{
            socket = new Socket(serverAddr, port);
            System.out.println("Connected to Server...!");
            
            in = new DataInputStream(System.in);
            
            out = new DataOutputStream(socket.getOutputStream());
        }catch(UnknownHostException u){
            System.out.println(u);
        }catch(IOException e){
            System.out.println(e);
        }
        
        String line = "";
        
        while(!line.equals("Over")){
            try{
                line = in.readLine();
                out.writeUTF(line);
            }catch(IOException i){
                System.out.println(i);
            }
        }
        
        try{
            in.close();
            out.close();
            socket.close();
        }catch(IOException c){
            System.out.println(c);
        }
    }
    
    public static void main(String[] args){
        clientFile clientStart = new clientFile("127.0.0.1", 1234);
    }
    
}
