package _week3;
import java.awt.image.BufferedImage;
import java.util.Random;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class SlidePuzzleBoard {
    private PuzzlePiece[][] board;
    private int empty_row;
    private int empty_col;
    private boolean on = false;

    public SlidePuzzleBoard() {
        board = new PuzzlePiece[4][4];
        Random random = new Random();

        // 이미지 파일 경로를 배열에 저장합니다.
        String[] imagePaths = {
                "src/IMG_0170.jpg",

        };

        // 랜덤하게 하나의 이미지 경로를 선택합니다.
        String selectedImagePath = imagePaths[random.nextInt(imagePaths.length)];

        try {
            BufferedImage originalImage = ImageIO.read(new File(selectedImagePath));
            int pieceWidth = originalImage.getWidth() / 4;
            int pieceHeight = originalImage.getHeight() / 4;

            // 이미지 분할 및 퍼즐 조각 생성 로직...
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    if (!(row == 3 && col == 3)) {
                        BufferedImage subImage = originalImage.getSubimage(
                                col * pieceWidth, row * pieceHeight, pieceWidth, pieceHeight);
                        board[row][col] = new PuzzlePiece(subImage);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        empty_row = 3;
        empty_col = 3;
        board[empty_row][empty_col] = null;
    }

    public void createPuzzleBoard() {
        resetBoard();

        shuffleBoard();
        on = true;
    }



    private void shuffleBoard() {
        int[] permutation = generateRandomPermutation(15);
        PuzzlePiece[] tempPieces = new PuzzlePiece[15];
        System.out.println(Arrays.toString(permutation));
        // Move pieces into a temporary linear array to shuffle them
        for (int i = 0; i < permutation.length; i++) {
            int row = i / 4;
            int col = i % 4;
            tempPieces[i] = board[row][col];
        }

        // Move pieces back into the board according to the permutation
        for (int i = 0; i < permutation.length; i++) {
            int row = i / 4;
            int col = i % 4;
            board[row][col] = tempPieces[permutation[i]];
        }

        // Update the position of the empty piece
        for (int i = 0; i < permutation.length; i++) {
            if (board[i / 4][i % 4] == null) {
                empty_row = i / 4;
                empty_col = i % 4;
            }
        }
    }



    public PuzzlePiece getPuzzlePiece(int row, int col) {
        if (row >= 0 && row < 4 && col >= 0 && col < 4) {
            return board[row][col];
        }
        return null;
    }

    public boolean move(int targetRow, int targetCol) {
        // Check if the target is in the same row or column as the empty space
        if (targetRow == empty_row || targetCol == empty_col) {
            // Calculate the direction of movement
            int rowDirection = Integer.compare(empty_row, targetRow);
            int colDirection = Integer.compare(empty_col, targetCol);

            int currentRow = empty_row;
            int currentCol = empty_col;

            // Check the boundaries and move all tiles between the target and the empty space
            while (currentRow != targetRow || currentCol != targetCol) {
                int nextRow = currentRow - rowDirection;
                int nextCol = currentCol - colDirection;

                if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length) {
                    board[currentRow][currentCol] = board[nextRow][nextCol];
                    currentRow = nextRow;
                    currentCol = nextCol;
                } else {
                    break;
                }
            }

            // Update the empty space
            board[targetRow][targetCol] = null;
            empty_row = targetRow;
            empty_col = targetCol;
            return true;
        }
        return false;
    }
    public boolean gameOver() {
        // This method needs to be implemented based on the correct order of image pieces
        // Implement the logic to check if each piece is in its correct position
        return false; // Placeholder return
    }

    public boolean on() {
        return on;
    }



    private int[] generateRandomPermutation(int n) {
        Random random = new Random();
        int[] permutation = new int[n];
        for (int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int randomIndexToSwap = random.nextInt(n);
            int temp = permutation[randomIndexToSwap];
            permutation[randomIndexToSwap] = permutation[i];
            permutation[i] = temp;
        }
        if (hasEvenInversions(permutation)) {
            return permutation;
        } else {
            int temp = permutation[0];
            permutation[0] = permutation[1];
            permutation[1] = temp;
            return permutation;
        }
    }

    private boolean hasEvenInversions(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }
        return count % 2 == 1; // Should return true for even number of inversions
    }

    public void printBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (board[i][j] == null) {
                    System.out.print("0 ");
                } else {
                    System.out.print(board[i][j].getImage() + " ");
                }
            }
            System.out.println();
        }
    }

    public void resetBoard() {
        // 초기 이미지 조각으로 보드를 설정합니다.
        setupInitialPieces();

        // 빈 칸의 위치를 초기 상태로 설정합니다.
        empty_row = 3;
        empty_col = 3;

        // 게임의 진행 상태를 활성화로 변경합니다.
        on = false;
    }

    private void setupInitialPieces() {
        board = new PuzzlePiece[4][4];
        Random random = new Random();

        // 이미지 파일 경로를 배열에 저장합니다.
        String[] imagePaths = {
                "src/IMG_0170.jpg",

        };

        // 랜덤하게 하나의 이미지 경로를 선택합니다.
        String selectedImagePath = imagePaths[random.nextInt(imagePaths.length)];

        try {
            BufferedImage originalImage = ImageIO.read(new File(selectedImagePath));
            int pieceWidth = originalImage.getWidth() / 4;
            int pieceHeight = originalImage.getHeight() / 4;

            // 이미지 분할 및 퍼즐 조각 생성 로직...
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    if (!(row == 3 && col == 3)) {
                        BufferedImage subImage = originalImage.getSubimage(
                                col * pieceWidth, row * pieceHeight, pieceWidth, pieceHeight);
                        board[row][col] = new PuzzlePiece(subImage);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        empty_row = 3;
        empty_col = 3;
        board[empty_row][empty_col] = null;
        // 이 부분은 보드의 초기 상태를 설정하는 로직을 포함합니다.
        // 이 예에서는 메소드를 상징적으로만 표시하고 있습니다.
        // 여기서는 보드 배열을 초기 상태로 설정하는 코드를 구현해야 합니다.
    }


}

