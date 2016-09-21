import javax.persistence.*;

@Entity
@Table(name = "Menu1")
@NamedQueries({
        @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
})
public class Menu {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double weight;

    private double discount;


    public Menu() {
    }

    public Menu(String name, double price, double discount, double weight) {
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.weight = weight;
    }

    public Menu(String name, double price, double weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", weight=" + weight +
                '}';
    }
}

