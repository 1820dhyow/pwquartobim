/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import entidade.Estado;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Hélio
 */
public class TestePU {
    
    public static void main(String[] args) {
        try {
            EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysqlPU");
            EntityManager gerenciador = fabrica.createEntityManager();
            
            Estado estado = new Estado();
            estado.setNome("afffa12");
            estado.setSigla("es");
            
            EntityTransaction t = gerenciador.getTransaction();
            t.begin();
            gerenciador.persist(estado);
            t.commit();
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
