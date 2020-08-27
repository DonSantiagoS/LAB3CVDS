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