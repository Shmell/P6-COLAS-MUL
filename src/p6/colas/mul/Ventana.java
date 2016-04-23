package p6.colas.mul;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.util.List;
import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;

import javax.swing.text.BadLocationException;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAM
 */
public class Ventana extends javax.swing.JFrame implements Runnable{

    
    public Ventana() 
    {
        initComponents();
        setLocation(400, 0) ;
        setTitle("SRT Prioridades");
        
        
        jLabel6.setText(Integer.toString(PRIORIDAD_SRT));
        jLabel8.setText(Integer.toString(TIEMPO_SRT));
        jLabel11.setText(Integer.toString(PRIORIDAD_RR));
        jLabel13.setText(Integer.toString(TIEMPO_RR));
        jLabel37.setText(Integer.toString(PRIORIDAD_FCFS));
        jLabel39.setText(Integer.toString(TIEMPO_FCFS));
        
        

          Creador=new Thread(this);
  
          auto=new Automatico();
          auto.start();
          
          HiloSRT=new SRT();
          HiloRR=new RR(TIEMPO_RR_INTERNO);
          HiloFCFS=new FCFS();
          
          
        
    }

/////////////////////////////////////////////////////////

 

//////////////////////////////////////////////////////////////////

public void run()
{
    int bandera=0;
 
 
 
 while(true)
{
    if(bandera==1)
    {
        System.out.println("entro segunda vuelta)");
       SRT.reanudar();LabelSistema.setForeground(Color.red);

      
       try {
                   sleep(TIEMPO_SRT*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
               }
       
       
       SRT.suspender();LabelSistema.setForeground(Color.white);
       RR.reanudar();LabelUsuario.setForeground(Color.red);

        //RR.reanudar();
      
       try {
                   sleep(TIEMPO_RR*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
               }
       
        RR.suspender();LabelUsuario.setForeground(Color.white);
         FCFS.reanudar();LabelVarios.setForeground(Color.red);

      
       try {
                   sleep(TIEMPO_FCFS*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
               }
      
        FCFS.suspender(); LabelVarios.setForeground(Color.white);
        
        
        
        
        
        
        
    }
    else
    {
        HiloSRT.start(); LabelSistema.setForeground(Color.red);
        

      
       try {
                   sleep(TIEMPO_SRT*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
               }
       
       
       SRT.suspender();LabelSistema.setForeground(Color.white);
       HiloRR.start();LabelUsuario.setForeground(Color.red);
      
       try {
                   sleep(TIEMPO_RR*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
               }
       
       RR.suspender();LabelUsuario.setForeground(Color.white);
       
         HiloFCFS.start();LabelVarios.setForeground(Color.red);

      
       try {
                   sleep(TIEMPO_FCFS*1000);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
               }
      
        FCFS.suspender();LabelVarios.setForeground(Color.white);
        
        bandera=1;
        
    }
    
    
    
       
        
             
             
}
        
         
     
 

 
     
    
}

//////////////////////////////////////////////////////////////////
/*
public void funciona() throws InterruptedException
{
int contador=nlista;

while(contador<ListaProcesos.size())
{
ListaProcesos.get(nlista).start();
//ListaProcesos.get(nlista).join();;


contador++;
}


}*/
//////////////////////////////////////////////////////////////
public synchronized static void crea()
{
 Proceso aux; 
 int tiempo;
 int prio;
 int turno;

 Random tiempo_random=new Random();
 tiempo=1 + tiempo_random.nextInt(15);
 
  Random prio_random=new Random();
  prio=1 + prio_random.nextInt(15); 
  
  Random turno_random=new Random();
  turno=1 + prio_random.nextInt(3); 
  
  
  
 
  
  if(contadorSRT==0 && contadorRR==0 && contadorFCFS==0)
  {
       contadorSRT++;
        ListaProcesosSRT.add((new Proceso(contadorSRT,tiempo,prio+1,Ventana.SISTEMA)));
        indiceSRT.add((new Referencia(contadorSRT,prio+1)));
        ListaProcesosSRT.get(ListaProcesosSRT.size()-1).imprimeListo(); 
        
        contadorSRT++;
        ListaProcesosSRT.add((new Proceso(contadorSRT,tiempo,prio,Ventana.SISTEMA)));
        indiceSRT.add((new Referencia(contadorSRT,prio)));
        ListaProcesosSRT.get(ListaProcesosSRT.size()-1).imprimeListo(); 
        
        
        contadorRR++;
        ListaProcesosRR.add((new Proceso(contadorRR,tiempo,prio,Ventana.USUARIO)));
        ListaProcesosRR.get(ListaProcesosRR.size()-1).imprimeListo(); 
        contadorRR++;
        ListaProcesosRR.add((new Proceso(contadorRR,tiempo,prio,Ventana.USUARIO)));
        ListaProcesosRR.get(ListaProcesosRR.size()-1).imprimeListo(); 
         
        contadorFCFS++;
        ListaProcesosFCFS.add((new Proceso(contadorFCFS,tiempo,prio,Ventana.OTROS)));
        ListaProcesosFCFS.get(ListaProcesosFCFS.size()-1).imprimeListo();  
        
  }
  else
  {
        if(turno==Ventana.SISTEMA)
       {
           contadorSRT++;
        ListaProcesosSRT.add((new Proceso(contadorSRT,tiempo,prio+1,Ventana.SISTEMA)));
        indiceSRT.add((new Referencia(contadorSRT,prio+1)));

        ListaProcesosSRT.get(ListaProcesosSRT.size()-1).imprimeListo();    
        
        contadorSRT++;
        ListaProcesosSRT.add((new Proceso(contadorSRT,tiempo,prio,Ventana.SISTEMA)));
        indiceSRT.add((new Referencia(contadorSRT,prio)));

        ListaProcesosSRT.get(ListaProcesosSRT.size()-1).imprimeListo(); 
       }
       else if(turno==Ventana.USUARIO)
              {
                  contadorRR++;
                 ListaProcesosRR.add((new Proceso(contadorRR,tiempo,prio,Ventana.USUARIO)));

                 ListaProcesosRR.get(ListaProcesosRR.size()-1).imprimeListo();    
              }
             else if(turno==Ventana.OTROS)
                     {
                         contadorFCFS++;
                      ListaProcesosFCFS.add((new Proceso(contadorFCFS,tiempo,prio,Ventana.OTROS)));


                      ListaProcesosFCFS.get(ListaProcesosFCFS.size()-1).imprimeListo();    
                     }
  
  
  
  
  }
  
  
  
  
  
  
  
}

//////////////////////////////////

//////////////////////////////////

public void proceso_ejecutandose(int posicion)
{

	  ListaProcesosSRT.get(posicion-1).start();
    // imprimeEjecucion(posicion);
	
	
}

//////////////////////////////////////////

public void retardo_bloqueo(int tiempo)
{
 try //Tiempo de retardo para la creacion de un nuevo hilo
	{
	 Thread.sleep(tiempo);
	}
 catch(InterruptedException er)
	{
	 System.out.println(er);
	}
 
}







////////////////////////////////////
public void imprimeListo(int posicion)
{
int posInicio=(posicion-1)*29;
int posFinal=posInicio+29;

 String pos=Integer.toString(posicion);
 String listo="Listo";

 
 
 
 if(posicion<=9)
	 {
	  pos="0"+Integer.toString(posicion);
	 }
 
 if(posicion==1)
	 textoSRT.append("Proceso "+pos+"\t"+listo);
 else
	 textoSRT.append("\n"+"Proceso "+pos+"\t"+listo);
	  

 
 
 /*
 if(posicion==1)
	 texto.replaceRange("Proceso "+pos+"\t"+ejecutandose,posInicio,posFinal);
 else
	 texto.replaceRange("\n"+"Proceso "+pos+"\t"+ejecutandose,posInicio,posFinal);

*/
 
 
}

////////////////////////////////////
public void imprimeEjecucion(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux,aux2;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"Listo";
nueva="Proceso "+pos+"\t"+"En ejecucion";


aux=textoSRT.getText();
aux2=aux.replaceFirst(vieja, nueva);

if(aux.equals(aux2))
	{
	 vieja="Proceso "+pos+"\t"+"Bloqueado";
	 aux2=aux.replaceFirst(vieja, nueva);
	}
textoSRT.setText(aux2);


}


//////////////////////////////////////////////
public void imprimeReanudado(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux,aux2;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"Listo";
nueva="Proceso "+pos+"\t"+"En ejecucion";


aux=textoSRT.getText();
aux2=aux.replaceFirst(vieja, nueva);

if(aux.equals(aux2))
	{
           
            
	 vieja="Proceso "+pos+"\t"+"Bloqueado";
	 aux2=aux.replaceFirst(vieja, nueva);
	}
textoSRT.setText(aux2);


ListaProcesosSRT.get(posicion-1).status=2;
ListaProcesosSRT.get(posicion-1).resume();


}

/////////////////////////////////////////////////
public String completarEstado(String estado)
{
 String cadena="";
 
	 
 for(int i=estado.length();i<20;i++)
	 {
	  cadena=cadena.concat(".");
	 }

 return estado.concat(cadena);
}

 //////////////////////////////////////

public void ponerStatusAleatorio() 
{
 Random randomLista=new Random();
 Random randomStatus=new Random();

 int aLista=randomLista.nextInt(ListaProcesosSRT.size()-1);
 int aStatus=1 + randomLista.nextInt(5);
 
 
 if(aStatus==1 || aStatus==2)
	 proceso_bloqueado(aLista+1);
 else if(aStatus==3 || aStatus==4)
	 		proceso_eliminado(aLista+1);
 		else
 			proceso_ejecutandose(aLista+1);
}	
 
 //////////////////////////////////////////////////

public void proceso_bloqueado(int nLista) 
{

/* 
try
	{
	ListaProcesos.get(nLista).sleep(15000);
	}
catch (InterruptedException e)
	{
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	*/
 imprimeBloqueado(nLista);
 
}
 

////////////////////////////////////////////////
public void imprimeBloqueado(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux;;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"En ejecucion";
nueva="Proceso "+pos+"\t"+"Bloqueado";

aux=textoSRT.getText().replaceFirst(vieja, nueva);

textoSRT.setText(aux);

ListaProcesosSRT.get(posicion-1).status=3;
ListaProcesosSRT.get(posicion-1).suspend();


}
 
//////////////////////////////////////////////////

public void proceso_eliminado(int nLista) 
{
ListaProcesosSRT.get(nLista-1).stop();
imprimeEliminado(nLista);

}


////////////////////////////////////////////////
public void imprimeEliminado(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux,aux2;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"En ejecucion";
nueva="Proceso "+pos+"\t"+"Eliminado";

aux=textoSRT.getText();
aux2=aux.replaceFirst(vieja, nueva);

if(aux.equals(aux2))
	{
	 vieja="Proceso "+pos+"\t"+"Bloqueado";
	 aux2=aux.replaceFirst(vieja, nueva);
	}


textoSRT.setText(aux2);
}
    
    
    
    
    
    
    
    
    

    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoSRT = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNumero = new javax.swing.JTextPane();
        reanudar = new javax.swing.JButton();
        pausar = new javax.swing.JButton();
        informacion = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        LabelSistema = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textoRR = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        LabelUsuario = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        textoFCFS = new javax.swing.JTextArea();
        jPanel11 = new javax.swing.JPanel();
        LabelVarios = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Proceso");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Estado");

        textoSRT.setColumns(20);
        textoSRT.setRows(5);
        jScrollPane1.setViewportView(textoSRT);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNumero.setBorder(null);
        txtNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(255, 0, 0));
        txtNumero.setToolTipText("Numero de Proceso");
        txtNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumero.setMargin(new java.awt.Insets(15, 3, 3, 3));
        jScrollPane2.setViewportView(txtNumero);

        reanudar.setBackground(new java.awt.Color(51, 51, 51));
        reanudar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        reanudar.setForeground(new java.awt.Color(255, 255, 255));
        reanudar.setText("Reanudar");
        reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarActionPerformed(evt);
            }
        });

