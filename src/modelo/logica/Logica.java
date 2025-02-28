/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.logica;

import java.sql.ResultSet;
import java.util.Date;
import modelo.dao.logueoDao;

/**
 *
 * @author USER
 */
public class Logica {
    logueoDao logueoD = new logueoDao();
    
    ///////////////////////////////////////////////////////
    public ResultSet Conectar(String usuario, String clave){
        return logueoD.Conectar(usuario, clave);
    
    }
    ////////////////////////////////////////////////////////
    public ResultSet IngresarTF(String usuario, String clave, String tipo){
        return logueoD.IngresarTF(usuario, clave, tipo);
    }
    ////////////////////////////////////////////////////////
    public ResultSet Ingresar(String usuario, String clave){
        return logueoD.Ingresar(usuario, clave);
    
    }
    //////////////////////////////////////////////////////////
    //////////////////CLIENTES///////////////////////////////
    public boolean agregarCliente(String usuario,/*int codigo,*/long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String estado)
    {
        return logueoD.agregarCliente(usuario,/*codigo,*/ cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, estado);
    }
    
    public ResultSet buscar(long cedula){
        return logueoD.buscar(cedula);
    }
    
    
    public ResultSet listarCliente()
    {
        return logueoD.listarCliente();
    }
    
    public long eliminarCliente(long cedula){
        return logueoD.eliminarCliente(cedula);
    
    }
    
   public boolean modificarCliente(long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String estado)
    {
        return logueoD.modificarCliente(cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, estado);
    }
   /////////////////////////////////////////////////////////////
     /////////////////////TIPO EMPLEADOS/////////////////////////
    
    public boolean agregarTipoEmpleado(/*int codigo,*/ String detalle)
    {
        return logueoD.agregarTipoEmpleado(/*codigo,*/ detalle);
    }
    
    public ResultSet listarTipoEmpleado()
    {
        return logueoD.listarTipoEmpleado();
    }
    public ResultSet buscarTipoEmpleado(int codigo){
        return logueoD.buscarTipoEmpleado(codigo);
    }
    
    public int eliminarTipoEmpleado(int codigo){
        return logueoD.eliminarTipoEmpleado(codigo);
    }
    
    public boolean modificarTipoEmpleado(int codigo, String detalle)
    {
        return logueoD.modificarTipoEmpleado(codigo, detalle);
    }
    
    /////////////////////////////////////////////////////////////
     /////////////////////EMPLEADOS/////////////////////////
    public boolean agregarEmpleado(/*int codigo,*/long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String usuario, String clave, String estado, int tipo)
    {
        return logueoD.agregarEmpleado(/*codigo,*/ cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, usuario, clave, estado, tipo);
    }
    
    public ResultSet listarEmpleado()
    {
        return logueoD.listarEmpleado();
    }
    
    public ResultSet buscarEmpleado(long cedula){
        return logueoD.buscarEmpleado(cedula);
    }
    
    public int eliminarEmpleado(long cedula, String usuario){
        return logueoD.eliminarEmpleado(cedula, usuario);
    }
    
    public boolean modificarEmpleado(long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String usuario, String clave, String estado, int tipo)
    {
        return logueoD.modificarEmpleado(cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, usuario, clave, estado, tipo);
    }
    
    /////////////////////////////////////////////////////////////
     /////////////////////CATEGORÍAS/////////////////////////
    public boolean agregarCategoria(/*int codigo,*/ String nombre)
    {
        return logueoD.agregarCategoria(/*codigo,*/ nombre);
    }
    
    public ResultSet listarCategoria()
    {
        return logueoD.listarCategoria();
    }
    
    public ResultSet buscarCategoria(int codigo){
        return logueoD.buscarCategoria(codigo);
    }
    
    public int eliminarCategoria(int codigo){
        return logueoD.eliminarCategoria(codigo);
    }
    
    public boolean modificarCategoria(int codigo, String nombre)
    {
        return logueoD.modificarCategoria(codigo, nombre);
        
    }
/////////////////////////////////////////////////////////////
     /////////////////////PROVEEDOR/////////////////////////
    
