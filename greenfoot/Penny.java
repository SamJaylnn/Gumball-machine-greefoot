import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * class Penny
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class Penny extends Coin
{   
    public void moveBack() {
        setLocation(100, 100);
    }
    public Penny()
    {
        GreenfootImage image = getImage() ;
        image.scale( 50, 50 ) ;
        value = 1;
        isReal = true;
    }
}
