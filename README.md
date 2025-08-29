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


---

## 📜 Historial de Commits – Parte 1
*(Cada commit debe tener el formato: `Parte 1 – Nombre Integrante: Acción realizada`)*  