class Solution {
  public int minEatingSpeed(int[] piles, int h)
  {
    int[] data = piles;
    Arrays.sort(data);

    int mid = 0;
    int max = data[data.length - 1];
    int min = 1;
    int res = max;

    int checker = 0;

    if (h < piles.length) {
      return -1;
    }

    while (min <= max) 
    {
      mid = (min + max) / 2;
      checker = 0;
      for (int i = 0; i < data.length; i++) {
        if (data[i] % mid == 0) {
          checker += data[i] * 1.0 / mid;
        } else {
          checker += (data[i] + (mid - (data[i] % mid))) * 1.0 / mid;
        }
      }

      if (checker > h) {
        min = mid + 1;
      } else {
        res = mid;
        max = mid - 1;
      }
    }

    return res;
  }
}