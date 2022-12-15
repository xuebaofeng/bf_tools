package com.xue.amazon;

import java.util.*;

public class NearestCity {


	private static int dist(Map<String, Integer> pointToIndex, int[] xCoordinates, int[] yCoordinates,
													String p1, String p2){
		int index1 = pointToIndex.get(p1);
		int index2 = pointToIndex.get(p2);

		return Math.abs(xCoordinates[index1] - xCoordinates[index2]) + Math.abs(yCoordinates[index1] - yCoordinates[index2]);
	}

	public static String[] findNearest(String[] points, int[] xCoordinates, int[] yCoordinates, String[] queries){

		long start = System.currentTimeMillis();

		Map<Integer, List<String>> xToPoint = new HashMap<>();
		Map<Integer, List<String>> yToPoint = new HashMap<>();
		Map<String, Integer> pointIndex = new HashMap<>();
		int numOfPoints = points.length;
		int numOfQueries = queries.length;

		for(int i = 0; i < numOfPoints; i++){
			xToPoint.putIfAbsent(xCoordinates[i], new ArrayList<>());
			yToPoint.putIfAbsent(yCoordinates[i], new ArrayList<>());
			xToPoint.get(xCoordinates[i]).add(points[i]);
			yToPoint.get(yCoordinates[i]).add(points[i]);
			pointIndex.put(points[i], i);
		}

		String[] result = new String[numOfQueries];
		for(int i = 0; i < numOfQueries; i++){
			String queryPoint = queries[i];
			int pointIndexAtPoints = pointIndex.get(queryPoint);
			int qeryX = xCoordinates[pointIndexAtPoints];
			int qeryY = yCoordinates[pointIndexAtPoints];

			List<String> xNeighbor = xToPoint.get(qeryX);
			List<String> yNeighbor = yToPoint.get(qeryY);

			if(xNeighbor.size() == 1 && yNeighbor.size() == 1){
				result[i] = null;
				continue;
			}

			int minDistance = Integer.MAX_VALUE;
			String minPoint = "";

			for(String xNei: xNeighbor){
				if(xNei.equalsIgnoreCase(queryPoint))
					continue;

				int dist = dist(pointIndex, xCoordinates, yCoordinates, xNei, queryPoint);
				if(dist < minDistance){
					minDistance = dist;
					minPoint = xNei;
				}
			}

			for(String yNei: yNeighbor){
				if(yNei.equalsIgnoreCase(queryPoint))
					continue;

				int dist = dist(pointIndex, xCoordinates, yCoordinates, yNei, queryPoint);
				if(dist < minDistance){
					minDistance = dist;
					minPoint = yNei;
				}
			}
			result[i] = minPoint;
		}

		System.out.println(System.currentTimeMillis() - start);

		return result;
	}

	public static String[] findNearest1(String[] points, int[] xCoordinates, int[] yCoordinates, String[] queries){

		long start = System.currentTimeMillis();

		String[] result = new String[queries.length];

		Map<String, String> map = new HashMap<>();
		Map<String, Integer> shortest = new HashMap<>();
		for(String point: points){
			shortest.put(point, Integer.MAX_VALUE);
		}

		for(int i = 0; i < points.length - 1; i++){
			for(int j = i + 1; j < points.length; j++){
				if(xCoordinates[i] != xCoordinates[j] && yCoordinates[i] != yCoordinates[j]) continue;
				int dist = Math.abs(xCoordinates[i] - xCoordinates[j]) + Math.abs(yCoordinates[i] - yCoordinates[j]);
				String a = points[i];
				if(shortest.get(a) > dist){
					String b = points[j];
					shortest.put(a, dist);
					shortest.put(b, dist);
					map.put(a, b);
					map.put(b, a);
				}
			}
		}

		for(int i = 0, queriesLength = queries.length; i < queriesLength; i++){
			result[i] = map.get(queries[i]);
		}

		System.out.println(System.currentTimeMillis() - start);

		return result;
	}


	public static void main(String[] args){
		assert Arrays.equals(findNearest(new String[]{"p1", "p2", "p3"}, new int[]{30, 20, 10}, new int[]{30, 20, 30}, new String[]{"p3", "p2", "p1"}), new String[]{"p1", null, "p3"});
		assert Arrays.equals(findNearest(new String[]{"p1", "p2", "p3", "p4", "p5"}, new int[]{10, 20, 30, 40, 50}, new int[]{10, 20, 30, 40, 50}, new String[]{"p1", "p2", "p3", "p4", "p5"}), new String[]{null, null, null, null, null});
		assert Arrays.equals(findNearest(new String[]{"p1", "p2", "p3", "p4", "p5"}, new int[]{40, 20, 20, 40, 40}, new int[]{10, 40, 30, 40, 30}, new String[]{"p1", "p2", "p3", "p4", "p5"}), new String[]{"p5", "p3", "p2", "p5", "p4"});

	}
}
