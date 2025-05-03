import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPanel extends JPanel {
    private Runnable startGameCallback;

    public MenuPanel(Runnable startGameCallback) {
        this.startGameCallback = startGameCallback;
        this.setPreferredSize(new Dimension(600, 600));
        this.setBackground(Color.decode("#4ea1b1"));
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int mx = e.getX();
                int my = e.getY();
                if (mx >= 220 && mx <= 380 && my >= 300 && my <= 360) {
                    startGameCallback.run();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.setFont(new Font("Segoe UI", Font.BOLD, 60));
        FontMetrics fm = getFontMetrics(g.getFont());
        g.drawString("Snake Game", (600 - fm.stringWidth("Snake Game")) / 2, 200);

        // Set the color for the border around the button
        Graphics2D g2d = getGraphics2D((Graphics2D) g);

        FontMetrics metrics = g.getFontMetrics();
        String playText = "Play";
        int textX = (GamePanel.SCREEN_WIDTH - metrics.stringWidth(playText)) / 2;
        int textY = GamePanel.SCREEN_HEIGHT / 2 + 10;

        g2d.drawString(playText, textX, textY);
    }

    private static Graphics2D getGraphics2D(Graphics2D g) {
        Graphics2D g2d = g;
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRoundRect(GamePanel.SCREEN_WIDTH / 2 - 100, GamePanel.SCREEN_HEIGHT / 2 - 50, 200, 80, 30, 30); // Draw rounded rectangle border


        g2d.setColor(new Color(32, 255, 0));
        g2d.fillRoundRect(GamePanel.SCREEN_WIDTH / 2 - 100, GamePanel.SCREEN_HEIGHT / 2 - 50, 200, 80, 30, 30);

        g2d.setColor(Color.white);
        g2d.setFont(new Font("Segoe UI", Font.BOLD, 40));
        return g2d;
    }
}
