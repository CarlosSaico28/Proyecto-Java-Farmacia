/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.Principal;
import vista.VistaMenu;
import java.util.Date;
////////////////////////////
///////////////////////////
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.filechooser.FileSystemView;
//////////////////////////////
////////////////////////////
/**
 *
 * @author USER
 */
public class logueoDao {
    PreparedStatement ps;
    Statement mistatement;
    Connection con;
    ResultSet rs;
    String usuario= VistaMenu.lblUsuario.getText()+(".");
    

    public ResultSet Conectar(String usuario, String clave){
        try {
                if(con!=null && con.isValid(0)){
                    System.out.println("Ya existe la conexión");
                }
                else{
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    System.out.println("Conectando con la base de datos..");
                    con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", usuario, clave);
                    mistatement = con.createStatement();
                    System.out.println("CONEXIÓN EXITOSA");
                }
            } 
            catch (SQLException ex) {
                System.out.println("La excepcion raiz es: "+ ex);
               Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        return null;
    
    }
    
    

    /////////////////////////////////LOGUEO////////////////////////////////////////
    public ResultSet Ingresar(String usuario, String clave) {
        
       // conectar();
       //////////////////////////////////////////////////////////////////////////////
       try {
                if(con!=null && con.isValid(0)){
                    System.out.println("Ya existe la conexión");
                }
                else{
                    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
                    System.out.println("Conectando con la base de datos..");
                    con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", usuario, clave);
                    mistatement = con.createStatement();
                    System.out.println("CONEXIÓN EXITOSA");
                }
            } 
            catch (SQLException ex) {
                System.out.println("La excepcion raiz es: "+ ex);
               Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
       /////////////////////////////////////////////////////////////////////////////
       
       /*
        try {
            //PreparedStatement sentencia=con.prepareStatement("SELECT * FROM far_empleados WHERE emp_usuario=? AND emp_contraseña=? AND ");
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM far_empleados ,far_tipo  WHERE far_empleados.tip_id = far_tipo.tip_id AND emp_usuario=? AND emp_contraseña=? AND tip_detalle=?");

            sentencia.setString(1, usuario);
            sentencia.setString(2, clave);
            sentencia.setString(3, tipo);
            ResultSet listado = sentencia.executeQuery();
            
            return listado;

        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
       
       */
        return null;
       
    }
    
    public ResultSet IngresarTF(String usuario, String clave, String tipo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_empleados, c##adminFar.far_tipos "
                    + "WHERE far_tipos.tip_id = far_empleados.tip_id AND emp_usuario=? AND emp_contrasenia=? AND tip_detalle = ?");
            sentencia.setString(1, usuario);
            sentencia.setString(2, clave);
            sentencia.setString(3, tipo);
            
            ResultSet listado = sentencia.executeQuery();
            return listado;
        } 
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    ////////////////////////////////////////////////////////////////////////////
    ////////////////////////////CLIENTES////////////////////////////////////////
    
    public boolean agregarCliente(String usuario,/*int codigo,*/long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String estado)
    {   
        
        String clave=Principal.txtClave.getText();
        Conectar(usuario,clave);
        
        
         try 
        {  
            
            
            //PreparedStatement sentencia=con.prepareStatement("INSERT INTO adminFar.far_clientes (adminFar.cli_id_seq.nextval,cli_cedula,cli_nombre, cli_apellido,cli_calle_principal,cli_calle_secundaria, cli_num_vivienda, cli_telefono, cli_email, cli_estado) VALUES ( ?,?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //adminFar.cli_id_seq.nextval,
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_clientes VALUES ( c##adminFar.cli_id_seq.nextval,?, ?, ?, ?, ?, ?, ?, ?, ?)");

            //sentencia.setInt(1, codigo);
            sentencia.setLong(1, cedula);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setString(4, calle_principal);
            sentencia.setString(5, calle_secundaria);
            sentencia.setString(6, num_vivienda);
            sentencia.setLong(7,telefono);
            sentencia.setString(8, email);
            sentencia.setString(9, estado);
            
            sentencia.executeUpdate();
            System.out.println("SI SE ESTÁN AGREGANDO");

            
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("NO SE ESTÁN AGREGANDO");
        }
        
        return false;
        
    }
    public ResultSet buscar(long cedula) {
        
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_clientes WHERE cli_cedula = ?");
            sentencia.setLong(1, cedula);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       // System.out.println("Esta buscando al cliente"+ cedula);
        return null;
         
       
    }
    public ResultSet listarCliente()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clave=Principal.txtClave.getText();
        Conectar(usuarioc,clave);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_clientes");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public long eliminarCliente(long cedula){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_clientes Where cli_cedula=?");
            sentencia.setLong(1, cedula);
            return sentencia.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    
    }
    
