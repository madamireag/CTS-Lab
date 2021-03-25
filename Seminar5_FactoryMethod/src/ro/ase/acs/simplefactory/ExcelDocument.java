package ro.ase.acs.simplefactory;

public class ExcelDocument implements Document{
    String name;

    public ExcelDocument(String name) {
        this.name = name;
    }

    @Override
    public void open() {
        System.out.println(String.format("The document %s.xlsx is opening...",name));
    }
}
