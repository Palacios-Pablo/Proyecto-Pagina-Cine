/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Horario;
import POJOs.Pelicula;
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
public class CRUDHorario {
    
     public static boolean insert(Date fechaHoraInicio, Integer sala, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Horario.class);
        criteria.add(Restrictions.eq("fechaHoraInicio", fechaHoraInicio));
        criteria.add(Restrictions.eq("estado", true));
        Horario insert=(Horario)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Horario();
                insert.setEstado(true);
                insert.setFechaHoraInicio(fechaHoraInicio);
                Sala sala2 = new Sala();
                sala2.setIdSala(sala);
                insert.setSala(sala2);
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
 
    public static boolean update(Integer idHorario, Date fechaHoraInicio, Integer sala, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Horario.class); 
        criteria.add(Restrictions.eq("idHorario", idHorario));
        Horario update=(Horario)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdHorario(idHorario);
                update.setFechaHoraInicio(fechaHoraInicio);
                Sala sala2 = new Sala();
                update.setSala(sala2);
                sala2.setIdSala(sala);
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
    
    public static List<Horario> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Horario>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Horario.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idHorario"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idHorario, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Horario.class); 
        criteria.add(Restrictions.eq("idHorario", idHorario));
        Horario update=(Horario)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idHorario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Horario.class); 
        criteria.add(Restrictions.eq("idHorario", idHorario));
        Horario update=(Horario)criteria.uniqueResult();
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
     
     public static Horario select(Integer idHorario){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Horario.class);
         criteria.add(Restrictions.eq("idHorario", idHorario));
         Horario select = (Horario)criteria.uniqueResult();
         if(select==null){
             select = new Horario();
             select.setIdHorario(0);
             
         }
         session.close();
         return select;
     }
     
     
     public static Horario select1(Usuario usuario){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Horario.class);
         criteria.add(Restrictions.eq("usuarioByUsuarioIngresa", usuario));
         Horario select = (Horario)criteria.uniqueResult();
         if(select==null){
             select = new Horario();
             select.setIdHorario(0);
         }
         session.close();
         return select;
     }
     
}
