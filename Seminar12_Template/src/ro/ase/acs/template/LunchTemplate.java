package ro.ase.acs.template;

// template testare din diagrama
public abstract class LunchTemplate {

    public void takeLunch() {
        System.out.println("Appetizer: ");
        appetizer();
        System.out.println("Main Course: ");
        mainCourse();
        System.out.println("Dessert: ");
        dessert();
    }

    protected abstract void mainCourse();

    protected abstract void dessert();

    protected abstract void appetizer();


}
