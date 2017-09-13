package B09_13;

/***
 * You are given several logs that each log contains a unique id and timestamp. Timestamp is a
 * string that has the following format: Year:Month:Day:Hour:Minute:Second, for example,
 * 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.
 * 
 * Design a log storage system to implement the following functions:
 * 
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your
 * storage system.
 * 
 * 
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose
 * timestamps are within the range from start to end. Start and end all have the same format as
 * timestamp. However, granularity means the time level for consideration. For example, start =
 * "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to
 * find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Leet635LogSystem {
	// !!!we can use HashMap, but use list of string array makes it more concise
	private List<String[]>	log	  = new LinkedList<>();
	// !!! how list is initialized here
	private List<String>	grans	= Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
	private int[]	       idx	  = { 4, 7, 10, 13, 16, 19 };

	public Leet635LogSystem() {

	}

	public void put(int id, String timestamp) {
		// !!!Integer.toString()
		log.add(new String[] { Integer.toString(id), timestamp });
	}

	public List<Integer> retrieve(String s, String e, String gra) {
		List<Integer> res = new LinkedList<>();

		int i = grans.indexOf(gra);
		String p1 = s.substring(0, idx[i]);
		String p2 = e.substring(0, idx[i]);

		for (String[] a : log) {
			String p = a[1].substring(0, idx[i]);
			if (p.compareTo(p1) >= 0 && p.compareTo(p2) <= 0) {
				// !!!Integer.parseInt()
				res.add(Integer.parseInt(a[0]));
			}
		}

		return res;
	}
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */
