import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class AddGUI {
    private Model model;
    private JFrame frame;

    private JLabel emplPicture;
    private JLabel elephPicture;
    private JLabel ostPicture;
    private JLabel tigerPicture;
    private JLabel flamPicture;

    private JTextField emplName;
    private JTextField elephName;
    private JTextField ostName;
    private JTextField tigerName;
    private JTextField flamName;

    private JRadioButton employerButton;
    private JRadioButton elephantButton;
    private JRadioButton ostrichButton;
    private JRadioButton tigerButton;
    private JRadioButton flamButton;
    private JButton add;

    AddGUI(Model model) {
        this.model = model;
        frame = new JFrame();
        GridBagLayout gbl = new GridBagLayout();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setLayout(gbl);

        //Create the radio buttons.
        employerButton = new JRadioButton("Работник");
        GBC gbc = new GBC(0, 0);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(1, 0);
        gbc.setAnchor(GridBagConstraints.EAST);
        gbl.setConstraints(employerButton, gbc);
        frame.add(employerButton);

        elephantButton = new JRadioButton("Слон");
        gbc = new GBC(0, 1);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(1, 0);
        gbl.setConstraints(elephantButton, gbc);
        frame.add(elephantButton);

        ostrichButton = new JRadioButton("Страус");
        gbc = new GBC(0, 2);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(1, 0);
        gbl.setConstraints(ostrichButton, gbc);
        frame.add(ostrichButton);

        tigerButton = new JRadioButton("Тигр");
        gbc = new GBC(0, 3);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(1, 0);
        gbl.setConstraints(tigerButton, gbc);
        frame.add(tigerButton);

        flamButton = new JRadioButton("Фламинго");
        gbc = new GBC(0, 4);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setFill(GridBagConstraints.HORIZONTAL);
        gbc.setWeight(1, 0);
        gbl.setConstraints(flamButton, gbc);
        frame.add(flamButton);

        //Group the radio buttons.
        ButtonGroup group = new ButtonGroup();
        group.add(employerButton);
        group.add(elephantButton);
        group.add(ostrichButton);
        group.add(tigerButton);
        group.add(flamButton);

        add = new JButton("Добавить");
        add.setIcon(new ImageIcon("icons8_Add_New_32.png"));
        gbc = new GBC(0, 7);
        gbc.setInsets(2, 4, 2, 4);
        gbc.setAnchor(GridBagConstraints.WEST);
        gbl.setConstraints(add, gbc);
        add.setVisible(false);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (employerButton.isSelected()) {
                    if (emplName.getText().equals("")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    if (emplName.getText().equals("Введите имя работника")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    else {
                        model.addEmployer(new Employer(emplName.getText()));
                        emplName.setText("Введите имя рабоника");
                    }
                }
                if (elephantButton.isSelected()) {
                    if (elephName.getText().equals("")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    if (elephName.getText().equals("Введите имя слона")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    else {
                        model.addElephant(new Elephant(elephName.getText()));
                        elephName.setText("Введите имя слона");
                    }

                }
                if (ostrichButton.isSelected()) {
                    if (ostName.getText().equals("")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    if (ostName.getText().equals("Введите имя страуса")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    else {
                        model.addOstrich(new Ostrich(ostName.getText()));
                        ostName.setText("Введите имя страуса");
                    }
                }

                if (tigerButton.isSelected()) {
                    if (tigerName.getText().equals("")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    if (tigerName.getText().equals("Введите имя тигра")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    else {
                        model.addTiger(new Tiger(tigerName.getText()));
                        tigerName.setText("Введите имя тигра");
                    }
                }

                if (flamButton.isSelected()) {
                    if (flamName.getText().equals("")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    if (flamName.getText().equals("Введите имя фламинго")) {
                        JOptionPane mess = new JOptionPane();
                        mess.showMessageDialog(frame, "Введите имя!");
                    }
                    else {
                        model.addFlamingo(new Flamingo(flamName.getText()));
                        flamName.setText("Введите имя фламинго");
                    }
                }


            }
        });

        frame.add(add);
        frame.setVisible(true);


        //Register a listener for the radio buttons.
        employerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (emplPicture == null) {
                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }
                    emplPicture = new JLabel();
                    emplPicture.setIcon(new ImageIcon("icons8_Employer_64.png"));
                    GBC gbc = new GBC(0, 5);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.BOTH);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(emplPicture, gbc);
                    emplPicture.setVisible(true);
                    frame.add(emplPicture);

                    emplName = new JTextField("Введите имя работника");
                    emplName.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            emplName.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            emplName.setText(emplName.getText());
                        }
                    });


                    gbc = new GBC(0, 6);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.HORIZONTAL);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(emplName, gbc);
                    emplName.setVisible(true);
                    frame.add(emplName);
                    frame.setVisible(true);
                }
                else
                {
                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }
                    emplPicture.setVisible(true);
                    emplName.setText("Введите имя работника");
                    emplName.setVisible(true);
                }
                add.setVisible(true);
            }
        });
        elephantButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (elephPicture == null)
                {
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }
                    elephPicture = new JLabel();
                    elephPicture.setIcon(new ImageIcon("icons8_Elephant_64.png"));
                    GBC gbc = new GBC(0, 5);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.BOTH);
