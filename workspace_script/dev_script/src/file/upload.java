package file;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajax/file/upload")
public class upload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public upload() {
		super();
	}

	private class Node {
		String filename;
		int filepos;
		int filelength;
		StringBuffer data;
		Date lastupdated;
	}
	
	private static List<Node> memory = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if (memory == null) {
			memory = new LinkedList<>();
			Executors.newSingleThreadExecutor().execute(() -> {
				while (true) {
					try {
						synchronized (memory) {
							for (int i = 0; i < memory.size(); i++) {
								Date now = new Date();
								if (now.getTime() - memory.get(i).lastupdated.getTime() > 10000) {
									System.out.println("제거!!");
									memory.remove(i);
									i--;
								}
							}
						}
						Thread.sleep(10000);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			});
		}

		Node node = null;
		String filename = request.getParameter("filename");
		String filelength = request.getParameter("filelength");
		String filepos = request.getParameter("filepos");
		String data = request.getParameter("data");
		synchronized (memory) {
			for (Node n : memory) {
				if (n.filename.equals(filename)) {
					node = n;
					break;
				}
			}
			if (node == null) {
				memory.add(node = new Node());
				node.filename = filename;
				node.data = new StringBuffer();
			}
		}

		node.filelength = Integer.parseInt(filelength);
		node.filepos = Integer.parseInt(filepos);
		node.lastupdated = new Date();
		node.data.append(data);
		
		if (node.filepos >= node.filelength) {
			synchronized (memory) {
				memory.remove(node);
			}
			byte[] binary = Base64.getDecoder().decode(node.data.toString());
			try (FileOutputStream stream = new FileOutputStream("d:\\work\\" + filename)) {
				stream.write(binary, 0, binary.length);
			}
			response.getWriter().write("{\"ret\":\"complete\"}");
		} else {
			response.getWriter().write("{\"ret\":\"continue\"}");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
