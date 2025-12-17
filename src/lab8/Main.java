package lab8;

public class Main {
    public static void main(String[] args) throws Exception {

        DataManager manager = new DataManager();

        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new TransformProcessor());
        manager.registerDataProcessor(new AggregateProcessor());

        manager.loadData("src/lab8/input.txt");
        manager.processData();
        manager.saveData("src/lab8/output.txt");
    }
}
