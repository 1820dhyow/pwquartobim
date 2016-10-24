
package teste;

import entidade.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestePUUsuario {
    
     public static void main(String[] args) {
        try {
            EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlPU");
            EntityManager gerenciador = fabrica.createEntityManager();
            
            Usuario usuario = new Usuario();
            usuario.setNome("Diovane");
            usuario.setRg("128118675");
            usuario.setEmail("diovanedhyow@gmail.com");
            
            EntityTransaction t = gerenciador.getTransaction();
            t.begin();
            gerenciador.persist(usuario);
            t.commit();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
