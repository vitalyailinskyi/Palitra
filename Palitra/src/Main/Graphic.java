package Main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;

public class Graphic{

	public static void MyFullPalitra(Graphics g){
	 ////// ПРОФЕССИОНАЛЬНАЯ ВЕРСИЯ ОТ ИЛЬИНСКОГО - Радужная окружность(Very High Skill)!!!!  
		for(int i = 0 ; i <= 360;i++){
			if(i>=0 && i<60){
				for(int j = 0; j <= 255; j++){
				g.setColor(new Color(255, 0, j));
				g.fillArc(70, 120, 200, 200, (i*j/255)*60/60, (61 - i*j/255)*60/60);
				}
			} else if(i>=60 && i<120){
				for(int j = 0; j <= 255; j++){
				g.setColor(new Color(255-j, 0, 255));
				g.fillArc(70, 120, 200, 200, 60 + (i*j/255)*60/120, (121 - i*j/255)*60/120);
				}
			} else if(i>=120 && i<180){
				for(int j = 0; j <= 255; j++){
				g.setColor(new Color(0, j, 255));
				g.fillArc(70, 120, 200, 200, 120 + (i*j/255)*60/180, (181 - i*j/255)*60/180);
				}
			} else if(i>=180 && i<240){
				for(int j = 0; j <= 255; j++){
					g.setColor(new Color(0, 255, 255-j));
				g.fillArc(70, 120, 200, 200, 180 + (i*j/255)*60/240, (241 - i*j/255)*60/240);
				}
			} else if(i>=240 && i<300){
				for(int j = 0; j <= 255; j++){
				g.setColor(new Color(j, 255, 0));
				g.fillArc(70, 120, 200, 200, 240 + (i*j/255)*60/300, (301 - i*j/255)*60/300);
				}
			} else if(i>=300 && i<360){
				for(int j = 0; j <= 255; j++){
					g.setColor(new Color(255, 255-j, 0));
				g.fillArc(70, 120, 200, 200, 300 + (i*j/255)*60/360, (361 - i*j/255)*60/360);
				}
			}
		}
		//   ОКОНЧАНИЕ ПРОФЕССИОНАЛЬНОЙ ВЕРСИИ //////	
	}

	public static void MyFastPalitra(Graphics g){
			//	Ускоренная профессиональная версия
 		for(int i = 0 ; i <= 360;i++){
			if(i>=0 && i<60){
				for(int j = 0; j <= 255; j=j+25){
				g.setColor(new Color(255, 0, j));
				g.fillArc(70, 120, 200, 200, (i*j/255)*60/60, (61 - i*j/255)*60/60);
				}
			} else if(i>=60 && i<120){
				for(int j = 0; j <= 255; j=j+25){
				g.setColor(new Color(255-j, 0, 255));
				g.fillArc(70, 120, 200, 200, 60 + (i*j/255)*60/120, (121 - i*j/255)*60/120);
				}
			} else if(i>=120 && i<180){
				for(int j = 0; j <= 255; j=j+25){
				g.setColor(new Color(0, j, 255));
				g.fillArc(70, 120, 200, 200, 120 + (i*j/255)*60/180, (181 - i*j/255)*60/180);
				}
			} else if(i>=180 && i<240){
				for(int j = 0; j <= 255; j=j+25){
					g.setColor(new Color(0, 255, 255-j));
				g.fillArc(70, 120, 200, 200, 180 + (i*j/255)*60/240, (241 - i*j/255)*60/240);
				}
			} else if(i>=240 && i<300){
				for(int j = 0; j <= 255; j=j+25){
				g.setColor(new Color(j, 255, 0));
				g.fillArc(70, 120, 200, 200, 240 + (i*j/255)*60/300, (301 - i*j/255)*60/300);
				}
			} else if(i>=300 && i<360){
				for(int j = 0; j <= 255; j=j+25){
					g.setColor(new Color(255, 255-j, 0));
				g.fillArc(70, 120, 200, 200, 300 + (i*j/255)*60/360, (361 - i*j/255)*60/360);
				}
			}
		}
	}

