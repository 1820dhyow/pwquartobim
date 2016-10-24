package dao;

import banco.Manager;
import entidade.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DAOUsuario {
    private EntityManager gerenciador = Manager.get();
    private EntityTransaction t = gerenciador.getTransaction();
    
    public Estado salvar (Estado estado){
        
        try{
            t.begin();
            gerenciador.persist(estado);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();
            t.rollback();
        }
        return estado;
    }
    
    public boolean alterar (Estado estado){
        
        try{
            t.begin();
            gerenciador.refresh(estado);
            t.commit();
        } catch(Exception e){
            e.printStackTrace();
            t.rollback();
        }
        return false;
    }
    
    public boolean excluir (Estado estado){
        try{
            t.begin();
            gerenciador.remove(estado);
            t.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Estado> consultar(){
        try{
            
            return gerenciador.createQuery("from Estado").getResultList();
            
        } catch(Exception e){
            return null;
        }
    }
    
    public Estado consultar (int id){
        return gerenciador.find(Estado.class, id);
    }
    
}
