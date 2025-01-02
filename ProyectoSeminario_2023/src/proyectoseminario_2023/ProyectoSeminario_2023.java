/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoseminario_2023;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Yoel
 */
public class ProyectoSeminario_2023 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        BigDecimal compra = new BigDecimal(5000);
        String fechaString = "2005";
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        Date fechaDate = formato.parse(fechaString);
        
         System.out.println("insert="+CRUDs.CRUDClasificacion.insert("Comedia", 8));
//        System.out.println("insert="+CRUDs.CRUDCompra.insert(1, 4, compra, 6));
//        System.out.println("update="+CRUDs.CRUDPelicula.update(2, "Spideman 2", "Sam Raimi", fechaDate, 1, 1, 6));
//          for(int i=0; i<CRUDs.CRUDPelicula.universo().size(); i++){
//              System.out.println("hola");
//              System.out.println("Titulo="+CRUDs.CRUDPelicula.universo().get(i).getTitulo());
//              System.out.println("Director="+CRUDs.CRUDPelicula.universo().get(i).getDirector());
//              System.out.println("Año de lanzamiento="+CRUDs.CRUDPelicula.universo().get(i).getAnioLanzamiento());
//              System.out.println("Salario="+CRUDs.CRUDPelicula.universo().get(i).getSalario());
          }
//                System.out.println("Titulo="+CRUDs.CRUDPelicula.select(2).getTitulo());
//        System.out.println("anular="+CRUDs.CRUDPelicula.anular(3, 6));
//    System.out.println("eliminar="+CRUDs.CRUDPelicula.eliminar(3, 6));
    

 
    }
    
    

