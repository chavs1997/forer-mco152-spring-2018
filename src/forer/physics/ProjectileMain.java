package forer.physics;

public class ProjectileMain {

	public static void main(String[] args) {

		Projectile model = new Projectile(50, 100);

		for (int i = 1; i < 11; i++) {
			double x = model.getX(i);
			double y = model.getY(i);
			System.out.println("At time " + i + ", x is: " + x + ". And y is: " + y + ".");
		}
	}

}
