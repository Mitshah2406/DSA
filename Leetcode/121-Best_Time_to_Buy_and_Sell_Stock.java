class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> map = new HashMap<>();
        // return bruteForce(prices);
        return singlePass(prices);
        // return recursiveTLE(prices,0,prices.length-1);
        //return memo(prices,0,prices.length-1,map);
        
    }
    
    public int bruteForce(int [] prices){
        int maxProfit = 0;
        int n = prices.length;
        for(int i=0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                if(prices[j]>prices[i]){
                    maxProfit = Math.max(maxProfit,prices[j]-prices[i]);    
                }
            }
        }
        return maxProfit;
    }
    
    public int singlePass(int[] prices){
        int maxProfit = 0;
        int n = prices.length;
        if(n<=1)
            return maxProfit;
        
        int sell = prices[n-1];
        
        for(int i=n-2;i>=0;i--){
            if(prices[i]<sell){
                maxProfit = Math.max(maxProfit,sell-prices[i]);
            }
            else
                sell = prices[i];
        }
        
        return maxProfit;
        
    }
    
    public int recursiveTLE(int[] prices,int buy,int sell){
        //only 1 element left or no elements left..
        if(buy>=sell)
            return 0;
        
       int profit = prices[sell]-prices[buy];
        
        return Math.max(profit<0?0:profit,Math.max(recursiveTLE(prices,buy+1,sell),recursiveTLE(prices,buy,sell-1)));
    }
    
    
    
    public int memo(int[] prices,int buy,int sell,Map<String,Integer> map){
        //only 1 element left or no elements left..
        String state = buy+"-"+sell;
        if(map.containsKey(state)){
            return  map.get(state);
        }
        
        if(buy>=sell)
            return 0;
        
       int profit = prices[sell]-prices[buy];
        
        int result= Math.max(profit<0?0:profit,Math.max(memo(prices,buy+1,sell,map),memo(prices,buy,sell-1,map)));
        map.put(state,result);
        return result;
    }

}