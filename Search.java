import java.io.*;
import java.util.*;
public class Search
{
    int[][] array;
    private int sizeOfPop;
   public Search(String link, int sizeOfPop){
     this.sizeOfPop=sizeOfPop;
     int size=0;
        try{
        File file=new File(link);
        Scanner sc=new Scanner(file);
        sc.nextLine();
        sc.next();
        sc.next();
        String s=sc.next();
        s=s.replaceAll(",$","");
        
         size=Integer.parseInt(s);
        array=new int[size][size];
        boolean running =true;
        List<Integer> numbers=new ArrayList<Integer>();
        while(running){
            if(sc.hasNext()){
                String next=sc.next();
                String[] values=next.split(",");
                for(String str: values){
                    //System.out.println(str);
                    str=str.replaceAll("[^0-9]","");
                    numbers.add(Integer.parseInt(str));
                }
            }else{running=false;}
        }
        System.out.println(numbers);
        //System.out.println("size:"+size);
        for (int i=0;i<size;i++){
            for(int j=i;j<size;j++){
                if(i!=j){
                    array[i][j]=numbers.get(0);
                    array[j][i]=array[i][j];
                    numbers.remove(0);
                }
            }
        }
        for(int[] row:array){
            for(int i: row){
                System.out.print(","+i);
            }
            System.out.println(" ");
        }
    }catch(IOException e){
        System.out.println("file not found");
    }
    Population pop=firstGen(sizeOfPop,size);
    pop.printPop();
    System.out.println("total cost:"+pop.getTotalCost(array));
    ArrayList<Individual> parents=pop.getParents(array);
    System.out.println("---------------PARENT 1---------------------");
    parents.get(0).printTour();
    System.out.println("/n---------------PARENT 2----------------------");
    parents.get(1).printTour();
    System.out.println("-------------mating-------------------");
    Population pop2=new Population(parents.get(0),parents.get(1),sizeOfPop);
    }
    public Population firstGen(int size, int sizeOfTour){
        return new Population(size,sizeOfTour);
    }
    public void printArray(){
        for(int[] row: array){
            System.out.println(row);
        }
    }
}
