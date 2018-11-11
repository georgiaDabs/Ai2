
public class Controller
{
   public Controller(){
       int popSize=500;
       String link="J:/SearchFiles/SearchFile535.txt";
       Search s1=new Search(link,popSize);
       Search s2=new Search(link,popSize);
      /* Search s3=new Search(link,popSize);
       Search s4=new Search(link,popSize);
       Search s5=new Search(link,popSize);
       Search s6=new Search(link,popSize);
       Search s7=new Search(link,popSize);
       Search s8=new Search(link,popSize);
       Search s9=new Search(link,popSize);
       Search s10=new Search(link,popSize);*/
       Individual best1=s1.getBest();
       int bestCost1=s1.getBestCost();
       Individual best2=s2.getBest();
       int bestCost2=s2.getBestCost();
      /* Individual best3=s3.getBest();
       int bestCost3=s3.getBestCost();
       Individual best4=s4.getBest();
       int bestCost4=s4.getBestCost();
       Individual best5=s5.getBest();
       int bestCost5=s5.getBestCost();
       Individual best6=s6.getBest();
       int bestCost6=s6.getBestCost();
       Individual best7=s7.getBest();
       int bestCost7=s7.getBestCost();
       Individual best8=s8.getBest();
       int bestCost8=s8.getBestCost();
       Individual best9=s9.getBest();
       int bestCost9=s9.getBestCost();
       Individual best10=s10.getBest();
       int bestCost10=s10.getBestCost();*/
       System.out.println("-----------CONTROLLER--------------");
       System.out.println("link------------->"+link);
       System.out.println("best Tour 1");
       best1.printTour();
       System.out.println("best cost1:"+bestCost1);
       System.out.println("best Tour 2");
       best2.printTour();
       System.out.println("best cost2:"+bestCost2);
      /* System.out.println("best Tour 3");
       best3.printTour();
       System.out.println("best cost3:"+bestCost3);
       System.out.println("best Tour 4");
       best4.printTour();
       System.out.println("best cost4:"+bestCost4);
       System.out.println("best Tour 5");
       best5.printTour();
       System.out.println("best cost5:"+bestCost5);
       System.out.println("best Tour 6");
       best6.printTour();
       System.out.println("best cost6:"+bestCost6);
       System.out.println("best Tour 7");
       best7.printTour();
       System.out.println("best cost7:"+bestCost7);
       System.out.println("best Tour 8");
       best8.printTour();
       System.out.println("best cost8:"+bestCost8);
       System.out.println("best Tour 9");
       best9.printTour();
       System.out.println("best cost1:"+bestCost9);
       System.out.println("best Tour 10");
       best10.printTour();
       System.out.println("best cost10:"+bestCost10);*/
    }
}