//                gbc.setWeight(0.1, 0.1);
                    gbl.setConstraints(elephPicture, gbc);
                    elephPicture.setVisible(true);
                    frame.add(elephPicture);

                    elephName = new JTextField("Введите имя слона");
                    elephName.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            elephName.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            elephName.setText(elephName.getText());
                        }
                    });


                    gbc = new GBC(0, 6);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.HORIZONTAL);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(elephName, gbc);
                    elephName.setText("Введите имя слона");
                    elephName.setVisible(true);
                    frame.add(elephName);
                    frame.setVisible(true);
                }
                else {
                    elephPicture.setVisible(true);
                    elephName.setVisible(true);
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }
                }
                add.setVisible(true);
            }
        });
        ostrichButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ostPicture == null) {
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }
                    ostPicture = new JLabel();
                    ostPicture.setIcon(new ImageIcon("icons8_Ostrich_64.png"));
                    GBC gbc = new GBC(0, 5);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.BOTH);
//                gbc.setWeight(0.1, 0.1);
                    gbl.setConstraints(ostPicture, gbc);
                    ostPicture.setVisible(true);
                    frame.add(ostPicture);

                    ostName = new JTextField("Введите имя страуса");
                    ostName.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            ostName.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            ostName.setText(ostName.getText());
                        }
                    });


                    gbc = new GBC(0, 6);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.HORIZONTAL);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(ostName, gbc);
                    ostName.setText("Введите имя страуса");
                    ostName.setVisible(true);
                    frame.add(ostName);
                    frame.setVisible(true);
                }
                else {
                    ostPicture.setVisible(true);
                    ostName.setVisible(true);
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }
                }
                add.setVisible(true);

            }
        });



        tigerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tigerPicture == null) {

                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }

                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    tigerPicture = new JLabel();
                    tigerPicture.setIcon(new ImageIcon("icons8_Tiger_64.png"));
                    GBC gbc = new GBC(0, 5);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.BOTH);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(tigerPicture, gbc);
                    tigerPicture.setVisible(true);
                    frame.add(tigerPicture);

                    tigerName = new JTextField("Введите имя тигра");
                    tigerName.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            tigerName.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            tigerName.setText(tigerName.getText());
                        }
                    });


                    gbc = new GBC(0, 6);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.HORIZONTAL);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(tigerName, gbc);
                    tigerName.setVisible(true);
                    frame.add(tigerName);
                    frame.setVisible(true);
                }
                else
                {
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (flamPicture != null) {
                        flamPicture.setVisible(false);
                        flamName.setVisible(false);
                    }

                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    tigerPicture.setVisible(true);
                    tigerName.setText("Введите имя тигра");
                    tigerName.setVisible(true);
                }
                add.setVisible(true);
            }
        });

        flamButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flamPicture == null)
                {
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                    flamPicture = new JLabel();
                    flamPicture.setIcon(new ImageIcon("icons8_Flamingo_64.png"));
                    GBC gbc = new GBC(0, 5);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.BOTH);
//                gbc.setWeight(0.1, 0.1);
                    gbl.setConstraints(flamPicture, gbc);
                    flamPicture.setVisible(true);
                    frame.add(flamPicture);

                    flamName = new JTextField("Введите имя фламинго");
                    flamName.addFocusListener(new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent e) {
                            flamName.setText(null);
                        }

                        @Override
                        public void focusLost(FocusEvent e) {
                            flamName.setText(flamName.getText());
                        }
                    });


                    gbc = new GBC(0, 6);
                    gbc.setInsets(2, 4, 2, 4);
                    gbc.setFill(GridBagConstraints.HORIZONTAL);
//                    gbc.setWeight(0.2, 0.2);
                    gbl.setConstraints(flamName, gbc);
                    flamName.setText("Введите имя фламинго");
                    flamName.setVisible(true);
                    frame.add(flamName);
                    frame.setVisible(true);
                }
                else {
                    flamPicture.setVisible(true);
                    flamName.setVisible(true);
                    if (emplPicture != null) {
                        emplPicture.setVisible(false);
                        emplName.setVisible(false);
                    }
                    if (ostPicture != null) {
                        ostPicture.setVisible(false);
                        ostName.setVisible(false);
                    }
                    if (tigerPicture != null) {
                        tigerPicture.setVisible(false);
                        tigerName.setVisible(false);
                    }
                    if (elephPicture != null) {
                        elephPicture.setVisible(false);
                        elephName.setVisible(false);
                    }
                }
                add.setVisible(true);
            }
        });


    }
}
