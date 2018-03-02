package forer.physics;

import static org.junit.Assert.*;
import org.junit.Test;

import forer.physics.Projectile;

public class ProjectileTest {

//	@Test
//	public void getXTest() {
//		Projectile proj = new Projectile(72, 35);
//		double xAtTime = proj.getX(10);
//
//		assertEquals(0, xAtTime, 0.1);
//
//	}

	@Test
	public void getYTest() {
		Projectile proj = new Projectile(72, 35);
		double yAtTime = proj.getY(10);

		assertEquals(-490.0, yAtTime, 0.1);

	}

}
