package ro.ase.acs.main;

import ro.ase.acs.simplefactory.*;

public class Main {
    public static void main(String[] args) {
        DocumentFactory documentFactory = new DocumentFactory();
        try {
          Document document = documentFactory.getDocument(DocumentType.EXCEL,"studenti");
          document.open();
          Document document2 = documentFactory.getDocument(DocumentType.OPENOFFICE_WORD,"proiect");
          document2.open();
        } catch (NoSuchDocumentException e) {
            e.printStackTrace();
        }
    }
}
