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
    public Population (){
        pop=new ArrayList<Individual>();
    }
    public void remove(ArrayList<Individual> removeList){
        for(Individual ind:removeList){
            pop.remove(ind);
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
                break;
            }
        }
        return parent;
    }
    public Population(Individual parent1,Individual parent2,int size){
        pop=new ArrayList<Individual>();
        while(pop.size()!=size){
            Individual ind=new Individual(parent1.getChromosomes(),parent2);
            pop.add(ind);
        }
        
    }
    public void mutate(int mutationRate){
        Random rand=new Random();
        System.out.println("----------mutating population-------------");
        for(Individual ind:pop){
            int r=rand.nextInt(100);
            if(r<mutationRate){
                System.out.println("------------------mutaing----------------------------");
                ind.printTour();
                ind.mutate();
                ind.printTour();
            }
        }
    }
    public Individual getBest(int[][] array){
        int cost=-1;
        Individual best=null;
        for(Individual ind:pop){
            if(cost==-1){
                best=ind;
                cost=ind.getCost(array);
            }else if(ind.getCost(array)<cost){
                best=ind;
                cost=ind.getCost(array);
            }
        }
        return best;
    }
    public ArrayList<Individual> getPopulation(){
        return pop;
    }
    public void addToPop(ArrayList<Individual> popToBeAdded){
        pop.addAll(popToBeAdded);
        size=pop.size();
    }
}
