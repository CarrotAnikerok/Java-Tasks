package Homework9;

public class CompanyEntity {
    int id;
    String name;
    String country;
    int creation_date;
    int stocks_count;

    public CompanyEntity() {

    }

    public CompanyEntity(int id, String name, String country, int creation_date, int stocks_count) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.creation_date = creation_date;
        this.stocks_count = stocks_count;
    }
}