        pausar.setBackground(new java.awt.Color(51, 51, 51));
        pausar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pausar.setForeground(new java.awt.Color(255, 255, 255));
        pausar.setText("Bloquear");
        pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarActionPerformed(evt);
            }
        });

        informacion.setBackground(new java.awt.Color(153, 153, 153));
        informacion.setText("Info");
        informacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionActionPerformed(evt);
            }
        });

        finalizar.setBackground(new java.awt.Color(51, 51, 51));
        finalizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        finalizar.setForeground(new java.awt.Color(255, 255, 255));
        finalizar.setText("Eliminar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(informacion))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(reanudar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pausar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(informacion))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Prioridad");

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        LabelSistema.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelSistema.setForeground(new java.awt.Color(255, 255, 255));
        LabelSistema.setText("Sistema (SRT)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Prioridad");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("P");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tiempo");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("T");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(87, 87, 87))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(LabelSistema)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LabelSistema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        textoRR.setColumns(20);
        textoRR.setRows(5);
        jScrollPane3.setViewportView(textoRR);

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        LabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(255, 255, 255));
        LabelUsuario.setText("Usuario (RR)");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Prioridad");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("P");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tiempo");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("T");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11))
                .addGap(87, 87, 87))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LabelUsuario)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(LabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel14.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel14.setText("Proceso");

        jLabel15.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel15.setText("Estado");

        jLabel22.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel22.setText("Proceso");

        jLabel23.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel23.setText("Estado");

        textoFCFS.setColumns(20);
        textoFCFS.setRows(5);
        jScrollPane4.setViewportView(textoFCFS);

        jPanel11.setBackground(new java.awt.Color(51, 51, 51));

        LabelVarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelVarios.setForeground(new java.awt.Color(255, 255, 255));
        LabelVarios.setText("Varios (FCFS)");

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Prioridad");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("P");

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Tiempo");

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("T");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel39)
                    .addComponent(jLabel37))
                .addGap(87, 87, 87))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(LabelVarios)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LabelVarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jLabel39))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel14)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel15))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel2)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel23)
                                .addGap(169, 169, 169)))
                        .addGap(27, 27, 27)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarActionPerformed
       
        if(txtNumero.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "No se ha ingresado el numero de proceso");

        
        
        
        imprimeReanudado(Integer.parseInt(txtNumero.getText()));
       txtNumero.setText("");				        

    }//GEN-LAST:event_reanudarActionPerformed

    private void informacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionActionPerformed
			        	JOptionPane.showMessageDialog(null, "Desarrollado por:\nSamuel Ramirez Torres\nCodigo:304454235\nBibliogafia:\nSistemas.Operativos\nWilliam Stallings\n2000 2da Edicion Prentice Hall ");
        
    }//GEN-LAST:event_informacionActionPerformed

    private void pausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarActionPerformed
      
        if(txtNumero.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "No se ha ingresado el numero de proceso");
        
        proceso_bloqueado(Integer.parseInt(txtNumero.getText()));
      txtNumero.setText("");	
    }//GEN-LAST:event_pausarActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        
        if(txtNumero.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "No se ha ingresado el numero de proceso");
        
        proceso_eliminado(Integer.parseInt(txtNumero.getText()));
        txtNumero.setText("");	
    }//GEN-LAST:event_finalizarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelSistema;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JLabel LabelVarios;
    private javax.swing.JButton finalizar;
    private javax.swing.JButton informacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton pausar;
    private javax.swing.JButton reanudar;
    public static javax.swing.JTextArea textoFCFS;
    public static javax.swing.JTextArea textoRR;
    public static javax.swing.JTextArea textoSRT;
    private javax.swing.JTextPane txtNumero;
    // End of variables declaration//GEN-END:variables
    
 
    
    
 static ArrayList<Proceso> ListaProcesosSRT=new ArrayList<Proceso>();
 static ArrayList<Referencia> indiceSRT=new ArrayList<Referencia>();
 
 static ArrayList<Proceso> ListaProcesosFCFS=new ArrayList<Proceso>();
 static ArrayList<Proceso> ListaProcesosRR=new ArrayList<Proceso>(); 
 
 final int PRIORIDAD_SRT=1;
 final int TIEMPO_SRT=6;
 
 final int PRIORIDAD_RR=2;
 final int TIEMPO_RR=4;
 final int TIEMPO_RR_INTERNO=2;
 
 
  final int PRIORIDAD_FCFS=3;
 final int TIEMPO_FCFS=2;

 
 
 
 
 
 
 
 int contAleatorio=0;
 static Thread Creador;
 
 Thread auto;
 Thread HiloSRT;
 Thread HiloRR;
Thread HiloFCFS;
 
 static int contadorSRT=0;
static int contadorRR=0;
static int contadorFCFS=0;
 
 
 
 
 


 public static boolean mayor=false;
 public static boolean entrar=true;
 
 static final int SISTEMA= 1;
 static final int USUARIO= 2;
 static final int OTROS= 3;
 
 static int rr=5;
 static int contador_pos=0;
 

}
