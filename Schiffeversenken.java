import java.util.Arrays;
import java.util.*;

    
    public class Schiffeversenken
{
    
    int feldgroeße = 10;
    String [] [] meer = new String [feldgroeße][feldgroeße];
    int buchstabeInZahl;
   
    public Schiffeversenken()
    {
        
        spielStarten();
        
    }

    public void spielStarten(){
        
        for (int i = 0; i<feldgroeße; i++){
            
            for (int j = 0; j<feldgroeße; j++){
                
                meer[i][j]= "\u25A1";
                
            }
            
        }
        
    }
  
    public void meerAnzeigen(){
       
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("     A..B.C.D.E..F.G.H. I. J  \n");
                                
        for (int i = 0; i<feldgroeße; i++){
            
            if(i==9){
                
                System.out.print(i+1 + "   ");
                
                for (int j = 0; j<feldgroeße; j++){
                    
                    System.out.print(meer[i][j]+ " ");
                    
                }
                
                System.out.print("\n");
                
            }
            
            else{
                
                System.out.print(i+1 +"    ");
                
                for (int j = 0; j<feldgroeße; j++){
                 
                    System.out.print(meer[i][j]+ " ");
                    
                }
                
                System.out.print("\n");
            
            }
            
        }
        
        System.out.println("\n\n\n\n\n\n\n");
        
    }
        
    
    
    public void meerNachEreignis(){
       
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("     A..B.C.D.E..F.G.H. I. J  \n");
                                
        for (int i = 0; i<feldgroeße; i++){
            
            if(i==9){
                
                System.out.print(i+1 + "   ");
                
                for (int j = 0; j<feldgroeße; j++){
                    
                    if (meer[i][j] == "\u25a0"){
                        
                        System.out.print("\u25a1 ");
                        
                    }
                    else{
                    
                        System.out.print(meer[i][j]+ " ");
                    
                    }
                    
                }
                
                System.out.print("\n");
                
            }
            
            else{
                
                System.out.print(i+1 +"    ");
                
                for (int j = 0; j<feldgroeße; j++){
                    
                    if (meer[i][j] == "\u25a0"){
                        
                        System.out.print("\u25a1 ");
                        
                    }
                    else{
                    
                        System.out.print(meer[i][j]+ " ");
                    
                    }
                    
                }
                
                System.out.print("\n");
            
            }
            
        }
        
    }
    
    
    public void buchstabeZuZahl(char pBuchstabe){
        
        int k1 = 0;
        
            if(pBuchstabe == 'A'){
                k1 = 0;
            }else if(pBuchstabe == 'B'){
                k1 = 1;
            }else if(pBuchstabe == 'C'){
                k1 = 2;
            }else if(pBuchstabe == 'D'){
                k1 = 3;
            }else if(pBuchstabe == 'E'){
                k1 = 4;
            }else if(pBuchstabe == 'F'){
                k1 = 5;
            }else if(pBuchstabe == 'G'){
                k1 = 6;
            }else if(pBuchstabe == 'H'){
                k1 = 7;
            }else if(pBuchstabe == 'I'){
                k1 = 8;
            }else if(pBuchstabe == 'J'){
                k1 = 9;
            }
        
        buchstabeInZahl = k1;
        
    }   
    
    public void schiffPlatzieren(char pBuchstabe , int pZahl){
        
        buchstabeZuZahl(pBuchstabe);
        meer [pZahl-1] [buchstabeInZahl] = "\u25a0" ;
        meerAnzeigen();
        
    }
    
    public void testen (){
    
        spielStarten();
        schiffPlatzieren('D',8);
        System.out.println("Testschiff platziert auf D 8");
    
    }
   
