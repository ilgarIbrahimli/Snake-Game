import java.awt.*;

public class GameOverPanel {
    private Rectangle retryButton = new Rectangle(250, 350, 100, 40);

    public void draw(Graphics g, int score, int width, int height) {
        g.setColor(Color.decode("#4ea1b1"));
        g.fillRect(0, 0, width, height);

        g.setColor(Color.RED);
        g.setFont(new Font("Segoe UI", Font.BOLD, 75));
        g.drawString("Game Over", 100, 200);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.PLAIN, 30));
        g.drawString("Score: " + score, 230, 270);

        g.setColor(Color.GRAY);
        g.fillRect(retryButton.x, retryButton.y, retryButton.width, retryButton.height);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Segoe UI", Font.BOLD, 20));
        g.drawString("Retry", retryButton.x + 20, retryButton.y + 27);
    }

    public boolean isRetryClicked(Point p) {
        return retryButton.contains(p);
    }
}