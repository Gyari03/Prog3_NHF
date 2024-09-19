import javax.swing.*;
import java.util.List;

public class MandelbrotFrame extends JFrame {
    private CanvasPanel canvasPanel;
    private ComputingUnit computer;



    public MandelbrotFrame(){

        //Logic
        computer = new ComputingUnit();
        computer.calculateMandelbrot();


        //Basic initialization
        setTitle("Mandelbrot set viewer");
        this.setSize(900,650);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null); //set the layout to manual

        //Adding canvas
        this.canvasPanel = new CanvasPanel(computer.getMaxIterations());
        this.add(canvasPanel);
        canvasPanel.setBounds(0,50,900,600);

        this.setVisible(true);

        updateCanvas(computer.getPixels());
    }

    public void updateCanvas(List<Pixel> pixels) {
        canvasPanel.setPixels(pixels);
        //canvas.repaint();
    }
}