package _力扣;

/**
 * @Author:Tod
 * @Description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），
 * 设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，
 * 在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * [7,3,5,1,6,4]
 * [7,3,6,1,5,4]
 * @Date: Create in 16:14 2019/10/4
 * @ModifiedBy:
 */
public class _07买卖股票的最佳时机 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7, 6, 4, 3, 1};
//        int[] prices = {1, 2, 4};
//        int[] prices = {3, 2, 6, 5, 0, 3};
//        int[] prices = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};
        System.out.println(maxProfitⅡ2(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minIndex = 0;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            } else if (prices[i] - prices[minIndex] > max) {
                max = prices[i] - prices[minIndex];
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            if (min > price) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }

    //    买卖股票的最佳时机 II
//    给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
//    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

    //    输入: [7,1,5,3,6,4]
//    输出: 7
//    解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//    随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    public static int maxProfitⅡ(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        int sum = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] - min > max) {
                max = prices[i] - min;
                if (i < prices.length - 1 && prices[i] > prices[i + 1] || i == prices.length - 1) {
                    sum += max;
                    min = prices[i];
                }
                max = 0;
            } else if (prices[i] < min) {
                min = prices[i];
            }
        }
        return sum;
    }

    public static int maxProfitⅡ2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int money = 0,buy,sale;
        for (int i = 0; i < prices.length-1; i++) {
            buy = prices[i];
            sale = prices[i+1];
            if (sale>buy){
                money+=sale - buy;
            }
        }
        return money;
    }
}
