package ro.ase.acs.template;

public class RomanianCuisineLunch extends LunchTemplate {
    @Override
    protected void mainCourse() {
        System.out.println("Sarmale cu mamaliguta");
    }

    @Override
    protected void dessert() {
        System.out.println("Papanasi");
    }

    @Override
    protected void appetizer() {
        System.out.println("Zacusca de vinete");
    }
}
