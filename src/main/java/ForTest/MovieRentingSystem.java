package ForTest;

import java.util.*;

class MovieRentingSystem {
    long MAX1 = (long)9e10 + 1;
    long MAX2 = (long)3e5 + 1;
    Map<Integer, PriorityQueue<int[]>> movieMap = new HashMap<>(); // 未借出电影全集，以movie为维度区分, 懒删除
    Map<Long, Integer> priceMap = new HashMap<>(); // 电影价格映射，(shop, movie) -> prive
    PriorityQueue<int[]> borrowed = new PriorityQueue<>((a, b) -> { // 已借出电影全集,懒删除
        if (a[0] == b[0]) {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        }
        return a[0] - b[0];
    });
    Set<Long> borrowedSet = new HashSet<>(); // 已借出电影全集


    public MovieRentingSystem(int n, int[][] entries) {
        for(int[] e : entries) {
            int shop = e[0];
            int movie = e[1];
            int price = e[2];

            PriorityQueue<int[]> pq = movieMap.getOrDefault(movie, new PriorityQueue<>((a, b) -> {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }));
            pq.add(new int[]{price, shop});
            movieMap.put(movie, pq);

            priceMap.put(MAX2 * shop + movie, price);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> list = new ArrayList<>();
        if (!movieMap.containsKey(movie)) {
            return list;
        }

        PriorityQueue<int[]> pq = movieMap.get(movie);
        List<int[]> addList = new ArrayList<>();
        while (!pq.isEmpty() && list.size() < 5) {
            int[] pk = pq.poll();
            long mark =

        }


    }

    public void rent(int shop, int movie) {
        borrowed.add(new int[]{price, shop, movie});
        borrowedSet.add()
    }

    public void drop(int shop, int movie) {

    }

    public List<List<Integer>> report() {

    }
}
