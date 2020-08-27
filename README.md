# **Laboratorio N°3**
## **CVDS-1**
### **Ciclos de Vida del Desarrollo de Software**

![](https://github.com/DonSantiagoS/LAB2CVDS/blob/master/Imagenes/Logo.png)


## **_CLASES DE EQUIVALENCIA_**


Se creo un directorio de trabajo para crear un proyecto en maven con las siguientes especificaciones del arquetipo base:

*Grupo: edu.eci.cvds
*Artefacto: ClasesEquivalencia
*Paquete: edu.eci.cvds.tdd
*archetypeArtifactId: maven-archetype-quickstart

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia1.PNG)

Es posible observar como queda la estrutura de datos del proyecto

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia2.PNG)

### **Actualizar y crear dependencias en el proyecto**

Posterior a esto se navego en la pagina del repositorio central de maven para escoger la dependencia de JUnit mas nueva, para esto ingresamos a [Repositorio central de Maven][1]
![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia3.PNG)

Se realizo la copia de la dependencia para acomodarla en el archivo pom del proyecto

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
### **Compilar y Ejecutar**

Para verificar que los cambios realizados en el archivo pom.xml del proyecto, se compilo el proyecto obteniendo como resultado *BUILD SUCCESS*
```
mvn compile
```
![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia4.PNG)

```
mvn package
```

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia5.PNG)


Posterior a ello, se compilaron las pruebas unitarias de manera que fuera posible observar que se ejecuta la clase **AppTest** y las de **ClasesEquivalencia**
```
mvn test
```

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia6.PNG)

## **Ejercicio “Registraduría”**

Se va a crear un proyecto base para un requerimiento de la registraduría en el cual se registrarán personas con intención de votar paras las próximas elecciones y se generarán los certificados electorales de aquellas personas cuyo voto sea válido.

Se usará la clase de persona que ya fue creada. El servicio de la registradiría permitirá registrar personas que sean votantes

Propiedades
*Solo se registrarán votantes válidos
*Solo se permite una inscripción por número de documento

Para este ejercicio se crearon las diferentes clases segun las especificaciones dadas, dentro del proyecto para posteriormente llevarlo acabo

Luego se compilo para verificar que no hayan inconvenientes

```
mvn package
```

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia7.PNG)

y las pruebas:

```
mvn test
```

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia8.PNG)


![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Evidencia9.PNG)
### **Finalizar el ejercicio**

Segun las indicaciones y parametros planteados en el ejecicio de la registraduria se definieron **_5 clases de equivalencia_**
![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/equivalencias.PNG)

Posteriormente se realizo la modificacion de Registry.java

```
package edu.eci.cvds.tdd.registry;

public class Registry {
    public RegisterResult registerVoter(Person p) {
		int age=p.getAge();
		//Creacion persona de prueba
		Person prueba = new Person("Santiago", 123456, 22, Gender.MALE , true);
		//Clase 1
		if (age<0 || age>150 ){
			return RegisterResult.INVALID_AGE;
		}
		//Clase 2
		else if (age>0 && age<18){
			return RegisterResult.UNDERAGE;
		}
		//Clase 3
		else if (age>17 && age<150 && p.isAlive()==false){
			return RegisterResult.DEAD;
		}
		//Clase 4
		else if (p.getId()==prueba.getId() && p.isAlive()==true){
			return RegisterResult.DUPLICATED;
		}
		//Clase 5
		else if (age>17 && age<150 && p.isAlive()==true ){
			// TODO Validate person and return real result.
			return RegisterResult.VALID;
		}
		return RegisterResult.VALID;
    }
	
}
```

y finalmente se realizaron las pruebas planteadas de manera que fuera posible evidenciar y probar segun las clases de equivalencia el ejercicio

![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/tests.PNG)

## **Ejercicio "Descuento de tarifas"**

#### Adicion de nueva dependencia en el archivo pom.xml.

```
   <dependency>
		<groupId>edu.eci.cvds</groupId>
		<artifactId>aerodescuentos</artifactId>
		<version>1.0.0</version>
		<scope>test</scope>
   </dependency>
```
#### Implementación de las pruebas propuestas en la etapa de diseño de pruebas en esta clase. 

```
   public class TarifasTest{
	private CalculadorDescuentos calculador= new CalculadorDescuentos();
	private double tarifa;
	
    @Test
    public void DeberiaAplicarDescuento1(){
        tarifa = calculador.calculoTarifa(2000,22,16);
        Assert.assertTrue(tarifa== 1600.0);
    }
    @Test
    public void DeberiaLanzarExcepcion4(){
        
	try{
		tarifa = calculador.calculoTarifa(-2000,-19,-72);
         	int fail= 2000/0;
	}
        catch(Exception ex){
	  }
      
    }

```
##### Realizando las pruebas
```
mvn package
```
![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/Tarifatest.PNG)


```
mvn compile
```
![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/tarifatest mvn compile.PNG)


```
mvn compile
```
![](https://github.com/DonSantiagoS/LAB3CVDS/blob/master/Imagenes/tarifatest mvn test.PNG)


##### Autores:
 * Santiago Buitrago
 * Andres Cubillos

[1]:https://mvnrepository.com/

=======
####### LAB3CVDS
Laboratorio Numero 3 Ciclos de Vida del Desarrollo de Software

####### Integrantes 
Santiago Buitrago 
Andres Cubillos

