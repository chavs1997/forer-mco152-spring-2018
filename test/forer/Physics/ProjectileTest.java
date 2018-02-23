package forer.Physics;

import static org.junit.Assert.*;

import org.junit.Test;

import forer.Physics.Projectile;

public class ProjectileTest {

	@Test
	public void test() {
		Projectile model = new Projectile(72, 23);
		double xAtTime = 7.107390870623791;
		assertEquals(xAtTime, model.getX(1));
		assertEquals(21.522899624365586, model.getY(3));
		
	}

}
