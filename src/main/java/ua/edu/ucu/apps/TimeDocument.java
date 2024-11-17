package ua.edu.ucu.apps;

public class TimeDocument extends AbstractDecorator {
    public TimeDocument(Document document) {
        super(document);
    }

    @Override
    public String parse(String parse) {
        // System.out.println("hello");
        long startTime = System.nanoTime();
        String result = super.parse(parse);
        long endTime = System.nanoTime();

        long durationTime = endTime - startTime;
        double durationInSeconds = durationTime / 1000000000;
        System.out.println("Time taken in seconds: " + durationInSeconds);
        return result;
    }
}
