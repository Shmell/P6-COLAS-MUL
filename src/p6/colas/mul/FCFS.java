package p6.colas.mul;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FCFS extends Thread
{
 public synchronized void run() 
    {
      while(true)
      {
          for(int i=0;i<Ventana.ListaProcesosFCFS.size();i++)
          {
              if(Ventana.ListaProcesosFCFS.get(i).status==1)
              {
                  Ventana.ListaProcesosFCFS.get(i).start();
                  
                  try {
                      Ventana.ListaProcesosFCFS.get(i).join();
                  } catch (InterruptedException ex) {
                      Logger.getLogger(FCFS.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                    
                    
                              
                         
                   
                    
                 
              }
              

          }
          
          
          
          
      }
              
         
    }
     
    static public void suspender()
    {
        
        for(int i=0;i<Ventana.ListaProcesosFCFS.size();i++)
            {
                Ventana.ListaProcesosFCFS.get(i).suspend();
            }
    }
    
    static public void reanudar()
    {
        
        for(int i=0;i<Ventana.ListaProcesosFCFS.size();i++)
            {
                Ventana.ListaProcesosFCFS.get(i).resume();
            }
    }
           


    
}
