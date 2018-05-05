import java.util.Vector;

public class Zoo {

    public Vector<Employer> employers;
    public Vector<Animal> animals;

    public static void main(String[] args) {
        Model model = new Model();

        InitGUI gui = new InitGUI(model);

    }
}
