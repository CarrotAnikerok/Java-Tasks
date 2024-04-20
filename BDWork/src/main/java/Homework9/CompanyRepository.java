package Homework9;

import java.sql.*;
import java.util.Map;

public class CompanyRepository {

    String DB_HOST;
    String DB_USER;
    String DB_PASSWORD;

    public CompanyRepository() throws ClassNotFoundException {
        Map<String, String> env = System.getenv();

        this.DB_HOST = env.get("DB_HOST");
        this.DB_USER = env.get("DB_USER");
        this.DB_PASSWORD = env.get("DB_PASSWORD");

        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            String tableStock = "CREATE TABLE IF NOT EXISTS Company"
                    + "(id integer PRIMARY KEY, name text,"
                    + "country text, creation_date int,"
                    + "stocks_count integer);";
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(tableStock);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public CompanyEntity find(int id) {
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                String findEntity = "SELECT * FROM company WHERE id = " + id + ";";
                try (ResultSet resultSet = statement.executeQuery(findEntity)) {
                    CompanyEntity entity = new CompanyEntity();
                    while (resultSet.next()) {
                        entity.id = resultSet.getInt("id");
                        entity.name = resultSet.getString("name");
                        entity.country = resultSet.getString("country");
                        entity.creation_date = resultSet.getInt("creation_date");
                        entity.stocks_count = resultSet.getInt("stocks_count");
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

    public void create(CompanyEntity entity) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            String insertEntity = "INSERT INTO company(id, name, country, creation_date, stocks_count)"
                    //+ "VALUES(1, 'Disney', 'USA', 2014-04-04, 2);";
                    + "VALUES(" + entity.id + ", " + "'" + entity.name + "'" + ", " + "'" + entity.country + "'" + ", "
                    + entity.creation_date + ", " + entity.stocks_count + ");";
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(insertEntity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(CompanyEntity entity) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                String deleteEntity = "DELETE FROM company "
                        + "WHERE id = " + entity.id + ";";
                statement.executeUpdate(deleteEntity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(CompanyEntity entity) throws ClassNotFoundException {
        delete(entity);
        create(entity);
    }
}
