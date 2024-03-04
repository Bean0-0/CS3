import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class DrawingFrame extends JFrame {
    private Point lineStart;
    private Image screenImage;
    private Graphics screenGraphics;
    private Stack<Image> undoStack = new Stack<>();

    public DrawingFrame() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(800, 600));
        panel.setLayout(null);

        JLabel label = new JLabel("<html><i>1. Draw: Press and hold left mouse button.<br>2. Erase: Hold Shift and left mouse button.<br>3. Clear: Double click left mouse button.<br>4. Undo: Press Ctrl+Z.</i></html>");
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        label.setBounds(20, 20, 600, 60);
        panel.add(label);

        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                lineStart = e.getPoint();
                if (e.getClickCount() == 2) {
                    clearScreen();
                }
                saveToUndoStack();
            }
        });

        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Point p = e.getPoint();
                if (e.isShiftDown()) {
                    eraseLine(lineStart, p);
                } else {
                    drawLine(lineStart, p);
                }
                lineStart = p;
            }
        });

        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if ((e.getKeyCode() == KeyEvent.VK_Z) && ((e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)) {
                    undo();
                }
            }
        });

        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void drawLine(Point start, Point end) {
        screenGraphics.setColor(Color.BLACK);
        screenGraphics.drawLine(start.x, start.y, end.x, end.y);
        repaint();
    }

    private void eraseLine(Point start, Point end) {
        screenGraphics.setColor(Color.WHITE);
        screenGraphics.drawLine(start.x, start.y, end.x, end.y);
        repaint();
    }

    private void clearScreen() {
        screenGraphics.setColor(Color.WHITE);
        screenGraphics.fillRect(0, 0, this.getWidth(), this.getHeight());
        repaint();
    }

    private void saveToUndoStack() {
        Image copyImage = createImage(this.getWidth(), this.getHeight());
        Graphics copyGraphics = copyImage.getGraphics();
        copyGraphics.drawImage(screenImage, 0, 0, null);
        undoStack.push(copyImage);
    }

    private void undo() {
        if (!undoStack.isEmpty()) {
            screenImage = undoStack.pop();
            screenGraphics = screenImage.getGraphics();
            repaint();
        }
    }

    public void paint(Graphics g) {
        if (screenImage == null) {
            screenImage = createImage(this.getWidth(), this.getHeight());
            screenGraphics = screenImage.getGraphics();
            clearScreen();
        }
        g.drawImage(screenImage, 0, 0, null);
    }

    public static void main(String[] args) {
        new DrawingFrame();
    }
}