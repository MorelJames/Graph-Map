import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

import org.graphstream.graph.Graph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

public class MainWindow extends JFrame{
    JPanel rty;
    JPanel theBorder;
    public MainWindow(JPanel aze){
        super();
        rty = aze;
        BuildWindow();
        
    }
    
    private void BuildWindow(){
        setTitle("GraphMap");
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(BuildBorderLayout());
        setVisible(true);
    }

    private JPanel BuildBorderLayout(){
        theBorder = new JPanel(new BorderLayout());

        //Viewer viewer = graphe.display();
        //View view = viewer.addDefaultView(false);

        //pane.add((Component) view,BorderLayout.EAST);
        theBorder.add(rty,BorderLayout.CENTER);
        Dimension dim = new DimensionUIResource(210, 210);
        theBorder.add(new JLabel("un texte juste pour tester"),BorderLayout.NORTH);
        this.getrty().setPreferredSize(dim);
        return theBorder;
    }
    public JPanel getBorder(){
        return theBorder;
    }

    public JPanel getrty(){
        return rty;
    }


}
