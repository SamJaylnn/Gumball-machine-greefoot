import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * class GreenPicker
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class GreenPicker extends Picker
{
    public void pick() 
    {
        World world = getWorld();
        Gumball gb = new GreenGumball();
        world.addObject(gb, 500, 500);
    }    
}
