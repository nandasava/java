import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetSelectorApp extends JFrame {
    private JRadioButton catRadioButton;
    private JRadioButton dogRadioButton;
    private JRadioButton birdRadioButton;
    private JRadioButton rabbitRadioButton;
    private JRadioButton pigRadioButton;
    private JLabel petLabel;
    private JLabel petImageLabel; // To display the selected pet's image

    public PetSelectorApp() {
        setTitle("Pet Selector");
        setSize(400, 300); // Increased the window size for image display
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create radio buttons
        catRadioButton = new JRadioButton("Cat");
        dogRadioButton = new JRadioButton("Dog");
        birdRadioButton = new JRadioButton("Bird");
        rabbitRadioButton = new JRadioButton("Rabbit");
        pigRadioButton = new JRadioButton("Pig");

        // Create a ButtonGroup to ensure only one radio button is selected at a time
        ButtonGroup group = new ButtonGroup();
        group.add(catRadioButton);
        group.add(dogRadioButton);
        group.add(birdRadioButton);
        group.add(rabbitRadioButton);
        group.add(pigRadioButton);

        // Add radio buttons to the frame
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new GridLayout(5, 1));
        radioPanel.add(catRadioButton);
        radioPanel.add(dogRadioButton);
        radioPanel.add(birdRadioButton);
        radioPanel.add(rabbitRadioButton);
        radioPanel.add(pigRadioButton);
        add(radioPanel, BorderLayout.WEST);

        // Create a label to display the selected pet
        petLabel = new JLabel("Selected Pet: ");
        add(petLabel, BorderLayout.CENTER);

        // Create a label to display the selected pet's image
        petImageLabel = new JLabel();
        add(petImageLabel, BorderLayout.EAST);

        // Add action listeners to the radio buttons
        catRadioButton.addActionListener(new PetSelectionListener("Cat", "cat.jfif"));
        dogRadioButton.addActionListener(new PetSelectionListener("Dog", "dog.jfif"));
        birdRadioButton.addActionListener(new PetSelectionListener("Bird", "bird.jfif"));
        rabbitRadioButton.addActionListener(new PetSelectionListener("Rabbit", "rabbit.jfif"));
        pigRadioButton.addActionListener(new PetSelectionListener("Pig", "pig.jfif"));
    }

    private class PetSelectionListener implements ActionListener {
        private String petType;
        private String imagePath;

        public PetSelectionListener(String type, String image) {
            petType = type;
            imagePath = image;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            petLabel.setText("Selected Pet: " + petType);
            displayPetImage(imagePath);
        }
    }

    private void displayPetImage(String imagePath) {
        // Load and display the selected pet's image
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imagePath));
        petImageLabel.setIcon(imageIcon);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PetSelectorApp app = new PetSelectorApp();
            app.setVisible(true);
        });
    }
}
