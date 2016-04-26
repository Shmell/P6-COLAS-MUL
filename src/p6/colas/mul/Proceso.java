package p6.colas.mul;

import java.util.logging.Level;
import java.util.logging.Logger;

/*
 STATUS

1 IISTO
2 EJECUTANDO
3 BLOQUEADO
4 ELIMINADO/TERMINADO

*/

/*
 ORIGEN

1 SISTEMA
2 USUARIO
3 OTROS
*/


public class Proceso extends Thread implements Comparable<Proceso>
{
//Thread hilo;
 
 private int numero;
 int duracion;
 int prioridad;
 int status;
 int origen;
 
 int inicio=1;
	
 public Proceso(int numero,int tiempo,int prioridad,int origen)
 {
  this.numero=numero;
  duracion=tiempo;
  this.prioridad=prioridad;
  //Thread hilo=new Thread(this);

   status=1;
  
   this.origen=origen;
 }
 
 
  public Proceso(int numero,int tiempo,int prioridad,int origen,Proceso anterior)
 {
  this.numero=numero;
  duracion=tiempo;
  this.prioridad=prioridad;
  //Thread hilo=new Thread(this);

   status=1;
  
   this.origen=origen;
   
     try {
         anterior.join();
     } catch (InterruptedException ex) {
         Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
     }
 }

  
 
 ///////////////////////////////////////////////////////////////
 
 public void run() 
 {
 /*
  imprimeListo();
  
  try
	 {
	 sleep(1000);
	 }
  catch (InterruptedException e1)
	 {
	 e1.printStackTrace();
	 }
  */
  
  try
	 {
	  imprimeEjecucion();
	 }
  catch (InterruptedException e)
	 {
	            System.out.println("se interrumpio");;
	 } 	
	
  
  
  //alive=0;
 }
 
 ///////////////////////////////////////////////////////////////
 
 public  void imprimeEjecucion() throws InterruptedException 
 {
 String pos=Integer.toString(numero);
 String vieja,nueva,aux="",aux2="";
 int dura=duracion;

 if(numero<=9)
 	  pos="0"+Integer.toString(numero);

 switch(origen)
  {
      case Ventana.SISTEMA:
                           vieja="Proceso "+pos+"\t"+"Listo y en espera"+"\t"+prioridad;
                            nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura+"\t"+prioridad;

                            status=2;

                            while(dura!=-1)
                                   {
                                   aux=Ventana.textoSRT.getText();
                                   aux2=aux.replaceFirst(vieja, nueva);

                                   Ventana.textoSRT.setText(aux2);


                                    vieja=nueva;
                                    dura--;
                                    nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura+"\t"+prioridad;
                                    sleep(1000);

                                    if(dura <= 2)
                                            Ventana.mayor=true;
                                   }

                            if(dura==-1)
                                   {
                                    vieja="Proceso "+pos+"\t"+"En ejecucion"+"\t"+(dura+1)+"\t"+prioridad;
                                    nueva="Proceso "+pos+"\t"+"      Finalizado"+"\t\t"+prioridad;

                                    aux=Ventana.textoSRT.getText();
                                    aux2=aux.replaceFirst(vieja, nueva);
                                    Ventana.textoSRT.setText(aux2);

                                    status=4;
                                   }

          ;break;    
      case Ventana.USUARIO:
                               vieja="Proceso "+pos+"\t"+"Listo y en espera";
                        nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura;

                        status=2;

                        while(dura!=-1)
                               {
                               aux=Ventana.textoRR.getText();
                               aux2=aux.replaceFirst(vieja, nueva);

                               Ventana.textoRR.setText(aux2);


                                vieja=nueva;
                                dura--;
                                nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura;
                                sleep(1000);

                                if(dura <= 2)
                                        Ventana.mayor=true;
                               }

                        if(dura==-1)
                               {
                                vieja="Proceso "+pos+"\t"+"En ejecucion"+"\t"+(dura+1);
                                nueva="Proceso "+pos+"\t"+"      Finalizado";

                                aux=Ventana.textoRR.getText();
                                aux2=aux.replaceFirst(vieja, nueva);
                                Ventana.textoRR.setText(aux2);

                                status=4;
                               } 


                               
 
                          

          ;break; 
      case Ventana.OTROS:
          
                        vieja="Proceso "+pos+"\t"+"Listo y en espera";
                        nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura;

                        status=2;

                        while(dura!=-1)
                               {
                               aux=Ventana.textoFCFS.getText();
                               aux2=aux.replaceFirst(vieja, nueva);

                               Ventana.textoFCFS.setText(aux2);


                                vieja=nueva;
                                dura--;
                                nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura;
                                sleep(1000);

                                if(dura <= 2)
                                        Ventana.mayor=true;
                               }

                        if(dura==-1)
                               {
                                vieja="Proceso "+pos+"\t"+"En ejecucion"+"\t"+(dura+1);
                                nueva="Proceso "+pos+"\t"+"      Finalizado";

                                aux=Ventana.textoFCFS.getText();
                                aux2=aux.replaceFirst(vieja, nueva);
                                Ventana.textoFCFS.setText(aux2);

                                status=4;
                               }
                         

          ;break; 
  }
 
 
 
 
 
 
 
 
 
 
 
 
	  
	
	 
	 
  
 

 
 
 }
 
 /////////////////////////////////////////////////////////////////
 
 public  void imprimeListo()
 {
  String pos=Integer.toString(numero);
  String status="Listo y en espera";

  if(numero<=9)
 	 {
 	  pos="0"+Integer.toString(numero);
 	 }
  
  switch(origen)
  {
      case Ventana.SISTEMA:
                            if(Ventana.ListaProcesosSRT.size() == 1)
                              Ventana.textoSRT.append("Proceso "+pos+"\t"+status+"\t"+prioridad);
                            else
                              Ventana.textoSRT.append("\n"+"Proceso "+pos+"\t"+status+"\t"+prioridad);

          ;break;    
      case Ventana.USUARIO:
                           if(Ventana.ListaProcesosRR.size() == 1)
                              Ventana.textoRR.append("Proceso "+pos+"\t"+status);
                            else
                              Ventana.textoRR.append("\n"+"Proceso "+pos+"\t"+status);

          ;break; 
      case Ventana.OTROS:
                           if(Ventana.ListaProcesosFCFS.size() == 1)
                              Ventana.textoFCFS.append("Proceso "+pos+"\t"+status);
                            else
                              Ventana.textoFCFS.append("\n"+"Proceso "+pos+"\t"+status);

          ;break; 
  }
  
  
  
  
  
  
 	  
 }


 
 
 

public int compareTo(Proceso o) {
int a=this.prioridad;
int b=o.prioridad;
int respuesta=0;


if(a<b)
	respuesta= -1;
else if(a>b)
	respuesta= 1;
	  else if(a==b)
		  respuesta= -1;

return respuesta;
}
 
 /////////////////////////////////////////////////////////////////
 /*
 public void imprimeBloqueado()
 {
  String pos=Integer.toString(numero);
  String status="Bloqueado";

  if(numero<=9)
 	 {
 	  pos="0"+Integer.toString(numero);
 	 }
  
  if(numero==1)
	  Interfaz.texto.append("Proceso "+pos+"\t"+status);
  else
	  Interfaz.texto.append("\n"+"Proceso "+pos+"\t"+status);
 	  
 }
 */
}
