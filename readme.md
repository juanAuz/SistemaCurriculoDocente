# Sistema de Gestión de Currículo Docente - EPN

Proyecto final de Programación Orientada a Objetos

## Estructura del Proyecto
```
src/main/java/
├── modelo/           # Clases de dominio
│   ├── formacion/   
│   ├── experiencia/ 
│   ├── capacitacion/
│   └── produccion/  
├── controlador/     # Controladores FXML
├── persistencia/    # Guardar/cargar datos
└── util/            # SistemaDocente (Singleton) visitar el docs.md dentro de documentacion para mas detalles

src/main/resources/
├── fxml/            # Archivos FXML (Scene Builder)
└── estilos.css      # Estilos compartidos docs.md
```

## Requisitos
- Java 17+
- Maven
- Scene Builder (https://gluonhq.com/products/scene-builder/)

## Cómo empezar

1. Clonar:
```bash
git clone https://github.com/juanAuz/SistemaCurriculoDocente.git
cd SistemaCurriculoDocente
```

2. Ejecutar en la carpeta raiz:
```bash
mvn clean javafx:run 
```