import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Canvas extends JPanel {
    int MAX_ITER;   // THIS IS TEMPORARY FUCK YOU SHOULD TAKE IT FROM MANDELBROTCALCULATOR
    public List<Pixel> pixels; //static?????

    public Canvas(){
        this.setPreferredSize(new Dimension(900,600));
        this.MAX_ITER = MandelbrotCalculator.getMaxIterations();
        //this.setBackground(Color.BLACK);
    }

    public void setPixels(List<Pixel> pixels) {
        this.pixels = pixels;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Clear the previous graphics

        if (pixels != null) {
            Graphics2D g2D = (Graphics2D) g;

            for (Pixel i : pixels) {
                if (i.getOutStoodIterations() == MAX_ITER) {
                    g2D.setColor(Color.white);
                    g2D.fillRect(i.getDisplayX(), i.getDisplayY(), 1, 1);  // Draw pixel
                } else {
                    g2D.setColor(Color.black);
                    g2D.fillRect(i.getDisplayX(), i.getDisplayY(), 1, 1);  // Draw pixel
                }
            }
        }
    }

}
