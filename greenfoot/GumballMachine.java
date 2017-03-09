import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * class GumballMachine
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class GumballMachine extends Actor
{
   
    Actor haveCoin;
    Actor readyToCrank;
    Message m = new Message();
    public GumballMachine()
    {
        GreenfootImage image = getImage() ;
        image.scale( 350, 400 ) ; 
    }
    
    public void getGumball() {
        World world = getWorld();
        Inspector inspector = new Inspector();
        List<RandomPicker> randomPicker = world.getObjects(RandomPicker.class);
        List<GreenPicker> greenPicker = world.getObjects(GreenPicker.class);
        int whichpicker = Greenfoot.getRandomNumber(2);
        if(whichpicker == 1) {
            Picker picker = greenPicker.remove(0);
            inspectMove("Green Picker!");
            Greenfoot.delay(30);
            pickerAction(picker, "GreenPicker");
        } else {
            Picker picker = randomPicker.remove(0);
            inspectMove("Random Picker!");
            Greenfoot.delay(30);
            pickerAction(picker, "RandomPicker");
        }
        Greenfoot.delay(100);
        clear();
        haveCoin = null;
        readyToCrank = null;
    }
    
    public void setMessage(String msg)
    {
        int mouseX, mouseY;
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mouseX = mouse.getX();
        mouseY = mouse.getY();
        World world = getWorld();
        if(m.getWorld() != null) {
            world.removeObject(m);
        }
        world.addObject(m, mouseX, mouseY);
        m.setText(msg);
    }
    
    public void removeCoin(Actor coin)
    {
        World world = getWorld();
        world.removeObject(coin);
    }
    
    public void inspectMove(String msg) {
        Inspector inspector;
        inspector = (Inspector)this.getOneIntersectingObject(Inspector.class);
        inspector.setLocation(233, 390);
        
        Message m2 = new Message();
        World world = getWorld();
        if(m.getWorld() != null) {
            world.removeObject(m);
        }
        world.addObject(m2, 233, 290);
        m2.setText(msg);
        Greenfoot.delay(100);
        world.removeObject(m2);
        inspector.setLocation(600, 290);
    }
    
    
    public void pickerAction(Picker picker, String str) {
        int x = picker.getX();
        int y = picker.getY();
        picker.setLocation(233, 390);
        Message m2 = new Message();
        World world = getWorld();
        if(m.getWorld() != null) {
            world.removeObject(m);
        }
        world.addObject(m2, 233, 290);
        m2.setText("I'm " + str);
        Greenfoot.delay(100);
        m2.setText("Pick your gumball!");
        picker.pick();
        Greenfoot.delay(100);
        world.removeObject(m2);
        picker.setLocation(x, y);
    }
    
    public void clear() {
        World world = getWorld();
        List<Gumball> gumball = world.getObjects(Gumball.class);
        Gumball gb = gumball.remove(0);
        world.removeObject(gb);
    }
    
    public void act() 
    {   
        if(Greenfoot.mousePressed(this)) {
            if(haveCoin == null) {
                setMessage("No Coin in Slot!");
            } else {
                setMessage("Crank Turned!");
                getGumball();
            }
        }
        
        Actor coin = getOneObjectAtOffset(+10, +10, Coin.class);
        if(coin != null) {
            if(haveCoin != null) {
                setMessage("Have Coin!");
                coin.move(-300);
                removeCoin(coin);
            } else {
                haveCoin = coin;
                switch(((Coin)coin).inSlot()) {
                    case 1: inspectMove("Have Coin!");
                            readyToCrank = haveCoin;
                            break;
                    case 2: inspectMove("Fake Coin!");
                            haveCoin = null;
                            break;
                    default: inspectMove("Not Quarter!");
                            haveCoin = null;
                            break;
                }
                removeCoin(coin);
            }
        }
    }
    

}
