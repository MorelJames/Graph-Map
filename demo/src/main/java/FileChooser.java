import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class FileChooser extends AbstractAction{
    private String path;
    private MainWindow window;
    public FileChooser(String label,MainWindow newWindow){
        super(label);
       window = newWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(new File(".csv"));
        File selectedfile;
        if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
            selectedfile = fileChooser.getSelectedFile();
            path = selectedfile.getAbsolutePath();

            CsvLoader.Loader(path, window.getListLocation(), window.getGraphItem());

            JPanel panel = window.getBorder();
            JPanel view = window.getGraphItem().createView();
            panel.add(view,BorderLayout.CENTER);
        }
        
    }
    
}
