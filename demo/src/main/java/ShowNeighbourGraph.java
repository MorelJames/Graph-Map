import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class ShowNeighbourGraph extends AbstractAction{

    private MainWindow window;

    public ShowNeighbourGraph(String label,MainWindow newWindow){
        super(label);
       window = newWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action neighbour");
        graphItem graph = new graphItem();
        int ind = window.getListLocation().getByName(window.getMouseManage().getSelectedElementId());
        Location loc = window.getListLocation().getByIndex(ind);
        neighbourNode.searchNeighbour(1, loc , graph);
        System.out.println("graph to string:\n");
        graph.allNode();
        window.getMainPanel().remove(4);
        window.getMainPanel().add((JPanel) graph.createView());
        window.getMainPanel().repaint();
        window.getMainPanel().validate();
        
    }
    
}
