/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUDs;

import POJOs.Clasificacion;
import POJOs.Pelicula;
import POJOs.Compra;
import POJOs.Genero;
import POJOs.Horario;
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
public class CRUDPelicula {
    
    public static boolean insert(String titulo, String director, Date anioLanzamiento, Integer idClasificacion, Integer idGenero, Integer usuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pelicula.class);
        criteria.add(Restrictions.eq("titulo", titulo));
        criteria.add(Restrictions.eq("estado", true));
        Pelicula insert=(Pelicula)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(insert==null){
                insert = new Pelicula();
                insert.setEstado(true);
                insert.setTitulo(titulo);
                insert.setDirector(director);
                insert.setAnioLanzamiento(anioLanzamiento);
                
                Clasificacion clasificacion = new Clasificacion();
                clasificacion.setIdClasificacion(idClasificacion);
                insert.setClasificacion(clasificacion);
                          
                Genero genero = new Genero();
                genero.setIdGenero(idGenero);
                insert.setGenero(genero);

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
 
    public static boolean update(Integer idPelicula, String titulo, String director, Date anioLanzamiento, Integer idClasificacion, Integer idGenero, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pelicula.class); 
        criteria.add(Restrictions.eq("idPelicula", idPelicula));
        Pelicula update=(Pelicula)criteria.uniqueResult();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            if(update!=null){
                update.setIdPelicula(idPelicula);
                
                update.setTitulo(titulo);
                update.setDirector(director);
                update.setAnioLanzamiento(anioLanzamiento);
                
                Clasificacion clasificacion = new Clasificacion();
                clasificacion.setIdClasificacion(idClasificacion);
                update.setClasificacion(clasificacion);
                          
                Genero genero = new Genero();
                genero.setIdGenero(idGenero);
                update.setGenero(genero);
                  
                
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
    
    public static List<Pelicula> universo(){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().getCurrentSession();
         List<Pelicula>lista = null;
         try{
             session.beginTransaction();
             Criteria criteria = session.createCriteria(Pelicula.class);
             criteria.add(Restrictions.eq("estado", true));
             criteria.addOrder(Order.desc("idPelicula"));
             criteria.setMaxResults(500);
             lista = criteria.list();
             
         }catch(HibernateException e){
             System.out.println("Error"+e);
             
         }finally{
             session.getTransaction().commit();
         }
         return lista;
    }
    
     public static boolean anular(Integer idPelicula, Integer idUsuario){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pelicula.class); 
        criteria.add(Restrictions.eq("idPelicula", idPelicula));
        Pelicula update=(Pelicula)criteria.uniqueResult();
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
     
     public static boolean eliminar(Integer idPelicula){
        boolean flag = false;
        Date fecha = new Date();
        Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Pelicula.class); 
        criteria.add(Restrictions.eq("idPelicula", idPelicula));
        Pelicula update=(Pelicula)criteria.uniqueResult();
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
     
     public static Pelicula select(Integer idPelicula){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Pelicula.class);
         criteria.add(Restrictions.eq("idPelicula", idPelicula));
         Pelicula select = (Pelicula)criteria.uniqueResult();
         if(select==null){
             select = new Pelicula();
             select.setIdPelicula(0);
             
         }
         session.close();
         return select;
     }
     
     public static Pelicula select1(Usuario usuario){
         Session session = HibernateUtil.HibernateUtil.getSessionFactory().openSession();
         Criteria criteria = session.createCriteria(Pelicula.class);
         criteria.add(Restrictions.eq("usuarioByUsuarioIngresa", usuario));
         Pelicula select = (Pelicula)criteria.uniqueResult();
         if(select==null){
             select = new Pelicula();
             select.setIdPelicula(0);
         }
         session.close();
         return select;
     }
}
