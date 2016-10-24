package banco;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private static EntityManagerFactory fabrica;
    private static EntityManager gerenciador;
    
    
    public static EntityManager get(){
        return Persistence.createEntityManagerFactory("mysqlPU").createEntityManager();
    }
}
