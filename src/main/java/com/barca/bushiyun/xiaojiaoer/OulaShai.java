package com.barca.bushiyun.xiaojiaoer;

import java.util.Arrays;

public class OulaShai {
    public static void main(String[] args) {
        int n = 20;
        int[] isPrime = new int[n];
        int[] primes = new int[n];
        int count = 0;  //记录质数个数
        Arrays.fill(isPrime, 1); //初始假设所有数都是质数
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                primes[count++] = i;  //i是质数,存入质数数组
            }
            for (int j = 0; primes[j] * i < n; j++) {
                isPrime[primes[j] * i] = 0;  //两个数的积肯定不是质数
                if (i % primes[j] == 0) { //i遇到其最小质因数即退出，保证每个合数仅被筛选一次,且是被它的最小质因数筛出
                    break;
                }
            }
        }
        for (int i = 0; i < count; i++) {
            System.out.print(primes[i] + " ");
        }
    }

}
