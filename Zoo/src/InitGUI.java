import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Класс предназначен для вывода и управления данными на экране
 */
public class InitGUI implements Subscriber{
    private Model model;

    private JFrame frame;
    private JLabel employerLabel;
    private JComboBox employerComboBox;

    private JLabel animalsLabel;
    private JComboBox animalsComboBox;

    private JLabel curAnimalLabel;
    private JComboBox curAnimalComboBox;

    private JButton addButton;
    private JButton feedButton;
    private JButton cleanButton;
    private JButton lookButton;

    private Visitor visitor;

    InitGUI(Model model) {
        this.visitor = new Visitor();
        this.model = model;
        model.addSubscriber(this);
        frame = new JFrame();
        GridBagLayout gbl = new GridBagLayout();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setLayout(gbl);

        employerLabel = new JLabel();
        employerLabel.setText("Работники:");
        GBC gbc = new GBC(0, 0, 0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(0, 0.1);
        gbl.setConstraints(employerLabel, gbc);
        frame.add(employerLabel);

        employerComboBox = new JComboBox();
        gbc = new GBC(0, 2, 0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(0, 0.1);
        gbl.setConstraints(employerComboBox, gbc);
        frame.add(employerComboBox);

        animalsLabel = new JLabel();
        animalsLabel.setText("Животные:");
        gbc = new GBC(0, 6, 0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);

        gbc.setWeight(0, 0.1);
        gbl.setConstraints(animalsLabel, gbc);
        frame.add(animalsLabel);

        animalsComboBox = new JComboBox();
        animalsComboBox.addItem("Слоны");
        animalsComboBox.addItem("Страусы");
        animalsComboBox.addItem("Тигры");
        animalsComboBox.addItem("Фламинго");
        gbc = new GBC(0, 8, 0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(0, 0.1);
        gbl.setConstraints(animalsComboBox, gbc);
        frame.add(animalsComboBox);

        curAnimalLabel = new JLabel(" ");
        gbc = new GBC(0, 10, 0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.BOTH);
        gbc.setWeight(0, 0.1);
        gbl.setConstraints(curAnimalLabel, gbc);
        curAnimalLabel.setVisible(false);
        frame.add(curAnimalLabel);

        curAnimalComboBox = new JComboBox();
        gbc = new GBC(0, 12, 0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(0, 0.1);
        gbl.setConstraints(curAnimalComboBox, gbc);
        curAnimalComboBox.setVisible(false);
        frame.add(curAnimalComboBox);

        addButton = new JButton("Добавить");
        addButton.setIcon(new ImageIcon("icons8_Add_New_32.png"));
        gbc = new GBC(0, 14, 6, 2);
        gbc.setInsets(2, 4, 25, 4);
        gbc.setWeight(0, 2);
        gbc.setAnchor(GridBagConstraints.SOUTH);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbl.setConstraints(addButton, gbc);
        frame.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                frame.setVisible(false);
                AddGUI addgui = new AddGUI(model);
//                frame.setVisible(true);
            }
        });

        feedButton = new JButton("Покормить");
        feedButton.setIcon(new ImageIcon("icons8_Dog_Bowl_32.png"));
        gbc = new GBC(6, 14, 6, 2);
        gbc.setInsets(2, 4, 25, 4);

        gbc.setAnchor(GridBagConstraints.SOUTH);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbl.setConstraints(feedButton, gbc);
        frame.add(feedButton);

        cleanButton = new JButton("Убрать клетку");
        cleanButton.setIcon(new ImageIcon("icons8_Broom_32.png"));
        gbc = new GBC(12, 14, 6, 2);
        gbc.setInsets(2, 4, 25, 4);

        gbc.setAnchor(GridBagConstraints.SOUTH);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbl.setConstraints(cleanButton, gbc);
        frame.add(cleanButton);

        lookButton = new JButton("Просмотреть животное");
        lookButton.setIcon(new ImageIcon("icons8_Look_32.png"));
        gbc = new GBC(18, 14, 6, 2);
        gbc.setInsets(2, 4, 25, 4);

        gbc.setAnchor(GridBagConstraints.SOUTH);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbl.setConstraints(lookButton, gbc);
        frame.add(lookButton);

//        this.add(initPanel);
        frame.setVisible(true);


        animalsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animalsComboBox.getSelectedItem() == "Слоны") {
                    curAnimalLabel.setText("Слон");
                    curAnimalComboBox.removeAllItems();
                    for (Elephant elephant: model.elephants) {
                        curAnimalComboBox.addItem(elephant.getName());
                    }
                    curAnimalLabel.setVisible(true);
                    curAnimalComboBox.setVisible(true);
                }

                if (animalsComboBox.getSelectedItem() == "Страусы") {
                    curAnimalLabel.setText("Страус");
                    curAnimalComboBox.removeAllItems();
                    for (Ostrich ostrich: model.ostriches) {
                        curAnimalComboBox.addItem(ostrich.getName());
                    }
                    curAnimalLabel.setVisible(true);
                    curAnimalComboBox.setVisible(true);
                }

                if (animalsComboBox.getSelectedItem() == "Тигры") {
                    curAnimalLabel.setText("Тигр");
                    curAnimalComboBox.removeAllItems();
                    for (Tiger tiger: model.tigers) {
                        curAnimalComboBox.addItem(tiger.getName());
                    }
                    curAnimalLabel.setVisible(true);
                    curAnimalComboBox.setVisible(true);
                }

                if (animalsComboBox.getSelectedItem() == "Фламинго") {
                    curAnimalLabel.setText("Фламинго");
                    curAnimalComboBox.removeAllItems();
                    for (Flamingo flamingo: model.flamingos) {
                        curAnimalComboBox.addItem(flamingo.getName());
                    }
                    curAnimalLabel.setVisible(true);
                    curAnimalComboBox.setVisible(true);
                }
            }
        });

        feedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (employerComboBox.getSelectedItem() == null || curAnimalComboBox.getSelectedItem() == null) {
                    JOptionPane mess = new JOptionPane();
                    mess.showMessageDialog(frame, "Необходимо выбрать работника и животное!");
                }
                else {
                    int employerIndex = employerComboBox.getSelectedIndex();
                    int animalIndex = curAnimalComboBox.getSelectedIndex();
                    if (animalsComboBox.getSelectedItem() == "Слоны") {
                        model.employers.elementAt(employerIndex).feed(model.elephants.elementAt(animalIndex), frame);
                    }
                    if (animalsComboBox.getSelectedItem() == "Страусы") {
                        model.employers.elementAt(employerIndex).feed(model.ostriches.elementAt(animalIndex), frame);
                    }
                    if (animalsComboBox.getSelectedItem() == "Тигры") {
                        model.employers.elementAt(employerIndex).feed(model.tigers.elementAt(animalIndex), frame);
                    }
                    if (animalsComboBox.getSelectedItem() == "Фламинго") {
                        model.employers.elementAt(employerIndex).feed(model.flamingos.elementAt(animalIndex), frame);
                    }

                }
            }
        });

        lookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitor.lookAnimal(model.randAnimal(), frame);
            }
        });

        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (employerComboBox.getSelectedItem() == null || curAnimalComboBox.getSelectedItem() == null) {
                    JOptionPane mess = new JOptionPane();
                    mess.showMessageDialog(frame, "Необходимо выбрать работника и животное!");
                }
                else {
                    int employerIndex = employerComboBox.getSelectedIndex();
                    int animalIndex = curAnimalComboBox.getSelectedIndex();
                    if (animalsComboBox.getSelectedItem() == "Слоны") {
                        model.employers.elementAt(employerIndex).clean(model.elephants.elementAt(animalIndex), frame);
                    }
                    if (animalsComboBox.getSelectedItem() == "Страусы") {
                        model.employers.elementAt(employerIndex).clean(model.ostriches.elementAt(animalIndex), frame);
                    }
                    if (animalsComboBox.getSelectedItem() == "Тигры") {
                        model.employers.elementAt(employerIndex).clean(model.tigers.elementAt(animalIndex), frame);
                    }
                    if (animalsComboBox.getSelectedItem() == "Фламинго") {
                        model.employers.elementAt(employerIndex).clean(model.flamingos.elementAt(animalIndex), frame);
                    }

                }
            }
        });

    }

    @Override
    public void updateEmployers() {
        employerComboBox.removeAllItems();
        for (Employer emp : model.employers) {
            employerComboBox.addItem(emp.getName());
        }
    }

    @Override
    public void updateElephants() {
        if (animalsComboBox.getSelectedItem() == "Слоны") {
            curAnimalComboBox.removeAllItems();
            for (Elephant el : model.elephants) {
                curAnimalComboBox.addItem(el.getName());
            }
        }
    }

    @Override
    public void updateOstrich() {
        if (animalsComboBox.getSelectedItem() == "Страусы") {
            curAnimalComboBox.removeAllItems();
            for (Ostrich ostrich : model.ostriches) {
                curAnimalComboBox.addItem(ostrich.getName());
            }
        }

    }

    @Override
    public void updateTigers() {
        if (animalsComboBox.getSelectedItem() == "Тигры") {
            curAnimalComboBox.removeAllItems();
            for (Tiger tiger : model.tigers) {
                curAnimalComboBox.addItem(tiger.getName());
            }
        }

    }
    @Override
    public void updateFlamingos() {
        if (animalsComboBox.getSelectedItem() == "Фламинго") {
            curAnimalComboBox.removeAllItems();
            for (Flamingo flamingo : model.flamingos) {
                curAnimalComboBox.addItem(flamingo.getName());
            }
        }

    }
}
