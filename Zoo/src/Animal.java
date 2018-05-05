import javax.swing.*;

public class Animal {

    public String getName() {
        return name;
    }

    //    protected String body;
    protected String name;

    public String eat(JFrame frame){
        JOptionPane mess = new JOptionPane();
        mess.showMessageDialog(frame, name + ": "+"\nЯ покушал. Спасибо!");
        return "Я покушал. Спасибо!";
    }
}
