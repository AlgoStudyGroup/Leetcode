using System;
using System.Collections.Generic;
using System.Collections;

namespace _735_Asteroid_Collision
{
    public class Solution
    {
        public int[] AsteroidCollision(int[] asteroids)
        {
            var stack = new Stack<int>();

            for (int i = 0; i < asteroids.Length; i++)
            {
                if (asteroids[i] > 0)
                {
                    //If element is positive, just push it into the stack
                    stack.Push(asteroids[i]);
                }
                //element is negative
                else
                {
                    //While the last element is positive, and it is smaller than absolute value of current element, then Pop the last element in the stack
                    while (stack.Count > 0 && stack.Peek() > 0 && stack.Peek() < Math.Abs(asteroids[i]))
                    {
                        stack.Pop();
                    }

                    //When the stack is empty or the last element is negative
                    if (stack.Count == 0 || stack.Peek() < 0)
                    {
                        stack.Push(asteroids[i]);
                    }
                    //When the last element + current element equals 0
                    else if (asteroids[i] + stack.Peek() == 0)
                    {
                        stack.Pop();
                    }
                }
            }

            var res = new int[stack.Count];
            for (int i = stack.Count - 1; i >= 0; i--)
            {
                res[i] = stack.Pop();
            }

            return res;
        }
    }
}