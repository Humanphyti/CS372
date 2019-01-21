import java.net.URL;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.swing.JLabel;

public class SpiderMaster{
	private JLabel _label;
	private URL _url;
	private LinkedBlockingQueue<String> webpages;// = {"https://en.wikipedia.org/wiki/CD_Projekt", "https://en.wikipedia.org/wiki/Larian_Studios", "https://bulbapedia.bulbagarden.net/wiki/Category:Games"};
	private Set<String> visitedURL;
	private int setSize;
	private int numSlaveThreads;
	private ExecutorService exec;
	
	public SpiderMaster(LinkedBlockingQueue<String> webpages, Set<String> visitedURL, int setSize, int numSalveThreads, ExecutorService exec) {
		this.webpages = webpages;
		this.visitedURL = visitedURL;
		this.setSize = setSize;
		this.numSlaveThreads = numSalveThreads;
		this.exec = exec;
	}

	/**
	 * @return the _label
	 */
	/*public JLabel get_label() {
		return _label;
	}

	/**
	 * @return the _url
	 */
	/*public URL get_url() {
		return _url;
	}*/

	/**
	 * @return the webpages
	 */
	public LinkedBlockingQueue<String> getWebpages() {
		return webpages;
	}

	/**
	 * @return the visitedURL
	 */
	public Set<String> getVisitedURL() {
		return visitedURL;
	}

	/**
	 * @return the setSize
	 */
	public int getSetSize() {
		return setSize;
	}

	/**
	 * @return the numSlaveThreads
	 */
	public int getNumSlaveThreads() {
		return numSlaveThreads;
	}

	/**
	 * @return the exec
	 */
	public ExecutorService getExec() {
		return exec;
	}

	public void crawl(String url) {
		for (int i = 0; i < numSlaveThreads; i++) {
			SpiderSlave ss = new SpiderSlave(this);
			exec.execute(ss);
		}
		
		try {
			webpages.put(url);
		} catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		exec.shutdown();
		try {
			exec.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		
	}

	

	
	
	
	/*public static void main(String[] args) {
		try {
			URL url = new URL("https://en.wikipedia.org/wiki/CD_Projekt");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("Name", "test");
			map.put("Phone", "555-1212");
			StringBuilder sb = new StringBuilder();
			for (Map.Entry<String, String> e: map.entrySet())
				sb.append(URLEncoder.encode(e.getKey(), "UTF-8")+"="+URLEncoder.encode(e.getValue(), "UTF-8")+"&");
			sb.deleteCharAt(sb.length()-1);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			PrintWriter pout = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(), "8859_1"), true);
			pout.print(sb.toString());
			pout.flush();
			
			BufferedReader rdr = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			int i = 100;
			while ((line = rdr.readLine()) != null && i > 0) {
				i--;
				System.out.printf("%s\n", line);
			}
			
			
		} catch (Exception ex) {System.out.printf("Oops: %s", ex.getMessage());}
	}*/
	
}