	public static void PaintElements(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
	
		int Deltax[] = {160, 180, 170};
		int Deltay[] = {95, 95, 120};

		//int Delta1[] = {Window.DX1-11, Window.DX1+11, Window.DX1+11, Window.DX1-11};
		//int Delta2[] = {Window.DY1-11, Window.DY1-11, Window.DY1+11, Window.DY1+11};
		
		Window.DX3 = (int) (170 + (170 - 170) * Math.cos(Math.toRadians(90-Window.angle)) - (120 - 230) * Math.sin(Math.toRadians(90-Window.angle)));
		Window.DY3 = (int) (220 + (120 - 230) * Math.cos(Math.toRadians(90-Window.angle)) + (170 - 170) * Math.sin(Math.toRadians(90-Window.angle)));		
		Window.DX1 = (int) (170 + (170 - 170) * Math.cos(Math.toRadians(90-Window.angle1)) - (120 - 205) * Math.sin(Math.toRadians(90-Window.angle1)));
		Window.DY1 = (int) (220 + (120 - 205) * Math.cos(Math.toRadians(90-Window.angle1)) + (170 - 170) * Math.sin(Math.toRadians(90-Window.angle1)));		
		
		//g.setColor(new Color(255, 255,255));
		//g.fillPolygon(Delta1, Delta2, 4);
		
		// Вращение на угол смещения мыши		
			g2.rotate(Math.toRadians(90-Window.angle), 170, 220);	
			
	 		try {
				ImageInsert.Image(g);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
	 		
			//Graphic.MyFastPalitra(g); 
			//Graphic.MyFullPalitra(g);
	 		
	 		
		// Трегугольник - Дельта
			g.setColor(new Color(160, 160, 160));		
			g.fillPolygon(Deltax, Deltay, 3);
	}

	@SuppressWarnings("unused")
	private void test(){
//      Graphics2D g2 = (Graphics2D) g;
////		try {
////			Image(getGraphics());
////			
////		} catch (IOException e) {
////			e.printStackTrace();
////		}
//		
//		g.setColor(new Color(131, 43, 255));
//		g.fillOval(70, 120, 200, 200);
//	
//		int Deltax[] = {160, 180, 170};
//		int Deltay[] = {95, 95, 120};
//
//		int Delta1[] = {DX3-15, DX3+15, DX3+15, DX3-15};
//		int Delta2[] = {DY3-15, DY3-15, DY3+15, DY3+15};
//		
//		/*long tm = System.currentTimeMillis();
//	    double angle = System.currentTimeMillis() - tm/1.0003;  
//	    DeltaX = (int) (170 + (130 - 170) * Math.cos(angle) - (130 - 220) * Math.sin(angle));
//		DeltaY = (int) (220 + (130 - 220) * Math.cos(angle) + (130 - 170) * Math.sin(angle));
//		System.out.println(DeltaX + " " + DeltaY);*/
//		
////		DX1 = (int) (170 + (160 - 170) * Math.cos(angle) - (95 - 220) * Math.sin(angle));
////		DY1 = (int) (220 + (95 - 220) * Math.cos(angle) + (160 - 170) * Math.sin(angle));
////		DX2 = (int) (170 + (180 - 170) * Math.cos(angle) - (95 - 220) * Math.sin(angle));
////		DY2 = (int) (220 + (95 - 220) * Math.cos(angle) + (180 - 170) * Math.sin(angle));
//	    DX3 = (int) (170 + (170 - 170) * Math.cos(Math.toRadians(90-angle)) - (120 - 230) * Math.sin(Math.toRadians(90-angle)));
//		DY3 = (int) (220 + (120 - 230) * Math.cos(Math.toRadians(90-angle)) + (170 - 170) * Math.sin(Math.toRadians(90-angle)));		
//		
//			g.setColor(new Color(255, 255,255));
//			g.fillPolygon(Delta1, Delta2, 4);
//		
//		// Вращение на угол смещения мыши		
//			g2.rotate(Math.toRadians(90-angle), 170, 220);	
//			
//		// Трегугольник - Дельта
//			g.setColor(new Color(160, 160, 160));		
//			g.fillPolygon(Deltax, Deltay, 3);
//					
//		// Построение окружности
//			g2.setColor(new Color(255, 0, 0));
//			g2.fillArc(70, 120, 200, 200, -90, 180);
//			g2.setColor(new Color(255, 255, 0));
//			g2.fillArc(70, 120, 200, 200, 90, 180);
//			
		
			//Graphic.MyFastPalitra(g);
			//Graphic.MyFullPalitra(g);
		
//		// Круг по середине
//			g.setColor(getBackground());
//			g.fillOval(95, 145, 150, 150);	
	}
}
