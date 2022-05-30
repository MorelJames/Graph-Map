

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

public class ShowFullGraphAction extends AbstractAction{

    private MainWindow window;

    public ShowFullGraphAction(String label,MainWindow newWindow){
        super(label);
       window = newWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("action full graph");
        window.setGraphPanel(((JPanel) window.getView()));
        
    }
    
}
