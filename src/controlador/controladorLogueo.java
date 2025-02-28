/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.logica.Logica;
import java.sql.ResultSet;
import java.util.Date;
import vista.Principal;
import vista.VistaMenu;

/**
 *
 * @author USER
 */
public class controladorLogueo {
    
    private Logica logica;
    private Principal principal;
    private VistaMenu vistaMenu;
    
    
    public VistaMenu getVistaMenu() {
        return vistaMenu;
    }
    
    public void setVistaMenu(VistaMenu vistaMenu) {
        this.vistaMenu= vistaMenu;
    }

    public Logica getLogica() {
        return logica;
    }

    public void setLogica(Logica logica) {
        this.logica = logica;
    }

    public Principal getPrincipal() {
        return principal;
    }

    public void setPrincipal(Principal principal) {
        this.principal = principal;
    }
    ///////////////////////////////////////////////////////
    public ResultSet Conectar(String usuario, String clave){
        return logica.Conectar(usuario, clave);
    }
    //////////////////////////////////////////////////////////
    public ResultSet IngresarTF(String usuario, String clave, String tipo){
        return logica.IngresarTF(usuario, clave, tipo);
    }
    ////////////////////////////////////////////////////////
    
    public ResultSet Ingresar(String usuario, String clave){
        return logica.Ingresar(usuario, clave);
    }
    
     //////////////////////////////////////////////////////
     /////////////////////CLIENTES/////////////////////////
    public boolean agregarCliente(String usuario,/*int codigo,*/long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String estado)
    {
        return logica.agregarCliente(usuario,/*codigo,*/ cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, estado);
    }
    
    public ResultSet buscar(long cedula){
        return logica.buscar(cedula);
    }
    
    public ResultSet listarCliente()
    {
        return logica.listarCliente();
    }
    
    public long eliminarCliente(long cedula){
        return logica.eliminarCliente(cedula);
    }
    
    public boolean modificarCliente(long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String estado)
    {
        return logica.modificarCliente(cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, estado);
    }
    /////////////////////////////////////////////////////////////
     /////////////////////TIPO EMPLEADOS/////////////////////////
    
    public boolean agregarTipoEmpleado(/*int codigo,*/ String detalle)
    {
        return logica.agregarTipoEmpleado(/*codigo,*/ detalle);
    }
    
    public ResultSet listarTipoEmpleado()
    {
        return logica.listarTipoEmpleado();
    }
    public ResultSet buscarTipoEmpleado(int codigo){
        return logica.buscarTipoEmpleado(codigo);
    }
    
    public int eliminarTipoEmpleado(int codigo){
        return logica.eliminarTipoEmpleado(codigo);
    }
    
    public boolean modificarTipoEmpleado(int codigo, String detalle)
    {
        return logica.modificarTipoEmpleado(codigo, detalle);
        
    }
    /////////////////////////////////////////////////////////////
     /////////////////////EMPLEADOS/////////////////////////
    public boolean agregarEmpleado(/*int codigo,*/long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String usuario, String clave, String estado, int tipo)
    {
        return logica.agregarEmpleado(/*codigo,*/ cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, usuario,clave, estado, tipo);
    }
    
    public ResultSet listarEmpleado()
    {
        return logica.listarEmpleado();
    }
    
    public ResultSet buscarEmpleado(long cedula){
        return logica.buscarEmpleado(cedula);
    }
    
    public int eliminarEmpleado(long cedula, String usuario){
        return logica.eliminarEmpleado(cedula, usuario);
    }
    
    public boolean modificarEmpleado(long cedula, String nombre, String apellido, String calle_principal,
             String calle_secundaria, String num_vivienda, long telefono, String email, String usuario, String clave, String estado, int tipo)
    {
        return logica.modificarEmpleado(cedula, nombre, apellido, calle_principal,
             calle_secundaria, num_vivienda, telefono,  email, usuario, clave, estado, tipo);
    }
    /////////////////////////////////////////////////////////////
     /////////////////////CATEGORÍAS/////////////////////////
    public boolean agregarCategoria(/*int codigo,*/ String nombre)
    {
        return logica.agregarCategoria(/*codigo,*/ nombre);
    }
    
    public ResultSet listarCategoria()
    {
        return logica.listarCategoria();
    }
    
    public ResultSet buscarCategoria(int codigo){
        return logica.buscarCategoria(codigo);
    }
    
