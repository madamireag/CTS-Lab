package ro.ase.acs.simplefactory;

public class DocumentFactory {

    public Document getDocument(DocumentType documentType, String name) throws NoSuchDocumentException {
        if(documentType == DocumentType.WORD){
            return new WordDocument(name);
        } else if(documentType == DocumentType.EXCEL) {
            return new ExcelDocument(name);
        } else if(documentType == DocumentType.OPENOFFICE_WORD) {
            return new OpenOfficeWord(name);
        } else if(documentType == DocumentType.OPENOFFICE_SPREADSHEET) {
            return new OpenOfficeSpreadsheet(name);
        }
        throw new NoSuchDocumentException();
    }
}