    public boolean modificarCliente(long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String estado)
    {        
         try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_clientes SET  cli_nombre=?, cli_apellido=?, cli_calle_principal=?, cli_calle_secundaria=?, cli_num_vivienda=?, cli_telefono=?, cli_email=?, cli_estado=? WHERE cli_cedula=?");

            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, calle_principal);
            sentencia.setString(4, calle_secundaria);
            sentencia.setString(5, num_vivienda);
            sentencia.setLong(6,telefono);
            sentencia.setString(7, email);
            sentencia.setString(8, estado);
            sentencia.setLong(9, cedula);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /////////////////////////////////////////////////////////////
     /////////////////////TIPO EMPLEADOS/////////////////////////
    
    public boolean agregarTipoEmpleado(/*int codigo,*/ String detalle)
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_tipos VALUES (c##adminfar.tip_id_seq.nextval, ?)");
            //sentencia.setInt(1, codigo);
            sentencia.setString(1, detalle);
            sentencia.executeUpdate();
    
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }
    
    public ResultSet listarTipoEmpleado()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_tipos");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
    public ResultSet buscarTipoEmpleado(int codigo){
                
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_tipos WHERE tip_id = ?");
            sentencia.setInt(1, codigo);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int eliminarTipoEmpleado(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_tipos Where tip_id=?");
            sentencia.setInt(1, codigo);
            return sentencia.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean modificarTipoEmpleado(int codigo, String detalle)
    {
       try 
        {  
            //conectar();
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_tipos SET  tip_detalle=? WHERE tip_id=?");

            sentencia.setString(1, detalle);
            sentencia.setInt(2, codigo);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
    }
    
    /////////////////////////////////////////////////////////////
     /////////////////////EMPLEADOS/////////////////////////
    public boolean agregarEmpleado(/*int codigo,*/long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String usuario, String clave, String estado, int tipo)
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_empleados  VALUES (c##adminFar.emp_id_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
          
            //sentencia.setInt(1, codigo);
            sentencia.setLong(1, cedula);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setString(4, calle_principal);
            sentencia.setString(5, calle_secundaria);
            sentencia.setString(6, num_vivienda);
            sentencia.setLong(7,telefono);
            sentencia.setString(8, email);
            sentencia.setString(9, usuario);
            sentencia.setString(10, clave);
            sentencia.setString(11, estado);
            sentencia.setInt(12, tipo);
            sentencia.executeUpdate();
            System.out.println("Se están agregando");
            ///ALTER SESSION/////
            //PreparedStatement sentenciaAlterSession=con.prepareStatement("ALTER SESSION SET \"_ORACLE_SCRIPT\"=TRUE");
            //sentenciaAlterSession.executeUpdate();
            ///CREATE USER/////
            PreparedStatement sentenciaCreateUser=con.prepareStatement("CREATE USER "+usuario+" IDENTIFIED BY "+clave+ " PROFILE c##contrasena "+ "ACCOUNT UNLOCK");
            
            sentenciaCreateUser.executeUpdate();
            if(tipo==1){
                PreparedStatement sentenciaARolA=con.prepareStatement("GRANT c##rol_administrador TO "+usuario);
                sentenciaARolA.executeUpdate();
            }
            else if (tipo==2){
                PreparedStatement sentenciaARolEG=con.prepareStatement("GRANT c##rol_empleado_general TO "+usuario);
                sentenciaARolEG.executeUpdate();
            }
            ///
            return true;

            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
    }
    
    public ResultSet listarEmpleado()
    {
        
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_empleados");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    public ResultSet buscarEmpleado(long cedula){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_empleados WHERE emp_cedula = ?");
            sentencia.setLong(1, cedula);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null; 
    }
    
    public int eliminarEmpleado(long cedula, String usuario){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_empleados Where emp_cedula=?");
            sentencia.setLong(1, cedula);
            
            //PreparedStatement sentenciaAlterSession=con.prepareStatement("ALTER SESSION SET \"_ORACLE_SCRIPT\"=TRUE");
            //sentenciaAlterSession.executeUpdate();
            
            PreparedStatement sentenciaEliminarEmpleado = con.prepareStatement("DROP USER "+usuario+ " CASCADE");
            sentenciaEliminarEmpleado.executeUpdate();
                    
            return sentencia.executeUpdate(); 
        } 
        
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean modificarEmpleado(long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email,String usuario, String clave, String estado, int tipo)
    {
         try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_empleados SET  emp_nombre=?, emp_apellido=?, emp_calle_principal=?, emp_calle_secundaria=?, emp_num_vivienda=?, emp_telefono=?, emp_email=?, emp_usuario=?, emp_contrasenia=?,  emp_estado=?, tip_id=? WHERE emp_cedula=?");

            sentencia.setString(1, nombre);
            sentencia.setString(2, apellido);
            sentencia.setString(3, calle_principal);
            sentencia.setString(4, calle_secundaria);
            sentencia.setString(5, num_vivienda);
            sentencia.setLong(6,telefono);
            sentencia.setString(7, email);
            sentencia.setString(8,usuario );
            sentencia.setString(9, clave);
            sentencia.setString(10, estado);
            sentencia.setInt(11, tipo);
            sentencia.setLong(12, cedula);
            
            sentencia.executeUpdate();
            ///ALTER SESSION/////
            //PreparedStatement sentenciaAlterSession=con.prepareStatement("ALTER SESSION SET \"_ORACLE_SCRIPT\"=TRUE");
            //sentenciaAlterSession.executeUpdate();
            ///CREATE USER/////
            PreparedStatement sentenciaCreateUser=con.prepareStatement("ALTER USER "+usuario+" IDENTIFIED BY "+clave);
            
            sentenciaCreateUser.executeUpdate();
            if(tipo==1){
                //PreparedStatement sentenciaAlterSession1=con.prepareStatement("ALTER SESSION SET \"_ORACLE_SCRIPT\"=TRUE");
                //sentenciaAlterSession1.executeUpdate();
                
                PreparedStatement sentenciaRVR=con.prepareStatement("REVOKE c##rol_empleado_general FROM "+usuario);
                sentenciaRVR.executeUpdate();
                
                PreparedStatement sentenciaARolA=con.prepareStatement("GRANT c##rol_administrador TO "+usuario);
                sentenciaARolA.executeUpdate();
                
                
            }
            else if (tipo==2){
                //PreparedStatement sentenciaAlterSession2=con.prepareStatement("ALTER SESSION SET \"_ORACLE_SCRIPT\"=TRUE");
                //sentenciaAlterSession2.executeUpdate();
                
                PreparedStatement sentenciaRVRF=con.prepareStatement("REVOKE c##rol_administrador FROM"+usuario);
                sentenciaRVRF.executeUpdate();
                
                PreparedStatement sentenciaARolEG=con.prepareStatement("GRANT c##rol_empleado_general TO "+usuario);
                sentenciaARolEG.executeUpdate();
                
                
                
            }
            ///

            return true;
        } 
        catch (SQLException ex) 
        {
            //Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    
    /////////////////////////////////////////////////////////////
     /////////////////////CATEGORÍAS/////////////////////////
    public boolean agregarCategoria(/*int codigo,*/ String nombre)
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_categorias VALUES (c##adminFar.cat_id_seq.nextval, ?)");
            //sentencia.setInt(1, codigo);
            sentencia.setString(1, nombre);
            sentencia.executeUpdate();
    
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
      
    }
    
    
    public ResultSet listarCategoria()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_categorias");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
    public ResultSet buscarCategoria(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_categorias WHERE cat_id = ?");
            sentencia.setInt(1, codigo);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int eliminarCategoria(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_categorias Where cat_id=?");
            sentencia.setInt(1, codigo);
            return sentencia.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean modificarCategoria(int codigo, String nombre)
    {
       try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_categorias SET  cat_nombre=? WHERE cat_id=?");

            sentencia.setString(1, nombre);
            sentencia.setInt(2, codigo);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
        
    }
    
/////////////////////////////////////////////////////////////
     /////////////////////PROVEEDOR/////////////////////////
    
    public boolean agregarProveedor(/*int codigo,*/ String nombre)
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_proveedores VALUES (c##adminFar.prov_id_seq.nextval, ?)");
            //sentencia.setInt(1, codigo);
            sentencia.setString(1, nombre);
            sentencia.executeUpdate();
    
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
    } 
    
    public ResultSet listarProveedor()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_proveedores");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
        
    }
    
    public ResultSet buscarProveedor(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_proveedores WHERE prov_id = ?");
            sentencia.setInt(1, codigo);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int eliminarProveedor(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_proveedores Where prov_id=?");
            sentencia.setInt(1, codigo);
            return sentencia.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean modificarProveedor(int codigo, String nombre)
    {
        try 
        {  
            //conectar();
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_proveedores SET  prov_nombre=? WHERE prov_id=?");

            sentencia.setString(1, nombre);
            sentencia.setInt(2, codigo);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
        
    }
    
    /////////////////////////////////////////////////////////////
     /////////////////////PRODUCTOS/////////////////////////
    
    public boolean agregarProductos(long codigo, String nombre, double precio, int stock, double iva, int cat_id)
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_productos (pro_codigo_barra, pro_nombre, pro_precio, pro_stock, pro_iva , cat_id ) VALUES (?, ?, ?, ?, ?, ?)");
          
            sentencia.setLong(1, codigo);
            sentencia.setString(2, nombre);
            sentencia.setDouble(3, precio);
            sentencia.setInt(4, stock);
            sentencia.setDouble(5, iva);
            sentencia.setInt(6, cat_id);

            sentencia.executeUpdate();
            
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }
    
    public ResultSet listarProducto()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_productos");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;   
    }
    
    public ResultSet buscarProducto(long codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_productos WHERE pro_codigo_barra = ?");
            sentencia.setLong(1, codigo);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int eliminarProducto(long codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_productos Where pro_codigo_barra=?");
            sentencia.setLong(1, codigo);
            return sentencia.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean modificarProductos(long codigo, String nombre, double precio, int stock, double iva, int cat_id)
    {
        try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_productos SET  pro_nombre=?, pro_precio=?, pro_stock=?, pro_iva=?, cat_id=? WHERE pro_codigo_barra=?");

            sentencia.setString(1, nombre);
            sentencia.setDouble(2, precio);
            sentencia.setInt(3, stock);
            sentencia.setDouble(4, iva);
            sentencia.setInt(5, cat_id);
            sentencia.setLong(6, codigo);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
    }
    
    
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-INVENTARIO/////////////////////////
    public boolean agregarInventario( String fecha, double total, int cantidad, long codigo_barra, int prov_id)
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_facturas  VALUES(##adminFar.fac_numero_seq.nextval, ?, ?, ?, ?, ?)");
          
            //sentencia.setInt(1, codigo);
            sentencia.setString(1,fecha);
            sentencia.setDouble(2, total);
            sentencia.setInt(3, cantidad);
            sentencia.setLong(4, codigo_barra);
            sentencia.setInt(5, prov_id );
            sentencia.executeUpdate();
            System.out.println("Se están agregando");
            
            ////////////////////////
            /*
            PreparedStatement sentenciaAI=con.prepareStatement("UPDATE adminFar.far_productos "
                    + " SET pro_stock = (SELECT fac_cantidad "
                    + "FROM adminFar.far_facturas "
                    + " WHERE pro_codigo_barra =  "+ codigo_barra+
                    ") + "+" adminFar.far_productos.pro_stock "
                    + " WHERE pro_codigo_barra= "+codigo_barra);
            sentenciaAI.executeUpdate();*/
            
           
            PreparedStatement sentenciaStock=con.prepareStatement("UPDATE c##adminFar.far_productos SET pro_stock=pro_stock + "+cantidad+ " WHERE pro_codigo_barra=?");
            //sentenciaStock.setInt(1, cantidad);
            sentenciaStock.setLong(1, codigo_barra);
            sentenciaStock.executeUpdate();
            
            
            
            return true;

            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
        
        
    }
    
    public ResultSet listarInventario()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_facturas");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;  
    }
    
    public ResultSet buscarInventario(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_facturas WHERE fac_numero = ?");
            sentencia.setLong(1, codigo);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int eliminarInventario(int codigo){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia = con.prepareStatement("DELETE FROM c##adminFar.far_facturas Where fac_numero=?");
            sentencia.setLong(1, codigo);
            return sentencia.executeUpdate();
            
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean modificarInventario( int codigo,String fecha, double total, int cantidad, long codigo_barra, int prov_id)
    {
     try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_facturas SET  fac_fecha=?, fac_total=?, fac_cantidad=?, pro_codigo_barra=?, prov_id=? WHERE fac_numero=?");

            sentencia.setString(1, fecha);
            sentencia.setDouble(2, total);
            sentencia.setInt(3, cantidad);
            sentencia.setLong(4, codigo_barra);
            sentencia.setInt(5, prov_id);
            sentencia.setLong(6, codigo);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;    
    }
    
    //////////////////////////////////////////////////////////////////
    /////////////////////CABECERA/////////////////////////
    public ResultSet listarIDCAB()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT MAX (cab_id) FROM c##adminFar.far_cabecera_facturas");
            
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;  
        
    }
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-CABECERA////////////////////////
   
     public boolean agregarCabecera( java.sql.Date fecha,double iva, String estado, int emp_id, int cli_id, double precio, int cantidad, double iva2 )
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
                                         
        try {
            PreparedStatement sentencia = con.prepareStatement("INSERT INTO c##adminFar.far_cabecera_facturas VALUES (c##adminFar.cab_id_seq.nextval, ?, ("+(((precio*cantidad)*iva)+(precio*cantidad))+"), ?, (" +(((precio*cantidad)*iva)+(precio*cantidad))+") , ?,?, ?)");
        
            sentencia.setDate(1, fecha);
            sentencia.setDouble(2, iva);
            sentencia.setString(3, estado);
            sentencia.setInt(4, emp_id);
            sentencia.setInt(5, cli_id);
            
            sentencia.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
           return false; 
         
    }
    
    
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-INVENTARIO/////////////////////////
    public boolean agregarDetalle( int cantidad, double precio,/* double subtotal, */double iva,/* double total,*/ int cab_id, long codigo_barra)
    {
       String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
         try 
        {  
            
            PreparedStatement sentencia=con.prepareStatement("INSERT INTO c##adminFar.far_detalle_facturas VALUES (c##adminFar.det_id_seq.nextval, ?, ?," +(precio * cantidad)+ " ,? ,"+ ((precio * cantidad * iva)+(precio )* cantidad)+ ", ?,?)");                                 
          
            sentencia.setInt(1, cantidad);
            sentencia.setDouble(2, precio);
            sentencia.setDouble(3, iva);
            sentencia.setInt(4, cab_id);
            sentencia.setLong(5, codigo_barra);

            sentencia.executeUpdate();
            
            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;  
    }
    
    public ResultSet listarDetalle()
    {
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try 
        {
            ResultSet listado=mistatement.executeQuery("SELECT * FROM c##adminFar.far_detalle_facturas");
            return listado;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null; 
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////////BUSCAR-IDS-EMP-CLI/////////////////////////////////
    public ResultSet buscarEMPFAC(String usuario){
        
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_empleados WHERE emp_usuario = ?");
            sentencia.setString(1, usuario);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ResultSet buscarCLIFAC(String nombref, String apellidof){
        String usuarioc="c##"+Principal.txtUsuario.getText();
        String clavec=Principal.txtClave.getText();
        Conectar(usuarioc,clavec);
        
        try {
            PreparedStatement sentencia=con.prepareStatement("SELECT * FROM c##adminFar.far_clientes WHERE cli_nombre= ? AND cli_apellido = ? ");
            sentencia.setString(1, nombref);
            sentencia.setString(2, apellidof);
            ResultSet listado = sentencia.executeQuery();

            return listado;
        } 
        
        catch (SQLException ex) {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public boolean actualizarCabecera(int id_cab,double sub_total, double total){
        try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_cabecera_facturas SET  cab_subtotal=?, cab_total=? WHERE cab_id=?");

            sentencia.setDouble(1, sub_total);
            sentencia.setDouble(2, total);
            sentencia.setInt(3, id_cab);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
        
    }
    
    public boolean actualizarStockFAC(int cantidad, long pro_codigo_barra){
        try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_productos SET  pro_stock=pro_stock -"+cantidad+" WHERE pro_codigo_barra=?");
            sentencia.setLong(1, pro_codigo_barra);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
        
    }
    
    public boolean anularFactura(int cantidad, String nombre){  
        try 
        {  
            String usuarioc="c##"+Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            
            PreparedStatement sentencia=con.prepareStatement("UPDATE c##adminFar.far_productos SET  pro_stock=pro_stock + "+cantidad+" WHERE pro_nombre=?");
            sentencia.setString(1, nombre);
            sentencia.executeUpdate();

            return true;
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(logueoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false; 
    }
    
    /////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////FACTURACIÓN PDF//////////////////////////////////////
    /*
    public void pdfV(int idventa, int Cliente, double total, String usuario) {
        try {
            String usuarioc=Principal.txtUsuario.getText();
            String clavec=Principal.txtClave.getText();
            Conectar(usuarioc,clavec);
            Date date = new Date();
            FileOutputStream archivo;
            String url = FileSystemView.getFileSystemView().getDefaultDirectory().getPath();
            File salida = new File(url + "venta.pdf");
            archivo = new FileOutputStream(salida);
            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();
            ///////////////////////////////////////////////////////////////////////////
            Image img = Image.getInstance(getClass().getResource("/Imagenes/lofof.png"));
            //Fecha
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            fecha.add("Vendedor: " + usuario + "\nFolio: " + idventa + "\nFecha: "
                    + new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n\n");
            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);
            float[] columnWidthsEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(columnWidthsEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            Encabezado.addCell(img);
            Encabezado.addCell("");
            //info empresa
            String config = "SELECT * FROM adminFar.far_proveedores";
            String mensaje = "";
            
            try {
                
                ps = con.prepareStatement(config);
                rs = ps.executeQuery();
                if (rs.next()) {
                    mensaje = rs.getString("mensaje");
                    Encabezado.addCell("Ruc:    " + rs.getString("ruc") + "\nNombre: " + rs.getString("nombre") + "\nTeléfono: " + rs.getString("telefono") + "\nDirección: " + rs.getString("direccion") + "\n\n");
                }
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            //
            Encabezado.addCell(fecha);
            doc.add(Encabezado);
            //cliente
            Paragraph cli = new Paragraph();
            cli.add(Chunk.NEWLINE);
            cli.add("DATOS DEL CLIENTE" + "\n\n");
            doc.add(cli);

            PdfPTable proveedor = new PdfPTable(3);
            proveedor.setWidthPercentage(100);
            proveedor.getDefaultCell().setBorder(0);
            float[] columnWidthsCliente = new float[]{50f, 25f, 25f};
            proveedor.setWidths(columnWidthsCliente);
            proveedor.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliNom = new PdfPCell(new Phrase("Nombre", negrita));
            PdfPCell cliTel = new PdfPCell(new Phrase("Télefono", negrita));
            PdfPCell cliDir = new PdfPCell(new Phrase("Dirección", negrita));
            cliNom.setBorder(Rectangle.NO_BORDER);
            cliTel.setBorder(Rectangle.NO_BORDER);
            cliDir.setBorder(Rectangle.NO_BORDER);
            proveedor.addCell(cliNom);
            proveedor.addCell(cliTel);
            proveedor.addCell(cliDir);
            String prove = "SELECT * FROM adminFar.far_clientes WHERE cli_cedula = ?";
            try {
                PreparedStatement ps = con.prepareStatement(prove);
                ps.setInt(1, Cliente);
                rs = ps.executeQuery();
                if (rs.next()) {
                    proveedor.addCell(rs.getString("cli_nombre"));
                    proveedor.addCell(rs.getString("cli_telefono"));
                    proveedor.addCell(rs.getString("cli_calle_principal") + "\n\n");
                } else {
                    proveedor.addCell("Publico en General");
                    proveedor.addCell("S/N");
                    proveedor.addCell("S/N" + "\n\n");
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            doc.add(proveedor);

            PdfPTable tabla = new PdfPTable(4);
            tabla.setWidthPercentage(100);
            tabla.getDefaultCell().setBorder(0);
            float[] columnWidths = new float[]{10f, 50f, 15f, 15f};
            tabla.setWidths(columnWidths);
            tabla.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell c1 = new PdfPCell(new Phrase("Cant.", negrita));
            PdfPCell c2 = new PdfPCell(new Phrase("Descripción.", negrita));
            PdfPCell c3 = new PdfPCell(new Phrase("P. unt.", negrita));
            PdfPCell c4 = new PdfPCell(new Phrase("P. Total", negrita));
            c1.setBorder(Rectangle.NO_BORDER);
            c2.setBorder(Rectangle.NO_BORDER);
            c3.setBorder(Rectangle.NO_BORDER);
            c4.setBorder(Rectangle.NO_BORDER);
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c4.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);
            String product = "SELECT d.det_id, d.pro_codigo_barra, d.cab_id, d.det_precio, d.det_cantidad, p.pro_codigo_barra, p.pro_nombre FROM adminFar.far_detalle_facturas d INNER JOIN adminFar.far_productos p ON d.pro_codigo_barra = p.pro_codigo_barra WHERE d.cab_id=?";
            try {
                ps = con.prepareStatement(product);
                ps.setInt(1, idventa);
                rs = ps.executeQuery();
                while (rs.next()) {
                    double subTotal = rs.getInt("det_cantidad") * rs.getDouble("det_precio");
                    tabla.addCell(rs.getString("det_cantidad"));
                    tabla.addCell(rs.getString("pro_nombre"));
                    tabla.addCell(rs.getString("det_precio"));
                    tabla.addCell(String.valueOf(subTotal));
                }

            } catch (SQLException e) {
                System.out.println(e.toString());
            }
            doc.add(tabla);
            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total S/: " + total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);
            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion \n\n");
            firma.add("------------------------------------\n");
            firma.add("Firma \n");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);
            Paragraph gr = new Paragraph();
            gr.add(Chunk.NEWLINE);
            gr.add(mensaje);
            gr.setAlignment(Element.ALIGN_CENTER);
            doc.add(gr);
            doc.close();
            archivo.close();
            Desktop.getDesktop().open(salida);
        } catch (DocumentException | IOException e) {
            System.out.println(e.toString());
        }
    }*/
}
