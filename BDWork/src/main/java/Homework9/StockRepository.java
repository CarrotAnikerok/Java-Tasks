package Homework9;

import java.sql.*;
import java.util.Map;

public class StockRepository {
    String DB_HOST;
    String DB_USER;
    String DB_PASSWORD;

    public StockRepository() throws ClassNotFoundException {
        Map<String, String> env = System.getenv();

        this.DB_HOST = env.get("DB_HOST");
        this.DB_USER = env.get("DB_USER");
        this.DB_PASSWORD = env.get("DB_PASSWORD");

        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            String tableStock = "CREATE TABLE IF NOT EXISTS stocks "
                    + "(id integer PRIMARY KEY, name varchar(30),"
                    + "cost integer, company_id integer,"
                    + "FOREIGN KEY (company_id) REFERENCES Company (Id));";
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(tableStock);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public StockEntity find(int id) {
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                String findEntity = "SELECT * FROM stocks WHERE id = " + id + ";";
                try (ResultSet resultSet = statement.executeQuery(findEntity)) {
                    StockEntity entity = new StockEntity();
                    while (resultSet.next()) {
                        entity.id = resultSet.getInt("id");
                        entity.name = resultSet.getString("name");
                        entity.cost = resultSet.getInt("cost");
                        entity.company_id = resultSet.getInt("company_id");
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

    public void create(StockEntity entity) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            String insertEntity = "INSERT INTO stocks(id, name, cost, company_id)"
                    //+ "VALUES(1, 'Disney', 500, 1);";
                    + "VALUES("+ entity.id + ", " + "'" + entity.name + "'" + ", " + entity.cost + ", " + entity.company_id + ");";
            try (Statement statement = con.createStatement()) {
                statement.executeUpdate(insertEntity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(StockEntity entity) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        try(Connection con = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASSWORD)) {
            try (Statement statement = con.createStatement()) {
                String deleteEntity = "DELETE FROM stocks "
                        + "WHERE id = " + entity.id + ";";
                statement.executeUpdate(deleteEntity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(StockEntity entity) throws ClassNotFoundException {
        delete(entity);
        create(entity);
    }
}
