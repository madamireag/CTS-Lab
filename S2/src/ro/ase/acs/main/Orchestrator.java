package ro.ase.acs.main;


import ro.ase.acs.readers.Readable;
import ro.ase.acs.writers.Writeable;

public class Orchestrator {
    private Readable reader;
    private Writeable writer;
    // fac costructor injection ca sa scap de dependintele la ConsoleReader si ConsoleWriter
    public Orchestrator(Readable reader, Writeable writer){
        this.reader = reader;
        this.writer = writer;
    }
    public void execute(){
        writer.write(reader.read());
    }
}
