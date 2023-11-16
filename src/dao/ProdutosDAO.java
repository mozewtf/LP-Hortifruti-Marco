/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ProdutosMabs;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;


/**
 *
 * @author MARCO
 */
public class ProdutosDAO extends DAO_Abstract  {

    @Override
    public void insert(Object object) {
    session.beginTransaction();
    session.save(object);
    session.getTransaction().commit();
    //transações podem ter duas "finalidades" commit ou rollback, onde o commit salva a transação e o rollback defaz 
    }

    @Override
    public void update(Object object) {
    session.beginTransaction();
    session.flush();
    session.clear();
    session.update(object);
    session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
    session.beginTransaction(); 
    session.flush();
    session.clear();
    //flush e clear limpam o cache do hibernate pra não enviar as coisas erradas
    session.delete(object);
    session.getTransaction().commit();
    }

    @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutosMabs.class);
        criteria.add(Restrictions.eq("id", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutosMabs.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }
    
    public List listTipo(String tipo){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutosMabs.class);
        criteria.add(Restrictions.like("tipoMabs", "%"+  tipo +"%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
//            jTxtId.setText(Util.intStr(clientesCwmo.getIdClienteCwmo()));
    public List listConservantes(int conservantes){
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutosMabs.class);
        criteria.add(Restrictions.eq("conservantesMabs", conservantes));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }
        public List listTipoConservantes(String tipo, int conservantes) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(ProdutosMabs.class);
        criteria.add(Restrictions.like("tipoMabs", "%"+  tipo +"%"));
        criteria.add(Restrictions.eq("conservantesMabs",  conservantes));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
        }
    
}
