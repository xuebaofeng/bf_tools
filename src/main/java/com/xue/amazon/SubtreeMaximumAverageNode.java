package com.xue.amazon;

import java.util.Arrays;
import java.util.List;

public class SubtreeMaximumAverageNode {

	public MAryTreeNode subtreeMaxAvg(MAryTreeNode root){
		if(root == null) return null;
		maxNode = root;
		dfs(root, new int[]{1, root.val});
		return maxNode;
	}

	double max = -10000;
	MAryTreeNode maxNode = null;

	MAryTreeNode dfs(MAryTreeNode node, int[] ans){
		if(node == null) return null;
		if(node.children == null){
			ans[0] = 1;
			ans[1] = node.val;
			return node;
		}

		int count = 0;
		int sum = 0;

		for(MAryTreeNode c: node.children){
			if(c == null) continue;
			MAryTreeNode candi = dfs(c, ans);
			double v = ans[1] * 1.0 / ans[0];
			if(v > max){
				max = v;
				maxNode = candi;
			}

			count += ans[0];
			sum += ans[1];
		}

		count++;
		sum += node.val;

		double v = sum * 1.0 / count;
		if(v > max)
			maxNode = node;

		ans[0] = count;
		ans[1] = sum;
		return maxNode;
	}

	public static void main(String[] args){
		SubtreeMaximumAverageNode app = new SubtreeMaximumAverageNode();
		MAryTreeNode root1 = new MAryTreeNode(0);
		root1.children = Arrays.asList(new MAryTreeNode(-2), new MAryTreeNode(-4), new MAryTreeNode(-5), new MAryTreeNode(-12), new MAryTreeNode(-1000));
		assert app.subtreeMaxAvg(root1).val == -2;

		MAryTreeNode root = new MAryTreeNode(10);
		assert app.subtreeMaxAvg(root).val == 10;
		MAryTreeNode node1 = new MAryTreeNode(1);
		root.children = Arrays.asList(node1, new MAryTreeNode(12));
		assert app.subtreeMaxAvg(root).val == 12;
		node1.children = Arrays.asList(new MAryTreeNode(3), new MAryTreeNode(11), new MAryTreeNode(15));
		assert app.subtreeMaxAvg(root).val == 15;

	}

	public static class MAryTreeNode {
		int val;
		List<MAryTreeNode> children;

		public MAryTreeNode(int val){
			this.val = val;
		}

		@Override
		public String toString(){
			return "" + val;
		}
	}
}
