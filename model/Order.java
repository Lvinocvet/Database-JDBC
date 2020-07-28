package sql.demo.model;

// Модель таблицы Заказов
public class Order extends BaseClass{
    private String date; // Время
    private long klient; // клиент

    public Order() {}

    public Order(long id, String date, long klient) {
        super(id); // super - текущий экземпляр суперкласса/ сылается на экземпляр родительского класса.
        this.date = date;
        this.klient = klient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getKlient() {
        return klient;
    }

    public void setKlient(long klient) {
        this.klient = klient;
    }


}
