package beaconsOfGondor;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class LocateMinasTirithTest {

	@Test
	public void test1() {
		assertEquals(new HashSet<Integer>(Arrays.asList(0)), LocateMinasTirith.getGoodLocations(1, "1"));
	}

	@Test
	public void test2() {
		assertEquals(new HashSet<Integer>(Arrays.asList(0, 1)), LocateMinasTirith.getGoodLocations(2, "1111"));
	}

	@Test
	public void test3() {
		assertEquals(new HashSet<Integer>(Arrays.asList(0, 1, 2)), LocateMinasTirith.getGoodLocations(3, "111111111"));
	}

	@Test
	public void test4() {
		assertEquals(new HashSet<Integer>(Arrays.asList(0)), LocateMinasTirith.getGoodLocations(3, "111110101"));
	}

	@Test
	public void test5() {
		assertEquals(new HashSet<Integer>(Arrays.asList(1, 3)),
				LocateMinasTirith.getGoodLocations(4, "1101 1111 0111 1111".replaceAll("\\s", "")));
	}

	@Test
	public void test6() {
		assertEquals(new HashSet<Integer>(Arrays.asList(2)),
				LocateMinasTirith.getGoodLocations(5, "11100 11100 11111 00111 00111".replaceAll("\\s", "")));
	}

	@Test
	public void test7() {
		assertEquals(new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4)),
				LocateMinasTirith.getGoodLocations(5, "10101 01110 11110 01111 10011".replaceAll("\\s", "")));
	}

}