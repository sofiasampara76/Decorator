package ua.edu.ucu.apps;

public class Main {
    public static void main(String[] args) {
        // Example file path to a local image
        String filePath = "D:/downloads/StudentPhoto.jpg";
        Document document = new SmartDocument(filePath);
        document = new CachedDocument(new TimeDocument(document));
        System.out.println(document.parse(filePath));
    }
}
