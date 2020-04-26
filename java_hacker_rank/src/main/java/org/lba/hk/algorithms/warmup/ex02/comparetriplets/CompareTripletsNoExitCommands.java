package org.lba.hk.algorithms.warmup.ex02.comparetriplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareTripletsNoExitCommands {

	private static final Scanner scanner = new Scanner(System.in);

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		return result;
	}


	public static void main(String[] args) throws IOException, URISyntaxException {

		System.out.println("** CompareTripletNoExitCommands: using input from user - START **");

		/*1. Configure the out writer*/
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		/**/
		String[] aItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> a = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int aItem = Integer.parseInt(aItems[i]);
			a.add(aItem);
		}

		String[] bItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		List<Integer> b = new ArrayList<>();

		for (int i = 0; i < 3; i++) {
			int bItem = Integer.parseInt(bItems[i]);
			b.add(bItem);
		}

		List<Integer> result = compareTriplets(a, b);

		for (int i = 0; i < result.size(); i++) {
			bufferedWriter.write(String.valueOf(result.get(i)));

			if (i != result.size() - 1) {
				bufferedWriter.write(" ");
			}
		}

		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();

		System.out.println("** CompareTripletNoExitCommands: using input from user - END **");
	}
	/**/
}
