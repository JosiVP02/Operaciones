/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.Modelo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author rrgrh
 */
public class RegistroOperacion 
{
    private String filePath = "Operaciones.json";
    Operacion operacion;
    
    public void appendJSonToFile(Operacion operacion) 
    {
         
        JSONObject newObject = new JSONObject();
        newObject.put("Numero 1", operacion.getNumero1());
        newObject.put("Numero 2", operacion.getNumero2());
        newObject.put("Resultado", operacion.getResultado());
        newObject.put("Tipo Operacion", operacion.getTipoOperacion());
        
        //El Json array contendra todos los objetos JSON
        JSONArray jsonArray = new JSONArray();
        //Se intenta leer el archivo existente
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(filePath)){
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;
        }catch(IOException | ParseException e){
            System.out.println("No existing file or new file will be created");
        }
        //Agrega el nuevo objeto JSON al array
        jsonArray.add(newObject);
        //Escribir el JSONARRAY actualizado de nuevo
        try(FileWriter file = new FileWriter(filePath)){
            file.write(JSONArray.toJSONString(jsonArray));
            file.flush();
        }catch(IOException io){
            io.printStackTrace();
        }
    }
    
    public Operacion Operar(Operacion operacion)
    {
      
        if(operacion.getTipoOperacion().equals("Suma"))
        {
          operacion.setResultado(operacion.getNumero1()+operacion.getNumero2());
        }else
        if(operacion.getTipoOperacion().equals("Resta"))
        {
          operacion.setResultado(operacion.getNumero1()-operacion.getNumero2());
        }else
        if(operacion.getTipoOperacion().equals("Multiplicacion"))
        {
          operacion.setResultado(operacion.getNumero1()*operacion.getNumero2());
        }else
        {
          operacion.setResultado(operacion.getNumero1()/operacion.getNumero2());
        }
    
        return operacion;
    }
    
    
    public ArrayList<Operacion> loadOperacion()
    {
      ArrayList<Operacion> operaciones=new ArrayList<>();
      JSONParser parser=new JSONParser();
      
      try(FileReader reader=new FileReader(filePath))
      {
        Object obj=parser.parse(reader);
        JSONArray jsonArray=(JSONArray) obj;
        
        for(Object object:jsonArray)
        {
         JSONObject jsonObject=(JSONObject)object;
         
         int numero1=((Long) jsonObject.get("Numero 1")).intValue();
         int numero2=((Long) jsonObject.get("Numero 2")).intValue();
         double resultado=(double) jsonObject.get("Resultado");
         String tipoOperacion=(String) jsonObject.get("Tipo Operacion");
         
         
         Operacion operacion=new Operacion(numero1,numero2,tipoOperacion);
         operacion.setResultado(resultado);
         
         operaciones.add(operacion);
         
        }
        
        
      }catch(IOException | ParseException e)
      {       
        e.printStackTrace();
              
      }
      
      return operaciones;
    }
    
    
    public String [][] getMatrizOperaciones(ArrayList<Operacion> lista)
    {
        
      String [][] matrizOperaciones=new String[lista.size()][Operacion.DATOS.length];
      
      for(int f=0; f<matrizOperaciones.length; f++)
      {
         matrizOperaciones[f][0]=lista.get(f).getNumero1()+"";
         matrizOperaciones[f][1]=lista.get(f).getNumero2()+"";
         matrizOperaciones[f][2]=lista.get(f).getResultado()+"";
         matrizOperaciones[f][3]=lista.get(f).getTipoOperacion();
      }
      
      return matrizOperaciones;
    }
    
}
