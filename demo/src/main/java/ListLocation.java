import java.util.ArrayList;

public class ListLocation {
    ArrayList<Location> LocationList = new ArrayList<>();

    public ListLocation(){
        LocationList.clear();// pour avoir la liste vide à la création
    }

    // a opti avec le ind de retour voir si je le laisse ou si je renvoie l'ind dans tous les cas
    //function that add a location into an arraylist.
    //if the location is not in the arraylist, it will add it and return -1
    //else, it will return the index of the location in the list
    //we suppose that two different location can't have the same name
    public int addLocation(Location loc){
        int ind;
        if (this.containByName(loc.getName())!=true) { //on verifie que la liste n'a pas déjà le lieux
            LocationList.add(loc);
            ind = -1;
        }
        else{
            ind = this.getByName(loc.getName());
        }

        return ind;
    }


    //a opti
    public boolean containByName(String name){
        boolean result = false;

        for (Location location : LocationList) {
            if (location.getName() == name) {
                result = true;
            }
        }

        
        return result;
    }

    // function that retrun the index of a location with the name gived
    //if the location isn't find, the function return -1
    public int getByName(String name){
        int i =0;
        int size = LocationList.size();
        while (i<size && LocationList.get(i).getName() != name){
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