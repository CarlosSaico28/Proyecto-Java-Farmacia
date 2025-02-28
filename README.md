<h1 align="center">📌 Proyecto Java - Farmacia</h1>

## 👨‍💻 Autor
[Carlos Saico](https://github.com/CarlosSaico28)

## 🏥 Descripción
Este es un sistema de gestión para farmacias desarrollado en **Java** con el patrón **MVC (Modelo-Vista-Controlador)**. Permite la administración de usuarios, productos e inventario, además de la generación de facturas en PDF.

## 📂 Estructura del Proyecto
```
📦 Proyecto-Java-Farmacia
├── 📂 src/                  (Código fuente del proyecto)
│   ├── 📂 controlador/      (Gestión de eventos y lógica de negocio)
│   │   ├── 📄 controladorLogueo.java
│   │
│   ├── 📂 modelo/           (Capa de datos y lógica de negocio)
│   │   ├── 📂 dao/          (Acceso a datos - Base de datos)
│   │   │   ├── 📄 logueoDao.java
│   │   ├── 📂 logica/       (Reglas del negocio)
│   │   │   ├── 📄 Logica.java
│   │
│   ├── 📂 vista/            (Interfaz gráfica - Swing/JavaFX)
│   │   ├── 📄 Principal.java
│   │   ├── 📄 VistaMenu.java
│   │   ├── 📄 Funciones.java
│   │   ├── 📄 Inicio.java
│   │   ├── 📄 Archivos .form (NetBeans GUI)
│   │
│   ├── 📂 pdf/              (Facturas generadas en PDF)
│   │   ├── 📄 venta.pdf
│   │
│   ├── 📂 Imagenes/         (Recursos gráficos - logos, botones, etc.)
│       ├── 🖼️ Logo.png
│       ├── 📂 Botones/      (Íconos y botones de la UI)
│           ├── 🖼️ boton.png
```
## 🔧 Tecnologías Usadas
- **Java** (JDK 8 o superior)
- **Swing** / **JavaFX** (para la interfaz gráfica)
- **Oracle SQL** (para almacenamiento de datos)
- **iText** (para generación de PDFs)
## 🚀 Instalación y Ejecución
1. Clona el repositorio:
   ```sh
   git clone https://github.com/CarlosSaico28/Proyecto-Java-Farmacia.git
   ```
2. Importa el proyecto en **NetBeans** o **IntelliJ IDEA**.
3. Configura la base de datos en `modelo.dao.logueoDao.java`.
4. Ejecuta el proyecto desde `Principal.java`.

## 📜 Funcionalidades
✅ Gestión de usuarios y logueo.  
✅ Administración de inventario y productos.  
✅ Generación de facturas en PDF.  
✅ Interfaz gráfica con imágenes y botones.  
✅ Integración con base de datos.

## 📸 Capturas de Pantalla
<p align="center">
  <img src="https://github.com/CarlosSaico28/imagesBraTS/blob/152bce1ce70e056db132f9e95f8e7ebaff8f91e2/Proyecto-Java-Farmacia/LogueoFarmacia.png" width="200">
</p>
<p align="center"><b>Pantalla de Logueo</b></p>
<br>
<p align="center">
  <img src="https://github.com/CarlosSaico28/imagesBraTS/blob/a8a53f978aaed9984876f735975d14e30874a222/Proyecto-Java-Farmacia/Factura.png" width="700">
</p>
<p align="center"><b>Pantalla Principal de Facturación</b></p>










