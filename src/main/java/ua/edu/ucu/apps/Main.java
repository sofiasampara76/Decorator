package ua.edu.ucu.apps;

public class Main {
    public static void main(String[] args) {
        // Example file path to a local image
        String filePath = "/mnt/d/downloads/Motivation board.png";
        // "D:\downloads\Motivation board.png"
        Document document = new SmartDocument(filePath);
        document = new TimeDocument(document);
        System.out.println(document.parse(filePath));
    }
}
