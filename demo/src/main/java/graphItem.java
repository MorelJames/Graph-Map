import java.awt.Component;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.JPanel;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.graphicGraph.GraphicGraph;
import org.graphstream.ui.layout.Layout;
import org.graphstream.ui.spriteManager.Sprite.*;
import org.graphstream.ui.spriteManager.SpriteManager.*;

import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;

public class graphItem {
    private Graph graph ;

    public graphItem(){
        graph = new MultiGraph("Full Graph");
    }

    public Graph getGraph(){
        return graph;
    }

    public void addNode(String node){
        graph.addNode(node);
    }

    public void linkNode(String node1, String node2,float distance){
        graph.addEdge(node1.concat(node2), node1, node2).setAttribute("length", distance);;
    }

    public View createView(){
        Viewer viewer = new SwingViewer(this.getGraph(), Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false);

        return view;
    }

    public GraphicGraph createGraphicGraph(){
        GraphicGraph graphicGraph = new GraphicGraph(this.getGraph().getId());
        return graphicGraph;
    }

    public void clearGraph(){
        this.getGraph().clear();
    }

    public void allNode(){
        for (Node node : graph) {
            System.out.println(node.getId());
        }
    }

    
}

