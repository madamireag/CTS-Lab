package ro.ase.acs.main;


import ro.ase.acs.iocContainer.IoC;
import ro.ase.acs.readers.Readable;
import ro.ase.acs.writers.Writeable;

public class Orchestrator {
    private Readable reader;
    private Writeable writer;
    private IoC container;
    // fac costructor injection ca sa scap de dependintele la ConsoleReader si ConsoleWriter
    public Orchestrator(Readable reader, Writeable writer){
        this.reader = reader;
        this.writer = writer;
    }
    public Orchestrator(IoC container){
        this.container = container;
        this.reader = this.container.resolve(Readable.class);
        this.writer = this.container.resolve(Writeable.class);
    }

    public void execute(){
        if(writer!= null && reader!=null) {
            writer.write(reader.read());
        }
    }

    @Override
    public String toString() {
        return "Orchestrator{" +
                "reader=" + reader +
                ", writer=" + writer +
                ", container=" + container +
                '}';
    }
}
