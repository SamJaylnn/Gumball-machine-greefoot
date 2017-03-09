import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class Quarter
 * 
 * @ Shuzhong Chen 
 * @ 3/5/2017
 */
public class Quarter extends Coin
{
    public void moveBack() {
        setLocation(100, 200);
    }
    public Quarter()
    {
        GreenfootImage image = getImage() ;
        image.scale( 80, 80 ) ;
        this.value = 25;
        this.isReal = true;
    }
  
}
