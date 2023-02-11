package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class HWQUPC_Solution {
	
//	public void union_find(int n) {
//		int count = 0;
//
//		UF_HWQUPC uf = new UF_HWQUPC(n);
//		Random random = new Random();
//		// random.nextInt(max - min) + min;
//
//		for (int k = 0; k < n-1; k++) {
//			int i = random.nextInt(n-1);
//			int j = random.nextInt(n-1);
//			if (!uf.isConnected(i, j)) {
//				uf.connect(i, j);
//				count++;
//			}
//
//		}
//
//		System.out.println("count is : " + count);
//	}
//
//	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
//		HWQUPC_Solution hs=new HWQUPC_Solution();
//		int n=sc.nextInt();
//		System.out.println("Please enter initial array size "+n);
//		sc.close();
//		
//		for(int i=0;i<5;i++) {
//			System.out.println("For N="+n);
//			Stopwatch target = new Stopwatch();
//			hs.union_find(n);
//			long milliseconds=target.lap();
//			System.out.println("Time taken for N="+n+" is : "+milliseconds);
//			target.close();
//			n*=2;
//		}
//	} 
	static int union=0;
	 public static int count(int n) {
	        int pairs = 0;
	        UF_HWQUPC uf = new UF_HWQUPC(n);
	        Random random = new Random();
	        while(uf.components()>1) {
	        	int i = random.nextInt(n);
	            int j = random.nextInt(n);
	            pairs++;
	            if (!uf.isConnected(i, j)) {
	                uf.connect(i, j);
	                union++;
	            }
	            
	        }
	        return pairs;
	    }

	    public static void printConnections(int runs, int interval, int upperBound) {
	        for (int i = interval; i <= upperBound; i = i+interval) {
	            int total = 0;
	            for (int j = 0; j < runs; j++) {
	                total+=count(i);
	            }
	            System.out.println("Number of connection generated for " + i + " sites - " + total/runs);
	            System.out.println("Number of Unions for "+i+" sites - "+union/runs); //because we are running for 1000 times
	            union=0;
	        }
	    }
	    public static void main(String[] arg) {
//	        // Accept input from command line
//	        Scanner sc= new Scanner(System.in);
//	        int n=sc.nextInt();
	//
//	        System.out.println("Number of connection generated for " + n + " sites - "+ count(n));
//	        sc.close();
	        printConnections(1000, 250, 1500);
	    }
}
