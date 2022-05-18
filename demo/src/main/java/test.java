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
        graphItem graph = new graphItem();

        ListLocation list = new ListLocation(graph);

        CsvLoader.Loader("F:\\pc pas pop\\univ\\graph\\graphe2.csv", list,graph);
        JPanel view = graph.createView();
        if (view !=null) {
            MainWindow window = new MainWindow(graph.createView()); 
        }

        
        System.out.println(list.toString());
        double tempsFin = System.nanoTime();
        System.out.println (tempsFin - tempsDebut);
        
    }

}
