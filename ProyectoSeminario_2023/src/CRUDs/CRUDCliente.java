/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Cliente;
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
public class CRUDCliente {
    
    public static boolean insert(String nombre, String apellido, String correo, String telefono, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class);
        criteria.add(Restrictions.eq("telefono", telefono));
        criteria.add(Restrictions.eq("correoElectronico", correo));
        criteria.add(Restrictions.eq("estado", true));
        Cliente insert=(Cliente)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Cliente();
                insert.setEstado(true);
                insert.setNombre(nombre);
                insert.setApellido(apellido);
                insert.setCorreoElectronico(correo);
                insert.setTelefono(telefono);
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
 
    public static boolean update(Integer idCliente, String nombre, String apellido, String correo, String telefono, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class); 
        criteria.add(Restrictions.eq("idCliente", idCliente));
        Cliente update=(Cliente)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdCliente(idCliente);
                update.setNombre(nombre);
                update.setApellido(apellido);
                update.setCorreoElectronico(correo);
                update.setTelefono(telefono);
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
    
    public static List<Cliente> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Cliente>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Cliente.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idCliente"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idCliente, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class); 
        criteria.add(Restrictions.eq("idCliente", idCliente));
        Cliente update=(Cliente)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idCliente){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Cliente.class); 
        criteria.add(Restrictions.eq("idCliente", idCliente));
        Cliente update=(Cliente)criteria.uniqueResult();
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
     
     public static Cliente select(Integer idCliente){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Cliente.class);
         criteria.add(Restrictions.eq("idCliente", idCliente));
         Cliente select = (Cliente)criteria.uniqueResult();
         if(select==null){
             select = new Cliente();
             select.setIdCliente(0);
             
         }
         session.close();
         return select;
     }
}
