The observer pattern is a software design pattern 
in which an object, called the subject, maintains a list of its dependents, called observers, 
and notifies them automatically of any state changes, usually by calling one of their methods.

More details:
Subject maintains list observers
new observer can be registered into list observers
registered observers can be unregistered
any state changes, subject will automatically notify to the registered observers, unregistered observers won't be notified



import java.util.ArrayList;
import java.util.List;

public class Subject {
	
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);		
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   } 	
}

public class BinaryObserver extends Observer{

   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}

public class OctalObserver extends Observer{

   public OctalObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
     System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
   }
}

public class HexaObserver extends Observer{

   public HexaObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() ); 
   }
}

public class ObserverPatternDemo {
   public static void main(String[] args) {
      Subject subject = new Subject();

      new HexaObserver(subject);
      new OctalObserver(subject);
      new BinaryObserver(subject);

      System.out.println("First state change: 15");	
      subject.setState(15);
      System.out.println("Second state change: 10");	
      subject.setState(10);
   }
}

