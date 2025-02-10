import java.awt.*;
public class Doodle {
    public static void main(String[] args) {
        DrawingPanel panel = new DrawingPanel(500, 500);
        Graphics pen = panel.getGraphics();

        //Sky
        drawSky(pen);
        //Sun
        drawSun(pen);
        //  Rays
        drawRays(pen);
        //Mountains
        drawMountains(pen);
         //Soil/Land
         drawLand(pen);
    }

    public static void drawSun(Graphics pen){
        pen.setColor(Color.YELLOW);
        pen.fillOval(155, 100, 150, 150);
    }
    
    public static void drawRays(Graphics pen){
        pen.drawLine(230, 90, 230, 50);
        pen.drawLine(255, 95, 270, 54);
        pen.drawLine(205, 94, 190, 54);
        pen.drawLine(277, 104, 304, 70);
        pen.drawLine(183, 104, 156, 70);
    }

    public static void drawMountains(Graphics pen){
        pen.setColor(new Color(22, 125, 16));
        pen.fillOval(200, 50, 420, 600);
        pen.setColor(new Color(44,158,38));
        pen.fillOval(-160, 50, 420, 600);
    }

    public static void drawLand(Graphics pen){
        int r = 115;
        int gb = 77;
        int y = 300;
        for(int i = 0; i < 4; i++){
            pen.setColor(new Color(r, gb, gb));
            pen.fillRect(0, y, 500, 200);
            y += 50;
            r -= 8;
            gb -= 8;
        }
    }

    public static void drawSky(Graphics pen){
        int r = 153;
        int g = 236;
        int b = 255;
        int height = 100;
        for(int i = 0; i < 6; i++){
            pen.setColor(new Color(r, g, b));
            if (i == 0) {
                pen.fillRect(0, 0, 500, 500); 
            }else{
                pen.fillRect(0, 0, 500, height);
                height -= 20;
            }
            r -= 30;
            g -= 30;
            b -= 30;
        }
    }
}