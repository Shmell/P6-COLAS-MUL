package p6.colas.mul;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RR extends Thread
{


    
    
    
    public synchronized void run() 
    {
      while(true)
      {
          for(int i=0;i<Ventana.ListaProcesosRR.size();i++)
          {
              if(Ventana.ListaProcesosRR.get(i).status==1)
              {
                  Ventana.ListaProcesosRR.get(i).start();
                  
                    
                    
                                try {
                             sleep(Ventana.rr*1000);
                         } catch (InterruptedException ex) {
                             System.out.println("dormido");;
                         }

                    if(Ventana.ListaProcesosRR.get(i).status!=4)
                        {

                        }
                         Ventana.ListaProcesosRR.get(i).interrupt();
                         Ventana.ListaProcesosRR.get(i).status=3;
                        
                         
                   
                    
                 
              }
              

          }
          
          
          
          
      }
              
         
    }
    
}

