package Homework9;

public class StockEntity {
    int id;
    String name;
    int cost;
    int company_id;


    public StockEntity() {

    }
    public StockEntity(int id, String name, int cost, int company_id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.company_id = company_id;
    }
}
