package com.lbchyx.coding;

import org.junit.Before;
import org.junit.Test;

/**
 * 二叉树相关
 */
public class BinaryTree {
	private TreeNode root;

	@Before
	public void setUp(){
		TreeNode node1 = new TreeNode(10);
		TreeNode node3 = new TreeNode(0);
		TreeNode node2 = new TreeNode(null, node3,3);
		root = new TreeNode(node1, node2, 100);
	}


	/**
	 * 二叉树遍历
	 */
	@Test
	public void traversingBinaryTree(){
		//递归先序遍历
		printTreeNodeValue(root);
		//非递归，先序遍历
		nonRecursive(root);
	}

	/**
	 * 非递归先序遍历
	 * @param root
	 */
	private void nonRecursive(TreeNode root){
		if (null == root)return;
		TreeNode p = root;
		while (null != p){
			System.out.println(p.value);
			if (null != p.lchild){
				p = p.lchild;
			}else if (null != p.rchild){
				p = p.rchild;
			}
		}


	}






	/**
	 * 递归先序遍历
	 * @param root
	 */
	private void printTreeNodeValue(TreeNode root){
		if(null == root){
			return;
		}
		//输出根节点
		System.out.println(root);
		//输出左子树
		if (null != root.lchild){
			printTreeNodeValue(root.lchild);
		}
		//输出右子树
		if (null != root.rchild){
			printTreeNodeValue(root.rchild);
		}
	}

	/**
	 * 二叉树结构定义
	 */
	public static class TreeNode{
		TreeNode root;
		TreeNode lchild;
		TreeNode rchild;
		int value;
		TreeNode(TreeNode lchild, TreeNode rchild, int value){
			this.lchild = lchild;
			this.rchild = rchild;
			this.value = value;
		}

		TreeNode(int value){
			this.value = value;
		}
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}


}
