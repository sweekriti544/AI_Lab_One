package com.dwit.bean;

/**
 * Created by Dell on 2/22/2018.
 */
    public class BTNode_lab1<T>
            extends java.lang.Object
    {

        private String data;
        private BTNode_lab1 left, right;


        public BTNode_lab1(String initialData, BTNode_lab1 initialLeft, BTNode_lab1 initialRight)
        {
            data = initialData;
            left = initialLeft;
            right = initialRight;
        }
        public boolean isGuess( )
        {
            return (left == null) && (right == null);
        }


        public void setData(String newData)
        {
            data = newData;
        }

        public String getData( )
        {
            return data;
        }


        public BTNode_lab1 getLeft( )
        {
            return left;
        }


        public BTNode_lab1 getRight( )
        {
            return right;
        }
        public void setLeft(BTNode_lab1 newLeft)
        {
            left = newLeft;
        }


        public void setRight(BTNode_lab1 newRight)
        {
            right = newRight;
        }




    }
