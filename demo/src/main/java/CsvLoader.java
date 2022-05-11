import java.io.BufferedReader;
import java.io.FileReader;  
import java.io.IOException;  

public abstract class CsvLoader {
    
    // a opti sur les verifications, on peut en avoir moins.
    public static boolean Loader(String CsvAbsolutePath, ListLocation LocationList){
        boolean operation = false;

        Location tmpLocation;
        Path tmpPath;

        String[] finalSeparation;
        String[] tmpPathInfo;
        int indStart =0;
        int indArrival;
        String line = "";  
    try{
        BufferedReader br = new BufferedReader(new FileReader(CsvAbsolutePath));  

        while ((line = br.readLine()) != null)   //returns a Boolean value  
        {  
        String[] separatedLine = line.split(";");    // sépare la ligne avec des ;
        
        for (int i = 0; i < separatedLine.length; i++) { //pour chaque partie de la ligne, on va encore separer par des ":" pour isoler les composantes 
            String[] secondSeparation = separatedLine[i].split(":");

            if (i==0) {//si c'est la première partie de la ligne, on va créer le points/la ville 
                finalSeparation = secondSeparation[0].split(","); //on separe encore une fois chaque partie pour avoir directement les infos à entrer dans les variables.
                tmpLocation = new Location(finalSeparation[0].charAt(0), finalSeparation[1]);
                LocationList.addLocation(tmpLocation);
                indStart = LocationList.getByName(tmpLocation.getName());

                tmpPathInfo = secondSeparation[1].split(",");
                finalSeparation =secondSeparation[3].split(",");
                tmpLocation = new Location(finalSeparation[0].charAt(0), finalSeparation[1]);
                LocationList.addLocation(tmpLocation);
                indArrival = LocationList.getByName(tmpLocation.getName());
                
                tmpPath = new Path(tmpPathInfo[0].charAt(0), LocationList.getByIndex(indStart), LocationList.getByIndex(indArrival),Float.parseFloat(tmpPathInfo[1]));

                LocationList.getByIndex(indStart).addNeightbour(tmpPath);
            }
            else{ //et sinon, on va lui affecter ses voisin , et créer le voisin si il n'existe pas

                tmpPathInfo = secondSeparation[0].split(",");
                finalSeparation = secondSeparation[2].split(",");
                tmpLocation = new Location(finalSeparation[0].charAt(0), finalSeparation[1]);
                LocationList.addLocation(tmpLocation);
                indArrival = LocationList.getByName(tmpLocation.getName());

                tmpPath = new Path(tmpPathInfo[0].charAt(0), LocationList.getByIndex(indStart), LocationList.getByIndex(indArrival),Float.parseFloat(tmpPathInfo[1]));

                LocationList.getByIndex(indStart).addNeightbour(tmpPath);


            }

        }

        }
    }
    catch(IOException e)  {
        e.printStackTrace();  
    }
        

        return operation;
    }
}
