package mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {

    private List<Person> people = new ArrayList<>();


    public void join(Person p){

        String joiningMessage= p.getName()+"Joins the room";
        broadCast("room",joiningMessage);
        people.add(p);
    }

    public void broadCast(String source, String message){

        for(Person person:people){

            if(!person.getName().equals(source)){

                person.receive(source,message);
            }
        }

    }

    public void message(String source,String destination,String message){

        people.stream()
                .filter(person->person.getName().equals(destination))
                .findFirst()
                .ifPresent(person->person.receive(source,message));

    }
}

class Person{

    private String name;
    private List<String> chatLog = new ArrayList<>();

    public ChatRoom chatRoom ;

    public Person(String name ){

        this.name= name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void receive(String sender,String message){

        String s= sender +":-> '"+ message+"'";
        System.out.println("["+name+"'s chat session"+s);
        chatLog.add(s);
    }

    public void say(String message){

        chatRoom.broadCast(name ,message);
    }

    public void privateMessage(String who,String message){

        chatRoom.message(name,who,message);

    }

}

class Demo{
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoom();

        Person john = new Person("John");
        Person jane = new Person("Jane");
        Person simon = new Person("Simon");


        chatRoom.join(john);
        chatRoom.join(jane);

        john.say("Hi room");
        jane.say("oh hey John");

        chatRoom.join(simon);

        simon.say("Hi everyone !");

        jane.privateMessage("Simon","Glad you joined us!");

    }
}

