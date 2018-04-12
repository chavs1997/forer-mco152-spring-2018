package forer.physics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class ProjectileGraph extends JComponent {

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);		
	    g.setColor(Color.BLACK);
		g.translate(0, getHeight());
		drawGridLines(g);
		
		g.setColor(Color.RED);
		Projectile projectile = new Projectile(50, 100);
		drawProjectile(g, projectile);
		
		g.setColor(Color.BLUE);
		Projectile projectile2 = new Projectile(45, 78);
		drawProjectile(g, projectile2);
		
		g.setColor(Color.ORANGE);
		Projectile projectile3 = new Projectile (30, 49);
		drawProjectile(g, projectile3);
		
	}

		public void drawGridLines(Graphics g) {
			for (int i = 0; i < this.getWidth(); i += 50) {
				g.drawLine(0, -i, this.getWidth(), -i);
				g.drawLine(i, -0, i, -this.getHeight());
			}
		}
		
		public void drawProjectile(Graphics g, Projectile proj) {
			ArrayList<Integer> pointsX = new ArrayList<Integer>();
			ArrayList<Integer> pointsY = new ArrayList<Integer>();
			int pointX;
			int pointY;
			
			for(double i = 1; i <= 25; i++) {
				pointX = (int)proj.getX(i);
				pointY = (int)proj.getY(i);
				pointsX.add(pointX);
				pointsY.add(pointY);
			}
			
			for (int i = 0; i < pointsX.size(); i++) {
		         int x = pointsX.get(i);
		         int y = pointsY.get(i);
		         int ovalW = 10;
		         int ovalH = 10;
		         g.fillOval(x, -y - 200, ovalW, ovalH);
		         g.drawString("(" + x + ", " + y + ")", x, -y - 200);
		      }
			
			
			for (int i = 0; i < pointsX.size() - 1; i++) {
			          int x1 = pointsX.get(i);
			          int y1 = pointsY.get(i) + 200;
			          int x2 = pointsX.get(i + 1);
			          int y2 = pointsY.get(i + 1) + 200;
			          g.drawLine(x1, -y1, x2, -y2);         
			       }
			     
			}
		
		
	}
