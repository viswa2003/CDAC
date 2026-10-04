package assignment_2;

public class BrokerageApp {
	
	public static void main(String[] args) {
		
		int[] prices = {7, 1, 5, 3, 6, 4};
		
		int bestProfit = 0;
		
		int currentProfit = 0;
		
		int minDay = -1;
		int sellDay = -1;	
		
		int minBuy = prices[0];
		
		for(int i = 0; i < prices.length; i++) {
			if(prices[i] < minBuy) {
				minBuy = prices[i];
				minDay = i;
			}
			currentProfit = prices[i] - minBuy;
			
			if(currentProfit > bestProfit) {
				bestProfit = currentProfit;
				sellDay = i;
			}
			
		}
		
		if(minDay == -1) {
			System.out.println("No profitable trade this month.");
		}else {			
			System.out.printf("Buy on day %d at %d, sell on day %d at %d, profit = %d", minDay + 1, minBuy, sellDay + 1, prices[sellDay], bestProfit);
		}
		
	}
}
