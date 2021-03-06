package forer.physics;

public class Projectile {

	double angle;
	double velocity;

	public Projectile(double ang, double vel) {
		angle = Math.toRadians(ang);
		velocity = vel;
	}

	public double getX(double time) {

		return Math.cos(angle) * velocity * time;
	}

	public double getY(double time) {
		return Math.sin(angle) * velocity * time - (0.5 * 9.8 * time * time);
	}

	public void setAngle(double angle) {
		this.angle = Math.toRadians(angle);
	}

	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}
	

}
