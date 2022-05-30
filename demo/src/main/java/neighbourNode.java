import java.util.ArrayList;

import org.graphstream.graph.Node;

public abstract class neighbourNode {

    public static void searchNeighbour(int distance, Location startLoc, graphItem graph){
        Location tmpLocation;

        if (graph.getGraph().getNode(startLoc.getName())==null) {
            graph.addNode(startLoc.getName());
            Node tmpNode = graph.getGraph().getNode(startLoc.getName());
            switch (startLoc.getType()) {
                case 'V':
                    tmpNode.setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 30px;");
                    break;
                case 'L':
                    tmpNode.setAttribute("ui.style", "shape:circle;fill-color: red;size: 30px;");
                    break;
                default:
                    break;
            }
            tmpNode.setAttribute("ui.label", startLoc.getName());
        }
        if (distance>0) {
            ArrayList<Path> paths = startLoc.getNeighbourPaths();
            for (Path path : paths) {
                tmpLocation = path.getArrivalLocation();
                System.out.println("the temp loc :"+tmpLocation.getName());
                if (graph.getGraph().getNode(tmpLocation.getName())==null) {
                    graph.addNode(tmpLocation.getName());

                    Node tmpNode = graph.getGraph().getNode(tmpLocation.getName());
                    switch (tmpLocation.getType()) {
                        case 'V':
                            tmpNode.setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 30px;");
                            break;
                        case 'L':
                            tmpNode.setAttribute("ui.style", "shape:circle;fill-color: red;size: 30px;");
                            break;
                        default:
                            break;
                    }

                    graph.linkNode(startLoc.getName(), tmpLocation.getName(), path.getDistance());
            tmpNode.setAttribute("ui.label", tmpLocation.getName());
                }
                if (distance>0) {
                    neighbourNode.searchNeighbour(distance-1, tmpLocation, graph);
                }
            }
        }
    }
}
