# GeoMédicos – Backend

Este repositorio contiene el backend del proyecto **GeoMédicos**, desarrollado como parte del proyecto final del ciclo formativo de desarrollo de aplicaciones web.

## 🛠 Tecnologías utilizadas

- ⚙️ Java 17
- 🚀 Spring Boot 3.4.4
- 🗄️ MySQL / MySQL Workbench
- 🔐 Spring Security (opcional)
- 📦 Maven
- 🌐 API REST

## 📁 Estructura del proyecto

```bash
tfg_DAW/
├── src/
├── pom.xml
├── README.md
└── .gitignore

```
## Configuracion del entorno:
1.Clonar el repositorio
```bash
  git clone https://github.com/stephanie2sv/Geomedicos_backend.git
  cd Geomedicos_backend
```
2. Configurar base de datos
  - Crear una base de datos en MySQL llamada geomedicos_tfg.
  - Importar los datos desde el archivo populate_geomedicos_tfg.sql ubicado en la carpeta statics/basedatos.
    
3. Configurar propiedades en application.properties.
   spring.datasource.url=jdbc:mysql://localhost:3306/geomedicos_tfg
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
4.Ejecutar proyecto:
./mvnw spring-boot:run
