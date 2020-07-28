
package sql.demo.model;
        import java.util.Objects;

public class BaseClass {
    protected long id;

    public long getId(int anInt) {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public  BaseClass() {}

    public BaseClass(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseClass baseModel = (BaseClass) o;
        return id == baseModel.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
