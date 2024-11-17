package ua.edu.ucu.apps;

public abstract class AbstractDecorator implements Document{
    private Document document;

    public AbstractDecorator(Document document) {
        this.document = document;
    }
    @Override
    public String parse(String parse) {
        // System.out.println("abstract");
        return this.document.parse(parse);
    }
}
