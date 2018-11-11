
public class Controller
{
   public Controller(){
       String link="C:/Users/GIIIIIIINGEEEEEEE/AISearch/AISearchtestcase.txt";
       Search s1=new Search(link,500);
       Search s2=new Search(link,500);
       Search s3=new Search(link,500);
       Individual best1=s1.getBest();
       int bestCost1=s1.getBestCost();
       Individual best2=s2.getBest();
       int bestCost2=s2.getBestCost();
       Individual best3=s3.getBest();
       int bestCost3=s3.getBestCost();
       System.out.println("-----------CONTROLLER--------------");
       System.out.println("link------------->"+link);
       System.out.println("best Tour 1");
       best1.printTour();
       System.out.println("best cost1:"+bestCost1);
       System.out.println("best Tour 2");
       best2.printTour();
       System.out.println("best cost2:"+bestCost2);
       System.out.println("best Tour 3");
       best3.printTour();
       System.out.println("best cost1:"+bestCost3);
    }
}
