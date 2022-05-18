import java.util.ArrayList;

public class Path {
    private Character type;
    private Location startLocation;
    private Location arrivalLoaction;
    private float distance;

    public Path(Character newtype, Location newStartLocation, Location newArrivalLocation, float newDistance){ //classe qui représente le lien/chemin qu'il y a entre deux lieux
        this.type = newtype;
        this.startLocation = newStartLocation;
        this.arrivalLoaction = newArrivalLocation;
        this.distance = newDistance;
    }

    public Character getType(){
        return type;
    }

    public Float getDistance(){
        return distance;
    }

    public Location getStartLocation(){
        return startLocation;
    }

    public Location getArrivalLocation(){
        return arrivalLoaction;
    }
}
