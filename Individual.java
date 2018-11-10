import java.util.ArrayList;
import java.util.Random;
public class Individual
{
    ArrayList<Integer> tour;
    public Individual(int size){
        
        tour=new ArrayList<Integer>();
        Random rand=new Random();
        while(tour.size()!=size){
            int n=rand.nextInt(size);
            if(!tour.contains(n)){
                tour.add(n);
            }
        }
    }
    public void printTour(){
        for(Integer i:tour){
            System.out.print(i+",");
        }
    }
    public int getNext(int current){
        int next=0;
        for(Integer i:tour){
            if(i==current){
                if(tour.indexOf(current)==(tour.size()-1)){
                    next=tour.get(0);
                    break;
                }else{
                    next=tour.get(tour.indexOf(i)+1);
                    break;
                }
            }
        }
        return next;
    }
    public int getCost(int[][] array){
        int cost=0;
        for(int i=0;i<tour.size()-1;i++){
            cost+=array[tour.get(i)][tour.get(i+1)];
        }

        cost+=array[tour.get(tour.size()-1)][tour.get(0)];
        return cost;
    }
    public int getSize(){
        return tour.size();
    }
    public Individual(ArrayList<Integer> sublist,Individual parent){
        tour=new ArrayList<Integer>();
        tour.addAll(sublist);
        int current=tour.get(tour.size()-1);
        int next=-1;
        while(tour.size()!=parent.getSize()){
            if (next==-1){
                next=parent.getNext(current);
            }else{
                next=parent.getNext(next);
            }
            if(!tour.contains(next)){
                tour.add(next);
                current=next;
                next=-1;
            }
        }
    }
    public ArrayList<Integer> getChromosomes(){
        Random rand=new Random();
        int start=rand.nextInt(tour.size()-1);
        int length=rand.nextInt(tour.size()-3)+2;
        ArrayList<Integer> sublist=new ArrayList<Integer>();
        if((start+length)>tour.size()){
            //System.out.println("--------alternative method-----------");
            sublist.addAll(tour.subList(start,tour.size()));
           // System.out.println("firstSublist:"+tour.subList(start,tour.size()));
            sublist.addAll(tour.subList(0,(start+length)-tour.size()));
           // System.out.println("second:"+tour.subList(0,(start+length)-tour.size()));
        }else{
            sublist.addAll(tour.subList(start,start+length));
        }
        System.out.println("parent");
        printTour();
        System.out.println("chromosomes passed");
        System.out.println(sublist);
        return sublist;
    }
}
