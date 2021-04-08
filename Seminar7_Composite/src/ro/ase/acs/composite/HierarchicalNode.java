package ro.ase.acs.composite;

// asta e ComponentaAbstracta din schema
public interface HierarchicalNode {
    // metode specifice
    public float getSalary();
    public String getName();
    // metodele care vor trebui implementate de composite si nu de frunza
    public void addHierarchicalNode(HierarchicalNode node);
    public void deleteHierarchicalNode(HierarchicalNode node);

    default public HierarchicalNode searchNodeByName(String name) {
        throw new UnsupportedOperationException();
    }
}
