
package sql.demo.model;

// Модель заказов
public class OrderProduct extends BaseClass{
    private int count; // количество
    private long order; // Заказ
    private long tovar; // Продукт

    public OrderProduct() {}

    public OrderProduct(long id, int count, long order,long tovar) {
        super(id); // super - текущий экземпляр суперкласса/ сылается на экземпляр родительского класса.
        this.count = count;
        this.order = order;
        this.tovar = tovar;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getOrder() {
        return order;
    }

    public void setOrder(long order) {
        this.order = order;
    }

    public long getProduct() {
        return tovar;
    }

    public void setProduct(long tovar) {
        this.tovar = tovar;
    }


}
