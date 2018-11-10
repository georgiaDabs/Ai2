import java.util.ArrayList;
import java.util.Random;
public class Population
{
    int size=0;
    ArrayList<Individual> pop;
    public Population(int size, int sizeOfTour){
        this.size=size;
        pop=new ArrayList<Individual>();
        while(pop.size()!=size){
            pop.add(getNewRandom(sizeOfTour));
        }
    }
    public Individual getNewRandom(int s){
        return new Individual(s);
    }
    public void printPop(){
        System.out.println("------------POPULATION---------------------");
        for(Individual ind:pop){
            ind.printTour();
            System.out.println(" ");
        }
    }
    public int getTotalCost(int[][] array){
        int cost=0;
        for(Individual ind:pop){
            cost+=ind.getCost(array);
        }
        return cost;
    }
    public ArrayList<Individual> getParents(int[][] array){
        System.out.println("get parents");
        ArrayList<Individual> parents=new ArrayList<Individual>();
        
        int total=getTotalCost(array);
        while(parents.size()!=2){
            Individual ind=getParent(total,array);
            //System.out.println("trying for parent");
            if(!parents.contains(ind)){
                System.out.println("got parent");
                parents.add(ind);
            }
        }
        return parents;
    }
    public Individual getParent(int total,int[][] array){
        
        Individual parent=null;
        Random rand=new Random();
        float r=rand.nextFloat();
        //System.out.println("float:"+r);
        float start=0;
        for(Individual ind:pop){
            float length=(((float)ind.getCost(array))/(float)total);
            System.out.println("start:"+start+" end:"+(start+length)+" float:"+r);
            if(r>(start+length)){
                start+=length;
            }else{
                parent=ind;
            }
        }
        return parent;
    }
    public Population(Individual parent1,Individual parent2,int size){
        pop=new ArrayList<Individual>();
       /* while(pop.size()!=size){
            
        }*/
        for(int i=0;i<10;i++){
            parent1.getChromosomes();
        }
    }
}
