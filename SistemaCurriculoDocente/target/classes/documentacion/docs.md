### ¿Por qué FXML y Scene Builder?

Utilizamos FXML con Scene Builder porque facilita el desarrollo visual sin necesidad de dominar JavaFX a profundidad. Es tan intuitivo como arrastrar y soltar elementos en PowerPoint, lo que acelera el desarrollo y reduce la curva de aprendizaje.

### Consistencia Visual

Para garantizar que el proyecto no parezca obra de 4 personas diferentes:

- **Archivo CSS compartido** (`estilos.css`): Define colores, tamaños de fuente y estilos de botones
- **Plantilla FXML base** (`PlantillaFormulario.fxml`): Estructura base que todos copian para sus módulos

### Patrón Singleton - SistemaDocente

Implementamos un Singleton para evitar conflictos con variables duplicadas. Todos trabajan sobre el mismo objeto `Docente`:
```java
// Todos acceden al mismo lugar
SistemaDocente.getInstancia().getDocente()
```

## 👥 División de Roles y Responsabilidades

### Persona 1 (Coordinador)

**Módulos**: Datos Personales + Títulos

**Responsabilidades adicionales**:
- Crear estructura inicial del proyecto (carpetas, archivos base)
- Desarrollar `estilos.css` y `PlantillaFormulario.fxml`
- Subir repositorio base
- Crear y mantener diagrama UML conforme se diseñan las clases

### Persona 2

**Módulos**: Experiencia Laboral completa (docente y no docente)

**Responsabilidades adicionales**:
- Escribir Manual Técnico explicando:
  - Arquitectura del sistema
  - Clases principales
  - Funcionamiento de la persistencia

### Persona 3

**Módulos**: Capacitación completa (recibida e impartida)

**Responsabilidades adicionales**:
- Escribir Manual de Usuario con:
  - Screenshots de cada funcionalidad
  - Guía paso a paso de uso del sistema

### Persona 4

**Módulos**: Investigaciones + Publicaciones

**Responsabilidades adicionales**:
- Integración final: crear ventana principal con `TabPane` unificando todos los módulos
- Preparar presentación en Canva para sustentación

## 📝 Tareas de Cada Integrante

Cada persona debe completar 3 tareas técnicas + 1 de documentación:

1. **Crear clases de modelo** con herencia y polimorfismo según corresponda
   - Ejemplo: Persona 2 crea clase abstracta `Experiencia` con hijos `ExperienciaDocente` y `ExperienciaNoDocente`

2. **Diseñar interfaz gráfica** en Scene Builder
   - Formularios de entrada
   - Tablas para visualización de datos

3. **Implementar persistencia**
   - Guardar datos en archivos .dat
   - Cargar datos al iniciar

4. **Documentación asignada** (ver roles arriba)

### Balanceo de Carga

- **Persona 4**: Aunque hace la integración final, sus clases son las más simples (solo `Investigacion` y `Publicacion`, sin herencia compleja)
- **Persona 1**: Menos código complejo porque coordina todo el proyecto


## 🔧 Arquitectura Técnica

### Singleton SistemaDocente

Garantiza un único objeto `Docente` en toda la aplicación:
```java
// Persona 1 guarda nombre
SistemaDocente.getInstancia().getDocente().setNombre("Juan");

// Persona 2 agrega experiencia
SistemaDocente.getInstancia().getDocente().agregarExperiencia(exp);

// Todos trabajan sobre el mismo objeto
```


## 🛠️ Herramientas Necesarias

- **Control de versiones**: Git/GitHub
- **Diseño de interfaces**: Scene Builder
- **Diagramas UML**: Lucidchart o draw.io
- **Java**: Versión 17 o superior
- **IDE**: IntelliJ IDEA, Eclipse, NetBeans o VS Code (a elección)

## 📚 Documentación Continua

**NO dejar para el final**:

- **Persona 1**: Actualiza UML mientras diseña clases
- **Persona 2**: Escribe Manual Técnico en Google Doc compartido durante desarrollo
- **Persona 3**: Captura screenshots y documenta en Google Doc mientras programa
- **Persona 4**: Prepara slides de presentación progresivamente

## 📊 Resumen de Asignaciones

| Persona | Módulos | Documentación |
|---------|---------|---------------|
| **1** | Datos Personales + Títulos | Diagrama UML |
| **2** | Experiencia Laboral | Manual Técnico |
| **3** | Capacitación | Manual de Usuario |
| **4** | Investigación + Publicaciones | Integración + Presentación |


## 🚀 Flujo de Trabajo

1. Persona 1 crea estructura inicial y sube al repositorio
2. Todos clonan el repositorio
3. Cada persona desarrolla su módulo independientemente
4. Documentación en paralelo (no al final)
5. Persona 4 integra todos los módulos
6. Revisión grupal y ajustes finales
7. Preparación de sustentación
