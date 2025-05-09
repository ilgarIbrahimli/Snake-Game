import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class GameOverPanel {
    private Rectangle retryButton = new Rectangle(GamePanel.SCREEN_WIDTH / 2 - 100, GamePanel.SCREEN_HEIGHT / 2, 200, 100);

    public void draw(Graphics g, int score, int width, int height) {
        // Cast to Graphics2D for more control over rendering
        Graphics2D g2d = (Graphics2D) g;

        // Set background color and fill the screen
        g.setColor(Color.decode("#4ea1b1"));
        g.fillRect(0, 0, width, height);

        // Draw the "Game Over" text
        g.setColor(Color.RED);
        g.setFont(new Font("Segoe UI", Font.BOLD, 75));
        g.drawString("Game Over", 100, 200);

        // Draw the score text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        g.drawString("Score: " + score, GamePanel.SCREEN_WIDTH / 2 - 50, GamePanel.SCREEN_HEIGHT / 2 - 30);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Smooth edges
        g2d.setColor(Color.GREEN);  // Set color for button
        g2d.fillRoundRect(retryButton.x, retryButton.y, retryButton.width, retryButton.height, 50, 50); // Rounded corners with higher radius for smoother look

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3)); // Thicker border for clean lines
        g2d.drawRoundRect(retryButton.x, retryButton.y, retryButton.width, retryButton.height, 50, 50);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, 50));
        FontMetrics fm = g.getFontMetrics();
        int textX = retryButton.x + (retryButton.width - fm.stringWidth("RETRY")) / 2;
        int textY = retryButton.y + (retryButton.height + fm.getHeight()) / 2 - 10;
        g.drawString("RETRY", textX, textY);
    }

    public boolean isRetryClicked(Point p) {
        return retryButton.contains(p);
    }
}
