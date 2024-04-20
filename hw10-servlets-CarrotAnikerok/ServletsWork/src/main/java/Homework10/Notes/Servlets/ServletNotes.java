package Homework10.Notes.Servlets;

import Homework10.Notes.Repository.Notes;
import Homework10.Notes.Repository.NotesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/note")
public class ServletNotes extends HttpServlet {
    static ObjectMapper objectMapper = new ObjectMapper();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appeal to repository, update data
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

        // Return data

        String reply = "{" +"\"notes\": [";

        for (Notes everyNote : notesList) {
            reply += objectMapper.writeValueAsString(everyNote) + "\n";
        }

        reply += "]";

        // On complete
        doSet(response, reply, HttpServletResponse.SC_OK);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appeal to repository, update data
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

        // Get the body
        BufferedReader reader = request.getReader();
        int intValueOfChar;

        StringBuilder sb = new StringBuilder();
        while ((intValueOfChar = reader.read()) != -1) {
            sb.append((char) intValueOfChar);
        }

        String resultJson = sb.toString();

        // Adding data to db
        Notes note = objectMapper.readValue(resultJson, Notes.class);
        note.id = notesList.get(notesList.size() - 1).id + 1;
        note.created_at = LocalDate.now().toString();

        try {
            notesRepository.create(note);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // On complete
        doSet(response, "New note created", HttpServletResponse.SC_CREATED);
    }

    protected void doSet(HttpServletResponse response, String reply, int status) throws ServletException, IOException {
        response.getOutputStream().write( reply.getBytes("UTF-8") );
        response.setContentType("text/html; charset=UTF-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(status);
    }
}
