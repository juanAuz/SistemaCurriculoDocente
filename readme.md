# Sistema de Gestión de Currículo Docente - EPN

Proyecto final de Programación Orientada a Objetos

## 🧪 Test Inicial - Commit 1

Este commit contiene la estructura base del proyecto y una app de prueba.

## Estructura del Proyecto
```
src/main/java/
├── modelo/           # Clases de dominio
│   ├── formacion/   # Persona 1
│   ├── experiencia/ # Persona 2
│   ├── capacitacion/# Persona 3
│   └── produccion/  # Persona 4
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

3. ✅ Deberías ver ventana "JavaFX Funciona Correctamente"

para las divisones de trabajo y el manejo de estilos revisar docs.md (resources/docs)
### Estado Actual
Unicamente estan creadas las carpetas mas generales y la app.java
Añadido el formularioBase.fxml para que puedan hacer una copia para sus formularios
### Próximos pasos
programen xd
Cualquier problema con el github o de cualquier tipo, por favor decirlo al whatsapp