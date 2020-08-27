package edu.eci.cvds.tdd.registry;

import org.junit.Assert;
import org.junit.Test;

public class RegistryTest {

    private Registry registry = new Registry();

    @Test
    public void validateRegistryResult() {

        Person person = new Person();

        RegisterResult result = registry.registerVoter(person);

        Assert.assertEquals(RegisterResult.VALID, result);
    }
	//CLASE 1
	@Test
    public void validateRegistryResultInvalidAge() {
        Person person = new Person("Santiago", 1111111, -12, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
	
	@Test
    public void validateRegistryResultInvalidAge2() {
        Person person = new Person("Santiago", 1111111, 155, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
	
	@Test
    public void validateRegistryResultInvalidAgeInf() {
        Person person = new Person("Santiago", 1111111, -1, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
	
	@Test
    public void validateRegistryResultInvalidAgeSuperior() {
        Person person = new Person("Santiago", 1111111, 151, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.INVALID_AGE, result);
    }
	
	//CLASE 2
	@Test
    public void validateRegistryResultUnderage() {
        Person person = new Person("Santiago", 1111111, 12, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
	@Test
    public void validateRegistryResultUnderageInferior() {
        Person person = new Person("Santiago", 1111111, 1, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
	@Test
    public void validateRegistryResultUnderageSuperior() {
        Person person = new Person("Santiago", 1111111, 17, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.UNDERAGE, result);
    }
	
	//CLASE 3
	@Test
    public void validateRegistryResultDeadJoven() {
        Person person = new Person("Santiago", 1111111, 22, Gender.MALE , false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
	@Test
    public void validateRegistryResultDeadAdulto() {
        Person person = new Person("Santiago", 123584, 42, Gender.MALE , false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
	@Test
    public void validateRegistryResultDeadAnciano() {
        Person person = new Person("Santiago", 89524, 72, Gender.MALE , false);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DEAD, result);
    }
	
	//CLASE 4
	@Test
    public void validateRegistryResultDuplicatedJoven() {
        Person person = new Person("Santiago", 123456, 20, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
	@Test
    public void validateRegistryResultDuplicatedAnciano() {
        Person person = new Person("Santiago", 123456, 120, Gender.FEMALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.DUPLICATED, result);
    }
	
	//CLASE 5
	@Test
    public void validateRegistryResultValid1() {
        Person person = new Person("Santiago", 1111111, 20, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
	
	@Test
    public void validateRegistryResultValid2() {
        Person person = new Person("Luisa", 2519815, 20, Gender.FEMALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
	
	@Test
    public void validateRegistryResultValid3() {
        Person person = new Person("Santiago", 1111111, 120, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
	
	@Test
    public void validateRegistryResultValid4() {
        Person person = new Person("Brayan", 51685, 80, Gender.MALE , true);
        RegisterResult result = registry.registerVoter(person);
        Assert.assertEquals(RegisterResult.VALID, result);
    }
	
    // TODO Complete with more test cases
}