import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.EnumSet;

import javax.swing.AbstractAction;
import javax.swing.event.MouseInputListener;
import javax.swing.text.ComponentView;

import org.graphstream.ui.graphicGraph.GraphicElement;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.swing_viewer.util.DefaultMouseManager;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.util.*;
import org.graphstream.graph.Graph;
import org.graphstream.ui.*;

//quand on clique dans le vide, ça met tous des expection du à un pointeur null

public class MouseManage<ONode, OGraph> extends DefaultMouseManager{

    protected View view;
    protected GraphicGraph graph;
    protected GraphicElement selectedElement;
    private String baseState;

    public MouseManage(View newView, GraphicGraph graphicGraph){
        graph = graphicGraph;
        view = newView;
        selectedElement = null;
    }


    public String getSelectedElementId(){
        return selectedElement.getId();
    }

    @Override
    public void init(GraphicGraph graph, View view) {
        super.init(graph, view);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {
		EnumSet<InteractiveElement> interactiveElements = EnumSet.of(InteractiveElement.NODE,InteractiveElement.EDGE,InteractiveElement.SPRITE);
        if (view.findGraphicElementAt(interactiveElements, ((double)e.getX()), ((double) e.getY()))!=null) {
            if(selectedElement!=null){
                selectedElement.setAttribute("ui.style", baseState);
                
            }
            
            selectedElement = view.findGraphicElementAt(interactiveElements, ((double)e.getX()), ((double) e.getY()));
            baseState = (String) selectedElement.getAttribute("ui.style");
            selectedElement.setAttribute("ui.style", "shape:circle;fill-color: blue;size: 30px;");
            System.out.println(selectedElement.getId());
        }
        //element = view.findGraphicElementAt(interactiveElements, ((double)e.getX()), ((double) e.getY()));
        
	}

    public void mousePressed(MouseEvent event) {
		 
	}

	public void mouseDragged(MouseEvent event) {
		
	}
    
}
