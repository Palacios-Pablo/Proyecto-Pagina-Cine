/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Clasificacion;
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
public class CRUDClasificacion {
    public static boolean insert(String clasificacion, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clasificacion.class);
        criteria.add(Restrictions.eq("clasificacion", clasificacion));
        Clasificacion insert=(Clasificacion)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Clasificacion();             
                insert.setClasificacion(clasificacion);
                
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
 
    public static boolean update(Integer idClasificacion, String clasificacion, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clasificacion.class); 
        criteria.add(Restrictions.eq("idClasificacion", idClasificacion));
        Clasificacion update=(Clasificacion)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdClasificacion(idClasificacion);
                
            
                update.setClasificacion(clasificacion);
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
    
    public static List<Clasificacion> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Clasificacion>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Clasificacion.class);
             criteria.addOrder(Order.desc("idClasificacion"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idClasificacion, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clasificacion.class); 
        criteria.add(Restrictions.eq("idClasificacion", idClasificacion));
        Clasificacion update=(Clasificacion)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
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
     
     public static boolean eliminar(Integer idClasificacion){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Clasificacion.class); 
        criteria.add(Restrictions.eq("idClasificacion", idClasificacion));
        Clasificacion update=(Clasificacion)criteria.uniqueResult();
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
     
     public static Clasificacion select(Integer idClasificacion){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Clasificacion.class);
         criteria.add(Restrictions.eq("idClasificacion", idClasificacion));
         Clasificacion select = (Clasificacion)criteria.uniqueResult();
         if(select==null){
             select = new Clasificacion();
             select.setIdClasificacion(0);
             
         }
         session.close();
         return select;
     }
}
