class Solution {
      public int minCostConnectPoints(int[][] points) {
      int num_nodes  =  points.length;
      int x1, y1;
      int x2, y2;
      int dist;

      Map<Integer, List<Pair<Integer, Integer>>> adjList = new HashMap<>();
      for(int i=0; i<num_nodes; i++)
      {     x1 = points[i][0];
            y1 = points[i][1];
            if ((adjList.containsKey(i))==false) adjList.put(i, new ArrayList<>());
          for(int j=i+1; j<num_nodes; j++)
          {
            if ((adjList.containsKey(j))==false) adjList.put(j, new ArrayList<>());
            

            x2 = points[j][0];
            y2 = points[j][1];
            dist = Math.abs(x2-x1) + Math.abs(y2-y1);
            adjList.get(i).add(new Pair<>(dist, j));
            adjList.get(j).add(new Pair<>(dist, i));
            //System.out.println(adjList);
          }
      }
      int cost ;
      int node ;
      Pair<Integer, Integer> point; 
      int res =0 ;
      Set<Integer> visit = new HashSet<>();
      PriorityQueue<Pair<Integer, Integer>> minH = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
      minH.add(new Pair<>(0,0));
    while (visit.size()<num_nodes)
    {   point = minH.poll();
        cost = point.getKey();
        node = point.getValue();
        if(visit.contains(node))
        {
            continue;
        }
        res += cost;
        visit.add(node);
        for (Pair nei: adjList.get(node))
        {
            if (!visit.contains(nei.getValue()))
            {
                minH.add(nei);
            }
        }
        
    }
return res;
    }
}