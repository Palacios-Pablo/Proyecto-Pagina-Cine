/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;


import POJOs.Usuario;
import POJOs.Perfil;
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
public class CRUDUsuario {
   public static boolean insert(String nombreUsuario, String contrasena, Integer perfil){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.eq("estado", true));
        Usuario insert=(Usuario)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Usuario();
                insert.setEstado(true);
                insert.setNombreUsuario(nombreUsuario);
                insert.setContrasena(contrasena);
                Perfil perfil2 = new Perfil();
                perfil2.setIdPerfil(perfil);
                insert.setPerfil(perfil2);
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
    
    public static boolean update(Integer idUsuario, String nombreUsuario, String contrasena, Integer perfil){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class); 
        criteria.add(Restrictions.eq("idUsuario", idUsuario));
        Usuario update=(Usuario)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdUsuario(idUsuario);
                update.setNombreUsuario(nombreUsuario);
                update.setContrasena(contrasena);
                Perfil perfil2 = new Perfil();
                perfil2.setIdPerfil(perfil);
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
    
    public static List<Usuario> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Usuario>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Usuario.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idUsuario"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idUsuario){
        boolean flag = false;
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class); 
        criteria.add(Restrictions.eq("idUsuario", idUsuario));
        Usuario update=(Usuario)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class); 
        criteria.add(Restrictions.eq("idUsuario", idUsuario));
        Usuario update=(Usuario)criteria.uniqueResult();
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
     
     public static Usuario select(Integer idUsuario){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Usuario.class);
         criteria.add(Restrictions.eq("idUsuario", idUsuario));
         Usuario select = (Usuario)criteria.uniqueResult();
         if(select==null){
             select = new Usuario();
             select.setIdUsuario(0);
             
         }
         session.close();
         return select;
     }
     
     public static Usuario selectUser(String nombreUsuario){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Usuario select=null;
         try{
             Criteria criteria=session.createCriteria(Usuario.class);
             criteria.add(Restrictions.eq("nombreUsuario", nombreUsuario));
             criteria.add(Restrictions.eq("estado",true));
             select=(Usuario)criteria.uniqueResult();
         }catch(HibernateException e){
             System.out.println("");
         }finally{
            session.close();
         }
         return select;
     }
     
}
