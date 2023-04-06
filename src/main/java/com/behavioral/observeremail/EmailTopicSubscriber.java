package com.behavioral.observeremail;

public class EmailTopicSubscriber implements Observer{

    private String name;
    private Subject topic;
    private Observer observer;

    public EmailTopicSubscriber(String name){
        this.name= name;
    }
    @Override
    public void update() {
       // Observer observer;
        //String msg = (String) topic.getUpdate(observer:this);
        //if(name == null){
          //  System.out.println(name + "No new message on this topic");
        //} else System.out.println(name+ "Retriving message: " +msg);
    }

    /**
     * @param subject
     */
    @Override
    public void setSubject(Subject subject) {
        this.topic= subject;
    }
}
