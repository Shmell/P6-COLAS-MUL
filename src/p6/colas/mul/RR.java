package p6.colas.mul;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RR extends Thread
{
 static int contador =0;
 int RR;
 
  public RR(int RR)
  {
   this.RR=RR;   
      
  }
    
    
    public synchronized void run() 
    {
        
        for(contador=0;contador<1000;contador++)
                {
                 Ventana.ListaProcesosRR.get(contador).start();
                  
                   
                    
                   
            try {
                
                sleep(2*1000);
                 
                //if(Ventana.ListaProcesosRR.get(contador).)
            } catch (InterruptedException ex) {
                System.out.println("se suspendio cuando estaba esperando");    
            }
            
            
            System.out.println("salio de RR INTERNO"); 
            Ventana.ListaProcesosRR.get(contador).stop();
            
            
             /*try {
                        Ventana.ListaProcesosRR.get(contador).join();
                    } catch (InterruptedException ex) {
                        System.out.println("ssssssse suspendio cuando estaba esperando");
                    }
             
             */
            
            
                
                

                    
                    
                    
                    
                  
                }
                    
                    /*System.out.println("numero"+i);
                  
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(RR.class.getName()).log(Level.SEVERE, null, ex);
                    }*/
            
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      /*while(true)
      {
          (i<Ventana.ListaProcesosRR.size())
          {
              if( Ventana.ListaProcesosRR.get(i).status==1)
                {
              Ventana.ListaProcesosRR.get(i).start();
         
          
                try {
                    sleep(Ventana.rr*1000);
                } catch (InterruptedException ex) {
                    System.out.println("tiempo de RR");;
                }

                if( Ventana.ListaProcesosRR.get(i).status==4)
                {
                    if(!(++i==Ventana.ListaProcesosRR.size()))
                                i--;
                }         
                else
                {
                  Ventana.ListaProcesosRR.get(i).suspend();  
                  Ventana.ListaProcesosRR.get(i).status=3;
                }
                   
                }
                else if( Ventana.ListaProcesosRR.get(i).status==3)
                        {
                            Ventana.ListaProcesosRR.get(i).resume();

                                    try {
                                   sleep(Ventana.rr*1000);
                               } catch (InterruptedException ex) {
                                   System.out.println("tiempo de RR");;
                               }

                               if( Ventana.ListaProcesosRR.get(i).status==4)
                                   if(!(++i==Ventana.ListaProcesosRR.size()))
                                       i--;
                               else
                               {
                                 Ventana.ListaProcesosRR.get(i).suspend();  
                                 Ventana.ListaProcesosRR.get(i).status=3;
                               }
                        }
                      else
                        i++;
          }*/
          
                /*else if( Ventana.ListaProcesosRR.get(i).status==4)
                        {
                              
                            if(!(++i==Ventana.ListaProcesosRR.size()))
                                i--;
                        
                        
          
              
         

      }}*/
          
          
      
       /*for(int i=0;i<Ventana.ListaProcesosRR.size();i++)
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
  
              */   
          
      
              
         
    }
    
    
static public void suspender()
    {
        
       
                
                Ventana.ListaProcesosRR.get(contador).suspend();
               
            
    }
    
    static public void reanudar()
    {
        
        
                
                Ventana.ListaProcesosRR.get(contador).resume();
            
    }    
    
    
    
    
}

