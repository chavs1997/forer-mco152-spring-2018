package forer.physics;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProjectileTest {

	@Test
	public void getXTest() {
		Projectile proj = new Projectile(72, 23);
		double xAtTime = proj.getX(4);

		assertEquals(28.42, xAtTime, 0.1);

	}

	@Test
	public void getYTest() {
		Projectile proj = new Projectile(72, 23);
		double yAtTime = proj.getY(6);

		assertEquals(-45.1542, yAtTime, 0.1);

	}

}