    public boolean agregarProveedor(/*int codigo, */String nombre)
    {
        return logueoD.agregarProveedor(/*codigo,*/ nombre);
    }   
    
    public ResultSet listarProveedor()
    {
        return logueoD.listarProveedor();
    }
     
    
    public ResultSet buscarProveedor(int codigo){
        return logueoD.buscarProveedor(codigo);
    }
    
    public int eliminarProveedor(int codigo){
        return logueoD.eliminarProveedor(codigo);
    }
    
    public boolean modificarProveedor(int codigo, String nombre)
    {
        return logueoD.modificarProveedor(codigo, nombre);
        
    }
    
/////////////////////////////////////////////////////////////
     /////////////////////PRODUCTOS/////////////////////////
    
    public boolean agregarProductos(long codigo, String nombre, double precio, int stock, double iva, int cat_id)
    {
        return logueoD.agregarProductos(codigo, nombre, precio, stock, iva, cat_id);
    }    
    
    public ResultSet listarProducto()
    {
        return logueoD.listarProducto();
    }
    
    public ResultSet buscarProducto(long codigo){
        return logueoD.buscarProducto(codigo);
    }
    
    public int eliminarProducto(long codigo){
        return logueoD.eliminarProducto(codigo);
    }
    
    public boolean modificarProductos(long codigo, String nombre, double precio, int stock, double iva, int cat_id)
    {
        return logueoD.modificarProductos(codigo, nombre, precio, stock, iva, cat_id);
    }
    
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-INVENTARIO/////////////////////////
    public boolean agregarInventario( String fecha, double total, int cantidad, long codigo_barra, int prov_id)
    {
        return logueoD.agregarInventario(fecha, total, cantidad, codigo_barra, prov_id);
    }
    public ResultSet listarInventario()
    {
        return logueoD.listarInventario();
    }
    public ResultSet buscarInventario(int codigo){
        return logueoD.buscarInventario(codigo);
    }
    
    public int eliminarInventario(int codigo){
        return logueoD.eliminarInventario(codigo);
    }
    
    public boolean modificarInventario( int codigo,String fecha, double total, int cantidad, long codigo_barra, int prov_id)
    {
        return logueoD.modificarInventario(codigo,fecha, total, cantidad, codigo_barra, prov_id);
    }
    
    
    /////////////////////////////////////////////////////////////////////
    public ResultSet listarIDCAB()
    {
        return logueoD.listarIDCAB();
    }
     /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-CABECERA////////////////////////
   
    public boolean agregarCabecera( java.sql.Date fecha,double iva, String estado,int emp_id, int cli_id, double precio, int cantidad, double iva2 )
    {
        return logueoD.agregarCabecera(fecha, iva, estado, emp_id, cli_id, precio, cantidad, iva2);
    }
    
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-INVENTARIO/////////////////////////
    public boolean agregarDetalle( int cantidad, double precio,/* double subtotal, */double iva,/* double total,*/ int cab_id, long codigo_barra)
    {
        return logueoD.agregarDetalle(cantidad, precio,/* subtotal,*/ iva,/* total,*/ cab_id, codigo_barra);
    }
    
    public ResultSet listarDetalle()
    {
        return logueoD.listarDetalle();
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////////BUSCAR-IDS-EMP-CLI/////////////////////////////////
    public ResultSet buscarEMPFAC(String usuario){
        return logueoD.buscarEMPFAC(usuario);
    }
    
    public ResultSet buscarCLIFAC(String nombref, String apellidof){
        return logueoD.buscarCLIFAC(nombref, apellidof);
    }
    
     public boolean actualizarCabecera(int id_cab,double sub_total, double total){
        
        return logueoD.actualizarCabecera(id_cab,sub_total, total);
    }
     
     public boolean actualizarStockFAC(int cantidad, long pro_codigo_barra){
        return logueoD.actualizarStockFAC( cantidad, pro_codigo_barra);
        
    }
     
    public boolean anularFactura(int cantidad, String nombre){
        return logueoD.anularFactura( cantidad, nombre);
        
    }
    
}
