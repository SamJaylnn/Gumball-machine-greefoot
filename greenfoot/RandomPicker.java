import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * class RandomPicker
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class RandomPicker extends Picker
{
    public void pick() 
    {
        Gumball gb = new GreenGumball();
        int lottery = Greenfoot.getRandomNumber(3);
        switch(lottery)
        {
            case 0: gb = new BlueGumball(); break;
            case 1: gb = new RedGumball(); break;
            case 2: gb = new GreenGumball(); break;            
        }
        World world = getWorld();
        world.addObject(gb, 500, 500);
    }
}
