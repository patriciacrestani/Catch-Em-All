package oopgame.gadgets;

public class Timer {
    private double time;
    private double goal;
    private boolean stop;
    
    public Timer(double goal){
        this.goal = goal;
        time = 0;
        stop = false;
    }
    
    public void setTime(double time){
        this.time = time;
    }
    
    public double getTime(){
        return time;
    }
    
    public void setGoal(double goal){
        this.goal = goal;
    }
    
    public void reset(){
        time = 0;
    }
    
    public void tick(double dt){
        if (!stop)
            time += dt;
    }
    
    public boolean isReady(){
        return time > goal;
    }
    
    public void stopTimer(){
        stop = true;
        reset();
    }
}
