/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Problem02 {
       static double matPorto [][];
       static double matInter[][];
   static int weight [];
   static double price [];
   static String clubName [];
   static String finalBuy [];
   static int porto;
   static int Inter;
   static int portoIndex;
   static double portoPro=0;
   static double InterPro=0;
   
   static int n,W;
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        System.out.println("Please enter Max weight");
        
        W=sc.nextInt();
        
        System.out.println("Please enter Total trophies");
        
        n=sc.nextInt();
        
        sc.nextLine();
        clubName=new String [n+1];
        
        price= new double[n+1];
        
        weight=new int[n+1];
        
        finalBuy=new String[n+1];
        
      
        
        for (int i = 0; i <7; i++) {
            
           // System.out.println("Give club name");
            clubName[i]=sc.nextLine();
            
           // System.out.println("give weight");
            weight[i]=sc.nextInt();
            
           // System.out.println("Give player price");
            
            price[i]=sc.nextDouble();
           
            sc.nextLine();
            
            
          
        }
       sc.close();
         porto=4;
         Inter=7;
       
        knapsack1(porto); 
        knapsack2(Inter);
        

        
        portoPro=matPorto[n][W-porto];
       // System.out.println("Porto Profit is:"+portoPro);
        InterPro=matInter[n][W-Inter];
       // System.out.println("Inter profit is "+InterPro);
        
      double result=0;   
      if(portoPro>InterPro) {
          
          printItemPorto(portoPro);
          result=price[portoIndex]+portoPro;
          
      }
        else result=result+InterPro;
      
      
        int count=0;
        for (int i = 0; i <finalBuy.length; i++) {
            if(finalBuy[i]!=null)count++;
        }
        
        int c=1;
        System.out.println("Name of the clubs whose trophies were sold:");
         for (int i = 0; i < finalBuy.length; i++) {
            if(finalBuy[i]!=null){
                System.out.print(finalBuy[i]);
                if(c<count)System.out.print("->");{
                c++;
            }
            }
        }

        
        System.out.println(" ");
        System.out.println("Maximum money he earned: "+result+" million");
    }
    
    
    
    
    static void knapsack1(int ucl){
        String p="Porto";
        matPorto=new double[n+1][(W-ucl)+1];
        portoIndex=0;
        for (int i = 0; i < n+1; i++) {
            String s=clubName[i];
          
            if(s.equals(p)){ 
                portoIndex=i;
                
            }
        }
        
        
         double temp=price[portoIndex];
         price[portoIndex]=1;
         for (int i = 0; i < 7; i++) {
             System.out.print(price[i]+" ");
        }
         System.out.println(" ");
        for (int i = 0; i < n+1; i++) {
            for (int currentValue = 0; currentValue < (W-ucl)+1; currentValue++) {
              if(currentValue==0||i==0)matPorto[i][currentValue]=0;
              else if(currentValue < weight[i]){
                  matPorto[i][currentValue]=matPorto[i-1][currentValue];
              }
              
             
              else{
                  matPorto[i][currentValue]=max(i,currentValue);
              }
            }
           
        }
        price[portoIndex]=temp;
        
    }
    static double max(int i, int cv){
        
        if((price[i]+matPorto[i-1][cv-weight[i]])> (matPorto[i-1][cv])) return (price[i]+matPorto[i-1][cv-weight[i]]);
        else if((price[i]+matPorto[i-1][cv-weight[i]])==(matPorto[i-1][cv]))return  (price[i]+matPorto[i-1][cv-weight[i]]);
        else return  matPorto[i-1][cv];

    }
    
        
    
      static void knapsack2(int ucl){
       
        matInter=new double[n+1][(W-ucl)+1];
        
       

        for (int i = 0; i < n+1; i++) {
            for (int currentValue = 0; currentValue < (W-ucl)+1; currentValue++) {
              if(currentValue==0||i==0)matInter[i][currentValue]=0;
              else if(currentValue < weight[i]){
                  matInter[i][currentValue]=matInter[i-1][currentValue];
              }
              
             
              else{
                  matInter[i][currentValue]=maxInter(i,currentValue);
              }
            }
           
        }
        
        
    }
    static double maxInter(int i, int cv){
        
        if((price[i]+matInter[i-1][cv-weight[i]])> (matInter[i-1][cv])) return (price[i]+matInter[i-1][cv-weight[i]]);
        else if((price[i]+matInter[i-1][cv-weight[i]])==(matInter[i-1][cv]))return  (price[i]+matInter[i-1][cv-weight[i]]);
        else return  matInter[i-1][cv];

    }
    
  static void printItemPorto(double res){
    
        int w=W-porto;
        
        for (int i = n+1; i > 0; i--) {
            if(res>0){
                if(res == matPorto[i-1][w]) continue;
                else{
                        
                       finalBuy[i]=clubName[i];
                       res=res-price[i];
                       w=w-weight[i];
                }
            
            }
        }
    
    }
    static void printItemInter(double res){
    
        int w=W-porto;
        
        for (int i = n+1; i > 0; i--) {
            if(res>0){
                if(res == matPorto[i-1][w]) continue;
                else{
                        
                       finalBuy[i]=clubName[i];
                       res=res-price[i];
                       w=w-weight[i];
                }
            
            }
        }
    
    }
}
