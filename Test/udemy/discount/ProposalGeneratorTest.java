package udemy.discount;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class ProposalGeneratorTest {
	private Clock fakeClock;
	private ProposalGenerator proposalGenerator;
	
	@Before
	public void setUp() {
		fakeClock = Mockito.mock(Clock.class);
		proposalGenerator = new ProposalGenerator(fakeClock);
	}
	
	public void createDate(int year, int mouth, int day) {
		Mockito.when(fakeClock.now()).thenReturn(new GregorianCalendar(year, mouth, day));
	}

	@Test
	public void discountWhenChristmas() {
			Basket basket = new BasketBuilder()
				.w("NOTE", 100)
				.build();

			createDate(2021, Calendar.DECEMBER, 25);
			Assert.assertEquals(100 * 0.15, proposalGenerator.calculateDiscount(basket), 0.0001);
	}
	
	@Test
	public void discountWhenJanuary() {
			Basket basket = new BasketBuilder()
				.w("NOTE", 50)
				.build();
			
			createDate(2021, Calendar.JANUARY, 05);
			Assert.assertEquals(50 * 0.05, proposalGenerator.calculateDiscount(basket), 0.0001);
	}
	
	@Test
	public void noDiscount() {
			Basket basket = new BasketBuilder()
				.w("NOTE", 75)
				.build();
			
			createDate(2021, Calendar.FEBRUARY, 15);
			Assert.assertEquals(75, proposalGenerator.calculateDiscount(basket), 0.0001);
	}
}
