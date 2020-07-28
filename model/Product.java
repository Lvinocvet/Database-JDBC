
package sql.demo.model;

// Модель таблицы продуктов
public class Product extends BaseClass{
    private String name;    // Название
    private String discr; // описание
    private int cost;   // Цена

    public Product() {}

    public Product(long id, String name, String discr, int cost) {
        super(id); // super - текущий экземпляр суперкласса/ сылается на экземпляр родительского класса.
        this.name = name;
        this.discr = discr;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscr() {
        return discr;
    }

    public void setDiscr(String discr) {
        this.discr = discr;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "{id: " + id + ", username: " + name +
                ", discription " + discr + ", cost " + cost  +"}";
    }



}
