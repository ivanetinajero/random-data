# Random Data CSV Generator

Generador de archivos CSV con datos de personas aleatorias, ideal para pruebas, demos, aprendizaje y desarrollo de software.

## Descripción

Esta aplicación web permite generar archivos CSV realistas con datos ficticios de personas, incluyendo nombre, email, profesión, país, salario, peso, estado civil, fecha de nacimiento y más. Es útil para desarrolladores, testers, docentes y cualquier persona que requiera datos de prueba de manera rápida y sencilla.

## Características principales

- **Generación instantánea de archivos CSV** con la cantidad de registros que elijas (hasta 1 millón).
- **Datos realistas**: nombres, apellidos, emails, profesiones, países, salarios, pesos, estado civil, fecha de nacimiento, etc.
- **Interfaz web moderna y responsiva** basada en Bootstrap 5.3 y Bootstrap Icons.
- **Descarga directa** del archivo generado.
- **Visualización de metadatos**: tamaño del archivo, nombre, fecha de generación, etc.
- **Backend robusto** con Spring Boot, lectura de datos desde archivos fuente (`data/*.txt`).
- **Configuración flexible** del directorio de salida para los archivos CSV.

## Estructura del proyecto

```
random-data/
├── data/                  # Archivos fuente: nombres, apellidos, profesiones, países, dominios
├── src/
│   ├── main/
│   │   ├── java/dev/itinajero/app/   # Código fuente Java (servicio, controladores, config)
│   │   └── resources/
│   │       ├── templates/            # Vistas HTML (Thymeleaf)
│   │       ├── static/               # Recursos estáticos (JS, imágenes)
│   │       └── application.properties
│   └── test/                        # Pruebas unitarias
├── pom.xml                # Dependencias Maven
└── README.md              # Este archivo
```

## Instalación y ejecución

1. **Clona el repositorio:**
   ```bash
   git clone https://github.com/ivanetinajero/random-data.git
   cd random-data
   ```
2. **Configura el directorio de salida (opcional):**
   Edita `src/main/resources/application.properties`:
   ```properties
   csv.output.dir=csv
   ```
   Por defecto, los archivos CSV se guardan en la carpeta `csv/` dentro del proyecto.
3. **Ejecuta la aplicación:**
   ```bash
   ./mvnw spring-boot:run
   ```
   O bien, desde tu IDE favorito.
4. **Abre tu navegador:**
   Visita [http://localhost:8080](http://localhost:8080)

## Uso

- Desde la landing page, haz clic en "Generar mi CSV".
- Elige la cantidad de registros y haz clic en "Generar CSV".
- Descarga el archivo generado y revisa los metadatos.

## Personalización

- Puedes modificar los archivos en `data/` para agregar o cambiar nombres, profesiones, países, etc.
- El diseño de la webapp puede personalizarse editando los archivos en `src/main/resources/templates/` y `static/`.

## Tecnologías utilizadas

- **Java 17+**
- **Spring Boot 3**
- **Maven**
- **Bootstrap 5.3**
- **Bootstrap Icons**
- **jQuery**

## Créditos

Desarrollado por [Ivan E. Tinajero](https://github.com/ivanetinajero) y colaboradores.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.
