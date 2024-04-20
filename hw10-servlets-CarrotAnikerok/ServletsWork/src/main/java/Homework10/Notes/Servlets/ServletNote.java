package Homework10.Notes.Servlets;

import Homework10.Notes.Repository.Notes;
import Homework10.Notes.Repository.NotesRepository;
import Homework10.Notes.StartServer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@WebServlet("/api/note/*")
public class ServletNote extends HttpServlet {
    static ObjectMapper objectMapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean noError = true;
        String reply = "";
        String idStr = request.getPathInfo();


        // Appeal to repository, update data
        Notes note;
        NotesRepository notesRepository;
        List<Notes> notesList = new ArrayList<Notes>();

        try {
            notesRepository = new NotesRepository();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        int i = 1;
        while (notesRepository.find(i).id != 0) {
            notesList.add(notesRepository.find(i));
            i+=1;
        }

        // Checking existing of note

        if (idStr.matches("/[+]?\\d+")) {
            int idNumb = Integer.parseInt(request.getPathInfo().substring(1)) - 1;
            try {
                note = notesList.get(idNumb);
                reply = objectMapper.writeValueAsString(note);
            } catch (IndexOutOfBoundsException e) {
                noError = false;
            }
        } else {
            noError = false;
        }


        // On complete
        if (noError) {
            doSet(response, reply, HttpServletResponse.SC_OK);
        }  else {
            doSet(response, "<h1 style=\"color:#00a771\">Note not found", HttpServletResponse.SC_NOT_FOUND);
        }
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean noError = true;
        String idStr = request.getPathInfo();


        // Appeal to repository, update data
        Notes note;
        NotesRepository notesRepository;
        List<Notes> notesList = new ArrayList<Notes>();

        try {
            notesRepository = new NotesRepository();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        int i = 1;
        while (notesRepository.find(i).id != 0) {
            notesList.add(notesRepository.find(i));
            i+=1;
        }

        // Checking existing of note
        if (idStr.matches("/[+]?\\d+")) {
            int idNumb = Integer.parseInt(request.getPathInfo().substring(1)) - 1;
            try {
                note = notesList.get(idNumb);
                notesRepository.delete(note);
            } catch (IndexOutOfBoundsException e) {
                noError = false;
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            noError = false;
        }

        // On complete
        if (noError) {
            doSet(response, "Note deleted", HttpServletResponse.SC_OK);
        }  else {
            doSet(response, "<h1 style=\"color:#00a771\">Note not found", HttpServletResponse.SC_NOT_FOUND);
        }
    }
    protected void doSet(HttpServletResponse response, String reply, int status) throws ServletException, IOException {
        response.getOutputStream().write( reply.getBytes("UTF-8") );
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(status);
    }
}
