
package sql.demo.model;


// Модель таблицы клиентов
public class Klient extends BaseClass{
    private String first_name;    // Название
    private String last_name ; // описание
    private String adres ; // Адрес

    public Klient() {}

    public Klient(long id, String first_name, String last_name, String adres) {
        super(id); // super - текущий экземпляр суперкласса/ сылается на экземпляр родительского класса.
        this.first_name = first_name;
        this.last_name = last_name;
        this.adres = adres;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
}
