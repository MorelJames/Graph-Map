import javax.swing.*;

import java.awt.*;


import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.swing_viewer.DefaultView;
import org.graphstream.ui.view.View;

public class MainWindow extends JFrame{
    private graphItem fullGraph ;
    private graphItem neighbourGraph;
    private ListLocation list ;
    private JPanel mainPanel;
    private JPanel graphPanel;
    private GraphicGraph grapic;
    private DefaultView view;
    private MouseManage mouseManage;

    //rennomer
    public MainWindow(){
        super();
        fullGraph = new graphItem();
        view = (DefaultView) fullGraph.createView();
        neighbourGraph = new graphItem();
        list = new ListLocation(fullGraph);
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
        mainPanel = new JPanel(new BorderLayout());

        //Viewer viewer = graphe.display();
        //View view = viewer.addDefaultView(false);

        //pane.add((Component) view,BorderLayout.EAST);
        
        /*mainPanel.add(rty,BorderLayout.CENTER);
        Dimension dim = new DimensionUIResource(510, 510);
        this.getrty().setPreferredSize(dim);*/
        mainPanel.add(new JButton(new ShowFullGraphAction("Show full graph", this)),BorderLayout.NORTH);
        mainPanel.add(new JLabel("un texte juste pour tester"),BorderLayout.WEST);
        mainPanel.add(new JButton(new ShowNeighbourGraph("Show neigbour of selected location", this)),BorderLayout.EAST);
        mainPanel.add(new JLabel("un texte juste pour tester"),BorderLayout.SOUTH);
        mainPanel.add(view);
        
        return mainPanel;
    }

    private JMenuBar buildMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenu actionMenu = new JMenu("Action");
        menuBar.add(menu);
        menuBar.add(actionMenu);

        menu.add(new JButton(new OpenFileAction("Open File", this)));

        return menuBar;
    }

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public JPanel getGraphPanel(){
        return graphPanel;
    }

    public void setGraphPanel(JPanel view){
        graphPanel = view;
    }

    public graphItem getFullGraph(){
        return fullGraph;
    }

    public ListLocation getListLocation(){
        return list;
    }

    public View getView(){
        return view;
    }

    public GraphicGraph getGraphicGraph(){
        return grapic;
    }

    public void setView(DefaultView newView){
         view = newView;
    }

    public void setGraphicGrpah(GraphicGraph newGraphic){
        grapic = newGraphic;
    }

    public graphItem getNeighbourGraph(){
        return neighbourGraph;
    }

    public void setMouseManage(MouseManage newMouseManage){
        mouseManage = newMouseManage;
    }

    public MouseManage getMouseManage(){
        return mouseManage;
    }

}
