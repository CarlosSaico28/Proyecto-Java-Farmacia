/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;

/**
 *
 * @author USER
 */
public class Funciones {
    SimpleDateFormat Formato =new SimpleDateFormat("dd-MM-yyyy");
    
    public String getFecha(JDateChooser jd){
        if(jd.getDate() !=null){
            return Formato.format(jd.getDate());
        }
        return null;
    }
}
