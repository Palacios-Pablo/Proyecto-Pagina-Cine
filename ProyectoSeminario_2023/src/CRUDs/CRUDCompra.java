/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Cliente;
import POJOs.Compra;
import java.util.Date;
import org.hibernate.Session;
import POJOs.Usuario;
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
public class CRUDCompra {
    
    public static boolean insert(Integer idCompra, Integer idCliente, BigDecimal totalCompra, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compra.class);
        criteria.add(Restrictions.eq("idCompra", idCompra));
        criteria.add(Restrictions.eq("estado", true));
        Compra insert=(Compra)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Compra();
                insert.setEstado(true);
                
                Cliente cliente = new Cliente();
                cliente.setIdCliente(idCliente);
                insert.setCliente(cliente);
                
                insert.setFechaCompra(fecha);
                
                insert.setTotalCompra(totalCompra);
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
 
    public static boolean update(Integer idCompra, Integer idCliente, BigDecimal totalCompra, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compra.class); 
        criteria.add(Restrictions.eq("idCompra", idCompra));
        Compra update=(Compra)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdCompra(idCompra);
                
                Cliente cliente = new Cliente();
                update.setCliente(cliente);
                cliente.setIdCliente(idCliente);
                
                update.setFechaCompra(fecha);
                update.setTotalCompra(totalCompra);
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
    
    public static List<Compra> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Compra>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Compra.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idCompra"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idCompra, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compra.class); 
        criteria.add(Restrictions.eq("idCompra", idCompra));
        Compra update=(Compra)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idCompra){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Compra.class); 
        criteria.add(Restrictions.eq("idCompra", idCompra));
        Compra update=(Compra)criteria.uniqueResult();
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
     
     public static Compra select(Integer idCompra){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Compra.class);
         criteria.add(Restrictions.eq("idCompra", idCompra));
         Compra select = (Compra)criteria.uniqueResult();
         if(select==null){
             select = new Compra();
             select.setIdCompra(0);
             
         }
         session.close();
         return select;
     }
     
     public static Compra select1(Usuario usuario){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Compra.class);
         criteria.add(Restrictions.eq("usuarioByUsuarioIngresa", usuario));
         Compra select = (Compra)criteria.uniqueResult();
         if(select==null){
             select = new Compra();
             select.setIdCompra(0);
         }
         session.close();
         return select;
     }
}
