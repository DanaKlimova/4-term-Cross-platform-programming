import javax.swing.*;

public class Employer {
    public String name;

    Employer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String feed(Animal animal, JFrame frame){
        animal.eat(frame);
        return "Покормил.";
    }

    public void clean(Animal animal, JFrame frame) {
        JOptionPane mess = new JOptionPane();
        mess.showMessageDialog(frame, name + ": "+"\nУ " + animal.getName() + " убрано!");
    }
}
