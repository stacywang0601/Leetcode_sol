package B09_13;

/**
 * Design an in-memory file system to simulate the following functions:
 * 
 * ls: Given a path in string format. If it is a file path, return a list that only contains this
 * file's name. If it is a directory path, return the list of file and directory names in this
 * directory. Your output (file and directory names together) should in lexicographic order.
 * 
 * mkdir: Given a directory path that does not exist, you should make a new directory according to
 * the path. If the middle directories in the path don't exist either, you should create them as
 * well. This function has void return type.
 * 
 * addContentToFile: Given a file path and file content in string format. If the file doesn't exist,
 * you need to create that file containing given content. If the file already exists, you need to
 * append given content to original content. This function has void return type.
 * 
 * readContentFromFile: Given a file path, return its content in string format.
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leet588FileSystem {
	class File {
		boolean		      isFile		= false;
		Map<String, File>	children	= new HashMap<>();
		String		      content		= "";
	}

	File	root	= null;

	public Leet588FileSystem() {
		root = new File();
	}

	public List<String> ls(String path) {
		String[] dirs = path.split("/");
		File node = root;
		List<String> result = new ArrayList<>();
		String name = "";
		for (String dir : dirs) {
			if (dir.length() == 0)
				continue;
			if (!node.children.containsKey(dir)) {
				return result;
			}
			node = node.children.get(dir);
			name = dir;
		}

		if (node.isFile) {
			result.add(name);
		} else {
			for (String key : node.children.keySet()) {
				result.add(key);
			}
		}

		Collections.sort(result);

		return result;
	}

	private File mkFile(String path) {
		String[] dirs = path.split("/");
		File node = root;
		for (String dir : dirs) {
			if (dir.length() == 0)
				continue;
			if (!node.children.containsKey(dir)) {
				node.children.put(dir, new File());
			}
			node = node.children.get(dir);
		}
		return node;
	}

	public void mkdir(String path) {
		mkFile(path);
	}

	public void addContentToFile(String filePath, String content) {
		File node = mkFile(filePath);
		node.isFile = true;
		node.content += content;
	}

	public String readContentFromFile(String filePath) {
		return mkFile(filePath).content;
	}
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
