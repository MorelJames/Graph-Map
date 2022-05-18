import java.util.ArrayList;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

import org.graphstream.ui.spriteManager.Sprite.*;
import org.graphstream.ui.spriteManager.SpriteManager.*;

public class ListLocation {
    private ArrayList<Location> LocationList = new ArrayList<>();
    private graphItem graph;

    public ListLocation(graphItem theGraph){
        LocationList.clear();// pour avoir la liste vide à la création
        graph = theGraph;
    }

    // a opti avec le ind de retour voir si je le laisse ou si je renvoie l'ind dans tous les cas
    //function that add a location into an arraylist.
    //if the location is not in the arraylist, it will add it and return -1
    //else, it will return the index of the location in the list
    //we suppose that two different location can't have the same name
    public int addLocation(Location loc){
        int ind;
        String name = loc.getName();
        if (this.containByName(name)== false) { //on verifie que la liste n'a pas déjà le lieux
            LocationList.add(loc);
            ind = -1;
            graph.addNode(name);
            Node tmpNode = graph.getGraph().getNode(name);
            switch (loc.getType()) {
                case 'V':
                    tmpNode.setAttribute("ui.style", "shape:circle;fill-color: yellow;size: 30px;");
                    break;
                case 'L':
                    tmpNode.setAttribute("ui.style", "shape:circle;fill-color: red;size: 30px;");
                    break;
                default:
                    break;
            }
            tmpNode.setAttribute("ui.label", name);
        }
        else{
            ind = this.getByName(name);
        }

        return ind;
    }


    //a opti
    public boolean containByName(String name){
        boolean result = false;

        for (Location tmpLocation : LocationList) {
            if (tmpLocation.getName().equals(name)) {
                result = true;
                System.out.println("contain the name :"+name);
            }
        }

        
        return result;
    }

    // function that retrun the index of a location with the name gived
    //if the location isn't find, the function return -1
    public int getByName(String name){
        int i =0;
        int size = LocationList.size();
        while (i<size && LocationList.get(i).getName().equals(name)==false){
            i++;
        }
        if (i>size) {
            i=-1;
        }
        
        return i;
    }


    public Location getByIndex(int ind){
        return LocationList.get(ind);
    }

    public String toString(){
        StringBuffer toStringResult = new StringBuffer();

        for (Location location : LocationList) {
            toStringResult.append(location.toString());
            toStringResult.append("\n");
        }

        return toStringResult.toString();
    }

}