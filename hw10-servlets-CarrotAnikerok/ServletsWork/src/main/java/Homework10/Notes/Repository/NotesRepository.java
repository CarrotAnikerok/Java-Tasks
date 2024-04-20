package Homework10.Notes.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class NotesRepository {
    String DB_HOST;
    String DB_USER;
    String DB_PASSWORD;


    public NotesRepository() throws ClassNotFoundException {
        Map<String, String> env = System.getenv();

        this.DB_HOST = env.get("DB_HOST");
        this.DB_USER = env.get("DB_USER");
        this.DB_PASSWORD = env.get("DB_PASSWORD");

        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            String tableStock = "CREATE TABLE IF NOT EXISTS Notes"
                    + "(id integer PRIMARY KEY, title text,"
                    + "content text, created_at text);";
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(tableStock);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Notes find(int id) {
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                String findEntity = "SELECT * FROM Notes WHERE id = " + id + ";";
                try (ResultSet resultSet = statement.executeQuery(findEntity)) {
                    Notes entity = new Notes();
                    while (resultSet.next()) {
                        entity.id = resultSet.getInt("id");
                        entity.title = resultSet.getString("title");
                        entity.content = resultSet.getString("content");
                        entity.created_at = resultSet.getString("created_at");
                    }

                    return entity;

                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(Notes entity) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            String insertEntity = "INSERT INTO notes(id, title, content, created_at)"
                    + "VALUES(" + entity.id + ", " + "'" + entity.title + "'" + ", " + "'" + entity.content + "'" + ", "
                    + "'" + entity.created_at + "'" + ");";
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(insertEntity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(Notes entity) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                String deleteEntity = "DELETE FROM Notes "
                        + "WHERE id = " + entity.id + ";";
                statement.executeUpdate(deleteEntity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Notes entity) throws ClassNotFoundException {
        delete(entity);
        create(entity);
    }
}
