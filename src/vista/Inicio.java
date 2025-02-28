/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista;

import controlador.controladorLogueo;
import modelo.logica.Logica;

/**
 *
 * @author USER
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Principal p = new Principal();
        controladorLogueo controlLogueo= new controladorLogueo();
        p.setControladorLogueo(controlLogueo);
        controlLogueo.setPrincipal(p);
       
        Logica logicaIngresar=new Logica();
        controlLogueo.setLogica(logicaIngresar);
        p.setVisible(true);
        
     ///////////////////////////////////////////////////////////////////////////
     //////////////////////////////////////////////////////////////////////////
        
       /*VistaMenu vm=new VistaMenu();
        
       controladorLogueo controlLogueoMenu=new controladorLogueo();        
       vm.setControladorLogueo(controlLogueoMenu);
       controlLogueoMenu.setVistaMenu(vm);
        
       Logica logic=new Logica();
       controlLogueoMenu.setLogica(logic);
       
       
       
        vm.setVisible(true);*/
        
    }
    
}
