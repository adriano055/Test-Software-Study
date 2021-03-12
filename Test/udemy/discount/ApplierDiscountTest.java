package udemy.discount;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ApplierDiscountTest {
	
	DiscountApplier discount;
	
	@Before
	public void setup() {
		discount = new DiscountApplier();
	}
	
	@Test
	public void macAndIphone() {
		Basket basket = new BasketBuilder()
				.w("MACBOOK", 100)
				.w("IPHONE", 50)
				.build();
				
		discount.apply(basket);
		
		double expected = (100 + 50) * 0.85;
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void notAndWinphone() {
		Basket basket = new BasketBuilder()
				.w("NOTEBOOK", 100)
				.w("WINDOWS PHONE", 50)
				.build();
				
		discount.apply(basket);
		
		double expected = (100 + 50) * (1 - 0.12);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void xbox() {
		Basket basket = new BasketBuilder()
				.w("XBOX", 100)
				.build();
				
		discount.apply(basket);
		
		double expected = (100) * (1 - 0.7);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void amontLess1000andQutItemsLessThan3Itens() {
		Basket basket = new BasketBuilder()
				.w("NOTEBOOK", 100)
				.w("REFRIGERATOR", 50)
				.build();
				
		discount.apply(basket);
		
		double expected = (100 + 50) * (1 - 0.02);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void amontMore3000andQutItemsBetween2and5() {
		Basket basket = new BasketBuilder()
				.w("NOTEBOOK", 100)
				.w("REFRIGERATOR", 50)
				.w("FREEZER", 2950)
				.build();
				
		discount.apply(basket);
		
		double expected = (100 + 50 + 2950) * (1 - 0.05);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void amontMore3000andQutItemsMoreThan4() {
		Basket basket = new BasketBuilder()
				.w("NOTEBOOK", 100)
				.w("REFRIGERATOR", 50)
				.w("FREEZER", 2950)
				.w("TV", 50)
				.build();
				
		discount.apply(basket);
		
		double expected = (100 + 50 + 2950 + 50) * (1 - 0.05);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void oneItemNoDiscount() {
		Basket basket = new BasketBuilder()
				.w("FREEZER", 2950)
				.build();
				
		discount.apply(basket);
		
		double expected = (2950);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void QutBetween2And5NoDiscount() {
		Basket basket = new BasketBuilder()
				.w("FREEZER", 1000)
				.w("TV", 100)
				.w("COMPUTER", 500)
				.build();
				
		discount.apply(basket);
		
		double expected = (1000 + 100 + 500);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
	
	@Test
	public void QutMoreThan4NoDiscount() {
		Basket basket = new BasketBuilder()
				.w("FREEZER", 1000)
				.w("TV", 100)
				.w("COMPUTER", 500)
				.w("GAME", 199)
				.w("FAN", 50)
				.build();
				
		discount.apply(basket);
		
		double expected = (1000 + 100 + 500 + 199 + 50);
		Assert.assertEquals(expected, basket.getAmount(), 0.0001);
	}
}
