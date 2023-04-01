public abstract class Graphic {
    
    
    protected int[] xPoints, yPoints;
    
    public void move(int xOffset, int yOffset ) {
        
        for (int i = 0; i < xPoints.length; i++) {
            xPoints[i] = xPoints[i] + xOffset;
        }
        
        for (int i = 0; i < yPoints.length; i++) {
            yPoints[i] = yPoints[i] + yOffset;
        }
        
    }
    
    public abstract void draw();
    
}