package by.epam.task4.parser;

public class StringParser {

    private static final String SPLITERATOR = ",";

    public String[] pars(String data) {
        return data.split(SPLITERATOR);
    }

    public String getAircraftType(String[] data) {
        return data[0];
    }
}
