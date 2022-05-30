import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.View;

import org.graphstream.ui.graphicGraph.GraphicGraph;

public class OpenFileAction extends AbstractAction{
    private String path;
    private MainWindow window;
    public OpenFileAction(String label,MainWindow newWindow){
        super(label);
       window = newWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser(".\\");
        fileChooser.setFileFilter(new FileFilter() {
            public String getDescription() {
                return "CSV Documents (*.csv)";
            }
         
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".csv");
                }
            }
        });
        File selectedfile;
        if (fileChooser.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
            selectedfile = fileChooser.getSelectedFile();
            path = selectedfile.getAbsolutePath();

            CsvLoader.Loader(path, window.getListLocation(), window.getFullGraph());

            window.setGraphicGrpah(window.getFullGraph().createGraphicGraph());
            window.setView(window.getFullGraph().createView());

            JPanel panel = window.getMainPanel();
            JPanel view = (JPanel) window.getView();
            window.setMouseManage(new MouseManage(window.getView(),window.getGraphicGraph()));
            view.addMouseListener(window.getMouseManage());
            //window.setGraphPanel(view);
            panel.add(((JPanel)view),BorderLayout.CENTER);
        }
        
    }
    
}
