import java.util.ArrayList;

public class Location {
    private Character type;
    private String name;
    private ArrayList<Path> neighbourPaths = new ArrayList<>();
    
    public Location(Character newType, String newName){
        this.type = newType;
        this.name = newName;
    }

    public void addNeightbour(Path newNeighbour){
        neighbourPaths.add(newNeighbour);
    }

    public String getName(){
        return name;
    }

    public Character getType(){
        return type;
    }

    public ArrayList<Path> getNeighbourPaths(){
        return neighbourPaths;
    }


    public String toString(){
        StringBuffer toStringResult = new StringBuffer("City : ");

        toStringResult.append(this.getName());
        toStringResult.append("| Type :");
        toStringResult.append(this.getType());
        toStringResult.append(" | Neighbour : ");

        for (int i = 0; i < neighbourPaths.size(); i++) {// on parcours la liste des voisin pour afficher les infos qui nous sont necessaire
            toStringResult.append(" | ");
            toStringResult.append(neighbourPaths.get(i).getType());
            toStringResult.append(" : ");
            toStringResult.append(neighbourPaths.get(i).getArrivalLocation().getName());
        }

        return toStringResult.toString();
    }
}
