package Homework10.Notes;

import Homework10.Notes.Servlets.ServletNote;
import Homework10.Notes.Servlets.ServletNotes;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class StartServer {
    public static void main(String[] args) {
        int port = 8500;
        Server server = new Server(port);
        ServletContextHandler handler = new ServletContextHandler(server, "/");
        handler.addServlet(ServletNote.class, "/api/note/*");
        handler.addServlet(ServletNotes.class, "/api/note");

        try {
            server.start();
            System.out.println("Listening port : " + port );
        } catch (Exception e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}
