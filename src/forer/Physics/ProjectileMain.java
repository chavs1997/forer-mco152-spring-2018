package forer.Physics;

public class ProjectileMain {

	public static void main(String[] args) {

		Projectile model = new Projectile(72, 23);

		for (int i = 1; i < 11; i++) {
			double x = model.getX(i);
			double y = model.getY(i);
			System.out.println("At time " + i + ", x is: " + x + ". And y is: " + y + ".");
		}
	}

}
