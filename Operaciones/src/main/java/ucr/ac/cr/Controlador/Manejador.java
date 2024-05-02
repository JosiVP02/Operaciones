/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucr.ac.cr.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ucr.ac.cr.Modelo.Operacion;
import ucr.ac.cr.Modelo.RegistroOperacion;
import ucr.ac.cr.Vista.FRM_Reporte;
import ucr.ac.cr.Vista.Pantalla;

/**
 *
 * @author rrgrh
 */
public class Manejador implements ActionListener
{
    private Operacion operacionl;
    private Pantalla pantalla;
    private RegistroOperacion registro;
    private FRM_Reporte reporte;
    
    
    
    public Manejador()
    {
        this.pantalla=new Pantalla();
        this.registro=new RegistroOperacion();
        this.reporte=new FRM_Reporte();
        
        this.pantalla.escuchador(this);
        this.pantalla.setVisible(true);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        
        switch(e.getActionCommand().toString())
        {
        
        case"Realizar Operacion":
            
            registro.appendJSonToFile(registro.Operar(pantalla.getOperacion()));
            pantalla.setResultado(registro.Operar(pantalla.getOperacion()).getResultado());
            
            
            break;
            
            
            
        case "Ver Registro":
            
            reporte.setDataTable(registro.getMatrizOperaciones(registro.loadOperacion()), Operacion.DATOS);
            reporte.setVisible(true);
            
            break;
        
        }
    }
    
}
