import java.io.IOException;

public class test{

    public static void main(String[] args) throws IOException {
        System.setProperty("org.graphstream.ui", "Swing");

        MainWindow window = new MainWindow(); 

        
        System.out.println(window.getListLocation().toString());
        
    }

}