    public int eliminarCategoria(int codigo){
        return logica.eliminarCategoria(codigo);
    }
    
    public boolean modificarCategoria(int codigo, String nombre)
    {
        return logica.modificarCategoria(codigo, nombre);
        
    }

/////////////////////////////////////////////////////////////
     /////////////////////PROVEEDOR/////////////////////////
    
    public boolean agregarProveedor(/*int codigo,*/ String nombre)
    {
        return logica.agregarProveedor(/*codigo,*/ nombre);
    }
    
    public ResultSet listarProveedor()
    {
        return logica.listarProveedor();
    }
    
    public ResultSet buscarProveedor(int codigo){
        return logica.buscarProveedor(codigo);
    }
    
    public int eliminarProveedor(int codigo){
        return logica.eliminarProveedor(codigo);
    }
    
    public boolean modificarProveedor(int codigo, String nombre)
    {
        return logica.modificarProveedor(codigo, nombre);
        
    }
/////////////////////////////////////////////////////////////
     /////////////////////PRODUCTOS/////////////////////////
    
    public boolean agregarProductos(long codigo, String nombre, double precio, int stock, double iva, int cat_id)
    {
        return logica.agregarProductos(codigo, nombre, precio, stock, iva, cat_id);
    }
    
    public ResultSet listarProducto()
    {
        return logica.listarProducto();
    }
    
    public ResultSet buscarProducto(long codigo){
        return logica.buscarProducto(codigo);
    }
    
    public int eliminarProducto(long codigo){
        return logica.eliminarProducto(codigo);
    }
    
    public boolean modificarProductos(long codigo, String nombre, double precio, int stock, double iva, int cat_id)
    {
        return logica.modificarProductos(codigo, nombre, precio, stock, iva, cat_id);
    }
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-INVENTARIO/////////////////////////
    public boolean agregarInventario( String fecha, double total, int cantidad, long codigo_barra, int prov_id)
    {
        return logica.agregarInventario(fecha, total, cantidad, codigo_barra, prov_id);
    }
    public ResultSet listarInventario()
    {
        return logica.listarInventario();
    }
    public ResultSet buscarInventario(int codigo){
        return logica.buscarInventario(codigo);
    }
    public int eliminarInventario(int codigo){
        return logica.eliminarInventario(codigo);
    }
    
    public boolean modificarInventario( int codigo,String fecha, double total, int cantidad, long codigo_barra, int prov_id)
    {
        return logica.modificarInventario(codigo,fecha, total, cantidad, codigo_barra, prov_id);
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    public ResultSet listarIDCAB()
    {
        return logica.listarIDCAB();
    }
    
     /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-CABECERA////////////////////////
   
    public boolean agregarCabecera( java.sql.Date fecha,double iva, String estado,int emp_id, int cli_id, double precio, int cantidad, double iva2 )
    {
        return logica.agregarCabecera(fecha, iva, estado, emp_id, cli_id, precio, cantidad, iva2);
    }
    
    
    
    /////////////////////////////////////////////////////////////////
     /////////////////////FACTURA-INVENTARIO/////////////////////////
    public boolean agregarDetalle( int cantidad, double precio,/* double subtotal, */double iva,/* double total,*/ int cab_id, long codigo_barra)
    {
        return logica.agregarDetalle(cantidad, precio,/* subtotal,*/ iva,/* total,*/ cab_id, codigo_barra);
    }
    
    public ResultSet listarDetalle()
    {
        return logica.listarDetalle();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //////////////////////////////BUSCAR-IDS-EMP-CLI/////////////////////////////////
    public ResultSet buscarEMPFAC(String usuario){
        return logica.buscarEMPFAC(usuario);
    }
    
    public ResultSet buscarCLIFAC(String nombref, String apellidof){
        return logica.buscarCLIFAC(nombref, apellidof);
    }
    
    public boolean actualizarCabecera(int id_cab,double sub_total, double total){
        
        return logica.actualizarCabecera(id_cab,sub_total, total);
    }
    
    public boolean actualizarStockFAC(int cantidad, long pro_codigo_barra){
        return logica.actualizarStockFAC( cantidad, pro_codigo_barra);
        
    }
    
    public boolean anularFactura(int cantidad, String nombre){
        return logica.anularFactura( cantidad, nombre);
        
    }

    
}

