import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SpiderSlave implements Runnable {
	
	private SpiderMaster spidermaster;
	
	public SpiderSlave(SpiderMaster spidermaster) {
		this.spidermaster = spidermaster;
	}

	@Override
	public void run() {
		if (spidermaster.get_url() == null) return;
		try {
			_label.setText(String.format("Reading from %s", _url.toString()));
			BufferedReader rdr = new BufferedReader(new InputStreamReader(_url.openStream()));
			String line;
			while ((line = rdr.readLine()) != null) {
				if (line.contains("href="))
					_label.setText(line);
			}
			_label.setText("Done");
		} catch (Exception ex) {
			System.out.printf("Oops: %s", ex.getMessage());
		}
		
	}

}
