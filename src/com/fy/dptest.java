package com.fy;

public class dptest {
	int getMostGold(int n, int w, int[] g, int[] p) {
		int[] preResults = new int [w+1];
		int[] results = new int [w+1];
		
		//���߽��ֵ
		for (int i=0; i<=w; i++) {
			if(i < p[0]) {
				preResults[i] = 0;
			} else {
				preResults[i] = g[0];
			}
		}
		
		//���ѭ��Ϊ����������ڲ�ѭ��Ϊ��������
		for (int i=0; i<n; i++) {
			for (int j=0; j<=w; j++) {
				if (j < p[i]) {
					results[j] = preResults[j];
				} else {
					results[j] = Math.max(preResults[j], preResults[j-p[i]] + g[i]);
				}
			}
		}
		
		return results[w];
	}
	
	public static void main(String[] args) {
		int n = 5, w = 10;
		int [] g = {500, 200, 300, 350, 400};
		int [] p = {5, 3, 4, 3, 5};
		System.out.println("�������" + new dptest().getMostGold(n, w, g, p) + "��");
	}
}