    void schiffDa(char pBuchstabe,int pZahl) {
            
        buchstabeZuZahl(pBuchstabe);
        int qReihe = buchstabeInZahl;
        int qSpalte = pZahl -1;
        
            if(meer [qReihe] [qSpalte] == "\u25a1") {
                
                meer [qSpalte] [qReihe] = "\u2206";
                meerNachEreignis();
                System.out.print("Auf dem Feld " + pBuchstabe + "/" + pZahl + " befindet sich Wasser.");
                                
            }
            else if(meer [qReihe] [qSpalte] == "\u25a0") {
                
                meer [qSpalte] [qReihe] = "\u2666";
                meerNachEreignis();
                System.out.print("Auf dem Feld " + pBuchstabe + "/" + pZahl + " befindet sich ein Schiff. Du hast einen Treffer erzielt.");
                
            }
            else if(meer [qReihe] [qSpalte] == "\u2666") {
               
                System.out.print("Auf dem Feld " + pBuchstabe + "/" + pZahl + " befindet sich ein bereits getroffenes Schiff.");
                
            }
            else if(meer [qReihe] [qSpalte] == "www") {
                
                System.out.print("Auf dem Feld " + pBuchstabe + "/" + pZahl + " befindet sich ein bereits versenktes Schiff.");
                
            }
            else if(meer [qReihe] [qSpalte] == "\u2206") {
                
                System.out.print("Das Feld " + pBuchstabe + "/" + pZahl + " ist ein bereits getroffenes Wasserfeld.");
                
            }
        
    }              
     
    
    void schiff5Zufall() {
            //platziert 5 einzelne Schiffe zufällig
        for(int i=0; i<5; i++) {
             
            int reihe = (int)(Math.random()*feldgroeße)+ 1;
            reihe --;
            int spalte = (int)(Math.random()*feldgroeße)+ 1;
            spalte --;
            meer [reihe] [spalte] = "\u25a0";
             
        }
        
    }
    
    void schiffGroeßerEins() {
                
           int reihe = (int)(Math.random()*feldgroeße)+ 1;
           reihe --;
           int spalte = (int)(Math.random()*feldgroeße)+ 1;
           spalte --;
           meer [reihe] [spalte] = "\u25a0";
           int richtung = (int) (Math.random()*4)+1; 
           int schiffslaenge = (int) (Math.random()*4)+1;
               
               if (richtung == 1)                                       //Schiff wird nach Norden gelegt.
               {
               
                    if(reihe - schiffslaenge <0){
                        
                        int ueberlaenge;
                        ueberlaenge = schiffslaenge - reihe;
                        schiffslaenge = schiffslaenge - ueberlaenge;
                   
                    }
                    
                    for(int i=0; i< schiffslaenge; i++)
                        {
                       
                           reihe --;
                           meer [reihe] [spalte] = "\u25a0";
                         
                        }
                    
               }
               else if (richtung == 2)                                      //Schiff wird nach Osten gelegt.
               {
                   
                   if(spalte + schiffslaenge > 9){
                       
                       int ueberlaenge;
                       ueberlaenge = schiffslaenge - (9-spalte);
                       schiffslaenge = schiffslaenge - ueberlaenge;
                       
                    }
                   
                   for(int i=0; i< schiffslaenge; i++)
                   {
                       
                       spalte ++;
                       meer [reihe] [spalte] = "\u25a0";
                        
                   }
                   
               }
               else if (richtung == 3)                                      //Schiff wird nach Süden gelegt.
               {
                   
                   if(reihe + schiffslaenge >9){
                        
                        int ueberlaenge;
                        ueberlaenge = schiffslaenge - reihe;
                        schiffslaenge = schiffslaenge - ueberlaenge;
                   
                    }
                   
                   for(int i=0; i< schiffslaenge; i++)
                   {
                       
                       reihe ++;
                       meer [reihe] [spalte] = "\u25a0";
                        
                   }
                   
               }
               else if (richtung == 4)                                       //Schiff wird nach Westen gelegt.
               {
                   
                   if(spalte - schiffslaenge < 0){
                       
                       int ueberlaenge;
                       ueberlaenge = schiffslaenge - (9-spalte);
                       schiffslaenge = schiffslaenge - ueberlaenge;
                       
                    }
                   
                   
                   for(int i=0; i< schiffslaenge; i++)
                   {
                       
                       spalte --;
                       meer [reihe] [spalte] = "\u25a0";
                        
                   }
                   
               }
               
    }
    
}

     // funktionierende Zeichen:
     /*
      * \u263c      ☼
        \u25a1      □
        \u25a0      ■
        \u2666      ♦
        \u2206      ∆
        \u222c      ∬
        */