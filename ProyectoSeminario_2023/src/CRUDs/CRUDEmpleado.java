/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;


import POJOs.Empleado;
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
public class CRUDEmpleado {
    public static boolean insert(String nombre, String apellido, String cargo, BigDecimal salario, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Empleado.class);
        criteria.add(Restrictions.eq("nombre", nombre));
        criteria.add(Restrictions.eq("apellido", apellido));
        criteria.add(Restrictions.eq("estado", true));
        Empleado insert=(Empleado)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Empleado();
                insert.setEstado(true);
                insert.setNombre(nombre);
                insert.setApellido(apellido);
                insert.setCargo(cargo);
                insert.setSalario(salario);
                insert.setFechaInicioEmpleo(fecha);
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
 
    public static boolean update(Integer idEmpleado, String nombre, String apellido, String cargo, BigDecimal salario, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Empleado.class); 
        criteria.add(Restrictions.eq("idEmpleado", idEmpleado));
        Empleado update=(Empleado)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdEmpleado(idEmpleado);
                update.setNombre(nombre);
                update.setApellido(apellido);
                update.setCargo(cargo);
                update.setSalario(salario);
                update.setFechaInicioEmpleo(fecha);
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
    
    public static List<Empleado> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Empleado>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Empleado.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idEmpleado"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idEmpleado, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Empleado.class); 
        criteria.add(Restrictions.eq("idEmpleado", idEmpleado));
        Empleado update=(Empleado)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idEmpleado){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Empleado.class); 
        criteria.add(Restrictions.eq("idEmpleado", idEmpleado));
        Empleado update=(Empleado)criteria.uniqueResult();
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
     
     public static Empleado select(Integer idEmpleado){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Empleado.class);
         criteria.add(Restrictions.eq("idEmpleado", idEmpleado));
         Empleado select = (Empleado)criteria.uniqueResult();
         if(select==null){
             select = new Empleado();
             select.setIdEmpleado(0);
             
         }
         session.close();
         return select;
     }
}
