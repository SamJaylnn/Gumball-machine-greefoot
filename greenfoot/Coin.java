import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class Coin
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class Coin extends Actor
{
    boolean isReal;
    int value;

    public Coin() {
        this.isReal = true;
        this.value = 0;
    }
    
    public int getValue() {
        return value;
    }
    
    public boolean isReal() {
        return isReal;
    }
    
    public void act() 
    {
        int mouseX, mouseY ;
        
        if(Greenfoot.mouseDragged(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            mouseX = mouse.getX();  
            mouseY = mouse.getY();  
            setLocation(mouseX, mouseY);  
        } 
    }    
    
    public int inSlot() {
        if (this.value == 25 && this.isReal) {
            return 1;
        } else if (!this.isReal) {
            return 2;
        } else {
            return 3;
        }
        
    }
    
     public void moveBack() {
        setLocation(100, 200);
    }
    
     public void setMessage(String msg)
    {
        int mouseX, mouseY;
        Message m = new Message();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        mouseX = mouse.getX();
        mouseY = mouse.getY();
        World world = getWorld();
        if(m.getWorld() != null) {
            world.removeObject(m);
        }
        world.addObject(m, mouseX, mouseY);
        m.setText(msg);
        Greenfoot.delay(50);
        world.removeObject(m);
    }
}
