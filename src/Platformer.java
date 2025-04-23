import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Platformer extends JPanel implements ActionListener, KeyListener {
    private int playerX = 50, playerY = 400;
    private int playerWidth = 50, playerHeight = 50;
    private int playerVelocityY = 0;
    private boolean isJumping = false;
    private boolean isFalling = true;
    private final int groundY = 450;
    private Timer timer;
    private ArrayList<Rectangle> obstacles;
    private ArrayList<Rectangle> clouds;
    private int cloudSpeed = 2;
    private int level1Plays = 0, level2Plays = 0;
    private int currentScore = 0;
    private int highScore = 0;
    private boolean inGame = false;
    private Font pixelFont;
    private Color neonPink = new Color(255, 105, 180);
    private Color neonCyan = new Color(0, 255, 255);
    private Color neonGreen = new Color(0, 255, 0);

    public Platformer() {
        setSize(800, 600);
        try {
            pixelFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/VT323-Regular.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pixelFont);
        } catch (Exception e) {
            pixelFont = new Font("Monospaced", Font.BOLD, 24);
        }

        timer = new Timer(20, this);
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setBackground(Color.BLACK);
        obstacles = new ArrayList<>();
        clouds = new ArrayList<>();
        HomePage();
        setVisible(true);
    }

    private void HomePage() {
        inGame = false;
        removeAll();
        setLayout(new BorderLayout());

        // Title panel
        JPanel titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        JLabel titleLabel = new JLabel("JumpBlox", SwingConstants.CENTER);
        titleLabel.setFont(pixelFont.deriveFont(48f));
        titleLabel.setForeground(neonPink);
        titlePanel.add(titleLabel);
        add(titlePanel, BorderLayout.NORTH);

        // Menu panel for buttons
        JPanel menuPanel = new JPanel();
        menuPanel.setOpaque(false);
        menuPanel.setLayout(new GridLayout(3, 1, 10, 20)); // Increased vertical spacing
        menuPanel.setBorder(BorderFactory.createEmptyBorder(50, 200, 50, 200)); // Center with padding

        JButton newGameButton = createRetroButton("NEW GAME");
        JButton highScoreButton = createRetroButton("HIGH SCORE");
        JButton restartButton = createRetroButton("RESTART");

        newGameButton.addActionListener(e -> StartNewGame(1));
        highScoreButton.addActionListener(e -> TopScore());
        restartButton.addActionListener(e -> resetGame());

        menuPanel.add(newGameButton);
        menuPanel.add(highScoreButton);
        menuPanel.add(restartButton);

        add(menuPanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private JButton createRetroButton(String text) {
        JButton button = new JButton(text);
        button.setFont(pixelFont);
        button.setForeground(neonCyan);
        button.setBackground(Color.DARK_GRAY);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(neonPink, 3),
                BorderFactory.createLineBorder(neonCyan, 1)
        ));
        button.setFocusPainted(false);
        return button;
    }

    private void TopScore() {
        removeAll();
        setLayout(new BorderLayout());

        JPanel scorePanel = new JPanel();
        scorePanel.setOpaque(false);
        scorePanel.setLayout(new GridLayout(2, 1, 10, 20));

        JLabel scoreLabel = new JLabel("HIGH SCORE: " + highScore, SwingConstants.CENTER);
        scoreLabel.setFont(pixelFont.deriveFont(36f));
        scoreLabel.setForeground(neonPink);

        JButton backButton = createRetroButton("BACK");
        backButton.addActionListener(e -> HomePage());

        scorePanel.add(scoreLabel);
        scorePanel.add(backButton);

        add(scorePanel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void resetGame() {
        playerX = 50;
        playerY = 400;
        playerVelocityY = 0;
        isJumping = false;
        isFalling = true;
        currentScore = 0;
        StartNewGame(1);
    }

    private void StartNewGame(int level) {
        inGame = true;
        removeAll();
        setLayout(null);
        playerX = 50;
        playerY = 400;
        currentScore = 0;
        obstacles = new ArrayList<>();
        clouds = new ArrayList<>();

        if (level == 1) {
            obstacles.add(new Rectangle(200, 380, 70, 20));
            obstacles.add(new Rectangle(290, 330, 100, 20));
            obstacles.add(new Rectangle(430, 270, 70, 20));
            obstacles.add(new Rectangle(550, 240, 150, 20));
            obstacles.add(new Rectangle(590, 220, 10, 10));
            clouds.add(new Rectangle(800, 100, 100, 30));
            clouds.add(new Rectangle(1200, 150, 120, 40));
            clouds.add(new Rectangle(1600, 80, 150, 50));
            level1Plays++;
        } else if (level == 2) {
            obstacles.add(new Rectangle(150, 370, 80, 20));
            obstacles.add(new Rectangle(280, 320, 100, 20));
            obstacles.add(new Rectangle(420, 290, 80, 20));
            obstacles.add(new Rectangle(530, 260, 150, 20));
            obstacles.add(new Rectangle(570, 240, 10, 10));
            obstacles.add(new Rectangle(320, 300, 10, 10));
            clouds.add(new Rectangle(900, 90, 110, 35));
            clouds.add(new Rectangle(1300, 140, 130, 45));
            clouds.add(new Rectangle(1800, 70, 160, 55));
            level2Plays++;
        }
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!inGame) return;

        playerY += playerVelocityY;
        if (isFalling || isJumping) {
            playerVelocityY += 1;
        }

        if (playerY + playerHeight >= groundY) {
            playerY = groundY - playerHeight;
            isJumping = false;
            isFalling = false;
            playerVelocityY = 0;
        } else {
            isFalling = true;
        }

        boolean onObstacle = false;
        for (Rectangle obstacle : obstacles) {
            if (new Rectangle(playerX, playerY, playerWidth, playerHeight).intersects(obstacle)) {
                if (playerY + playerHeight - playerVelocityY <= obstacle.y) {
                    playerY = obstacle.y - playerHeight;
                    isJumping = false;
                    isFalling = false;
                    playerVelocityY = 0;
                    onObstacle = true;
                } else if (obstacle.height == 10 && obstacle.width == 10) {
                    updateHighScore();
                    resetPlayer();
                    HomePage();
                    return;
                }
            }
        }
        if (!onObstacle && playerY + playerHeight < groundY) {
            isFalling = true;
        }

        if (playerX < 0) playerX = 0;
        if (playerX + playerWidth > getWidth()) playerX = getWidth() - playerWidth;

        for (Rectangle cloud : clouds) {
            cloud.x -= cloudSpeed;
            if (cloud.x + cloud.width < 0) {
                cloud.x = getWidth();
            }
        }

        currentScore = Math.max(currentScore, playerX / 10);
        repaint();
    }

    private void updateHighScore() {
        highScore = Math.max(highScore, currentScore);
    }

    private void resetPlayer() {
        updateHighScore();
        playerX = 50;
        playerY = 400;
        playerVelocityY = 0;
        isJumping = false;
        isFalling = true;
        currentScore = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);

        if (!inGame) {
            return;
        }

        g.setColor(neonCyan);
        g.fillRect(playerX, playerY, playerWidth, playerHeight);

        g.setColor(neonGreen);
        g.fillRect(0, groundY, getWidth(), getHeight() - groundY);

        g.setColor(Color.YELLOW);
        for (Rectangle obstacle : obstacles) {
            if (obstacle.height == 10 && obstacle.width == 10) {
                g.setColor(Color.RED);
                g.fillOval(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
            } else {
                g.setColor(Color.YELLOW);
                g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
            }
        }

        g.setColor(Color.WHITE);
        for (Rectangle cloud : clouds) {
            g.fillRoundRect(cloud.x, cloud.y, cloud.width, cloud.height, 20, 20);
        }

        g.setFont(pixelFont);
        g.setColor(neonPink);
        g.drawString("SCORE: " + currentScore, 10, 30);
        g.drawString("HIGH SCORE: " + highScore, 10, 60);
        g.drawString("LEVEL: " + (level1Plays > level2Plays ? "1" : "2"), 10, 90);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!inGame) return;

        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP && !isJumping && !isFalling) {
            isJumping = true;
            playerVelocityY = -15;
        }
        if (code == KeyEvent.VK_LEFT) {
            playerX -= 10;
        }
        if (code == KeyEvent.VK_RIGHT) {
            playerX += 10;
        }
        if (code == KeyEvent.VK_1) {
            StartNewGame(1);
        }
        if (code == KeyEvent.VK_2) {
            StartNewGame(2);
        }
        if (code == KeyEvent.VK_ESCAPE) {
            resetPlayer();
            HomePage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("JumpBlox");
        Platformer game = new Platformer();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}