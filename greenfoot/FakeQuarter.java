import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class FakeQuarter
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class FakeQuarter extends Quarter
{
    public void moveBack() {
        setLocation(100, 300);
    }
    public FakeQuarter()
    {
        GreenfootImage image = getImage() ;
        image.scale( 75, 75 ) ;
        value = 25;
        isReal = false;
    }
}
