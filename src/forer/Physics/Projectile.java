package forer.Physics;

public class Projectile {

	double angle;
	double velocity;

	public Projectile(double ang, double vel) {
		angle = Math.toRadians(ang);
		velocity = vel;
	}

	public double getX(int time) {

		return Math.cos(angle) * velocity * time;
	}

	public double getY(int time) {
		return Math.sin(angle) * velocity * time - (0.5 * 9.8 * time * time);
	}

}
