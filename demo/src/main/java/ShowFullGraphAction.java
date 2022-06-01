

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
        window.getMainPanel().remove(4);
        window.getMainPanel().add((JPanel) window.getView());
        window.getMainPanel().repaint();
        window.getMainPanel().validate();
        
    }
    
}
