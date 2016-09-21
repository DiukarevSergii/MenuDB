import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MenuRest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Menu dish1 = new Menu("Potato", 100, 10, 0.25);
            Menu dish2 = new Menu("Corn", 80, 5, 0.9);
            Menu dish3 = new Menu("Water", 20, 5, 0.55);
            Menu dish4 = new Menu("Banana", 14, 0.25);
            Menu dish5 = new Menu("Spageti", 45, 0.2);
            Menu dish6 = new Menu("Soup", 55, 0.3);
            Menu dish7 = new Menu("Bread", 55, 0.1);

            entityManager.persist(dish1);
            entityManager.persist(dish2);
            entityManager.persist(dish3);
            entityManager.persist(dish4);
            entityManager.persist(dish5);
            entityManager.persist(dish6);
            entityManager.persist(dish7);

            entityManager.getTransaction().commit();

            Query query = entityManager.createNamedQuery("Menu.findAll", Menu.class);
            List<Menu> dishes = query.getResultList();

            for (Menu dish : dishes) {
                System.out.println(dish);
            }
            System.out.println();

            List<Menu> menuList = new ArrayList<>();
            double sum = 0;
            for (Menu dish : dishes) {
                if (dish.getWeight() < 1 && (dish.getWeight() + sum) < 1) {
                    sum += dish.getWeight();
                    menuList.add(dish);
                }
            }
            System.out.println(sum + "\n");

            for (Menu dish : menuList) {
                System.out.println(dish);
            }
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
