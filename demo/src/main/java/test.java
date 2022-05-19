import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;

import javax.swing.JPanel;

import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import javax.swing.*;
import java.awt.*;

public class test{

    public static void main(String[] args) throws IOException {
        System.setProperty("org.graphstream.ui", "Swing");
        double tempsDebut = System.nanoTime();

            MainWindow window = new MainWindow(); 

        
        System.out.println(window.getListLocation().toString());
        double tempsFin = System.nanoTime();
        System.out.println (tempsFin - tempsDebut);
        
    }

}
