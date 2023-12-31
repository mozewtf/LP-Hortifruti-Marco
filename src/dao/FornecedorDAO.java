/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.FornecedorMabs;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author MARCO
 */
public class FornecedorDAO extends DAO_Abstract{

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
        Criteria criteria = session.createCriteria(FornecedorMabs.class);
        criteria.add(Restrictions.eq("idFornecedormabs", id));
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FornecedorMabs.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
}
       public List listTelefone(String tel) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FornecedorMabs.class);
        criteria.add(Restrictions.like("telefoneMabs", "%"+  tel +"%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
}
 
       public List listCidade(String city) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FornecedorMabs.class);
        criteria.add(Restrictions.like("cidadeMabs", "%"+  city +"%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
}
        public List listTelefoneCidade(String tel, String city) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(FornecedorMabs.class);
        criteria.add(Restrictions.like("telefoneMabs", "%"+  tel +"%"));
        criteria.add(Restrictions.like("cidadeMabs", "%"+  city +"%"));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
        }
    }

