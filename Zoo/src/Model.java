import java.util.Random;
import java.util.Vector;

public class Model {
    private Vector<Subscriber> subscribers;

    Vector<Employer> employers;
    Vector<Elephant> elephants;
    Vector<Ostrich> ostriches;
    Vector<Tiger> tigers;
    Vector<Flamingo> flamingos;

    public void addSubscriber(Subscriber subscriber) {
        this.subscribers.add(subscriber);
    }


    Model (){
        subscribers = new Vector<Subscriber>();
        employers = new Vector<Employer>();
        elephants = new Vector<Elephant>();
        ostriches = new Vector<Ostrich>();
        tigers = new Vector<Tiger>();
        flamingos = new Vector<Flamingo>();
    }
    public Vector<Employer> getEmployers() {
        return employers;
    }

    public void addEmployer(Employer employer) {
        this.employers.add(employer);
        for (Subscriber sub : subscribers) {
            sub.updateEmployers();
        }
    }

    public Vector<Elephant> getElephants() {
        return elephants;
    }

    public void addElephant(Elephant elephant) {
        this.elephants.add(elephant);
        for (Subscriber sub : subscribers) {
            sub.updateElephants();
        }
    }

    public Vector<Ostrich> getOstriches() {
        return ostriches;
    }

    public void addOstrich(Ostrich ostrich) {
        this.ostriches.add(ostrich);
        for (Subscriber sub : subscribers) {
            sub.updateOstrich();
        }
    }

    public Vector<Tiger> getTigerss() {
        return tigers;
    }

    public void addTiger(Tiger tiger) {
        this.tigers.add(tiger);
        for (Subscriber sub : subscribers) {
            sub.updateTigers();
        }
    }

    public Vector<Flamingo> getFlamingos() {
        return flamingos;
    }

    public void addFlamingo(Flamingo flamingo) {
        this.flamingos.add(flamingo);
        for (Subscriber sub : subscribers) {
            sub.updateFlamingos();
        }
    }

    public Animal randAnimal() {
        Animal animal = new Animal();
        if (elephants.isEmpty() && ostriches.isEmpty() && tigers.isEmpty() && flamingos.isEmpty()) {
            return null;
        }
        Random rand = new Random();
        int choice;
        boolean check = true;
        while (check) {

            choice = rand.nextInt(3);
            switch (choice) {
                case 0: {
                    if (!elephants.isEmpty()) {
                        animal = elephants.elementAt(rand.nextInt(elephants.size()));
                        check = false;
                    }
                    break;
                }
                case 1: {
                    if (!ostriches.isEmpty()) {
                        animal = ostriches.elementAt(rand.nextInt(ostriches.size()));
                        check = false;
                    }
                    break;
                }
                case 2: {
                    if (!tigers.isEmpty()) {
                        animal = tigers.elementAt(rand.nextInt(tigers.size()));
                        check = false;
                    }
                    break;
                }
                case 3: {
                    if (!flamingos.isEmpty()) {
                        animal = flamingos.elementAt(rand.nextInt(flamingos.size()));
                        check = false;
                    }
                    break;
                }
            }

        }
        return animal;
    }
}
