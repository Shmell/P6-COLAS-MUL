package p6.colas.mul;

import static java.lang.Thread.sleep;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SRT extends Thread
{


 public synchronized void run()
 {
     
     
        
         int aux_status;
         
         while(true)
         {
           // if(Ventana.entrar==true)
            //{
                //Ventana.entrar=false;
                Collections.sort(Ventana.indiceSRT);

                for(int i=0;i<Ventana.indiceSRT.size();i++)
                {
                    aux_status=Ventana.ListaProcesosSRT.get(Ventana.indiceSRT.get(i).numProceso-1).status;
                    
                    if(aux_status==1)
                    {
                        
                        
                           Ventana.ListaProcesosSRT.get(Ventana.indiceSRT.get(i).numProceso-1).start();
                        try {
                            Ventana.ListaProcesosSRT.get(Ventana.indiceSRT.get(i).numProceso-1).join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SRT.class.getName()).log(Level.SEVERE, null, ex);
                        }
                           
                        i=Ventana.indiceSRT.size();  
                        
                       
                    }
                    
                    
              //  }
                
                //Ventana.entrar=true;
                //mayor=false;
                
                
            }
              /*try
                {
                sleep(5000);
                }
                catch (InterruptedException e)
                {
                System.out.println("pr9oblemilla");
                }  
               */ 
                
         }
          
 }
 static public void suspender()
    {
        
        for(int i=0;i<Ventana.ListaProcesosSRT.size();i++)
            {
                Ventana.ListaProcesosSRT.get(i).suspend();
            }
    }
    
    static public void reanudar()
    {
        
        for(int i=0;i<Ventana.ListaProcesosSRT.size();i++)
            {
                Ventana.ListaProcesosSRT.get(i).resume();
            }
    }
 
 
   
  
}


    

