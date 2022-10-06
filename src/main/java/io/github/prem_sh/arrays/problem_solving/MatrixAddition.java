package io.github.prem_sh.arrays.problem_solving;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixAddition {
        static Scanner input = new Scanner(System.in);
        public static void main(String[] args) {
            System.out.print("Enter size of the Matrix : ");
            int row = input.nextInt();
            int col = input.nextInt();
            int[][] matrix1 = new int[row][col];
            int[][] matrix2 = new int[row][col];
            int[][] result  = new int[row][col];

            System.out.print("Enter MatrixA elements ("+row*col+") : ");
            for (int i=0; i<row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix1[i][j] = input.nextInt();
                }
            }
            System.out.print("Enter MatrixB elements ("+row*col+") : ");
            for (int i=0; i<row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix2[i][j] = input.nextInt();
                }
            }

            for (int i=0; i<row; i++) {
                for (int j=0; j < col; j++) {
                    result[i][j] = matrix1[i][j]+matrix2[i][j];
                }
            }

            System.out.println("=== Input matrix A ===\n");

            for (int i=0; i<row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(matrix1[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("=== Input matrix B ===\n");

            for (int i=0; i<row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(matrix2[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println("=== Resultant matrix ===\n");
            for (int i=0; i<row; i++) {
                for (int j = 0; j < col; j++) {
                    System.out.print(result[i][j]+" ");
                }
                System.out.println();
            }
        }
    }

