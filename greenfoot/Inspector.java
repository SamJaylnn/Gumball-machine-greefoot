import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * class Inspector
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class Inspector extends Alien
{
    Message m = new Message();
    private ArrayList<Picker> pickers = new ArrayList<Picker>();
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
    
    public void addPicker(Picker obj) {
        pickers.add(obj);
    }
    
    public void removePicker(Picker obj) {
        pickers.remove(obj);
    }
    
    public void inspect(Coin coin) {
        System.out.println("Coin: " + coin.getClass());
        setMessage(coin.getClass().getName());
        int whichPicker = Greenfoot.getRandomNumber(pickers.size());
        Picker pickerChosen = pickers.get(whichPicker);
        System.out.println("Picker: " + pickerChosen.getClass());
        if (coin.getClass() == Quarter.class) {
            pickerChosen.pick();
        }
    }    
}
