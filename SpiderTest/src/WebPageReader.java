import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.swing.JLabel;

class WebpageReader implements Runnable {
    private JLabel _label;
    private URL _url;
    public WebpageReader(JLabel label, String url) {
        _label = label;
        try {
            _url = new URL(url);
        }
        catch (Exception ex) {
            _url = null;
        }
    }

    public void run() {
        if (_url == null) return;
        try {
            _label.setText(String.format("reading from %s", _url.toString()));
            BufferedReader rdr = new BufferedReader(new InputStreamReader(_url.openStream()));
            String line;
            while ((line = rdr.readLine()) != null) {
                if (line.contains("href="))
                    _label.setText(line);
            }
            _label.setText("done");
        }
        catch (Exception ex) {
            System.out.printf("Oops: %s", ex.getMessage());
        }
    }
}