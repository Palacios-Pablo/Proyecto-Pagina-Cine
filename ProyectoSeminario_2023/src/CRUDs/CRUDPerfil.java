/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Perfil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Yoel
 */
public class CRUDPerfil {
    
    public static boolean insert(String nombrePerfil, String descripcion){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfil.class);
        criteria.add(Restrictions.eq("nombrePerfil", nombrePerfil));
        criteria.add(Restrictions.eq("estado", true));
        Perfil insert=(Perfil)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Perfil();
                insert.setEstado(true);
                insert.setNombrePerfil(nombrePerfil);
                insert.setDescripcion(descripcion);
                session.save(insert);
                flag = true;
            }
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
            System.out.println("Error"+e);
        }finally{
            session.close();
        }
            
        return flag;
    }
    //se utiliza static para no instaciar la clase
    public static boolean update(Integer idPerfil, String nombrePerfil, String descripion){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfil.class); 
        criteria.add(Restrictions.eq("idPerfil", idPerfil));
        Perfil update=(Perfil)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdPerfil(idPerfil);
                update.setNombrePerfil(nombrePerfil);
                update.setDescripcion(descripion);
                session.update(update);
                flag = true;
            }
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
            System.out.println("Error"+e);
        }finally{
            session.close();
        }
            
        return flag;
    }
    
    public static List<Perfil> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Perfil>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Perfil.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idPerfil"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idPerfil){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfil.class); 
        criteria.add(Restrictions.eq("idPerfil", idPerfil));
        Perfil update=(Perfil)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setEstado(false); 
                session.update(update);
                flag = true;
            }
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
            System.out.println("Error"+e);
        }finally{
            session.close();
        }
            
        return flag;
    }
     
     public static boolean eliminar(Integer idPerfil){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Perfil.class); 
        criteria.add(Restrictions.eq("idPerfil", idPerfil));
        Perfil update=(Perfil)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                session.delete(update);
                flag = true;
            }
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
            System.out.println("Error"+e);
        }finally{
            session.close();
        }
            
        return flag;
    }
     
     public static Perfil select(Integer idPerfil){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Perfil.class);
         criteria.add(Restrictions.eq("idPerfil", idPerfil));
         Perfil select = (Perfil)criteria.uniqueResult();
         if(select==null){
             select = new Perfil();
             select.setIdPerfil(0);
             
         }
         session.close();
         return select;
     }
}
