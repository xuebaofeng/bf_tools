package com.xue.amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ClosestPairOfPoints {

	public static class Point {
		public final int x;
		public final int y;

		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}


	public static long distance(Point p1, Point p2){
		return (long)(p2.x - p1.x) * (p2.x - p1.x) + (long)(p2.y - p1.y) * (p2.y - p1.y);
	}

	public static long bruteForce(List<Point> points){
		long min = Integer.MAX_VALUE;

		int numPoints = points.size();
		if(numPoints < 2)
			return min;
		for(int i = 0; i < numPoints - 1; i++){
			Point point1 = points.get(i);
			for(int j = i + 1; j < numPoints; j++){
				Point point2 = points.get(j);
				long distance = distance(point1, point2);
				if(distance == 0) continue;
				if(distance < min)
					min = distance;
			}
		}
//		System.out.println(min);
		return min;
	}


	public static long divideAndConquer(List<Point> points){
		List<Point> pointsSortedByX = new ArrayList<>(points);
		pointsSortedByX.sort(Comparator.comparingInt(point -> point.x));
		List<Point> pointsSortedByY = new ArrayList<>(points);
		pointsSortedByY.sort(Comparator.comparingInt(point -> point.y));
		long dis = divideAndConquer(pointsSortedByX, pointsSortedByY);
//		System.out.println(dis);
		return dis;
	}

	private static long divideAndConquer(List<Point> pointsSortedByX, List<Point> pointsSortedByY){
		int numPoints = pointsSortedByX.size();
		if(numPoints <= 3)
			return bruteForce(pointsSortedByX);

		int dividingIndex = numPoints >>> 1;
		List<Point> leftOfCenter = pointsSortedByX.subList(0, dividingIndex);
		List<Point> rightOfCenter = pointsSortedByX.subList(dividingIndex, numPoints);

		List<Point> tempList = new ArrayList<>(leftOfCenter);
		tempList.sort(Comparator.comparingInt(point4 -> point4.y));
		long closestint = divideAndConquer(leftOfCenter, tempList);

		tempList.clear();
		tempList.addAll(rightOfCenter);
		tempList.sort(Comparator.comparingInt(point3 -> point3.y));
		long closestintRight = divideAndConquer(rightOfCenter, tempList);

		if(closestintRight < closestint)
			closestint = closestintRight;

		tempList.clear();
		long shortestDistance = closestint;
		int centerX = rightOfCenter.get(0).x;
		for(Point point: pointsSortedByY)
			if(Math.abs(centerX - point.x) < shortestDistance)
				tempList.add(point);

		for(int i = 0; i < tempList.size() - 1; i++){
			Point point1 = tempList.get(i);
			for(int j = i + 1; j < Math.min(8, tempList.size()); j++){
				Point point2 = tempList.get(j);
				if((point2.y - point1.y) >= shortestDistance)
					break;
				long distance = distance(point1, point2);
				if(distance < closestint){
					shortestDistance = distance;
				}
			}
		}
		return shortestDistance;
	}

	public static void main(String[] args){
		List<Point> points = new ArrayList<>();
		int numPoints = (args.length == 0) ? 10000 : Integer.parseInt(args[0]);
		Random r = new Random();
		for(int i = 0; i < numPoints; i++)
			points.add(new Point(r.nextInt(100000), r.nextInt(100000)));
		System.out.println("Generated " + numPoints + " random points");
		long startTime = System.currentTimeMillis();
		long bruteForceClosestint = bruteForce(points);
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Brute force (" + elapsedTime + " ms) ");
		startTime = System.currentTimeMillis();
		long dqClosestint = divideAndConquer(points);
		elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("Divide and conquer (" + elapsedTime + " ms)");

		assert bruteForceClosestint == dqClosestint;

		points.clear();
		points.add(new Point(0, 0));
		points.add(new Point(1, 1));
		points.add(new Point(2, 4));
		assert divideAndConquer(points) == 2;

		points.clear();
		//0 1 0
		//0 3 0
		points.add(new Point(0, 0));
		points.add(new Point(1, 3));
		points.add(new Point(0, 0));
		assert divideAndConquer(points) == 10;

	}
}
