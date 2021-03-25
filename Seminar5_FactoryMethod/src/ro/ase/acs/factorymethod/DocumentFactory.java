package ro.ase.acs.factorymethod;

import ro.ase.acs.simplefactory.NoSuchDocumentException;

public interface DocumentFactory {
    public Document getDocument(DocumentType documentType, String name) throws NoSuchDocumentException;
}
