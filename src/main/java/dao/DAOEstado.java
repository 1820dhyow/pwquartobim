package dao;

import banco.Manager;
import entidade.Estado;
import java.util.List;
import javax.persistence.EntityManager;

public class DAOEstado {
    
    private EntityManager gerenciador = Manager.get();
    
    public Estado salvar(Estado estado){
        try {
            gerenciador.persist(estado);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estado;
    }
    
    public boolean alterar(Estado estado){
        try {
            gerenciador.merge(estado);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean excluir(Estado estado){
        try {
            gerenciador.remove(estado);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Estado> consultar(){
        try {
            //gerenciaodor → responsável pelos métodos crud
            //createQuery → cria um consulta
            //getResultList → cria uma lista
            return gerenciador.createQuery("from Estado").getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Estado consultar(int id){
        return gerenciador.find(Estado.class, id);
    }
            
    
}
