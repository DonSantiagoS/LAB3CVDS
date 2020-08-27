package edu.eci.cvds.tdd.aerodescuentos;
import edu.eci.cvds.tdd.aerodescuentos.CalculadorDescuentos;
import org.junit.Assert;
import org.junit.Test;
public class TarifasTest{
	private CalculadorDescuentos calculador= new CalculadorDescuentos();
	private double tarifa;
	
	@Test
    public void DeberiaAplicarDescuento1(){
        tarifa = calculador.calculoTarifa(2000,22,16);
        Assert.assertTrue(tarifa== 1600.0);
    }
	@Test
    public void DeberiaAplicarDescuento2(){
        tarifa = calculador.calculoTarifa(2000,24,25);
        Assert.assertTrue(tarifa== 1700.0);
    } 
	@Test
    public void DeberiaAplicarDescuento3(){
        tarifa = calculador.calculoTarifa(2000,29,69);
        Assert.assertTrue(tarifa== 1540.0);
    } 
	@Test
    public void DeberiaAplicarDescuento14(){
        tarifa = calculador.calculoTarifa(2000,17,16);
        Assert.assertTrue(tarifa== 1900.0);
    } 
	@Test
    public void DeberiaAplicarDescuento5(){
        tarifa = calculador.calculoTarifa(2000,5,30);
        Assert.assertTrue(tarifa== 2000.0);
    } 
	@Test
    public void DeberiaAplicarDescuento6(){
        tarifa = calculador.calculoTarifa(2000,10,66);
        Assert.assertTrue(tarifa== 1840.0);
    } 
	@Test
    public void DeberiaLanzarExcepcion(){
        
		try{
		 tarifa = calculador.calculoTarifa(-2000,5,30);
         int fail= 2000/0;
		 }
      catch(Exception ex){
		  
	  }
      
    }
    @Test
    public void DeberiaLanzarExcepcion2(){
        
		try{
		 tarifa = calculador.calculoTarifa(2000,-25,15);
         int fail= 2000/0;
		 }
      catch(Exception ex){
       }
      
    }
	@Test
    public void DeberiaLanzarExcepcion3(){
        
		try{
		 tarifa = calculador.calculoTarifa(2000,-19,-72);
         int fail= 2000/0;
		 }
      catch(Exception ex){
	  }
      
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
	
}
