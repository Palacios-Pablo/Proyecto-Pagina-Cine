/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;


import POJOs.Usuario;
import POJOs.Boleto;
import POJOs.Cliente;
import POJOs.Compra;
import POJOs.Sala;
import POJOs.Horario;
import java.math.BigDecimal;
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
public class CRUDBoleto {
    public static boolean insert(Integer idCompra, Integer idHorario, Integer idSala, Integer numeroAsiento, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Boleto.class);
        criteria.add(Restrictions.eq("numeroAsiento", numeroAsiento));
        criteria.add(Restrictions.eq("estado", true));
        Boleto insert=(Boleto)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Boleto();
                insert.setEstado(true);
                
                Compra compra = new Compra();
                compra.setIdCompra(idCompra);
                insert.setCompra(compra);
                          
                Horario horario = new Horario();
                horario.setIdHorario(idHorario);
                insert.setHorario(horario);
                
                Sala sala = new Sala();
                sala.setIdSala(idSala);
                insert.setSala(sala);
                
                insert.setNumeroAsiento(numeroAsiento);
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
 
    public static boolean update(Integer idBoleto, Integer idCompra, Integer idHorario, Integer idSala, Integer numeroAsiento, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Boleto.class); 
        criteria.add(Restrictions.eq("idBoleto", idBoleto));
        criteria.add(Restrictions.eq("numeroAsiento", numeroAsiento));
        Boleto update=(Boleto)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdBoleto(idBoleto);
                
                Compra compra = new Compra();
                compra.setIdCompra(idCompra);
                update.setCompra(compra);
                          
                Horario horario = new Horario();
                horario.setIdHorario(idHorario);
                update.setHorario(horario);
                
                Sala sala = new Sala();
                sala.setIdSala(idSala);
                update.setSala(sala);
                
                update.setNumeroAsiento(numeroAsiento);
               
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
    
    public static List<Boleto> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Boleto>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Boleto.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idBoleto"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idBoleto, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Boleto.class); 
        criteria.add(Restrictions.eq("idBoleto", idBoleto));
        Boleto update=(Boleto)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idBoleto, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Boleto.class); 
        criteria.add(Restrictions.eq("idBoleto", idBoleto));
        Boleto update=(Boleto)criteria.uniqueResult();
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
     
     public static Boleto select(Integer idBoleto){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Boleto.class);
         criteria.add(Restrictions.eq("idBoleto", idBoleto));
         Boleto select = (Boleto)criteria.uniqueResult();
         if(select==null){
             select = new Boleto();
             select.setIdBoleto(0);
             
         }
         session.close();
         return select;
     }
    
}
