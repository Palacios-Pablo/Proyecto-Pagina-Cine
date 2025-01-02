/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Sala;
import POJOs.Usuario;
import java.util.Date;
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
public class CRUDSala {
    public static boolean insert(String nombreSala, Integer capacidad, String tipoSala, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sala.class);
        criteria.add(Restrictions.eq("nombreSala", nombreSala));
        criteria.add(Restrictions.eq("estado", true));
        Sala insert=(Sala)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Sala();
                insert.setEstado(true);
                insert.setNombreSala(nombreSala);
                insert.setCapacidad(capacidad);
                insert.setTipoSala(tipoSala);
                Usuario usuario2 = new Usuario();
                usuario2.setIdUsuario(usuario);
                insert.setUsuarioByUsuarioIngresa(usuario2);
                insert.setFechaIngresa(fecha);
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
 
    public static boolean update(Integer idSala, String nombreSala, Integer capacidad, String tipoSala, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sala.class); 
        criteria.add(Restrictions.eq("idSala", idSala));
        Sala update=(Sala)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdSala(idSala);
                update.setNombreSala(nombreSala);
                update.setCapacidad(capacidad);
                update.setTipoSala(tipoSala);
                update.setFechaModifica(fecha);  
                Usuario usuario = new Usuario();
                update.setUsuarioByUsuarioModifica(usuario);
                usuario.setIdUsuario(idUsuario);
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
    
    public static List<Sala> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Sala>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Sala.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idSala"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idSala, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sala.class); 
        criteria.add(Restrictions.eq("idSala", idSala));
        Sala update=(Sala)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setEstado(false);
                update.setFechaModifica(fecha);  
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(idUsuario);
                update.setUsuarioByUsuarioModifica(usuario);
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
     
     public static boolean eliminar(Integer idSala){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Sala.class); 
        criteria.add(Restrictions.eq("idSala", idSala));
        Sala update=(Sala)criteria.uniqueResult();
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
     
     public static Sala select(Integer idSala){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Sala.class);
         criteria.add(Restrictions.eq("idSala", idSala));
         Sala select = (Sala)criteria.uniqueResult();
         if(select==null){
             select = new Sala();
             select.setIdSala(0);
             
         }
         session.close();
         return select;
     }
}
