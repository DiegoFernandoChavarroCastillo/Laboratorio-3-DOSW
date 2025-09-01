# Laboratorio 3 – Desarrollo y Operaciones de Software (DOSW)

## 👥 Integrantes
- **Valeria Bermúdez**  
- **Diego Chavarro**  
- **David Palacios**

Curso: **CVDS – DOSW 2025-2**  
Escuela Colombiana de Ingeniería Julio Garavito  

---

## 🎯 Objetivo del Laboratorio
Aplicar **TDD (Test Driven Development)**, el uso de **JUnit 5** para pruebas unitarias, **JaCoCo** para medir cobertura y **SonarQube** para analizar calidad de código.  
Además, fomentar el trabajo en equipo aplicando metodologías ágiles (**Scrum**) y realizar un análisis básico de requerimientos.

---

## ⚙️ Requisitos previos
- Java **OpenJDK 17.x.x**
- Apache **Maven 3.9.x**
- **JUnit 5.x.x**
- Git y GitHub
- Docker

---

## 📂 Estructura del Proyecto
Laboratorio-3-DOSW/
│
├── docs/
│ ├── uml/ # Diagramas UML exportados en PDF o PNG
│ ├── imagenes/ # Evidencias de compilación, pruebas, etc.
│ └── README.md # Respuestas a preguntas iniciales
│
├── src/main/java/edu/dosw/lab/
│ ├── testing/
│ ├── agilismo/
│ └── util/
│ └── Application.java
│
├── src/test/java/edu/dosw/lab/
│ ├── testing/
│ ├── agilismo/
│ └── util/
│ └── Application.java
│
├── pom.xml
├── .gitignore
└── README.md # 

yaml
Copiar código

---

## 📸 Evidencias – Parte 1
- **Compilación inicial del proyecto con Maven:**  
  ![Compilación Maven](docs/imagenes/compilacion-ok.png)

- **Prueba unitaria mínima con JUnit 5:**  
  ![Test JUnit](docs/imagenes/test-ok.png)

---

## 📸 Evidencias – reto 1
# Identificación de Requerimientos

## Reglas de negocio
- Las cuentas deben tener 10 dígitos exactos.
- Los dos primeros dígitos corresponden al banco (ej: 01 Bancolombia, 02 Davivienda).
- Solo se permiten números, sin letras ni caracteres especiales. 
- No pueden existir dos cuentas con el mismo número. 
- Los depósitos deben ser valores positivos.
- El saldo se actualiza inmediatamente después de un depósito.

---

## Funcionalidades principales
- Crear cuentas válidas.
- Validar que las cuentas cumplan las reglas.
- Consultar el saldo de una cuenta.
- Realizar depósitos.
- Registrar bancos disponibles para validación.

## Actores Principales

### 1. Cliente del banco
- Se refiere a la persona que crea su cuenta en Bankify, puede consultar el saldo y realizar depositos en su cuenta.

### 2. Sistema Bankify
- Todo lo que tiene que ver con el software principal, encargado de:
    - Validar que los números de cuenta cumplan con las reglas de negocio.
    - Gestionar saldos de las cuentas.
    - Procesar depósitos y consultas.

### 3. Banco Registrado
- Es la entidad financiera asociada a la cuenta, se identifica con los dos primeros dígitos del número de cuenta y garantiza que la cuenta pertenezca a un banco válido.

### 4. Administrador del Sistema
- Es la persona encargada de:
    - Configurar los bancos registrados en el sistema.
    - Supervisar el correcto funcionamiento de Bankify.
    - Gestionar reportes de seguridad, calidad y auditoría.

## Documentación Precondición necesarias para el sitema

### 1. Existencia de bancos registrados

- Debe existir una lista inicial de bancos válidos con sus respectivos códigos (por ejemplo: 01 = Bancolombia, 02 = Davivienda).
- Esta lista debe ser gestionada y actualizada por el Administrador del Sistema.

### 2. Acceso a una base de datos operativa

- El sistema debe estar conectado a una base de datos para:
  - Registrar nuevas cuentas.
  - Almacenar saldos actualizados.
  - Guardar información de los bancos registrados.
-La base de datos debe estar disponible y segura.
  
### 3. Reglas de validación implementadas

- Las reglas de negocio deben estar correctamente codificadas y activas en el sistema:
  - Validación del número de cuenta (formato, unicidad, código de banco).
  - Validación de montos de depósito (solo valores positivos).

### Interfaz de usuario o API disponible

- Debe existir una interfaz (web, móvil o API REST) para que:

  - Los clientes creen cuentas, consulten saldo y hagan depósitos.
  - Los administradores configuren bancos válidos.

### Sistema autenticado y autorizado

- Los usuarios (clientes o administradores) deben poder autenticarse con credenciales válidas.
- El sistema debe aplicar controles de acceso según el rol del usuario:
  - Clientes → Solo sus propias cuentas.
  - Administradores → Gestión de bancos y supervisión del sistema.

### Entorno de ejecución funcional

- El sistema debe estar desplegado en un entorno que cuente con:
  - Infraestructura tecnológica adecuada (servidores, red, almacenamiento).
  - Herramientas de CI/CD y monitoreo.
  - Seguridad y respaldo de datos.

### 7. Integración con herramientas de calidad

- Herramientas como SonarQube (análisis estático) y JaCoCo (cobertura de pruebas) deben estar integradas para garantizar la calidad del código.
- Las pruebas automatizadas deben estar implementadas con TDD.

## 📜 Historial de Commits – Parte 1
*(Cada commit debe tener el formato: `Parte 1 – Nombre Integrante: Acción realizada`)*  