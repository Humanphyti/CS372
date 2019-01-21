import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class ThreadTest extends JFrame {
    
	private String[] webpages = {"https://docs.oracle.com/javase/7/docs", "http://www.espn.com/","https://www.whitworth.edu/cms/"};
    public ThreadTest() {
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        this.setVisible(true);

        WebpageReader[] cs = new WebpageReader[webpages.length];
        for (int i=0; i< cs.length; i++) {
            JLabel l = new JLabel();
            cs[i] = new WebpageReader(l, webpages[i]);
            this.add(l);
        }    
        Thread[] ts = new Thread[webpages.length];
        for (int i=0; i< ts.length; i++) {
            ts[i] = new Thread(cs[i]);
            ts[i].start();
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) {;}
        }
        for (int i=0; i<ts.length; i++) {
            try {
                ts[i].join();
            }
            catch (InterruptedException ex) {;}
        }
        JLabel i = new JLabel("done");
        this.add(i);
        revalidate();
    }
        

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();
    }
}