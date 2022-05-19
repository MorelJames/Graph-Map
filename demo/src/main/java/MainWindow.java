import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;

import java.awt.*;

import org.graphstream.graph.Graph;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

public class MainWindow extends JFrame{
    private graphItem graph ;
    private ListLocation list ;
    private JPanel theBorder;

    //rennomer
    public MainWindow(){
        super();
        graph = new graphItem();
        list = new ListLocation(graph);
        BuildWindow();
        
    }
    
    private void BuildWindow(){
        setTitle("GraphMap");
        setSize(1920,1080);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(BuildBorderLayout());
        setJMenuBar(buildMenuBar());
        setVisible(true);
    }

    private JPanel BuildBorderLayout(){
        theBorder = new JPanel(new BorderLayout());

        //Viewer viewer = graphe.display();
        //View view = viewer.addDefaultView(false);

        //pane.add((Component) view,BorderLayout.EAST);
        
        /*theBorder.add(rty,BorderLayout.CENTER);
        Dimension dim = new DimensionUIResource(510, 510);
        this.getrty().setPreferredSize(dim);*/
        theBorder.add(new JLabel("un texte juste pour tester"),BorderLayout.NORTH);
        theBorder.add(new JLabel("un texte juste pour tester"),BorderLayout.WEST);
        theBorder.add(new JLabel("un texte juste pour tester"),BorderLayout.EAST);
        theBorder.add(new JLabel("un texte juste pour tester"),BorderLayout.SOUTH);
        
        return theBorder;
    }

    private JMenuBar buildMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        menu.add(new JButton(new FileChooser("Open File", this)));

        return menuBar;
    }

    JPanel getBorder(){
        return theBorder;
    }


    public graphItem getGraphItem(){
        return graph;
    }

    public ListLocation getListLocation(){
        return list;
    }

}
