import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame() {
        this.setTitle("Snake Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        // Start with the menu
        showMenu();

        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void showMenu() {
        MenuPanel menuPanel = new MenuPanel(() -> {
            // Switch to GamePanel
            SwingUtilities.invokeLater(this::startGame);
        });
        this.setContentPane(menuPanel);
        this.revalidate();
    }

    private void startGame() {
        GamePanel gamePanel = new GamePanel();
        this.setContentPane(gamePanel);
        this.revalidate();
        gamePanel.requestFocusInWindow(); // important for key input
    }

    public static void main(String[] args) {
        new GameFrame();
    }
}
