//this is not the best solution. wellcome the other solution
//itinerary soltuion by using stack.


public class Solution
	{
		
		public bool IsCousins(TreeNode root, int x, int y)
		{
			int levelactuel=0;
			int level1=-1;
			TreeNode nodeparent = null;
			TreeNode nodeparent1 = null;
		
			if (root!= null) {
				Stack<TreeNode[]> stack = new Stack<TreeNode[]>();
				Stack<int> level = new Stack<int>();
				TreeNode[] treestack ={root,null};
				stack.Push(treestack);
				level.Push(0);
				
				while (stack.Count != 0) {
				    TreeNode[] temp = stack.Pop();
					root = temp[0];
					levelactuel =  level.Pop();
					if (root.val==x || root.val == y)
					{
						if (level1==-1)
						{
							level1=levelactuel;
							nodeparent1=temp[1];
						}
						else
						{
							nodeparent=temp[1];
							break;
						}
					}
										
					if (root.right != null) {
						TreeNode[] treestack1 ={root.right,root};					
						stack.Push(treestack1);
						level.Push(levelactuel+1);
					}
					if (root.left != null) {
						TreeNode[] treestack2 ={root.left,root};
						stack.Push(treestack2);
						level.Push(levelactuel+1);
					}
				}
				
			if (level1==levelactuel && nodeparent1!= nodeparent && levelactuel != 0)
				{
					return true;
				}
				else
				{
					return false;
				}			
			}
			else{
				return false;
			}
		}

	}
