<<<<<<< HEAD

# **Laboratorio N°3**
## **CVDS-1**
### **Ciclos de Vida del Desarrollo de Software**

![](https://github.com/DonSantiagoS/LAB2CVDS/blob/master/Imagenes/Logo.png)


## _Maven_

La herramienta Apache Maven se usa para gestionar y manejar proyectos de software. La base de maven para un proyecto es el concepto de un modelo de objeto de proyecto (POM), Maven puede gestionar la compilación, los informes y la documentación de un proyecto a partir de este modelo, que se concreta en el archivo pom.xml.
Tomado de [Apache Maven][1]

1. **Validar:** Revisar si toda la información necesaria para el constructor esta disponible.
2. **Compilar:** Compilar el código base.

Se edita las dependencias del archivo **_pom.xml_**
```
<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
      <scope>test</scope>
    </dependency>
	<!-- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api -->
	<dependency>
		<groupId>org.junit.jupiter</groupId>
		<artifactId>junit-jupiter-api</artifactId>
		<version>5.7.0-RC1</version>
		<scope>test</scope>
	</dependency>

  </dependencies>
```

posteriormente es de gran importancia que se editen las propiedades de manera que se especifique la version de Java **1.8**

```
  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
  </properties>
```

+ mvn clean Borra todos los .class y .jar generados.
+ mvn compile Compila el proyecto.


##### Autores:
 * Santiago Buitrago
 * Andres Cubillos

[1]:https://maven.apache.org/

=======
# LAB3CVDS
Laboratorio Numero 3 Ciclos de Vida del Desarrollo de Software

# Integrantes 
Santiago Buitrago
Andres Cubillos
>>>>>>> 529e4078a5585da26365f410e93fc8d3a613b893
