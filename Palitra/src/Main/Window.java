package Main;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class Window extends Frame implements ActionListener, MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1;

	public static double angle = 90, angle1 = 90;
    
    public double Mx = 170, My = 220;
    public int    Cx = 170, Cy = 220;
	
	private ArrayList<Ellipse2D> circle;
	private Ellipse2D current, after;
	private ArrayList<Double> ang;
	
	private int curRound = 0, state = 0;
	
	public int DeltaX = 170, DeltaY = 120;
	
	public static int 	DX1 = 170, DY1 = 110,
						DX3 = 170, DY3 = 110;
	
	public Point2D Delta = new Point2D() {
		
		public void setLocation(double x, double y) {
			DeltaX = (int) x;
			DeltaY = (int) y;
		}
		
		public double getY() {

			return DeltaY;
		}

		public double getX() {
			return DeltaX;
		}
	} ;

	Window(String title) {
		super(title);
		setLayout(null);

		Button Plus, Minus;
		add(Plus = new Button("+"));
		Plus.setBounds(300, 300, 20, 20);
		Plus.addActionListener(this);
		add(Minus = new Button("-"));
		Minus.setBounds(330, 300, 20, 20);
		Minus.addActionListener(this);

		circle=new ArrayList<Ellipse2D> ();
		ang = new ArrayList<Double> ();
		current=null;
		after =null;
		
		addMouseListener(this) ;
    	addMouseMotionListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public void paint(Graphics g) {
		super.paintComponents(g);	
		Graphic.PaintElements(getGraphics());
		paintComponent(getGraphics());
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2 = (Graphics2D) g;	// Приведение типов
//		if(state == 2){
//			
//			g2.rotate(Math.toRadians(90-angle1), Cx, Cy);
//		}
		
		for(int i = 0; i < circle.size(); i=i+2){	
			g2.setColor(new Color (255,255,255));
			if(state == 2){
				ang.add(i/2, angle1);
				g2.rotate(Math.toRadians(90-ang.get(i/2)), Cx, Cy);
				//ang.add(i/2, angle1);
			}
			//if(curRound != 0) {
			g2.rotate(Math.toRadians(90-ang.get(i/2)), Cx, Cy); //}
			g2.draw((Ellipse2D) circle.get(i));
			g2.draw((Ellipse2D) circle.get(i+1));	
			//System.out.println(curRound + " " +ang.get(i/2));
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		String b = ae.getActionCommand();
		if(b.equals("+")){
			Delta.setLocation(170, 120);
			angle1 = 90.0;
			add(Delta);
			///System.out.println(curRound + " " +ang.get(curRound));
			repaint();
		}
		else if(b.equals("-")){
			remove(current);
			remove(after);
			repaint();
		}
	}

	// Добавить в массив окружность
	public void add(Point2D p) {
		current = new Ellipse2D.Double(p.getX()-12, p.getY(),25,25);
		after = new Ellipse2D.Double(p.getX()-14, p.getY() -2,29,29);
		circle.add(current);
		circle.add(after);
		ang.add(curRound/2, angle1);
		//System.out.println(curRound + " " +ang.get(curRound/2));
		curRound = curRound + 2;	
	}
	
	//удалить окружность
	public void remove(Ellipse2D e) {
		//if (e==null) return;
		//if (e==current) current=null;
		circle.remove(e);
		if(curRound!= 0) curRound--;
		if(curRound== 0) return;
	}
	
	public void mousePressed(MouseEvent e) {
		
		if(e.getX()>=DX3-14 && e.getX()<=DX3+14 && e.getY()>=DY3-14 && e.getY()<=DY3+14){
			state = 1;
		} else 
		if(e.getX()>=DX1-10 && e.getX()<=DX1+10 && e.getY()>=DY1-10 && e.getY()<=DY1+10){
			state = 2;
		}
	}

	public void mouseReleased(MouseEvent e) {
		state = 0;
		repaint();
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseMoved(MouseEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
	
		if(state == 1){	
			Mx = e.getX();
			My = e.getY();		
			if(Mx < Cx && My > Cy){			// 3-я четверть
				angle = 270 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle);
			}else if(Mx < Cx && My < Cy){	// 2-я четверть
				angle = 90 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle);
			}else if(Mx > Cx && My < Cy){	// 1-я четверть
				angle = 90 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle);
			}else if(Mx > Cx && My > Cy){	// 4-я четверть						
				if(angle > 360.0)angle = 0.0;
				else angle = 270 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle);
			}else if(Mx>Cx && My == Cy){
				angle = 0;
			}
			repaint();
		} else if(state ==2){
			Mx = e.getX();
			My = e.getY();
			
			if(Mx < Cx && My > Cy){			// 3-я четверть
				angle1 = 270 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle1);
			}else if(Mx < Cx && My < Cy){	// 2-я четверть
				angle1 = 90 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle1);
			}else if(Mx > Cx && My < Cy){	// 1-я четверть
				angle1 = 90 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle1);
			}else if(Mx > Cx && My > Cy){	// 4-я четверть						
				if(angle1 > 360.0)angle1 = 0.0;
				else angle1 = 270 + Math.toDegrees(Math.atan((Cx-Mx)/(Cy - My)));
				//System.out.println(angle1);
			}else if(Mx>Cx && My == Cy){
				angle1 = 0;
			}
			repaint();
		}
		
	}



	
}
