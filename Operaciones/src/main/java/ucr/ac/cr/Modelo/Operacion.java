/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.Modelo;

/**
 *
 * @author Usuario
 */
public class Operacion 
{
    
    private int numero1;
    private int numero2;
    private double resultado;
    private String tipoOperacion;
    
     public static final String[] DATOS={"Numero 1","Numero 2","Resultado","Tipo Operacion"};

    public Operacion(int numero1, int numero2,String tipoOperacion) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.resultado = 0;
        this.tipoOperacion = tipoOperacion;
    }

    public int getNumero1() {
        return numero1;
    }

    public void setNumero1(int numero1) {
        this.numero1 = numero1;
    }

    public int getNumero2() {
        return numero2;
    }

    public void setNumero2(int numero2) {
        this.numero2 = numero2;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    

 
    
    
}
