package Homework9;

import java.util.Map;

public class Initialization {
    public static void main(String[] args) throws ClassNotFoundException {
        // Создание сущностей компаний
        CompanyEntity disney = new CompanyEntity(1, "Disney", "USA", 1923, 2);
        CompanyEntity pixar = new CompanyEntity(2, "Pixar", "USA", 1986, 3);

        // Создание сущностей акций диснея
        StockEntity ducktales = new StockEntity(1, "ducktales", 500, 1);
        StockEntity cinderella = new StockEntity(2, "cinderella", 1000, 1);

        // Создание сущностей акций пиксар
        StockEntity toyStory = new StockEntity(3, "toy story", 700, 2);
        StockEntity brave = new StockEntity(4, "brave", 200, 2);
        StockEntity cars = new StockEntity(5, "cars", 600, 2);

        // Создание таблиц
        CompanyRepository company = new CompanyRepository();
        StockRepository stock = new StockRepository();

        // Создание компаний в базе данных
        /*company.create(disney);
        company.create(pixar);*/

        // Создание акций в базе данных
        /*stock.create(ducktales);
        stock.create(cinderella);
        stock.create(toyStory);
        stock.create(cars);
        stock.create(brave);*/

        // Нахождение нужных элементов
        /*System.out.println(stock.find(1).name);
        System.out.println(company.find(1).name);
        System.out.println(company.find(2).name);*/

        // Удаление и обновление элементов
        //stock.delete(ducktales);
        //stock.update(new StockEntity(1, "ducktales", 700, 1));
    }
}
