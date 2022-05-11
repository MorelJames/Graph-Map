public class test {
    public static void main(String[] args) {
        ListLocation list = new ListLocation();

        CsvLoader.Loader("D:\\pc pas pop\\univ\\graph\\graphe1.csv", list);

        System.out.println(list.toString());
    }
}
