import javax.swing.*;

public class Visitor {
    public void lookAnimal(Animal animal, JFrame frame) {
        JOptionPane mess = new JOptionPane();
        if (animal == null) {
            mess.showMessageDialog(frame, "Зоопарк пуст");
        }
        else {
            mess.showMessageDialog(frame, "Имя животного: " + animal.getName(),
                    "Данные о животном", JOptionPane.NO_OPTION);
        }
    }
}
